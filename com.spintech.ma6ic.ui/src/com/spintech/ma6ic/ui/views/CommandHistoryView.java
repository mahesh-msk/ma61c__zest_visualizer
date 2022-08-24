package com.spintech.ma6ic.ui.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ma6icmodel.Command;
import ma6icmodel.Computer;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Subsystem;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.labelproviders.cmdTableLabelProvider;
import com.spintech.ma6ic.ui.utils.Utils;

public class CommandHistoryView extends ViewPart implements ISelectionListener {
	private ImageDescriptor exportImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/export.png");
	private Table table;
	private TableViewer tableViewerCmdHistory;
	private Subsystem subsystem;

	public CommandHistoryView() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		tableViewerCmdHistory = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewerCmdHistory.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableColumn tblclmnFunctionalitiesOfThe = new TableColumn(table, SWT.NONE);
		tblclmnFunctionalitiesOfThe.setWidth(167);
		tblclmnFunctionalitiesOfThe.setText("Functionalities of the driver");
		
		TableColumn tblclmnExecutionStatus = new TableColumn(table, SWT.NONE);
		tblclmnExecutionStatus.setWidth(134);
		tblclmnExecutionStatus.setText("Execution status");
		

		tableViewerCmdHistory.setContentProvider(ArrayContentProvider.getInstance());
		tableViewerCmdHistory.setLabelProvider(new cmdTableLabelProvider());
		
		getSite().getPage().addSelectionListener(this);

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
		// TODO Auto-generated method stub

	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			Object firstElement = sSelection.getFirstElement();
			
			ArrayList<Command> arrayList = new ArrayList<Command>();
			if (firstElement instanceof Subsystem) {
				subsystem = (Subsystem) firstElement;
				int subsystemID = Integer.parseInt(subsystem.getName(), 16);
				String commandsDirectory = Platform.getInstallLocation().getURL().getPath();
				File file = new File(commandsDirectory + "/commands/CommandTextFile.txt");

				if (file.exists()) {
					String sCurrentLine;

					try {
						BufferedReader br = new BufferedReader(new FileReader(file));

						while ((sCurrentLine = br.readLine()) != null) {
							String[] split = sCurrentLine.split(",");
							
							if(sCurrentLine.isEmpty()) {
								continue;
							}
							
							if(subsystemID==Integer.parseInt(split[0],16)){
								
								Command command= Ma6icmodelFactory.eINSTANCE.createCommand();
								command.setCommandId(split[1]);
								command.setTelecommand(split[2]);
								arrayList.add(command);
							
							}
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					tableViewerCmdHistory.setInput(arrayList);

			}
		}
	}

	private boolean duplicateCommand(String commandID) {
		EList<Command> commands = subsystem.getCommand();
		for (Command command : commands) {
			if (command.getCommandId().equals(commandID)) {
				return true;
			}
		}
		return false;
	}

}
