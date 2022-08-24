package com.spintech.ma6ic.ui.contentproviders;

import java.util.ArrayList;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import com.spintech.ma6ic.ui.views.InterfaceViewOld;

import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.Ma6ic;

public class InterfaceViewGraphicalContentProvider implements IGraphEntityContentProvider {
	/**
	 * 
	 */
	private final InterfaceViewOld InterfaceViewGraphicalContentProvider;

	/**
	 * @param interfaceViewOld
	 */
	public InterfaceViewGraphicalContentProvider(InterfaceViewOld interfaceViewOld) {
		InterfaceViewGraphicalContentProvider = interfaceViewOld;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public Object[] getElements(Object inputElement) {
		ArrayList<Object> objectsToShow = new ArrayList<Object>();
		if (inputElement instanceof Ma6ic) {
			Ma6ic ma6ic = (Ma6ic) inputElement;
			objectsToShow.add(ma6ic.getComputer());
			objectsToShow.addAll(ma6ic.getAdapters());
			objectsToShow.addAll(ma6ic.getSubsystems());
		}
		return objectsToShow.toArray();
	}

	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof Computer) {
			Computer computer = (Computer) entity;
			return computer.getAdapters().toArray();
		} else if (entity instanceof Adapter) {
			Adapter adapter = (Adapter) entity;
			return adapter.getSubsystems().toArray();
		}
		return null;
	}
}