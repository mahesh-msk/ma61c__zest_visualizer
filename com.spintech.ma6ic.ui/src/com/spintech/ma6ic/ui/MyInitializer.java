package com.spintech.ma6ic.ui;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class MyInitializer extends AbstractPreferenceInitializer {

	public MyInitializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		
		  IPreferenceStore store = Activator.getDefault().getPreferenceStore();
	        store.setDefault("ZIP_PATH", Platform.getInstallLocation().getURL().getPath() + "\\commands");
	        store.setDefault("BACKUP_PATH", Platform.getInstallLocation().getURL().getPath() + "\\commands");	

	}

}
