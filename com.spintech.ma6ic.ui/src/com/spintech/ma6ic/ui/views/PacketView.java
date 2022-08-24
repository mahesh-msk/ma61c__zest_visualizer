package com.spintech.ma6ic.ui.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ma6icmodel.Adapter;
import ma6icmodel.Command;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Subsystem;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class PacketView extends ViewPart implements ISelectionListener {
	private Text txtDescription;
	private Text text;
	private Subsystem subsystem;
	private Combo combo;
	private ComboViewer comboViewer;
	private Text txtCommandid;
	private Adapter adapterobj;

	public PacketView() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Label lblParameter = new Label(composite, SWT.NONE);
		lblParameter.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblParameter.setText("Command");

		comboViewer = new ComboViewer(composite, SWT.NONE);
		combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Command) {
					Command command = (Command) element;
					return command.getTelecommand();
				}
				return super.getText(element);
			}
		});

		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Command command = (Command) ((IStructuredSelection) event.getSelection()).getFirstElement();
				txtDescription.setText(command.getCommandDescription() == null ? "" : command.getCommandDescription());
				text.setText(command.getCommandData() == null ? "" : command.getCommandData());
				txtCommandid.setText(command.getCommandId());
			}
		});

		Label lblDescription = new Label(composite, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblDescription.setText("Command Description");

		txtDescription = new Text(composite, SWT.BORDER);
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtDescription.heightHint = 68;
		txtDescription.setLayoutData(gd_txtDescription);
		txtDescription.setText("Command Description");

		Label lblCommandData = new Label(composite, SWT.NONE);
		lblCommandData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCommandData.setText("Command Data");

		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblCommandId = new Label(composite, SWT.NONE);
		lblCommandId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCommandId.setText("Command ID");

		txtCommandid = new Text(composite, SWT.BORDER);
		txtCommandid.setText("commandId");
		txtCommandid.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String tofile = null;
				String filename = null;
				if (null != adapterobj) {
					tofile = adapterobj.getName() + "," + txtCommandid.getText() + "," + combo.getText()
							+ System.lineSeparator();

					filename = Platform.getInstallLocation().getURL().getPath() + "/commands/CommandTextFile.txt";
				} else if (null != subsystem) {
					tofile = subsystem.getName() + "," + txtCommandid.getText() + "," + combo.getText()
							+ System.lineSeparator();

					filename = Platform.getInstallLocation().getURL().getPath() + "/commands/CommandTextFile.txt";
				}

				if (null != tofile && null != filename) {
					FileWriter fw = null;
					try {
						fw = new FileWriter(filename, true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // the true will append the new data
					try {
						fw.write(tofile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // appends the string to the file
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnNewButton.setText("SEND");

		getSite().getPage().addSelectionListener(this);

	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IStructuredSelection sSelection = (IStructuredSelection) selection;
		Object firstElement = sSelection.getFirstElement();
		if (firstElement instanceof Subsystem) {
			subsystem = (Subsystem) firstElement;

			int subsystemID = Integer.parseInt(subsystem.getName(), 16);

			String commandsDirectory = Platform.getInstallLocation().getURL().getPath() + "/commands";
			File file = new File(commandsDirectory + "/" + subsystemID + ".txt");

			if (file.exists()) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String sCurrentLine = "";
					while ((sCurrentLine = br.readLine()) != null) {

						if (sCurrentLine.isEmpty()) {
							continue;
						}
						String[] split = sCurrentLine.split(",");
						String commandID = split[1];
						if (!duplicateCommand(commandID)) {
							Command command = Ma6icmodelFactory.eINSTANCE.createCommand();
							command.setTelecommand(split[0]);
							command.setCommandDescription(split[2]);

							command.setCommandId(commandID);
							if (split.length == 4) {
								command.setCommandData(split[3]);
							}
							subsystem.getCommand().add(command);
						}
					}

					comboViewer.setInput(subsystem.getCommand());
					if (subsystem.getCommand().size() > 0) {
						comboViewer.setSelection(new StructuredSelection(subsystem.getCommand().get(0)));
					}
					txtDescription.setText("");
					txtCommandid.setText("");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				comboViewer.setInput(new Object());
				txtDescription.setText("");
				txtCommandid.setText("");
			}

		} else if (firstElement instanceof Adapter) {
			adapterobj = (Adapter) firstElement;

			int adapterID = Integer.parseInt(adapterobj.getName(), 16);

			String commandsDirectory = Platform.getInstallLocation().getURL().getPath() + "/commands";
			File file = new File(commandsDirectory + "/ADAPTER" + adapterID + ".txt");

			if (file.exists()) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String sCurrentLine = "";
					while ((sCurrentLine = br.readLine()) != null) {

						if (sCurrentLine.isEmpty()) {
							continue;
						}
						String[] split = sCurrentLine.split(",");
						String commandID = split[1];
						if (!duplicateCommand(commandID, adapterobj)) {
							Command command = Ma6icmodelFactory.eINSTANCE.createCommand();
							command.setTelecommand(split[0]);
							command.setCommandDescription(split[2]);

							command.setCommandId(commandID);
							if (split.length == 4) {
								command.setCommandData(split[3]);
							}
							adapterobj.getCommand().add(command);
						}
					}

					comboViewer.setInput(adapterobj.getCommand());
					if (adapterobj.getCommand().size() > 0) {
						comboViewer.setSelection(new StructuredSelection(adapterobj.getCommand().get(0)));
					}
					txtDescription.setText("");
					txtCommandid.setText("");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private boolean duplicateCommand(String commandID, Adapter adapter) {
		EList<Command> commands = adapter.getCommand();
		for (Command command : commands) {
			if (command.getCommandId().equals(commandID)) {
				return true;
			}
		}
		return false;
	}

	private boolean duplicateCommand(String commandID) {
		EList<Command> commands = subsystem.getCommand();
		for (Command command : commands) {
			if (command.getCommandId().equals(commandID)) {
				return true;
			}
		}
		return false;
	}
}
