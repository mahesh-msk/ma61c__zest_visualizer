package com.spintech.ma6ic.ui;
import java.util.TimerTask;

public class RunMeTask extends TimerTask
{
	private String filePath;
	private boolean isFresh;
	private boolean isPause;
	private String folderName;
	
	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public RunMeTask(String filePath, boolean isFresh, String folderName) {
		this.filePath = filePath;
		// TODO Auto-generated constructor stub
		this.isFresh = isFresh;
		this.folderName = folderName;
	}

	@Override
	public void run() {
		if(isPause) {
			return;
		}
		Parser parser = new Parser();
		parser.parse(filePath, isFresh,folderName);
		isFresh = false;
		
		System.out.println("Parsed");
	}
}