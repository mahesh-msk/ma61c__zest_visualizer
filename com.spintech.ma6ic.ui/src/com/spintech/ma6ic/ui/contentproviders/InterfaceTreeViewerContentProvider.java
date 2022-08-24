package com.spintech.ma6ic.ui.contentproviders;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.Ma6ic;

public class InterfaceTreeViewerContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Ma6ic) {
			Ma6ic ma6ic = (Ma6ic) inputElement;
			return new Object[] { ma6ic.getComputer() };
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Computer) {
			Computer computer = (Computer) parentElement;
			return computer.getAdapters().toArray();
		} else if (parentElement instanceof Adapter) {
			Adapter adapter = (Adapter) parentElement;
			return adapter.getSubsystems().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Computer || element instanceof Adapter) {
			return true;
		}
		return false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

}
