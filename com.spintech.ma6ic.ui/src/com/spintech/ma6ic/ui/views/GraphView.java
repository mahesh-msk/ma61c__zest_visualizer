package com.spintech.ma6ic.ui.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Ellipse2D;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.experimental.chart.swt.ChartComposite;

import com.spintech.ma6ic.ui.Activator;

import ma6icmodel.Adapter;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;

public class GraphView extends ViewPart implements ISelectionListener {

	private DefaultCategoryDataset dataset;

	private JFreeChart lineChart;
	private ChartComposite chartComposite;

	private Action rangeAction;
	private Object firstElement;

	private AdapterImpl adapterImpl;

	public GraphView() {
		createActions();
	}

	private void createActions() {
		{
			rangeAction = new Action("Select Range") {
				@Override
				public void run() {
					InputDialog iDialog = new InputDialog(Display.getDefault().getActiveShell(), "Graph Range Dialog",
							"Mention Range of Values to Display on Graph. For e.g 1:20", "1:20", null);
					int open = iDialog.open();
					if (IDialogConstants.OK_ID == open) {
						String value = iDialog.getValue();
						String[] ranges = value.split(":");
						String startRange = ranges[0];
						String endRange = ranges[1];

						dataset.clear();
						if (firstElement instanceof Adapter) {
							Adapter adapter = (Adapter) firstElement;
							updateGraph(adapter, Integer.parseInt(startRange), Integer.parseInt(endRange));
						} else if (firstElement instanceof Subsystem) {
							Subsystem subsystem = (Subsystem) firstElement;
							updateGraph(subsystem, Integer.parseInt(startRange), Integer.parseInt(endRange));
						}

					}
				}
			};

			rangeAction.setImageDescriptor(
					Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/compare_view.gif"));
		}
	}

	final Color adapterColor = new Color(174, 145, 71);
	final Color lightGreyCol = new Color(134, 140, 152); /* Light grey */

	private Plot plot;

	private NumberAxis rangeAxis;

	private CategoryAxis categoryAxis;

	@Override
	public void createPartControl(Composite parent) {

		dataset = new DefaultCategoryDataset();

		lineChart = ChartFactory.createLineChart("Packets per second", "Time", "", dataset, PlotOrientation.VERTICAL,
				true, true, false);

		lineChart.setBackgroundPaint(new GradientPaint(0, 0, lightGreyCol, 200, 200, lightGreyCol, false));

		lineChart.setTitle(new org.jfree.chart.title.TextTitle("Packets per second",
				new java.awt.Font("Euphemia EUCAS", java.awt.Font.BOLD, 12)));
		lineChart.getTitle().setPaint(Color.WHITE);

		chartComposite = new ChartComposite(parent, SWT.NONE, lineChart, true);
		getSite().getPage().addSelectionListener(this);
		// CategoryPlot cplot = (CategoryPlot) lineChart.getPlot();

		plot = lineChart.getPlot();

		plot.setBackgroundPaint(lightGreyCol);
		plot.setBackgroundAlpha(0.5f);

		CategoryItemRenderer renderer = ((CategoryPlot) plot).getRenderer();
		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(3.0f));
		// Setting custom paint color and stroke for the plot’s outlines (chart
		// borders):
		renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));
		renderer.setSeriesShape(0, new Ellipse2D.Double(0, 0, 0, 0));
		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.YELLOW);

		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesOutlineStroke(1, new BasicStroke(2.0f));
		renderer.setSeriesShape(1, new Ellipse2D.Double(0, 0, 0, 0));
		// sets paint color for each series
		renderer.setSeriesPaint(1, Color.BLUE);
		// plot.setBackgroundPaint(Color.LIGHT_GRAY) ;
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(rangeAction);

		if (plot instanceof CategoryPlot) {
			setAxisFontColor(((CategoryPlot) plot).getDomainAxis(), Color.WHITE);
			setAxisFontColor(((CategoryPlot) plot).getRangeAxis(), Color.WHITE);

			rangeAxis = (NumberAxis) ((CategoryPlot) plot).getRangeAxis();
			rangeAxis.setLowerBound(0);
			rangeAxis.setUpperBound(1000);

			categoryAxis = (CategoryAxis) ((CategoryPlot) plot).getDomainAxis();
			categoryAxis.setTickLabelsVisible(false);
			categoryAxis.setTickMarksVisible(false);

		} else if (plot instanceof XYPlot) {
			setAxisFontColor(((XYPlot) plot).getDomainAxis(), Color.WHITE);
			setAxisFontColor(((XYPlot) plot).getRangeAxis(), Color.WHITE);

		}

	}

	private void setAxisFontColor(Axis axis, Color fontColor) {
		if (!fontColor.equals(axis.getLabelPaint()))
			axis.setLabelPaint(fontColor);
		if (!fontColor.equals(axis.getTickLabelPaint()))
			axis.setTickLabelPaint(fontColor);
	}

	@Override
	public void setFocus() {

	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof InterfaceViewOld || part instanceof InterfaceViewNew) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;

			unregisterListeners();

			firstElement = sSelection.getFirstElement();
			if (firstElement instanceof Adapter) {

				Adapter adapter = (Adapter) firstElement;
				adapterImpl = new AdapterImpl() {
					@Override
					public void notifyChanged(Notification msg) {
						EStructuralFeature feature = (EStructuralFeature) msg.getFeature();
						if (feature != null) {
							if (feature.equals(Ma6icmodelPackage.Literals.ADAPTER__NO_OF_PACKETS)) {

								Runnable run = new Runnable() {
									public void run() {
										updateGraph(adapter);
									}
								};
								Display.getDefault().asyncExec(run);

							}
						}
						super.notifyChanged(msg);
					}
				};
				adapter.eAdapters().add(adapterImpl);

				updateGraph(adapter);

				lineChart.fireChartChanged();

			} else if (firstElement instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) firstElement;

				adapterImpl = new AdapterImpl() {
					@Override
					public void notifyChanged(Notification msg) {
						EStructuralFeature feature = (EStructuralFeature) msg.getFeature();
						if (feature != null) {
							if (feature.equals(Ma6icmodelPackage.Literals.SUBSYSTEM__NO_OF_PACKETS)
									|| feature.equals(Ma6icmodelPackage.Literals.SUBSYSTEM__NO_OF_RECEIVED_PACKET)) {

								Runnable run = new Runnable() {
									public void run() {
										updateGraph(subsystem);
									}
								};
								Display.getDefault().asyncExec(run);

							}
						}
						super.notifyChanged(msg);
					}
				};
				subsystem.eAdapters().add(adapterImpl);

				updateGraph(subsystem);

				lineChart.fireChartChanged();
			}
		}
	}

	private void updateGraph(Adapter adapter) {
		EList<Integer> noOfPackets = adapter.getNoOfPackets();
		int count = 1;
		dataset.clear();

		int startRange = noOfPackets.size() - (1 * 60) / Activator.getDefault().getPreferenceStore().getInt("TIMER");
		if (startRange < 0) {
			startRange = 1;
		}
		int endRange = noOfPackets.size();

		updateGraph(adapter, startRange, endRange);

	}

	private void updateGraph(Subsystem subsystem) {
		EList<Integer> noOfPackets = subsystem.getNoOfPackets();
		// EList<Integer> noOfRecPackets = subsystem.getNoOfReceivedPacket();

		dataset.clear();

		int startRange = noOfPackets.size() - (1 * 60) / Activator.getDefault().getPreferenceStore().getInt("TIMER");
		if (startRange < 0) {
			startRange = 1;
		}
		int endRange = noOfPackets.size();

		updateGraph(subsystem, startRange, endRange);

		// for (int i = 0; i < noOfPackets.size(); i++) {
		//
		// int timerValue = i *
		// Activator.getDefault().getPreferenceStore().getInt("TIMER");
		// dataset.addValue(noOfPackets.get(i), "Transmitted Packet", timerValue
		// + "");
		// }
		//
		// for (int i = 0; i < noOfRecPackets.size(); i++) {
		// int timerValue = i *
		// Activator.getDefault().getPreferenceStore().getInt("TIMER");
		// dataset.addValue(noOfRecPackets.get(i), "Received Packet", timerValue
		// + "");
		// }

	}

	private void updateGraph(Adapter adapter, int startRange, int endRange) {
		EList<Integer> noOfPackets = adapter.getNoOfPackets();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < noOfPackets.size(); i++) {
			if (noOfPackets.get(i) > max) {
				max = noOfPackets.get(i);
			}
		}
		int count = startRange;
		dataset.clear();
		if (startRange > noOfPackets.size()) {
			return;
		}

		if (endRange > noOfPackets.size()) {
			endRange = noOfPackets.size() - 1;
		}

		for (int i = startRange; i < endRange; i++) {
			if (noOfPackets.size() > 1) {
				dataset.addValue(Math.abs(noOfPackets.get(i) - noOfPackets.get(i - 1)), "Packets",
						count * Activator.getDefault().getPreferenceStore().getInt("TIMER") + "");
			} else {
				dataset.addValue(0, "Packets",
						count * Activator.getDefault().getPreferenceStore().getInt("TIMER") + "");
			}
			// if(i != startRange || i != endRange){
			// categoryAxis.setTickLabelPaint( count *
			// Activator.getDefault().getPreferenceStore().getInt("TIMER") + "",
			// Color.BLUE);
			// }
			count++;
		}

		// rangeAxis.setRange(0, max);
		rangeAxis.setRange(0, 1000);

	}

	private void updateGraph(Subsystem subsystem, int startRange, int endRange) {
		EList<Integer> noOfPackets = subsystem.getNoOfPackets();
		EList<Integer> noOfRecPackets = subsystem.getNoOfReceivedPacket();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < noOfPackets.size(); i++) {
			if (noOfPackets.get(i) > max) {
				max = noOfPackets.get(i);
			}
		}

		int max1 = Integer.MIN_VALUE;
		for (int i = 0; i < noOfRecPackets.size(); i++) {
			if (noOfRecPackets.get(i) > max1) {
				max1 = noOfRecPackets.get(i);
			}
		}

		int count = startRange;

		int startRange1 = noOfRecPackets.size()
				- (10 * 60) / Activator.getDefault().getPreferenceStore().getInt("TIMER");
		if (startRange1 < 0) {
			startRange1 = 1;
		}
		int endRange1 = noOfPackets.size();
		int count1 = startRange1;

		dataset.clear();
		if (startRange > noOfPackets.size()) {
			return;
		}

		if (startRange1 > noOfRecPackets.size()) {
			return;
		}
		if (endRange > noOfPackets.size()) {
			endRange = noOfPackets.size() - 1;
		}
		if (endRange1 > noOfRecPackets.size()) {
			endRange1 = noOfRecPackets.size() - 1;
		}

		for (int i = startRange; i < endRange; i++) {
			if (noOfPackets.size() > 1) {
				dataset.addValue(Math.abs(noOfPackets.get(i) - noOfPackets.get(i - 1)), "Transmitted Packet",
						count * Activator.getDefault().getPreferenceStore().getInt("TIMER") + "");
			} else {
				dataset.addValue(0, "Transmitted Packet",
						count * Activator.getDefault().getPreferenceStore().getInt("TIMER") + "");
			}
			count++;
		}

		for (int i = startRange1; i < endRange1; i++) {
			if (noOfRecPackets.size() > 1) {
				dataset.addValue(Math.abs(noOfRecPackets.get(i) - noOfRecPackets.get(i - 1)), "Received Packet",
						count1 * Activator.getDefault().getPreferenceStore().getInt("TIMER") + "");
			} else {
				dataset.addValue(0, "Received Packet",
						count1 * Activator.getDefault().getPreferenceStore().getInt("TIMER") + "");
			}
			count1++;
		}
		// rangeAxis.setRange(-0.1, max > max1 ? max : max1);
		rangeAxis.setRange(0, 1000);
	}

	@Override
	public void dispose() {
		unregisterListeners();
	}

	private void unregisterListeners() {
		if (firstElement != null) {
			if (firstElement instanceof Adapter) {
				Adapter adapter = (Adapter) firstElement;
				if (adapter.eAdapters().contains(adapterImpl)) {
					adapter.eAdapters().remove(adapterImpl);
				}
			} else if (firstElement instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) firstElement;
				if (subsystem.eAdapters().contains(adapterImpl)) {
					subsystem.eAdapters().remove(adapterImpl);
				}
			}
		}
	}

}