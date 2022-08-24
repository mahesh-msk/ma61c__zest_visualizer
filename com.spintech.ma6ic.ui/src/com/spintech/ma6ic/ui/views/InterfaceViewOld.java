package com.spintech.ma6ic.ui.views;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.contentproviders.InterfaceViewGraphicalContentProvider;
import com.spintech.ma6ic.ui.labelproviders.InterfaceViewGraphicalLabelProvider;

import ma6icmodel.Adapter;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;

public class InterfaceViewOld extends ViewPart {
	private Graph graph;
	private int layout = 1;

	static int count = 0;
	private GraphNode computer;

	public InterfaceViewOld() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {

		// Graph will hold all other objects

		// parent.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");

		final GraphViewer graphViewer = new GraphViewer(parent, SWT.NONE);
		graph = graphViewer.getGraphControl();
		graph.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");
		graphViewer.setContentProvider(new InterfaceViewGraphicalContentProvider(this));

		graphViewer.setLabelProvider(new InterfaceViewGraphicalLabelProvider(this));
		
		Manager.getInstance().getMa6ic().eAdapters().add(new EContentAdapter() {

			@Override
			public void notifyChanged(final Notification notification) {

				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.ADD_MANY
						|| notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.REMOVE_MANY) {

					EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
					if (feature.equals(Ma6icmodelPackage.eINSTANCE.getMa6ic_Adapters())
							|| feature.equals(Ma6icmodelPackage.eINSTANCE.getMa6ic_Subsystems())) {
						Runnable run = new Runnable() {
							public void run() {
								graphViewer.refresh();
								graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
										true);
							}
						};
						Display.getDefault().asyncExec(run);
					}

					super.notifyChanged(notification);
				}
			}
		});

		getSite().setSelectionProvider(graphViewer);

		graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		graphViewer.setInput(Manager.getInstance().getMa6ic());

	}

	private void removeUnwantedElements() {
		ArrayList<Adapter> objectsToRemove = new ArrayList<Adapter>();
		for (Object adapObject : Manager.getInstance().getMa6ic().getAdapters()) {
			Adapter adapter = (Adapter) adapObject;
			if (!adapter.isValid()) {
				objectsToRemove.add(adapter);
				if (Manager.getInstance().getMa6ic().getComputer().getAdapters().contains(adapter)) {
					Manager.getInstance().getMa6ic().getComputer().getAdapters().remove(adapter);
				}
			}
		}
		Manager.getInstance().getMa6ic().getAdapters().removeAll(objectsToRemove);

		ArrayList<Subsystem> subSysToRemove = new ArrayList<Subsystem>();
		for (Object subsystemObject : Manager.getInstance().getMa6ic().getSubsystems()) {
			Subsystem subsystem = (Subsystem) subsystemObject;
			if (!subsystem.isValid()) {
				subSysToRemove.add(subsystem);
				for (Object adapObject : Manager.getInstance().getMa6ic().getAdapters()) {
					Adapter adapter = (Adapter) adapObject;
					if (adapter.getSubsystems().contains(subsystem)) {
						adapter.getSubsystems().remove(subsystem);
					}
				}
			}
		}

		Manager.getInstance().getMa6ic().getSubsystems().removeAll(subSysToRemove);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
