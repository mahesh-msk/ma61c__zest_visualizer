package com.spintech.ma6ic.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

public class CommandsView extends ViewPart {
	private Table table;

	public CommandsView() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableColumn tblclmnTelecommands = new TableColumn(table, SWT.NONE);
		tblclmnTelecommands.setWidth(272);
		tblclmnTelecommands.setText("Telecommands");
		
		TableColumn tblclmnExecutionStatus = new TableColumn(table, SWT.NONE);
		tblclmnExecutionStatus.setWidth(308);
		tblclmnExecutionStatus.setText("Execution status ");
		// TODO Auto-generated method stub

	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
