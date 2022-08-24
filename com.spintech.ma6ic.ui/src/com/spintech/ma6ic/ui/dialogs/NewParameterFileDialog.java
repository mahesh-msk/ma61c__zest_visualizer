package com.spintech.ma6ic.ui.dialogs;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.RGBA;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.spintech.ma6ic.ui.Activator;


public class NewParameterFileDialog extends Dialog {
	private Text text;
	private Text text_1;
	private String fileString;
	private String filePath;
	private String timer;
	private Text text_2;
	private String folderName;
	
	String myPrefExecName = Activator.getDefault().getPreferenceStore()
			.getString("ExecName");
	String myPrefApiPath = Activator.getDefault().getPreferenceStore()
			.getString("API_PATH");
	String myPrefTimeStamp = Activator.getDefault().getPreferenceStore()
			.getString("TimeStamp");
	private boolean apiExists;
	private Button btnNewButton;
	

	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param apiExists 
	 */
	public NewParameterFileDialog(Shell parentShell, boolean apiExists) {
		super(parentShell);
		this.apiExists = apiExists;
	}
	

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		container.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(1, false));
		composite.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");
		
		Label lblConfigureMaicStartup = new Label(composite, SWT.NONE);
		lblConfigureMaicStartup.setText("Please Configure the required MA6IC Startup Parameters");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_1.setLayout(new GridLayout(3, false));
		composite_1.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");
		
//		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
//		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblNewLabel_2.setText("Name");
//		
//		text_2 = new Text(composite_1, SWT.BORDER);
//		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		text_2.setText(myPrefExecName);
//		new Label(composite_1, SWT.NONE);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("File");
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text_1.setText(myPrefApiPath);
			
		btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setText("...");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getDefault().getActiveShell());
				fileString = fileDialog.open();
				if(fileString==null || fileString.isEmpty()){
					return;
				}
				text_1.setText(fileString);
				
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Time");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.setText(myPrefTimeStamp);
		
		Label lblSec = new Label(composite_1, SWT.NONE);
		lblSec.setText("Sec");
		
		Label lblApiWarningImage = new Label(composite_1, SWT.NONE);
		lblApiWarningImage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblApiWarningImage.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK));
		
		Label lblApiwarning = new Label(composite_1, SWT.NONE);		
		lblApiwarning.setText("API File does not exist...!!");

		if(!apiExists){
			lblApiwarning.setVisible(true);
			lblApiWarningImage.setVisible(true);
		} else {
			String apiPath =	Platform.getInstallLocation().getURL().getPath() + "\\ma61capi\\ma61capi_telemetry.txt";
			text_1.setText(apiPath);
			text_1.setEditable(false);
			text_1.setEnabled(false);
			btnNewButton.setEnabled(false);
			lblApiwarning.setVisible(false);
			lblApiWarningImage.setVisible(false);
		}

		return container;
	}
	
	@Override
	protected void okPressed() {
		filePath = text_1.getText();
		timer = text.getText();
		folderName = myPrefExecName;

		super.okPressed();
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getTimer() {
		return timer;
	}
	
	public String getFolderName() {
		return folderName;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
//		parent.setData("org.eclipse.e4.ui.css.id", "MyCSSTagForComposite");
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
