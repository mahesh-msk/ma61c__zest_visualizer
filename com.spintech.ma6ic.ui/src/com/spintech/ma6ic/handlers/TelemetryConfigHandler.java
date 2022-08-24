package com.spintech.ma6ic.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import com.spintech.ma6ic.ui.dialogs.ConfigDialog;

public class TelemetryConfigHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		ConfigDialog configdialog = new ConfigDialog(Display.getDefault().getActiveShell());
		configdialog.open();
		return null;
	}

}
