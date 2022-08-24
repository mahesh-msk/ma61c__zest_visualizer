package com.spintech.ma6ic.ui.labelproviders;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGBA;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.views.InterfaceViewOld;

import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

public class InterfaceViewGraphicalLabelProvider extends LabelProvider implements IColorProvider, IFontProvider {
	/**
	 * 
	 */
	private final InterfaceViewOld InterfaceViewLabelProvider;

	/**
	 * @param interfaceViewOld
	 */
	public InterfaceViewGraphicalLabelProvider(InterfaceViewOld interfaceViewOld) {
		InterfaceViewLabelProvider = interfaceViewOld;
	}

	private Image computerImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/computer2.png")
			.createImage();
	private Image adapterImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/adap.png")
			.createImage();
	private Image subSystemImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "images/dev1.png")
			.createImage();

	@Override
	public String getText(Object element) {
		if (element instanceof Computer) {
			Computer computer = (Computer) element;
//			return computer.getName();
			return "PC";
		} else if (element instanceof Adapter) {
			Adapter adapter = (Adapter) element;
			return Integer.parseInt(adapter.getName()) + "";
		} else if (element instanceof Subsystem) {
			Subsystem subsystem = (Subsystem) element;
			return Integer.parseInt(subsystem.getName()) + "";
		} else if (element instanceof EntityConnectionData) {
			EntityConnectionData test = (EntityConnectionData) element;
			Object object = test.dest;
			if (object instanceof Subsystem) {
				Subsystem adapter = (Subsystem) object;
				EList<Telemetry> telemetry = adapter.getTelemetry();
				for (Telemetry telemetry2 : telemetry) {
					if (telemetry2.getParameter().equalsIgnoreCase("Sub-system interface")) {
						String value = telemetry2.getValue();
						if (value.equals("1")) {
							return "SpaceWire";
						} else if (value.equals("2")) {
							return "CAN";
						} else if (value.equals("3")) {
							return "MIL";
						} else if (value.equals("4")) {
							return "UART";
						} else if (value.equals("5")) {
							return "I2C";
						} else if (value.equals("6")) {
							return "SPI";
						} else if (value.equals("7")) {
							return "JTAG";
						}
					}
				}
			} else if (test.dest instanceof Adapter) {
				Adapter adapter = (Adapter) test.dest;
				EList<Telemetry> telemetry = adapter.getTelemetry();
				for (Telemetry telemetry2 : telemetry) {
					if (telemetry2.getParameter().equalsIgnoreCase("Active Interface")) {
						String value = telemetry2.getValue();
						if (value.equals("1")) {
							return "SpaceWire";
						} else if (value.equals("2")) {
							return "CAN";
						} else if (value.equals("3")) {
							return "MIL";
						} else if (value.equals("4")) {
							return "UART";
						} else if (value.equals("5")) {
							return "I2C";
						} else if (value.equals("6")) {
							return "SPI";
						}else if (value.equals("7")) {
							return "JTAG";
						}
					}
				}
			}
			return "";
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof Computer) {
			return computerImage;
		} else if (element instanceof Adapter) {
			return adapterImage;
		} else if (element instanceof Subsystem) {
			return subSystemImage;
		}
		return super.getImage(element);
	}

	public Color getForeground(Object element) {
		return null;
	}

	private Color computerColor = new Color(Display.getDefault() , new RGBA(134,140,152,0)); //16, 45, 57
	private Color adapterColor = new Color(Display.getDefault(), new RGBA(134,140,152,0)); //174, 145, 71
	private Color subsystemColor = new Color(Display.getDefault(), new RGBA(134,140,152,0)); //47, 91, 110

	public Color getBackground(Object element) {
		if (element instanceof Computer) {
			return computerColor;
		} else if (element instanceof Adapter) {
			if (((Adapter) element).isValid()) {
				return adapterColor;
			} else {
				return Display.getDefault().getSystemColor(SWT.COLOR_RED);
			}

		} else if (element instanceof Subsystem) {
			if (((Subsystem) element).isValid()) {
				return subsystemColor;
			} else {
				return Display.getDefault().getSystemColor(SWT.COLOR_RED);
			}
		}
		return null;
	}

	private Font font = new Font(Display.getDefault(), "Euphemia EUCAS", 10, SWT.BOLD);


	public Font getFont(Object element) {
		return font;
	}
	
	


}