package com.spintech.ma6ic.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.util.EList;

import com.spintech.ma6ic.ui.utils.Utils;

import ma6icmodel.Adapter;
import ma6icmodel.ErrorTelemetry;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
public class Parser {

	private String subsystemID;
	private BufferedWriter bufferedWriter1;

	public void parse(String filePath, boolean isFresh, String folderName) {

		String string = null;
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("ddMMYYYY_HHmmss");
		String dateTime = dateFormat.format(now);
		String dateTime1 = dateFormat1.format(now);

		String SOURCE_FOLDER = Activator.getDefault().getPreferenceStore().getString("BACKUP_PATH");

		Boolean myPrefStoreSubSys = Activator.getDefault().getPreferenceStore().getBoolean("STORE_SSYS_BOOLEAN_VALUE");
		Boolean myPrefStoreAdp = Activator.getDefault().getPreferenceStore().getBoolean("STORE_ADAPTER_BOOLEAN_VALUE");

		File theDir = new File(SOURCE_FOLDER + "\\" + folderName + "_" + dateTime);

		try {
			FileReader input = new FileReader(filePath);

			BufferedReader bufRead = new BufferedReader(input);
			if (isFresh) {
				Manager.getInstance().getMa6ic().getSubsystems().clear();
				Manager.getInstance().getMa6ic().getAdapters().clear();
				Manager.getInstance().getMa6ic().getComputer().getAdapters().clear();
				Manager.getInstance().getMa6ic().getComputer().getTelemetry().clear();
				Manager.getInstance().getMa6ic().getErrorTelemetries().clear();
			}

			EList adapters = Manager.getInstance().getMa6ic().getAdapters();
			for (Object object : adapters) {
				((Adapter) object).setValid(false);
			}

			EList subsystems = Manager.getInstance().getMa6ic().getSubsystems();

			for (Object object : subsystems) {
				((Subsystem) object).setValid(false);
			}

			Subsystem subsystem;
			String line;
			int lineCounter = 0;
			while ((line = bufRead.readLine()) != null) {
				lineCounter++;
				string = line;
				String telemetryArray[] = string.split("\\|", -1);

				String telemetryType = string.substring(0, 1);
				// Adapter Telemetry
				if (telemetryType.equalsIgnoreCase("1")) {

					String adapterID = string.substring(1, 3);

					Adapter adapter = Utils.findAdapter(adapterID);

					ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
               // Set Error telemetry if config file  does not exist
					if (adapter == null) {
						errorTelemetry.setTelemetry("Adapter Config");
						errorTelemetry.setError(
								new StringBuilder("Adapter Telemetry Config file not Found for " + adapterID + " ID")
										.toString());
						errorTelemetry.setTime(new Date());
						Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						break;

					}

					if (string.length() == adapter.getTelemetrySize() + 1) {
						// Left for Error Handling in Future if the Length of
						// the Message is equal but values are invalid
						// for (int i = 1; i < telemetryArray.length; i++) {
						//
						// adapter.getTelemetry().get(i-1);
						//
						// int actualLength = telemetryArray[i].length();
						// Telemetry telemetry = adapter.getTelemetry().get(i -
						// 1);
						// int proposedLength = telemetry.getLength();
						// if (actualLength != proposedLength) {
						// ErrorTelemetry errorTelemetry =
						// Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
						// errorTelemetry.setTelemetry(telemetry.getParameter());
						// errorTelemetry.setError(
						// (new StringBuilder("In Adapter " + adapter.getName()
						// + " Size error - "))
						// .append(actualLength).append("instead
						// of").append(proposedLength)
						// .toString());
						// errorTelemetry.setTime(new Date());
						// Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						// }
						// }

					} else {

						errorTelemetry.setTelemetry("Adapter Length");
						errorTelemetry.setError(new StringBuilder(
								"Adapter Telemetry at Line No" + lineCounter + " hase an invalid length").toString());
						errorTelemetry.setTime(new Date());
						Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						continue;
					}

					adapter.setValid(true);
					Manager.getInstance().getMa6ic().getComputer().getAdapters().add(adapter);

					EList<Telemetry> telemetries = adapter.getTelemetry();
					int startCounter = 1;
					int counter = 1;
					for (Telemetry telemetry : telemetries) {
						int length = telemetry.getLength();
						String value = string.substring(startCounter, startCounter + length);
						telemetry.setValue(value);

						if (counter == 2) {
							adapter.getNoOfPackets().add(Integer.valueOf(Integer.parseInt(value, 16)));
						}

						counter++;
						startCounter = startCounter + length;
					}

					// Store the adapter data if it checked in preference
					if (myPrefStoreAdp) {
						adapterDataBackUp(dateTime1, theDir, adapter);
					}
					continue;
				}

				// Unknown Parameters

				else if (telemetryType.equalsIgnoreCase("2")) {
					String substring2 = string.substring(1, 4);
					String substring3 = string.substring(4);
					Telemetry telemetry = Utils.getComputerTelemetry(substring3, substring2);
					telemetry.setValue(substring3);
					telemetry.setParameter(substring2);
					Manager.getInstance().getMa6ic().getComputer().getTelemetry().add(telemetry);
					continue;

				}

				// End : Unknown Parameters
				// Subsystem Telemetry

				else if (telemetryType.equalsIgnoreCase("0")) {
					Adapter adapter = null;
					subsystemID = string.substring(1, 4);

					subsystem = Utils.findSubsystem(subsystemID, "-1");

					ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
					// Set Error telemetry if config file  does not exist
					if (subsystem == null) {
						errorTelemetry.setTelemetry("Subsystem Config");
						errorTelemetry.setError(new StringBuilder(
								"Subsystem Telemetry Config file not Found for " + subsystemID + " ID").toString());
						Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						continue;
					}

					if (string.length() == subsystem.getTelemetrySize() + 1) {
						// checkSubsystemTelemetryLength(telemetryArray);
						// for (int i = 1; i < telemetryArray.length; i++) {
						// int actualLength = telemetryArray[i].length();
						// Telemetry telemetry = subsystem.getTelemetry().get(i
						// - 1);
						// int proposedLength = telemetry.getLength();
						// if (actualLength != proposedLength) {
						// ErrorTelemetry errorTelemetry =
						// Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
						// errorTelemetry.setTelemetry(telemetry.getParameter());
						// errorTelemetry.setError(
						// (new StringBuilder("In Subsystem " +
						// subsystem.getName() + " Size error - "))
						// .append(actualLength).append("instead
						// of").append(proposedLength)
						// .toString());
						// errorTelemetry.setTime(new Date());
						// Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						// }
						// }

					} else {

						errorTelemetry.setTelemetry("Subsystem Length");
						errorTelemetry.setError(new StringBuilder(
								"Subsystem Telemetry at Line No" + lineCounter + " hase an invalid length").toString());
						Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						break;
					}

					subsystem.setValid(true);
					Manager.getInstance().getMa6ic().getSubsystems().add(subsystem);

					int noOfPackets = 0;

					EList<Telemetry> telemetries = subsystem.getTelemetry();
					int startCounter = 1;
					int counter = 1;
					for (Telemetry telemetry : telemetries) {
						int length = telemetry.getLength();
						String value = string.substring(startCounter, startCounter + length);
						telemetry.setValue(value);

						if (counter == 3) {
							noOfPackets = Integer.valueOf(Integer.parseInt(value, 16));
							subsystem.getNoOfPackets().add(noOfPackets);
						}
						if (counter == 2) {
							adapter = Utils.findAdapterForSubsystem(value);
						}
						if (counter == 4) {
							noOfPackets = Integer.valueOf(Integer.parseInt(value, 16));
							subsystem.getNoOfReceivedPacket().add(noOfPackets);
						}

						counter++;
						startCounter = startCounter + length;
					}

					if (!checkSubSystem(subsystemID, adapter)) {
						if (adapter != null) {
							if (subsystem.getAdapter() != null) {
								if (!subsystem.getAdapter().equals(adapter)) {
									subsystem.getAdapter().getSubsystems().remove(subsystem);
								}
							}
							adapter.getSubsystems().add(subsystem);
						} else {
							if (subsystem.getAdapter() != null) {
								subsystem.getAdapter().getSubsystems().remove(subsystem);
							}
						}
					}

					// Store the SubSystem data if it checked in preference
					if (myPrefStoreSubSys) {

						subsystemDataBackup(dateTime1, theDir, subsystem);
					}
				} else {
					ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
					errorTelemetry.setTelemetry("Invalid Telemetry Type");
					errorTelemetry.setError(
							(new StringBuilder("Invalid Telemetry Type found at Line No " + lineCounter).toString()));
					errorTelemetry.setTime(new Date());
					Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
				}

				// End : Subsystem Telemetry
			}

			removeUnwantedElements();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void subsystemDataBackup(String dateTime1, File theDir, Subsystem subsystem) {
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		if (theDir.exists()) {
			File theSsys = new File(theDir + "\\" + "SubSys_" + subsystem.getName());
			if (!theSsys.exists()) {
				System.out.println("creating Adapter directory: " + theSsys.getName());
				try {
					theSsys.mkdir();
					System.out.println("SubSys DIR created");
				} catch (SecurityException se) {
					// handle it
				}
			}
			// write the data into file
			File ssysfPath = new File(
					theDir + "\\" + "SubSys_" + subsystem.getName() + "\\" + subsystem.getName() + ".csv");
			StringBuffer stringBuffer1 = new StringBuffer();
			if (!ssysfPath.exists()) {
				try {
					ssysfPath.createNewFile();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			EList<Telemetry> telemetries = subsystem.getTelemetry();
			stringBuffer1.append("SybSystem Telemetry Captured at: >>" + dateTime1 + "\n");
			for (Telemetry telemetry : telemetries) {
				stringBuffer1.append(
						telemetry.getParameter() + "," + telemetry.getValue() + "," + telemetry.getUnit() + " \n");

			}
			try {
				FileWriter fileWriter1 = new FileWriter(ssysfPath, true);

				BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
				bufferedWriter1.write(stringBuffer1 + "\n");
				bufferedWriter1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private void adapterDataBackUp(String dateTime1, File theDir, Adapter adapter) {
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		// check the root dir and if exist create adapter
		// directories
		if (theDir.exists()) {

			File theAdp = new File(theDir + "\\" + "Ma6ic_" + adapter.getName());
			if (!theAdp.exists()) {
				System.out.println("creating Adapter directory: " + theAdp.getName());

				try {
					theAdp.mkdir();
					System.out.println("Adp DIR created");
				} catch (SecurityException se) {
					// handle it
				}

			}

			// write the data into file
			File adpfPath = new File(theDir + "\\" + "Ma6ic_" + adapter.getName() + "\\" + adapter.getName() + ".csv");
			StringBuffer stringBuffer = new StringBuffer();
			if (!adpfPath.exists()) {
				try {
					adpfPath.createNewFile();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			EList<Telemetry> telemetries = adapter.getTelemetry();
			stringBuffer.append("Adapter Telemetry Captured at: >>" + dateTime1 + "\n");
			for (Telemetry telemetry : telemetries) {
				stringBuffer.append(
						telemetry.getParameter() + "," + telemetry.getValue() + "," + telemetry.getUnit() + "\n");

			}
			try {

				FileWriter fileWriter = new FileWriter(adpfPath, true);

				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(stringBuffer + "\n");
				bufferedWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
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

		// if (objectsToRemove.size() > 0 || subSysToRemove.size() > 0) {
		// Runnable run = new Runnable() {
		// public void run() {
		// MessageDialog.openInformation(Display.getDefault().getActiveShell(),
		// "Removing Non Existent SubSystems",
		// "Count Subsystem = " + subSysToRemove.size() + "Adapter = " +
		// objectsToRemove.size());
		//
		// }
		// };
		// Display.getDefault().asyncExec(run);
		// }
	}

	private boolean checkSubSystem(String subsystem, Adapter adapter) {
		if (adapter == null) {
			return false;
		}
		EList<Subsystem> subsystemsAdapter = adapter.getSubsystems();
		for (Subsystem subsystemAdapter : subsystemsAdapter) {
			if (subsystemAdapter.getName().equals(subsystem)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Parser_New parser = new Parser_New();
		parser.parse("D:\\eclipse\\commands\\TelemetryFile_New.txt", true, "test");

	}
}