package com.spintech.ma6ic.ui.utils;

import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import org.eclipse.core.runtime.Platform;

public class RunApiTask extends TimerTask {
	private String filePath;

	public RunApiTask(String filePath) {
		this.filePath = filePath;
		
	}
	

	@Override
	public void run() {

		 try {
			Runtime.getRuntime().exec(filePath, null,
					new File(Platform.getInstallLocation().getURL().getPath() + "\\ma61capi"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
}	
