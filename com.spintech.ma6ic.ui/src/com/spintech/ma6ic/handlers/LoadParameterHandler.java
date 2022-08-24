package com.spintech.ma6ic.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.dialogs.NewParameterFileDialog;

public class LoadParameterHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// FileDialog dialog = new
		// FileDialog(Display.getCurrent().getActiveShell());
		// String filePath = dialog.open();

		NewParameterFileDialog fileDialog = new NewParameterFileDialog(Display.getDefault().getActiveShell(),false);
		int open = fileDialog.open();
		if (IDialogConstants.OK_ID == open) {
			
			Activator.getDefault().getPreferenceStore().setValue("TIMER",Integer.parseInt(fileDialog.getTimer()));
			
			try {
				Manager.getInstance().startReadingMessages(fileDialog.getFilePath(),
						Integer.parseInt(fileDialog.getTimer()), true,fileDialog.getFolderName());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			
			
		}
		return open;
	}
}
