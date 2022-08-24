package com.spintech.ma6ic.ui.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.spintech.ma6ic.ui.Activator;

public class MA6ICProjectBackUpInitializer extends AbstractPreferenceInitializer {

	public MA6ICProjectBackUpInitializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		
		  IPreferenceStore store = Activator.getDefault().getPreferenceStore();
	        store.setDefault("ZIP_PATH", Platform.getInstallLocation().getURL().getPath() + "\\backup");
	        store.setDefault("BACKUP_PATH", Platform.getInstallLocation().getURL().getPath() + "\\backup");	
	        store.setDefault("ExecName", "MA61C");	
	        store.setDefault("STORE_SSYS_BOOLEAN_VALUE", true);	
	        store.setDefault("STORE_ADAPTER_BOOLEAN_VALUE", true);	

	}

}
