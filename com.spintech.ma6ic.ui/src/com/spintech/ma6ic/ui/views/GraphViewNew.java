package com.spintech.ma6ic.ui.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.experimental.chart.swt.ChartComposite;

import com.spintech.ma6ic.ui.Activator;

import ma6icmodel.Adapter;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;

public class GraphViewNew extends ViewPart implements ISelectionListener {

	private XYSeriesCollection  dataset;
	private JFreeChart lineChart;
	private ChartComposite chartComposite;
	
	private Action rangeAction;
	private Object firstElement;

	public GraphViewNew() {
		createActions();
		// TODO Auto-generated constructor stub
	}
	private void createActions() {
		{
			rangeAction = new Action("Select Range") {
				@Override
				public void run() {
					InputDialog iDialog = new InputDialog(Display.getDefault().getActiveShell(), "Graph Range Dialog", "Mention Range of Values to Display on Graph. For e.g 1:20", "1:20", null);
					int open = iDialog.open();
					if(IDialogConstants.OK_ID == open) {
						String value = iDialog.getValue();
						String[] ranges = value.split(":");
						String startRange = ranges[0];
						String endRange = ranges[1];
						
//						dataset.clear();
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
			
			rangeAction.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/compare_view.gif"));
		}
	}
	
//	final Color adapterColor = new Color(174, 145,
//			71);

	@Override
	public void createPartControl(Composite parent) {
		
		
		
		dataset = new XYSeriesCollection( );
		
		lineChart = ChartFactory.createXYLineChart(
		         "No of Packets",
		         "Seconds","Number of Packets",
		         dataset,
		         PlotOrientation.VERTICAL,
		         false,true,false);
		chartComposite = new ChartComposite(parent, SWT.NONE, lineChart, true);
		getSite().getPage().addSelectionListener(this);
		final XYPlot plot = lineChart.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.RED );
	      renderer.setSeriesPaint( 1 , Color.GREEN );
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
	      plot.setRenderer( renderer ); 
		
		
		
		
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(rangeAction);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof InterfaceViewOld || part instanceof InterfaceViewNew) {
			IStructuredSelection sSelection = (IStructuredSelection)selection;
			
			if(firstElement != null) {
				if (firstElement instanceof Adapter) {
					Adapter adapter = (Adapter) firstElement;
					adapter.eAdapters().clear();
				} else if (firstElement instanceof Subsystem) {
					Subsystem subsystem = (Subsystem) firstElement;
					subsystem.eAdapters().clear();
				}
			}
			
			
			firstElement = sSelection.getFirstElement();
			if (firstElement instanceof Adapter) {
				
				
				Adapter adapter = (Adapter) firstElement;
				adapter.eAdapters().clear();
				AdapterImpl adapterImpl = new AdapterImpl(){
					@Override
					public void notifyChanged(Notification msg) {
						EStructuralFeature feature = (EStructuralFeature) msg.getFeature();
						if(feature != null) {
						if(feature.equals(Ma6icmodelPackage.Literals.ADAPTER__NO_OF_PACKETS)) {
							
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
				
			}  else if (firstElement instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) firstElement;
				
				subsystem.eAdapters().clear();
				AdapterImpl adapterImpl = new AdapterImpl(){
					@Override
					public void notifyChanged(Notification msg) {
						EStructuralFeature feature = (EStructuralFeature) msg.getFeature();
						if(feature != null) {
						if(feature.equals(Ma6icmodelPackage.Literals.ADAPTER__NO_OF_PACKETS)) {
							
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
		
		int startRange = noOfPackets.size()-10;
		if(startRange < 0) {
			startRange = 1;
		}
		int endRange = noOfPackets.size();
		
		updateGraph(adapter, startRange, endRange);

	}
	
	private void updateGraph(Subsystem subsystem) {
		List series = dataset.getSeries();
		
		for (Object object : series) {
			
			series.remove(object);
			
		}
		
		EList<Integer> noOfPackets = subsystem.getNoOfPackets();
		EList<Integer> noOfReceivedPackets = subsystem.getNoOfReceivedPacket();
		int count = 1;
		final XYSeries transmittedPackets = new XYSeries( "Transmitted Packets" );  
		for (Integer noOfPckt : noOfPackets) {
			        
			transmittedPackets.add((double)noOfPckt , count * Activator.getDefault().getPreferenceStore().getInt("TIMER") );                  

			 count++;
		}
		
		final XYSeries receivedPackets = new XYSeries( "Received Packets" );  
		for (Integer noOfPckt : noOfReceivedPackets) {
			        
			receivedPackets.add((double)noOfPckt , count * Activator.getDefault().getPreferenceStore().getInt("TIMER") );                  

			 count++;
		}
		
		dataset.addSeries(transmittedPackets);
		dataset.addSeries(receivedPackets);
	}
	
	private void updateGraph(Adapter adapter, int startRange, int endRange) {
		
		List series = dataset.getSeries();
		
		for (Object object : series) {
			
			series.remove(object);
			
		}
		
		EList<Integer> noOfPackets = adapter.getNoOfPackets();
		int count = startRange;
		if(startRange > noOfPackets.size()) {
			return;
		}
		
		
		
		if(endRange > noOfPackets.size()) {
			endRange = noOfPackets.size()-1;
		}
		
final XYSeries transmittedPackets = new XYSeries( "Transmitted Packets" ); 
		
		for (int i = startRange; i < endRange; i++) {
			transmittedPackets.add((double)noOfPackets.get(i) , count * Activator.getDefault().getPreferenceStore().getInt("TIMER") );                  
			 count++;
		}
		
		dataset.addSeries(transmittedPackets);

	}
	
	private void updateGraph(Subsystem subsystem, int startRange, int endRange) {
		EList<Integer> noOfPackets = subsystem.getNoOfPackets();
		EList<Integer> noOfReceivedPackets = subsystem.getNoOfReceivedPacket();
		int count = startRange;
		if(startRange > noOfPackets.size()) {
			return;
		}
		
		if(endRange > noOfPackets.size()) {
			endRange = noOfPackets.size()-1;
		}
		
		final XYSeries transmittedPackets = new XYSeries( "Transmitted Packets" ); 
		
		for (int i = startRange; i < endRange; i++) {
			transmittedPackets.add((double)noOfPackets.get(i) , count * Activator.getDefault().getPreferenceStore().getInt("TIMER") );                  
			 count++;
		}
		
		final XYSeries receivedPackets = new XYSeries( "Received Packets" );  
		for (int i = startRange; i < endRange; i++) {
			        
			receivedPackets.add((double)noOfReceivedPackets.get(i) , count * Activator.getDefault().getPreferenceStore().getInt("TIMER") );                  

			 count++;
		}
		
		dataset.addSeries(transmittedPackets);
		dataset.addSeries(receivedPackets);
		
	}
	
	@Override
	public void dispose() {
		if(firstElement != null) {
			if (firstElement instanceof Adapter) {
				Adapter adapter = (Adapter) firstElement;
				adapter.eAdapters().clear();
			} else if (firstElement instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) firstElement;
				subsystem.eAdapters().clear();
			}
		}
	}

}