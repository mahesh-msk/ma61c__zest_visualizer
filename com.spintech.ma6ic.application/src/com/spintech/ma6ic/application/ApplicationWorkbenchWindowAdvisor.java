package com.spintech.ma6ic.application;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.dialogs.NewParameterFileDialog;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(1200, 1000));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(false);
		configurer.setTitle("MA61C"); //$NON-NLS-1$
	}

	@Override
	public void postWindowOpen() {
		
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int i = 0; i < windows.length; ++i) {
			IWorkbenchPage page = windows[i].getActivePage();
			if (page != null)
				page.hideActionSet("org.eclipse.ui.actionSet.openFiles");
			   page.hideActionSet("org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo");
			   page.hideActionSet("org.eclipse.ui.actionSet.keyBindings");
		}
		
			String myPrefExecName = Activator.getDefault().getPreferenceStore().getString("ExecName");
		String myPrefApiPath = Activator.getDefault().getPreferenceStore().getString("API_PATH");
		String myPrefTimeStamp = Activator.getDefault().getPreferenceStore().getString("TIMER");

		String apiPath = Platform.getInstallLocation().getURL().getPath() + "\\ma61capi\\ma61capi.exe";

		File apiFile = new File(apiPath);

		boolean apiExists = apiFile.exists();
		if (apiExists) {
			try {
				 Runtime.getRuntime().exec(apiPath, null,
						new File(Platform.getInstallLocation().getURL().getPath() + "\\ma61capi"));
				
//				System.out.println(exec);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (myPrefApiPath.isEmpty() || myPrefTimeStamp.isEmpty()) {

			NewParameterFileDialog fileDialog = new NewParameterFileDialog(Display.getDefault().getActiveShell(),
					apiExists);
			int open = fileDialog.open();
			if (open == IDialogConstants.OK_ID) {
				myPrefApiPath = fileDialog.getFilePath();
				myPrefExecName = fileDialog.getFolderName();
				myPrefTimeStamp = fileDialog.getTimer();

				Activator.getDefault().getPreferenceStore().setValue("ExecName", myPrefExecName);
				Activator.getDefault().getPreferenceStore().setValue("API_PATH", myPrefApiPath);
				Activator.getDefault().getPreferenceStore().setValue("TIMER", myPrefTimeStamp);

			} else {
				return;
			}

		}

		try {
			Manager.getInstance().startReadingMessages(myPrefApiPath, Integer.parseInt(myPrefTimeStamp), true,
					myPrefExecName);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		super.postWindowOpen();
	}
	
	@Override
	public void postWindowCreate() {
		PreferenceManager pm = PlatformUI.getWorkbench().getPreferenceManager();
		pm.remove("org.eclipse.ui.preferencePages.Workbench");
		super.postWindowCreate();
	}

	@Override
	public boolean preWindowShellClose() {
		Manager.getInstance().stopReadingMessages();
		return super.preWindowShellClose();
	}
}
