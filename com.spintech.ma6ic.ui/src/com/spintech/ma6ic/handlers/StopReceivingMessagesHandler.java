package com.spintech.ma6ic.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.IPreferenceStore;

import com.spintech.ma6ic.ui.Activator;
import com.spintech.ma6ic.ui.Manager;
import com.spintech.ma6ic.ui.Parser;

public class StopReceivingMessagesHandler extends AbstractHandler {
	IPreferenceStore store = Activator.getDefault().getPreferenceStore();

	public Object execute(ExecutionEvent event) throws ExecutionException {
		store.setValue("TIMER", "");
		Manager.getInstance().stopReadingMessages();
		return null;
	}

}
