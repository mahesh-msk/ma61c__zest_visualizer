package com.spintech.ma6ic.ui.views;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.labelproviders.ErrorViewTableLabelProvider;
import com.spintech.ma6ic.ui.utils.Utils;

import ma6icmodel.Ma6ic;
import ma6icmodel.Ma6icmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.part.ViewPart;

public class ErrorView extends ViewPart {
	
	private ImageDescriptor exportImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/export.png");
	/* member class not found */
	class TableLabelProvider {
	}

	public ErrorView() {
	}

	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		final TableViewer tableViewer = new TableViewer(parent, 0x10800);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(4, 4, true, true, 1, 1));
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, 0);
		TableColumn tblclmnTelemetry = tableViewerColumn.getColumn();
		tblclmnTelemetry.setWidth(260);
		tblclmnTelemetry.setText("Telemetry");
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, 0);
		TableColumn tblclmnError = tableViewerColumn_1.getColumn();
		tblclmnError.setWidth(210);
		tblclmnError.setText("Error");
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, 0);
		TableColumn tblclmnTime = tableViewerColumn_2.getColumn();
		tblclmnTime.setWidth(100);
		tblclmnTime.setText("Time");
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new ErrorViewTableLabelProvider());
		ma6ic = Manager.getInstance().getMa6ic();
		EList errorTelemetries = ma6ic.getErrorTelemetries();
		tableViewer.setInput(errorTelemetries);

		eContentAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {

				EStructuralFeature feature = (EStructuralFeature) notification.getFeature();

				if (feature != null && feature.equals(Ma6icmodelPackage.eINSTANCE.getMa6ic_ErrorTelemetries())) {

					Runnable runnable = new Runnable() {

						public void run() {
							tableViewer.refresh();
						}
					};
					Display.getDefault().asyncExec(runnable);
				}
			}
		};
		ma6ic.eAdapters().add(eContentAdapter);

		createActions();

	}

	private void createActions() {
		Action action = new Action("Export",exportImage) {
			@Override
			public void run() {
				Utils.exportTable(table);
			}
		};
		getViewSite().getActionBars().getToolBarManager().add(action);
	}

	public void setFocus() {
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		ma6ic.eAdapters().remove(eContentAdapter);
	}

	private Table table;
	private AdapterImpl eContentAdapter;
	private Ma6ic ma6ic;
}
