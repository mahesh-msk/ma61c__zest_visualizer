package com.spintech.ma6ic.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Telemetry;

public class App {

	public static void main(String[] args) {

		// TimerTask task = new RunMeTask("C:/Work/Spintech/FileTOParse.txt",
		// true,"test");
		//
		// Timer timer = new Timer();
		// timer.schedule(task, 1000,5000);

		///////////////////////////

		File theDir = new File("D:\\" + "TestForBulk");
		// write the data into file

		if (!theDir.exists()) {

			try {
				theDir.mkdir();
			} catch (SecurityException se) {
				// handle it
			}

			
		}
		
		File adpfPathTemp = new File("D:\\" + "TestForBulk" + "\\" + "BulkAdapterFile" + ".csv");
		
		if (!adpfPathTemp.exists()) {
			try {
				adpfPathTemp.createNewFile();

				

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ArrayList<Telemetry> telemetries = new ArrayList<Telemetry>();

		for (int i = 0; i < 15; i++) {
			Telemetry telemetry = Ma6icmodelFactory.eINSTANCE.createTelemetry();
			// set parameter
			telemetry.setParameter("Power");
			// set value
			telemetry.setValue("9");
			// set Unit
			telemetry.setUnit("W");
			telemetries.add(telemetry);
		}

		try {
			FileWriter fileWriter = new FileWriter(adpfPathTemp, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (int i = 0; i < 86000; i++) {
				StringBuffer stringBuffer = new StringBuffer();
				for (Telemetry telemetry : telemetries) {
					stringBuffer.append(telemetry.getParameter() + "," + telemetry.getValue() + ","
							+ telemetry.getUnit() + " \n");

				}
				bufferedWriter.write(stringBuffer + "\n");

			}
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}