package com.spintech.ma6ic.ui.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.spintech.ma6ic.ui.Activator;

public class BackupPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public BackupPreferencePage() {
		super(GRID);
	}



	@Override
	protected void createFieldEditors() {
		

		
		addField(new DirectoryFieldEditor("BACKUP_PATH", "&Select the backup Path to store:",
                getFieldEditorParent()));
		addField(new DirectoryFieldEditor("ZIP_PATH", "&Select the Zip Path:",
                getFieldEditorParent()));
//		addField(new BooleanFieldEditor("DELETE_BOOLEAN_VALUE", "&Delete daily backup",
//				getFieldEditorParent()));
		addField(new BooleanFieldEditor("ZIP_DELETE_BOOLEAN_VALUE", "&Zip and delete daily backup",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor("STORE_SSYS_BOOLEAN_VALUE", "&Store Sub-System telemetry Data",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor("STORE_ADAPTER_BOOLEAN_VALUE", "&Store Adapter telemetry Data",
				getFieldEditorParent()));


	}
	
	@Override
	public void init(IWorkbench workbench) {	
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preference - Backup");
		
		
	}
	// @Override
	// protected Control createContents(Composite parent) {
	//
	// Composite composite = new Composite(parent, SWT.NONE);
	// composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
	// 1, 1));
	// composite.setLayout(new GridLayout(1, false));
	// new Label(composite, SWT.NONE);
	//
	//
	//
	//
	//
	// return composite;
	// }

	// @Override
	// protected void performApply() {
	//
	// Boolean myPrefBoolean = Activator.getDefault().getPreferenceStore()
	// .getBoolean("BOOLEAN_VALUE");
	//
	// IPreferenceStore store = Activator.getDefault().getPreferenceStore();
	// store.setValue("CONFIRM_VALUE", myPrefBoolean);
	//
	// }
	//
	//
	// @Override
	// protected void performDefaults() {
	//
	//
	//
	// }
	//
	//
	// @Override
	// public boolean performOk() {
	//
	//
	// return super.performOk();
	// }

}
