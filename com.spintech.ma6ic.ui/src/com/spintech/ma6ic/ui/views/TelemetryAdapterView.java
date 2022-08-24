/*
 * FILE:            TelemetryAdapterView.java
 *
 * SW-COMPONENT:    com.spintech.ma6ic.ui
 *
 * DESCRIPTION:     -
 *
 * COPYRIGHT:       © 2015 - 2022 Robert Bosch GmbH
 *
 * The reproduction, distribution and utilization of this file as
 * well as the communication of its contents to others without express
 * authorization is prohibited. Offenders will be held liable for the
 * payment of damages. All rights reserved in the event of the grant
 * of a patent, utility model or design.
 */
package com.spintech.ma6ic.ui.views;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.spintech.ma6ic.ui.labelproviders.tableViewerTelemetryAdapterLabelProvider;

import ma6icmodel.Adapter;

public class TelemetryAdapterView extends ViewPart implements ISelectionListener {
	private Table table;
	private TableViewer tableViewerTelemetryAdapter;

	public TelemetryAdapterView() {
	}

	@Override
	public void createPartControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		tableViewerTelemetryAdapter = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewerTelemetryAdapter.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableColumn tblclmnParameter = new TableColumn(table, SWT.NONE);
		tblclmnParameter.setWidth(150);
		tblclmnParameter.setText("Parameter");

		TableColumn tblclmnDescription = new TableColumn(table, SWT.NONE);
		tblclmnDescription.setWidth(92);
		tblclmnDescription.setText("Description");

		TableColumn tblclmnValue = new TableColumn(table, SWT.NONE);
		tblclmnValue.setWidth(79);
		tblclmnValue.setText("Value");

		TableColumn tblclmnUnit = new TableColumn(table, SWT.NONE);
		tblclmnUnit.setWidth(70);
		tblclmnUnit.setText("Unit");

		tableViewerTelemetryAdapter.setContentProvider(ArrayContentProvider.getInstance());
		tableViewerTelemetryAdapter.setLabelProvider(new tableViewerTelemetryAdapterLabelProvider());

//		Manager.getInstance().getMa6ic().eAdapters().add(new EContentAdapter(){
//			@Override
//			public void notifyChanged(Notification notification) {
//				EList<Adapter> adapters = Manager.getInstance().getMa6ic().getAdapters();
//				final ArrayList<Telemetry> telemetryList = new ArrayList<Telemetry>();
//
//				for (Adapter adapter : adapters) {
//					telemetryList.addAll(adapter.getTelemetry());
//				}
//				
//				Runnable run = new Runnable() {
//					public void run() {
//						tableViewerTelemetryAdapter.setInput(telemetryList);
//					}
//				};
//				Display.getDefault().asyncExec(run);
//
//				
//				super.notifyChanged(notification);
//			}
//		});

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addSelectionListener(this);

	}

	@Override
	public void setFocus() {

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof InterfaceViewOld || part instanceof InterfaceViewNew) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			Object firstElement = sSelection.getFirstElement();
			if (firstElement instanceof Adapter) {
				Adapter adapter = (Adapter) firstElement;
				adapter.eAdapters().add(new AdapterImpl() {
					@Override
					public void notifyChanged(Notification msg) {
						if (msg.getEventType() == Notification.ADD || msg.getEventType() == Notification.SET) {

							Runnable run = () -> tableViewerTelemetryAdapter.refresh();
							Display.getDefault().asyncExec(run);

						}
						super.notifyChanged(msg);
					}
				});
				tableViewerTelemetryAdapter.setInput(adapter.getTelemetry());
			}
		}
	}

}
