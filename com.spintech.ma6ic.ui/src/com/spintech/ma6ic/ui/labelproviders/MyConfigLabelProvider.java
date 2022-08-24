package com.spintech.ma6ic.ui.labelproviders;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import ma6icmodel.Telemetry;

public class MyConfigLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		//// List cnf = (List) element;
		// if (element instanceof ArrayList) {
		// ArrayList tel = (ArrayList) element;
		// switch (columnIndex) {
		// case 0:
		// return tel.get(0).toString();
		// case 1:
		// return tel.get(1).toString();
		// case 2:
		// return tel.get(2).toString();
		// case 3:
		// return tel.get(3).toString();
		// default:
		// break;
		//
		// }
		//
		// }
		if (element instanceof Telemetry) {
			Telemetry tel = (Telemetry) element;
			switch (columnIndex) {
			case 0:
				return tel.getParameter().toString();
			case 1:
				return tel.getDescription().toString();
			case 2:
				return tel.getUnit().toString();
			case 3:
				return Integer.toString(tel.getLength());
			default:
				break;

			}
		}

		return null;
	}

}
