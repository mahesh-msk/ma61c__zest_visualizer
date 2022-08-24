package com.spintech.ma6ic.ui.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This utility class can be used to delete folders recursively in java
 * 
 * @author mahesh
 */

public class DeleteFolderUtils {

	static String folder = "/Users/pankaj/tmp";
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");
	String dateTime = dateFormat.format(now);

	public static void main(String[] args) {

		// delete folder recursively
		DeleteFolderUtils delBak = new DeleteFolderUtils();
		delBak.recursiveDelete(new File(folder), "test");
	}
	
	/* * Right way to delete a non empty directory in Java */ 
	public static boolean deleteDirectory(File dir) {
		
		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDirectory(children[i]);
				if (!success) {
					return false;
				}
			}
		} // either file or an empty directory
		System.out.println("removing file or directory : " + dir.getName());
		return dir.delete();
	}

	public void recursiveDelete(File file, String folderName) {

		File[] files = file.listFiles();

		for (File file2 : files) {

			String curDir = file2.getAbsolutePath() + "\\" + folderName;

			if (file2.getName().startsWith(folderName) && !(file2.getName()).equals((folderName + "_"+dateTime))) {

				// to end the recursive loop
				if (!file2.exists())
					return;

				// if directory, go inside and call recursively
				if (file2.isDirectory()) {
					for (File f : file2.listFiles()) {
						deleteDirectory(f);
						
					}
					file2.delete();
					System.out.println("Deleted file/folder: " + file2.getAbsolutePath());
				}


			}

		}

	}

}
