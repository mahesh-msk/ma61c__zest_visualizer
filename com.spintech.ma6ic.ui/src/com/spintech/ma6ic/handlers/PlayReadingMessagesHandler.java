package com.spintech.ma6ic.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.spintech.ma6ic.ui.Manager;

public class PlayReadingMessagesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Manager.getInstance().runReadingMessages();
		return null;
	}

}
