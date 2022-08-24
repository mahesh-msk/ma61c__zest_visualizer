package com.spintech.ma6ic.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.spintech.ma6ic.ui.Activator;

public class ZipUtils extends TimerTask {

	private List<String> fileList;
	private String folderName;
	private String OUTPUT_ZIP_FILE;
	private String SOURCE_PATH;
	private Boolean delPrefBoolean;
	
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");
	String dateTime = dateFormat.format(now);

	//
	// private static final String OUTPUT_ZIP_FILE = "D:\\Folder_ " + dateTime +
	// ".zip"; // Zipped path
	// private static final String SOURCE_FOLDER = "D:\\OBDH_28122017"; //
	// SourceFolder path

	public ZipUtils(String folderName) {
		this.folderName = folderName;
		fileList = new ArrayList<String>();
	}

	@Override
	public void run() {

	

//		String OUTPUT_ZIP_FILE = "D:\\Folder_ " + dateTime + ".zip"; // Zipped path
//		String SOURCE_FOLDER = "D:\\OBDH_28122017"; // SourceFolder path
		
		 OUTPUT_ZIP_FILE = Activator.getDefault().getPreferenceStore().getString("ZIP_PATH")+"\\" + folderName +"_ " + dateTime + ".zip"; // Zipped path;
		 SOURCE_PATH = Activator.getDefault().getPreferenceStore().getString("BACKUP_PATH");	
			delPrefBoolean = Activator.getDefault().getPreferenceStore()
					 .getBoolean("DELETE_BOOLEAN_VALUE");
	
	

		ZipUtils appZip = new ZipUtils(folderName);
		appZip.generateFileList(new File(SOURCE_PATH),SOURCE_PATH);
		appZip.zipIt(OUTPUT_ZIP_FILE,SOURCE_PATH);

			DeleteFolderUtils delBak = new DeleteFolderUtils();
			delBak.recursiveDelete(new File(SOURCE_PATH),folderName);

	
	}

	
	//Zip the source
	public void zipIt(String zipFile, String SOURCE_PATH) {
		byte[] buffer = new byte[1024];
		String source = new File(SOURCE_PATH).getName();
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);

			System.out.println("Output to Zip : " + zipFile);
			FileInputStream in = null;
			
			String curDir = folderName;

		


			for (String file : this.fileList) {
				if (file.startsWith(curDir) && (file) != (curDir + dateTime)) {
				System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(SOURCE_PATH + File.separator + file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					in.close();
				}
				}
			}

			zos.closeEntry();
			System.out.println("Folder successfully compressed");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void generateFileList(File node, String SOURCE_PATH) {
		// add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.toString(),SOURCE_PATH));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename),SOURCE_PATH);
			}
		}
	}

	private String generateZipEntry(String file, String SOURCE_PATH) {
		return file.substring(SOURCE_PATH.length() + 1, file.length());
	}
	
	
}