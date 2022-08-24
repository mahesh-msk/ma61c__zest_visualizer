package editors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.spintech.ma6ic.ui.contentproviders.InterfaceTreeViewerContentProvider;
import com.spintech.ma6ic.ui.contentproviders.tableViewerTelemetryAdapterContentProvider;
import com.spintech.ma6ic.ui.labelproviders.tableViewerTelemetryAdapterLabelProvider;
import com.spintech.ma6ic.ui.labelproviders.treeViewerTelemetryAdapterLabelProvider;
import com.spintech.ma6ic.ui.views.InterfaceViewNew;

import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.Ma6ic;
import ma6icmodel.Telemetry;
import ma6icmodel.impl.ComputerImpl;
import ma6icmodel.impl.TelemetryImpl;

public class InterFaceMasterBlock extends MasterDetailsBlock {


	private Ma6ic ma6ic;
	private FormToolkit toolkit;
	private TreeViewer treeViewer;
	private Tree tree;
	private InterfaceViewNew interfaceViewNew;

	/**
	 * Create the master details block.
	 * 
	 * @param scheduler
	 */
	public InterFaceMasterBlock(Ma6ic ma6ic, InterfaceViewNew interfaceViewNew) {
		this.interfaceViewNew = interfaceViewNew;

		this.ma6ic = ma6ic;
		ma6ic.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				
				Runnable runnable = new Runnable() {
					public void run() {
						treeViewer.refresh();
					}
				};
				Display.getDefault().asyncExec(runnable);
				
				super.notifyChanged(msg);
			}
		});
		// Create the master details block
	}


	/**
	 * Create contents of the master details block.
	 * 
	 * @param managedForm
	 * @param parent
	 */
	@Override
	protected void createMasterPart(IManagedForm managedForm, Composite parent) {
		toolkit = managedForm.getToolkit();
		//
		Section section = toolkit.createSection(parent, ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		section.setText("Interface Structure");

		// this.sashForm.setWeights(new int[]{2,1});

		//
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		
		final SectionPart sectionPart = new SectionPart(section);
		Section section_1 = sectionPart.getSection();
		managedForm.addPart(sectionPart);
		
		
		treeViewer = new TreeViewer(composite, SWT.BORDER | SWT.V_SCROLL);
		tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		treeViewer.setContentProvider(new InterfaceTreeViewerContentProvider());
		treeViewer.setLabelProvider(new treeViewerTelemetryAdapterLabelProvider());
		treeViewer.setInput(ma6ic);
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
				event.getSelection();
				
				managedForm.fireSelectionChanged(sectionPart, event.getSelection());
				
			}
		});
		
		interfaceViewNew.getSite().setSelectionProvider(treeViewer);

	}

	/**
	 * Register the pages.
	 * 
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		part.registerPage(ma6icmodel.impl.AdapterImpl.class, new InterfaceDetailBlock(ma6ic));
		part.registerPage(ma6icmodel.impl.SubsystemImpl.class, new SubsystemDetailBlock(ma6ic));
	}

	/**
	 * Create the toolbar actions.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		// Create the toolbar actions
	}

}
