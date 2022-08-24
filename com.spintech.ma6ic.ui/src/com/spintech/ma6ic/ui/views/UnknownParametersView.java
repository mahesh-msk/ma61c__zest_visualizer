package com.spintech.ma6ic.ui.views;

import java.util.ArrayList;

import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Telemetry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.utils.Utils;

public class UnknownParametersView extends ViewPart {
	
	private ImageDescriptor exportImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/export.png");
	
	
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			String string = null;
			if (element instanceof Telemetry) {
				Telemetry telemetry = (Telemetry) element;
				switch (columnIndex) {
				case 0:
					string = telemetry.getValue();
					break;
				case 1:
					string = telemetry.getParameter();
				default:
					break;
				}

			}
			return string;
		}
	}

	private Table table;
	private TableViewer tableViewer;
	private AdapterImpl adapterImpl;

	public UnknownParametersView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer = new TableViewer(table);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnParameter = new TableColumn(table, SWT.NONE);
		tblclmnParameter.setWidth(302);
		tblclmnParameter.setText("Parameter");

		tblclmnParameter = new TableColumn(table, SWT.NONE);
		tblclmnParameter.setWidth(302);
		tblclmnParameter.setText("Subsystem ID");

		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		// tableViewer.setInput(Manager.getInstance().getMa6ic().getComputer().getTelemetry().get(0));
		// TODO Auto-generated method stub

		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {

				EStructuralFeature feature = (EStructuralFeature) notification.getFeature();

				if (feature != null && feature.equals(Ma6icmodelPackage.eINSTANCE.getComputer_Telemetry())) {
					Computer computer = Manager.getInstance().getMa6ic().getComputer();
					final ArrayList<Telemetry> telemetryList = new ArrayList<Telemetry>();
					telemetryList.addAll(computer.getTelemetry());
					Runnable run = new Runnable() {
						public void run() {
							tableViewer.setInput(telemetryList);
						}
					};
					Display.getDefault().asyncExec(run);

				}
				super.notifyChanged(notification);
			}
		};
		Manager.getInstance().getMa6ic().getComputer().eAdapters().add(adapterImpl);

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

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		Manager.getInstance().getMa6ic().eAdapters().remove(adapterImpl);
	}

}
