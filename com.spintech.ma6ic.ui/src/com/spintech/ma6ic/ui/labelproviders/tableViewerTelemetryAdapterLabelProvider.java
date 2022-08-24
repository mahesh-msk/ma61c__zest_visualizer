package com.spintech.ma6ic.ui.labelproviders;

import ma6icmodel.Adapter;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

public class tableViewerTelemetryAdapterLabelProvider extends LabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {

		switch (columnIndex) {
		case 0:
			if (element instanceof Telemetry) {
				Telemetry telemetry = (Telemetry) element;
				return telemetry.getParameter();
			}
		case 1:
			if (element instanceof Telemetry) {
				Telemetry telemetry = (Telemetry) element;
				return telemetry.getDescription();
			}
		case 2:
			if (element instanceof Telemetry) {
				Telemetry telemetry = (Telemetry) element;

				if (telemetry.getValue() == null && !telemetry.getParameter().equals("Sub system id")) {
					return "";
				}
				// Adapter Telemetry Parameters
				if (telemetry.getParameter().equals("Adapter id")) {
					return Integer.parseInt(telemetry.getValue()) + "";
				} else if (telemetry.getParameter().equals("Active interface")) {
					int interfaceID = Integer.parseInt(telemetry.getValue());
					return getInterfaceType(interfaceID);
				} else if (telemetry.getParameter().equals("Bus Speed")) {
					String value = telemetry.getValue();
					String voltageValue = value.substring(1);
					voltageValue = Integer.toString(Integer.parseInt(value, 16));
					return voltageValue;
				} else if (telemetry.getParameter().equals("Adapter Status")) {
					String value = telemetry.getValue();
					if (value.equals("0")) {
						return "Not Connected";
					} else {
						return "Connected";
					}
				} else if (telemetry.getParameter().equals("Status of Last Command Execution")) {
					String value = telemetry.getValue();
					if (value.equals("0")) {
						return "Not Executed";
					} else if (value.equals("1")) {
						return "Executed";
					} else {
						return "In Process of Execution";
					}
				} else if (telemetry.getParameter().equals("OBDH Interface")) {
					int interfaceID = Integer.parseInt(telemetry.getValue());
					return getInterfaceType(interfaceID);
				} else if (telemetry.getParameter().equals("Active CPU")) {
					String value = telemetry.getValue();
					if (value.equals("0")) {
						return "None";
					} else if (value.equals("1")) {
						return "CPU#1";
					} else if (value.equals("2")) {
						return "CPU#2";
					} else {
						return "CPU#1 & CPU#2";
					}
				}
				if (telemetry.getParameter().equals("Sub system id")) {
					EList<Subsystem> subsystems = ((Adapter) telemetry.eContainer()).getSubsystems();
					String subsystemid = new String();
					for (Subsystem subsystem : subsystems) {
						subsystemid += subsystem.getName() + ",";
					}
					return subsystemid;
				}

				// SubSystem Telemetry Parameters
				else if (telemetry.getParameter().equals("Subsystem name")) {
					return Integer.parseInt(telemetry.getValue()) + "";
				}
				else if (telemetry.getParameter().equals("Status")) {
					String value = telemetry.getValue();

					if (value.equals("0")) {
						return "Not Initialised";
					} else if (value.equals("1")) {
						return "Initialised";
					} else {
						return "Error in Initialisation";
					}
				} else if (telemetry.getParameter().equals("Sub-system interface")) {
					int interfaceID = Integer.parseInt(telemetry.getValue());
					return getInterfaceType(interfaceID);
				}
				return Integer.parseInt(telemetry.getValue(), 16) + "";
			}
		case 3:
			if (element instanceof Telemetry) {
				Telemetry telemetry = (Telemetry) element;
				return telemetry.getUnit();
			}

		default:
			break;
		}

		if (element instanceof Telemetry) {
			Telemetry telemetry = (Telemetry) element;
			return telemetry.getDescription();
		}
		return null;
	}

	private String getInterfaceType(int interfaceID) {
		String result = "";
		switch (interfaceID) {
		case 1:
			result = "SpaceWire";
			break;
		case 2:
			result = "CAN";
			break;
		case 3:
			result = "MIL";
			break;
		case 4:
			result = "UART";
			break;
		case 5:
			result = "I2C";
			break;
		case 6:
			result = "SPI";
			break;
		case 7:
			result = "JTAG";
			break;
		default:
			break;
		}
		return result;
	}

}
