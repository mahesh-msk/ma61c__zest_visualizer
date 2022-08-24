package com.spintech.ma6ic.ui.labelproviders;

import ma6icmodel.Command;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class cmdTableLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		
		switch (columnIndex) {
		
		case 0:
			if (element instanceof Command) {
				Command command = (Command) element;
				return command.getTelecommand();
			}
		case 1:			
			if (element instanceof Command) {
				Command command = (Command) element;
				return command.getExecutionStatus() != null ? command.getExecutionStatus():"";
			}

		default:
			break;
		}
		
		return null;
	}


}
