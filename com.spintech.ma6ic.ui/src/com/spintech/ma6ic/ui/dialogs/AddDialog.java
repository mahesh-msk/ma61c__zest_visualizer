package com.spintech.ma6ic.ui.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Telemetry;

import org.eclipse.swt.layout.GridData;

public class AddDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private List list;
	private Telemetry tel;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public AddDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDescription.setText("Description");
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblUnit = new Label(container, SWT.NONE);
		lblUnit.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUnit.setText("Unit");
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setText("");
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		Label lblLength = new Label(container, SWT.NONE);
		lblLength.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLength.setText("Length");
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	
	@Override
	protected void okPressed() {
		
		String name = text.getText();
		String desc = text_1.getText();
		String unit = text_2.getText();
		String size = text_3.getText();
		
		tel = Ma6icmodelFactory.eINSTANCE.createTelemetry();
		tel.setParameter(name);
		tel.setDescription(desc);
		tel.setUnit(unit);
		tel.setValue(size);
		
		
		//list = Arrays.asList(name, desc, unit, size);
		
		super.okPressed();
	}
	public Telemetry getTelemetry(){
		return tel;
	}
	
//	public List getConfig(){
//		return list;
//	}

	
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
