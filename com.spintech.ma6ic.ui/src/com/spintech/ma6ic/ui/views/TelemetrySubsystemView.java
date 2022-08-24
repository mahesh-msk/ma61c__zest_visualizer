package com.spintech.ma6ic.ui.views;

import java.util.ArrayList;

import ma6icmodel.Adapter;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.contentproviders.tableViewerTelemetryAdapterContentProvider;
import com.spintech.ma6ic.ui.labelproviders.tableViewerTelemetryAdapterLabelProvider;

public class TelemetrySubsystemView extends ViewPart implements ISelectionListener {
	private Table table;
	private TableViewer tableViewer;
	private Subsystem subsystem;
	private AdapterImpl adapterImpl;

	public TelemetrySubsystemView() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableColumn tblclmnParameter = new TableColumn(table, SWT.NONE);
		tblclmnParameter.setWidth(125);
		tblclmnParameter.setText("Parameter");
		
		TableColumn tblclmnDescription = new TableColumn(table, SWT.NONE);
		tblclmnDescription.setWidth(85);
		tblclmnDescription.setText("Description");
		
		TableColumn tblclmnValue = new TableColumn(table, SWT.NONE);
		tblclmnValue.setWidth(74);
		tblclmnValue.setText("Value");
		
		TableColumn tblclmnUnit = new TableColumn(table, SWT.NONE);
		tblclmnUnit.setWidth(67);
		tblclmnUnit.setText("Unit");
		
		
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new tableViewerTelemetryAdapterLabelProvider());
		
//		Manager.getInstance().getMa6ic().eAdapters().add(new EContentAdapter(){
//			public void notifyChanged(Notification notification){
//				EList<Subsystem> subsystems = Manager.getInstance().getMa6ic().getSubsystems();
//				final ArrayList<Telemetry> arrayList = new ArrayList<Telemetry>();
//				for (Subsystem subsystem : subsystems) {
//					arrayList.addAll(subsystem.getTelemetry());
//				}
//				Runnable run = new Runnable() {
//					public void run() {
//						tableViewer.setInput(arrayList);
//					}
//				};
//				Display.getDefault().asyncExec(run);
//				
//				super.notifyChanged(notification);
//			}
//		});
		
		getSite().getPage().addSelectionListener(this);

	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof InterfaceViewOld || part instanceof InterfaceViewNew ) {
			IStructuredSelection sSelection = (IStructuredSelection)selection;
			Object firstElement = sSelection.getFirstElement();
			if (firstElement instanceof Subsystem) {
				subsystem = (Subsystem) firstElement;
				subsystem.eAdapters().remove(adapterImpl);
				adapterImpl = new AdapterImpl(){
					@Override
					public void notifyChanged(Notification msg) {
						
						if(msg.getEventType() == Notification.SET) {
							
							Runnable run = new Runnable() {
								public void run() {
									tableViewer.refresh();
								}
							};
							Display.getDefault().asyncExec(run);
							
						}
						super.notifyChanged(msg);
					}
				};
				subsystem.eAdapters().add(adapterImpl);
				tableViewer.setInput(subsystem.getTelemetry());
			}
		}
	}
	
	@Override
	public void dispose() {
		if(subsystem  != null) {
		subsystem.eAdapters().remove(adapterImpl);
		}
		super.dispose();
		
	}

}
