package com.spintech.ma6ic.ui.preferences;

import java.io.IOException;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.Manager;

public class APIConfigPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public APIConfigPreferencePage() {
		super(GRID);
	}



	@Override
	protected void createFieldEditors() {
		

		addField(new FileFieldEditor("API_PATH", "&Select the API file Path:",
                getFieldEditorParent()));
//	     addField(new StringFieldEditor("ExecName", "Execution Name:",
//	                getFieldEditorParent()));
	        addField(new StringFieldEditor("TIMER", "Time Stamp to Run (in sec):",
	                getFieldEditorParent()));
		addField(new BooleanFieldEditor("APPLY_IMMEDIATE", "&Apply Immediately",
					getFieldEditorParent()));


	}
	
	@Override
	public void init(IWorkbench workbench) {	
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preference - API Configuration");
	}
	
	@Override
	public boolean performOk() {
		Boolean myPrefBoolean = Activator.getDefault().getPreferenceStore().getBoolean("APPLY_IMMEDIATE");
		String myPrefApiPath = Activator.getDefault().getPreferenceStore().getString("API_PATH");
		String myPrefTimeStamp = Activator.getDefault().getPreferenceStore().getString("TIMER");
		String myPrefExecName = Activator.getDefault().getPreferenceStore().getString("ExecName");
		if(myPrefBoolean){
			Manager.getInstance().stopReadingMessages();
			try {
				Manager.getInstance().startReadingMessages(myPrefApiPath, Integer.parseInt(myPrefTimeStamp), true,
						myPrefExecName);
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
			
		return super.performOk();
	}
	

}
