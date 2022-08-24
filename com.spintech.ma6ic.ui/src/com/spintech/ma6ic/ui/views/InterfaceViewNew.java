package com.spintech.ma6ic.ui.views;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.contentproviders.InterfaceTreeViewerContentProvider;
import com.spintech.ma6ic.ui.labelproviders.treeViewerTelemetryAdapterLabelProvider;

import editors.InterFaceMasterBlock;
import ma6icmodel.Adapter;
import ma6icmodel.Ma6ic;
import org.eclipse.swt.layout.GridLayout;

public class InterfaceViewNew extends ViewPart {

	private FormToolkit toolkit;
	private TreeViewer treeViewer;
	private Tree tree;
	private Ma6ic ma6ic;
	private AdapterImpl adapterImpl;

	public InterfaceViewNew() {

	}

	

	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new GridLayout(1, false));		
	 
		ma6ic = Manager.getInstance().getMa6ic();
		
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.V_SCROLL);
		tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		treeViewer.setContentProvider(new InterfaceTreeViewerContentProvider());
		treeViewer.setLabelProvider(new treeViewerTelemetryAdapterLabelProvider());
		treeViewer.setInput(ma6ic);
		tree.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");
		
		
		adapterImpl =new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				
				Runnable runnable = new Runnable() {
					public void run() {
						if(treeViewer != null || !treeViewer.getControl().isDisposed()) {
						treeViewer.refresh();
						}
					}
				};
				Display.getDefault().asyncExec(runnable);
				
				super.notifyChanged(msg);
			}
	
		};
		
		ma6ic.eAdapters().add(adapterImpl);

		getSite().setSelectionProvider(treeViewer);
	}

	@Override
	public void setFocus() {

	}
	
	@Override
	public void dispose() {
		super.dispose();
		ma6ic.eAdapters().remove(adapterImpl);
	}


}
