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
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.spintech.ma6ic.ui.utils.Utils;

import ma6icmodel.Adapter;
import ma6icmodel.ErrorTelemetry;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
public class Parser_New {

	private String errorTelemetry;
	private BufferedWriter bufferedWriter1;

	public void parse(String filePath, boolean isFresh, String folderName) {

		String string = null;
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");
		String dateTime = dateFormat.format(now);
		String SOURCE_FOLDER = Activator.getDefault().getPreferenceStore().getString("BACKUP_PATH");	

//		File theDir = new File("D:\\" + folderName + "_" + dateTime);
		File theDir = new File(SOURCE_FOLDER +"\\"+ folderName + "_" + dateTime);
		
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

			HashMap adapterMap = new HashMap();
			EList adapters = Manager.getInstance().getMa6ic().getAdapters();
			for (Object object : adapters) {
				adapterMap.put(((Adapter) object).getName(), "0");
				((Adapter) object).setValid(false);
			}

			HashMap subsystemMap = new HashMap();
			EList subsystems = Manager.getInstance().getMa6ic().getSubsystems();

			for (Object object : subsystems) {
				subsystemMap.put(((Subsystem) object).getName(), "0");
				((Subsystem) object).setValid(false);
			}
			Subsystem subsystem;
			String line;
			while ((line = bufRead.readLine()) != null) {
				string = line;
				String telemetryArray[] = string.split("\\|", -1);
				for (int i = 0; i < telemetryArray.length; i++)
					System.out.println((new StringBuilder(String.valueOf(i))).append("=>")
							.append(telemetryArray[i].length()).toString());

				String firstTelemetry = telemetryArray[0];
				Telemetry telemetryPower8;
				String substring10;
				Telemetry telemetryPower9;
				String substring11;
				// Adapter Telemetry
				if (firstTelemetry.equalsIgnoreCase("1")) {

					String substring9 = telemetryArray[1];
					Adapter adapter = Utils.findAdapter(substring9);

					if (telemetryArray.length == adapter.getTelemetry().size()) {
						// checkLengthAdapterTelemetry(telemetryArray);

						for (int i = 1; i < telemetryArray.length; i++) {

							int actualLength = telemetryArray[i].length();
							Telemetry telemetry = adapter.getTelemetry().get(i - 1);
							int proposedLength = telemetry.getLength();
							if (actualLength != proposedLength) {
								ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
								errorTelemetry.setTelemetry(telemetry.getParameter());
								errorTelemetry.setError((new StringBuilder("Size error - ")).append(actualLength)
										.append("instead of").append(proposedLength).toString());
								errorTelemetry.setTime(new Date());
								Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
							}
						}

					} else {
						ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();

						errorTelemetry.setTelemetry("Adapter Length");
						errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray.length - 1)))
								.append(" instead ").append(15).toString());
						errorTelemetry.setTime(new Date());
						Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						continue;
					}

					if (adapterMap.get(substring9) != null) {
						adapterMap.put(substring9, "1");
					}
					adapter.setValid(true);
					Manager.getInstance().getMa6ic().getComputer().getAdapters().add(adapter);

					for (int i = 1; i < telemetryArray.length; i++) {
						String substring2 = telemetryArray[i];
						Telemetry telemetryPower1 = adapter.getTelemetry().get(i - 1);
						telemetryPower1.setValue(substring2);

						if (i == 5) {
							adapter.getNoOfPackets().add(Integer.valueOf(Integer.parseInt(substring2, 16)));
						}

					}


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

							File theAdp = new File(
									theDir + "\\" + "Ma6ic_" + adapter.getName());
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
							File adpfPath = new File(theDir + "\\" + "Ma6ic_"
									+ adapter.getName() + "\\" + adapter.getName() + ".csv");
							StringBuffer stringBuffer = new StringBuffer();
							if (!adpfPath.exists()) {
								try {
									adpfPath.createNewFile();

								} catch (IOException e) {
									e.printStackTrace();
								}
							}

							EList<Telemetry> telemetries = adapter.getTelemetry();
							for (Telemetry telemetry : telemetries) {
								stringBuffer.append(telemetry.getParameter() + "," + telemetry.getValue() + ","
										+ telemetry.getUnit() + " \n");

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
					continue;
				}

				// Unknown Parameters

				else if (telemetryArray[0].equalsIgnoreCase("2")) {
					String substring2 = telemetryArray[1];
					int parseInt = Integer.parseInt(substring2);
					String substring3 = telemetryArray[2].substring(0, parseInt);
					String substring4 = telemetryArray[3];
					Telemetry telemetry = Utils.getComputerTelemetry(substring3, substring4);
					telemetry.setValue(substring3);

					telemetry.setParameter(substring4);
					Manager.getInstance().getMa6ic().getComputer().getTelemetry().add(telemetry);
					continue;

				}

				// End : Unknown Parameters
				// Subsystem Telemetry

				else if (firstTelemetry.equalsIgnoreCase("0")) {
					Adapter adapter = null;
					errorTelemetry = telemetryArray[1];
					subsystem = Utils.findSubsystem(errorTelemetry, "-1");

					if (telemetryArray.length == subsystem.getTelemetry().size()+1) {
						// checkSubsystemTelemetryLength(telemetryArray);
						for (int i = 1; i < telemetryArray.length; i++) {
							int actualLength = telemetryArray[i].length();
							Telemetry telemetry = subsystem.getTelemetry().get(i - 1);
							int proposedLength = telemetry.getLength();
							if (actualLength != proposedLength) {
								ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
								errorTelemetry.setTelemetry(telemetry.getParameter());
								errorTelemetry.setError((new StringBuilder("Size error - ")).append(actualLength)
										.append("instead of").append(proposedLength).toString());
								errorTelemetry.setTime(new Date());
								Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
							}
						}

					} else {
						ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
						errorTelemetry.setTelemetry("Subsystem Length");
						errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray.length - 1)))
								.append(" instead ").append(15).toString());
						Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
						continue;
					}

					if (subsystemMap.get(errorTelemetry) != null) {
						subsystemMap.put(errorTelemetry, "1");
					}

					subsystem.setValid(true);
					Manager.getInstance().getMa6ic().getSubsystems().add(subsystem);
					
					int noOfPackets = 0;
					
					for (int i = 1; i < telemetryArray.length; i++) {
						String substring2 = telemetryArray[i];
						Telemetry telemetryPower1 = subsystem.getTelemetry().get(i - 1);
						telemetryPower1.setValue(substring2);

						if (i == 5) {
							noOfPackets=Integer.valueOf(Integer.parseInt(substring2, 16));
						}
						if (i == 10) {
							adapter = Utils.findAdapterForSubsystem(substring2);
						}
					}
					
					if(adapter != null) {
						adapter.getNoOfPackets().add(noOfPackets);
					}

					if (!checkSubSystem(errorTelemetry, adapter)) {
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
					
					if (theDir.exists()) {
							File theSsys = new File(theDir + "\\" + "SubSys_"
									+ subsystem.getName());
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
							File ssysfPath = new File(theDir + "\\" + "SubSys_"
									+ subsystem.getName() + "\\" + subsystem.getName() + ".csv");
							StringBuffer stringBuffer1 = new StringBuffer();
							if (!ssysfPath.exists()) {
								try {
									ssysfPath.createNewFile();

								} catch (IOException e) {
									e.printStackTrace();
								}
							}

							EList<Telemetry> telemetries = subsystem.getTelemetry();
							for (Telemetry telemetry : telemetries) {
								stringBuffer1.append(telemetry.getParameter() + "," + telemetry.getValue() + ","
										+ telemetry.getUnit() + " \n");

								
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


				// End : Subsystem Telemetry
			}

			removeUnwantedElements();

		} catch (Exception e) {
			e.printStackTrace();
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

		if (objectsToRemove.size() > 0 || subSysToRemove.size() > 0) {
			Runnable run = new Runnable() {
				public void run() {
					MessageDialog.openInformation(Display.getDefault().getActiveShell(),
							"Removing Non Existent SubSystems",
							"Count Subsystem = " + subSysToRemove.size() + "Adapter = " + objectsToRemove.size());

				}
			};
			Display.getDefault().asyncExec(run);
		}
	}

	private void checkSubsystemTelemetryLength(String telemetryArray[]) {
		if (telemetryArray[1].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Sub-system name");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[1].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[2].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Supplier");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[2].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[3].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Status");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[3].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (!telemetryArray[3].equals("0") && !telemetryArray[3].equals("1") && !telemetryArray[3].equals("2")
				&& !telemetryArray[3].equals("3")) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Status");
			errorTelemetry.setError("Out of Bounds");
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[4].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Transmitted packet");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[4].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[5].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Received packet");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[5].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[6].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Data rate");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[6].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[7].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Version");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[7].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[8].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Data sheet id");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[8].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[9].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Sub-system interface");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[9].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (!telemetryArray[9].equals("1") && !telemetryArray[9].equals("2") && !telemetryArray[9].equals("3")
				&& !telemetryArray[9].equals("4") && !telemetryArray[9].equals("5") && !telemetryArray[9].equals("6")) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Sub-system interface");
			errorTelemetry.setError("Out Of Bounds");
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[10].length() != 2) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Adapter id");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[10].length()))).append(" instead ")
					.append(2).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		}
	}

	private void checkLengthAdapterTelemetry(String telemetryArray[]) {
		if (telemetryArray[1].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Power");
			errorTelemetry.setError((new StringBuilder("Packet size error - ")).append(telemetryArray[1].length())
					.append("instead 1").toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[2].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Active interface");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[2].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (Integer.parseInt(telemetryArray[2]) > 6 || Integer.parseInt(telemetryArray[2]) < 0) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Active interface");
			errorTelemetry
					.setError((new StringBuilder("Value exceeds the limit")).append(telemetryArray[2]).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[3].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Adapter data rate");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[3].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else
		// if(telemetryArray[4].length() != 3)
		// {
		// ErrorTelemetry errorTelemetry =
		// Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
		// errorTelemetry.setTelemetry("Sub-system id");
		// errorTelemetry.setError((new
		// StringBuilder(String.valueOf(telemetryArray[4].length()))).append("
		// instead ").append(3).toString());
		// errorTelemetry.setTime(new Date());
		// Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		// }
		// else
		if (telemetryArray[4].length() != 4) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Number of packets");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[4].length()))).append(" instead ")
					.append(2).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (Integer.parseInt(telemetryArray[4], 16) > 65535) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Number of packets");
			errorTelemetry.setError("Out Of Range");
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[5].length() != 4) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Bus Speed");
			errorTelemetry.setError((new StringBuilder("Packet size ")).append(telemetryArray[5].length())
					.append(" instead ").append(4).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[6].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Memory in use");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[6].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[7].length() != 2) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Adapter id");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[7].length()))).append(" instead ")
					.append(2).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[8].length() != 3) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Free memory");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[8].length()))).append(" instead ")
					.append(3).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[9].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Adapter status");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[9].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (!telemetryArray[9].equals("0") && !telemetryArray[10].equals("1")) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Adapter status");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[9].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[10].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Software version");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[10].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[11].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Active CPU");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[11].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[12].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Last command received ID");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[12].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[13].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Status of last command ");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[13].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (!telemetryArray[13].equals("0") && !telemetryArray[13].equals("1")
				&& !telemetryArray[13].equals("2")) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("Status of last command ");
			errorTelemetry.setError("Out Of Range");
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (telemetryArray[14].length() != 1) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("OBDH interface");
			errorTelemetry.setError((new StringBuilder(String.valueOf(telemetryArray[14].length()))).append(" instead ")
					.append(1).toString());
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		} else if (!telemetryArray[14].equals("1") && !telemetryArray[14].equals("2") && !telemetryArray[14].equals("3")
				&& !telemetryArray[14].equals("5") && !telemetryArray[14].equals("4")
				&& !telemetryArray[14].equals("6")) {
			ErrorTelemetry errorTelemetry = Ma6icmodelFactory.eINSTANCE.createErrorTelemetry();
			errorTelemetry.setTelemetry("OBDH interface");
			errorTelemetry.setError("Out Of Range");
			errorTelemetry.setTime(new Date());
			Manager.getInstance().getMa6ic().getErrorTelemetries().add(errorTelemetry);
		}
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
		parser.parse("D:\\eclipse\\commands\\TelemetryFile_New.txt", true,
				"test");

	}
}