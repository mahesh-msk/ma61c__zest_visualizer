package com.spintech.ma6ic.ui;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

import org.eclipse.core.runtime.Platform;

import com.spintech.ma6ic.ui.utils.RunApiTask;
import com.spintech.ma6ic.ui.utils.ZipUtils;

import ma6icmodel.Computer;
import ma6icmodel.Ma6ic;
import ma6icmodel.Ma6icmodelFactory;

public class Manager {
	private static Manager manager;
	
	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}

	private Manager() {

	}

	Ma6ic ma6ic;

	public Ma6ic getMa6ic() {
		if (ma6ic == null) {
			ma6ic = Ma6icmodelFactory.eINSTANCE.createMa6ic();
			Computer computer = Ma6icmodelFactory.eINSTANCE.createComputer();
			computer.setName("OBDH");
			ma6ic.setComputer(computer);
		}
		return ma6ic;
	}

	private RunMeTask task;
	private ZipUtils zipTask;
	private Timer timer;
	private RunApiTask runApiTask;


	public void startReadingMessages(String filePath, int time, boolean isFresh,String folderName) throws IOException {
		boolean zipPrefBoolean = Activator.getDefault().getPreferenceStore().getBoolean("ZIP_DELETE_BOOLEAN_VALUE");
		
		
		task = new RunMeTask(filePath, isFresh,folderName);

		timer = new Timer();
		int seconds = time * 1000;
		timer.schedule(task, 1000, seconds);
		
		
		//Run APi file for every given stime stamp
		String apiPath = Platform.getInstallLocation().getURL().getPath() + "\\ma61capi\\ma61capi.exe";
		File apiFile = new File(apiPath);
		boolean apiExists = apiFile.exists();
		if (apiExists) {
			runApiTask = new RunApiTask(apiPath);
				timer.schedule(runApiTask, 1000, seconds);
		}
		
		// calling Zip and backup
        if(zipPrefBoolean){
        	zipAndBackup(timer,folderName);
        }

	}

	public void zipAndBackup(Timer timer, String folderName) {
		zipTask = new ZipUtils(folderName);
		int seconds = 24 * 60 * 60 * 1000;  // taking backup after every 24 hours
//		 int seconds=30*1000;
		timer.schedule(zipTask, 1 * 60 * 60 * 1000, // initial delay
//		 timer.schedule(zipTask, 30*1000, // initial delay
				seconds); // subsequent rate
	}

	public void stopReadingMessages() {
		try {
			task.cancel();
			timer.cancel();
			timer.purge();
		} catch (Exception e) {
			
		}
	
	}

	public void pauseReadingMessages() {
		task.setPause(true);
	}

	public void runReadingMessages() {
		task.setPause(false);
	}

}
