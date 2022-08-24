package com.spintech.ma6ic.ui.contentproviders;

import ma6icmodel.Adapter;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class tableViewerTelemetryAdapterContentProvider implements
		IStructuredContentProvider {

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Adapter) {
			Adapter adapter = (Adapter) inputElement;
			return adapter.getTelemetry().toArray();
		}
		return null;
	}

}
