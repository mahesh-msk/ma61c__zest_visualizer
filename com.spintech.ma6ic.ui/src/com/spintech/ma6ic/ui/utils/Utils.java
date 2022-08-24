package com.spintech.ma6ic.ui.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.spintech.ma6ic.ui.Manager;

import ma6icmodel.Adapter;
import ma6icmodel.ErrorTelemetry;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

public class Utils {

	public static Adapter findAdapter(String adapterID) {
		File adpConfgFile = new File(Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs\\"
				+ "AdapterTelemetryConfig_" + adapterID + ".txt");
		
		if (!adpConfgFile.exists()) {

			return null;
		}

		
		EList<Adapter> adapters = Manager.getInstance().getMa6ic().getAdapters();
		for (Adapter adapter : adapters) {
			if (adapter.getName().equals(adapterID)) {
				return adapter;
			}
		}

		Adapter adapter = Ma6icmodelFactory.eINSTANCE.createAdapter();
		adapter.setName(adapterID);
		Manager.getInstance().getMa6ic().getAdapters().add(adapter);

		
	
		// Open the file
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs\\"
					+ "AdapterTelemetryConfig_" + adapterID + ".txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String strLine;
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		// Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null) {

				// System.out.println (strLine);
				if (strLine.isEmpty()) {
					continue;
				}
				String[] parts = strLine.split("\\|");
				String part1 = parts[0]; // param
				String part2 = parts[1]; // desc
				String part3 = parts[2]; // Unit
				int part4 = Integer.parseInt(parts[3]); // len
				Telemetry telemetryPower1 = Ma6icmodelFactory.eINSTANCE.createTelemetry();
				telemetryPower1.setParameter(part1);
				telemetryPower1.setDescription(part2);
				telemetryPower1.setUnit(part3);
				telemetryPower1.setLength(part4);
				adapter.getTelemetry().add(telemetryPower1);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return adapter;
	}

	public static Subsystem findSubsystem(String subsystemID, String activeInterface) {
		
		File subSysConfgFile = new File(Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs\\"
				+ "SubSysTelemetryConfig_" + subsystemID + ".txt");
		if (!subSysConfgFile.exists()) {

			return null;
		}
		
		EList<Subsystem> subsystems = Manager.getInstance().getMa6ic().getSubsystems();
		for (Subsystem subsystem : subsystems) {
			if (subsystem.getName().equals(subsystemID)) {
				return subsystem;
			}
		}

		Subsystem subsystem2 = Ma6icmodelFactory.eINSTANCE.createSubsystem();
		subsystem2.setName(subsystemID);
		Manager.getInstance().getMa6ic().getSubsystems().add(subsystem2);

		
		// Open the file
		FileInputStream fstream1 = null;
		try {
			fstream1 = new FileInputStream(Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs\\"
					+ "SubSysTelemetryConfig_" + subsystemID + ".txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String strLine1;
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
		// Read File Line By Line
		try {
			while ((strLine1 = br1.readLine()) != null) {
				// System.out.println (strLine);
				String[] parts = strLine1.split("\\|");
				String part1 = parts[0]; // param
				String part2 = parts[1]; // desc
				String part3 = parts[2]; // Unit
				int part4 = Integer.parseInt(parts[3]); // len
				Telemetry telemetryPower1 = Ma6icmodelFactory.eINSTANCE.createTelemetry();
				telemetryPower1.setParameter(part1);
				telemetryPower1.setDescription(part2);
				telemetryPower1.setUnit(part3);
				telemetryPower1.setLength(part4);
				subsystem2.getTelemetry().add(telemetryPower1);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Close the input stream
		try {
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return subsystem2;
	}

	public static Telemetry getTelemetry(Adapter adapter, String string) {
		EList<Telemetry> telemetries = adapter.getTelemetry();
		for (Telemetry telemetry : telemetries) {
			if (telemetry.getParameter().equals(string)) {
				return telemetry;
			}
		}
		return null;
	}

	public static Telemetry getComputerTelemetry(String string, String subsystemID) {
		EList<Telemetry> telemetries = Manager.getInstance().getMa6ic().getComputer().getTelemetry();
		for (Telemetry telemetry : telemetries) {
			if (telemetry.getValue().equals(string) && telemetry.getParameter().equals(subsystemID)) {
				return telemetry;
			}
		}
		Telemetry telemetry = Ma6icmodelFactory.eINSTANCE.createTelemetry();
		return telemetry;
	}

	public static Telemetry getSTelemetry(Subsystem subsystem, String string) {
		EList<Telemetry> telemetries = subsystem.getTelemetry();
		for (Telemetry telemetry : telemetries) {
			if (telemetry.getParameter().equals(string)) {
				return telemetry;
			}
		}
		return null;
	}

	public static Adapter findAdapterForSubsystem(String adapterID) {
		EList adapters = Manager.getInstance().getMa6ic().getAdapters();
		Iterator iterator = adapters.iterator();
		while (iterator.hasNext()) {
			Adapter adapter = (Adapter) iterator.next();
			if (adapter.getName().equals(adapterID)) {
				return adapter;
			}
		}

		ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
		errorTelemetry.setTelemetry("Sub-system name");
		errorTelemetry.setError("Sub-system ID match");
		errorTelemetry.setTime(new Date());
		Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		return null;

	}

	public static void exportTable(Table table) {

		try {
			int tableColumnSize = table.getColumnCount();
			TableColumn[] columns = table.getColumns();
			TableItem[] items = table.getItems();

			StringBuffer content = new StringBuffer();
			for (TableItem tableItem : items) {
				for (int j = 0; j < tableColumnSize; j++) {
					content.append(tableItem.getText(j)).append(",");
				}
				content.append("\n");
			}

			FileDialog fDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
			String result = fDialog.open();

			if (result == null || result.isEmpty()) {
				return;
			}
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(result)));

			// write contents of StringBuffer to a file
			bwr.write(content.toString());

			// flush the stream
			bwr.flush();

			// close the stream
			bwr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
