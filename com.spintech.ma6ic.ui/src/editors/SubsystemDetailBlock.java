package editors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.spintech.ma6ic.ui.labelproviders.cmdTableLabelProvider;
import com.spintech.ma6ic.ui.labelproviders.tableViewerTelemetryAdapterLabelProvider;

import ma6icmodel.Adapter;
import ma6icmodel.Command;
import ma6icmodel.Ma6ic;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SubsystemDetailBlock implements IDetailsPage {

	private Ma6ic ma6ic;
	private IManagedForm managedForm;
	private TableViewer tableViewerTelemetry;
	private Table table;
	private EList<Telemetry> telemetry;
	private TableViewer tableViewerCmdHistory;
	private Subsystem subSys;
	private ComboViewer comboViewer;
	private Combo combo;
	private Text txtDescription;
	private Text text;
	private Text txtCommandid;

	public SubsystemDetailBlock(Ma6ic ma6ic) {
		this.ma6ic = ma6ic;
	}


	/**
	 * Initialize the details page.
	 * 
	 * @param form
	 */
	public void initialize(IManagedForm form) {
		managedForm = form;
	}

	/**
	 * Create contents of the details page.
	 * 
	 * @param parent
	 */
	public void createContents(Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//
		Section section = toolkit.createSection(parent, ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		section.setText("Telemetry Details");
		//
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);

		composite.setLayout(new GridLayout(1, false));
		
		tableViewerTelemetry = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewerTelemetry.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		
		TableColumn tblclmnParameter = new TableColumn(table, SWT.NONE);
		tblclmnParameter.setWidth(150);
		tblclmnParameter.setText("Parameter");
	
		
		TableColumn tblclmnDescription = new TableColumn(table, SWT.NONE);
		tblclmnDescription.setWidth(92);
		tblclmnDescription.setText("Description");
		
		TableColumn tblclmnValue = new TableColumn(table, SWT.NONE);
		tblclmnValue.setWidth(79);
		tblclmnValue.setText("Value");
		
		TableColumn tblclmnUnit = new TableColumn(table, SWT.NONE);
		tblclmnUnit.setWidth(70);
		tblclmnUnit.setText("Unit");
		
		tableViewerTelemetry.setContentProvider(ArrayContentProvider.getInstance());
		tableViewerTelemetry.setLabelProvider(new tableViewerTelemetryAdapterLabelProvider());
		
		Section sctnCommands = toolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		sctnCommands.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(sctnCommands);
		sctnCommands.setText("Commands");
		sctnCommands.setExpanded(true);
		
		CTabFolder tabFolder = new CTabFolder(sctnCommands, SWT.BORDER);
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		sctnCommands.setClient(tabFolder);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		createExecutionCommandTab(toolkit, composite, tabFolder);
		
		createCommandHistoryTab(toolkit, composite, tabFolder);
	
		
	
		

		

	}


	private void createExecutionCommandTab(FormToolkit toolkit, Composite composite, CTabFolder tabFolder) {
		CTabItem tbtmExecuteCommand = new CTabItem(tabFolder, SWT.NONE);
		tbtmExecuteCommand.setText("Execute Command");
		
		Composite executeCommandComposite = new Composite(tabFolder, SWT.NONE);
		tbtmExecuteCommand.setControl(executeCommandComposite);
		toolkit.paintBordersFor(executeCommandComposite);
		executeCommandComposite.setLayout(new GridLayout(2, false));
		
		Label lblParameter = new Label(executeCommandComposite, SWT.NONE);
		lblParameter.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblParameter.setText("Command");

		comboViewer = new ComboViewer(executeCommandComposite, SWT.NONE);
		combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
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
			txtDescription.setText(command.getCommandDescription()== null ? "":command.getCommandDescription());
			text.setText(command.getCommandData() == null ? "": command.getCommandData());
			txtCommandid.setText(command.getCommandId());
			}
			});

		Label lblDescription = new Label(executeCommandComposite, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		lblDescription.setText("Command Description");

		txtDescription = new Text(executeCommandComposite, SWT.BORDER);
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 68;
		txtDescription.setLayoutData(gd_txtDescription);
		txtDescription.setText("Command Description");

		Label lblCommandData = new Label(executeCommandComposite, SWT.NONE);
		lblCommandData.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblCommandData.setText("Command Data");

		text = new Text(executeCommandComposite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblCommandId = new Label(executeCommandComposite, SWT.NONE);
		lblCommandId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblCommandId.setText("Command ID");

		txtCommandid = new Text(executeCommandComposite, SWT.BORDER);
		txtCommandid.setText("commandId");
		txtCommandid.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(composite, SWT.NONE);

		Button btnNewButton = new Button(executeCommandComposite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String tofile = subSys.getName()
						+ "," + txtCommandid.getText() + "," + combo.getText() + System.lineSeparator();

				String filename = Platform.getInstallLocation().getURL()
						.getPath()
						+ "/commands/CommandTextFile.txt";
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
				}// appends the string to the file
				try {
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 2, 1));
		btnNewButton.setText("SEND");
	}


	private void createCommandHistoryTab(FormToolkit toolkit, Composite composite2, CTabFolder tabFolder) {
		CTabItem tbtmCommandHistory = new CTabItem(tabFolder, SWT.NONE);
		tbtmCommandHistory.setText("Command History");
		
		Composite commandHistoryComposite = new Composite(tabFolder, SWT.NONE);
		tbtmCommandHistory.setControl(commandHistoryComposite);
		toolkit.paintBordersFor(commandHistoryComposite);
		commandHistoryComposite.setLayout(new GridLayout(1, false));
		
		tableViewerCmdHistory = new TableViewer(commandHistoryComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewerCmdHistory.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableColumn tblclmnFunctionalitiesOfThe = new TableColumn(table, SWT.NONE);
		tblclmnFunctionalitiesOfThe.setWidth(167);
		tblclmnFunctionalitiesOfThe.setText("Functionalities of the driver");
		
		TableColumn tblclmnExecutionStatus = new TableColumn(table, SWT.NONE);
		tblclmnExecutionStatus.setWidth(134);
		tblclmnExecutionStatus.setText("Execution status");
		new Label(composite2, SWT.NONE);
		new Label(composite2, SWT.NONE);
		

		tableViewerCmdHistory.setContentProvider(ArrayContentProvider.getInstance());
		tableViewerCmdHistory.setLabelProvider(new cmdTableLabelProvider());
	
	}

	public void dispose() {
		// Disposet
	}

	public void setFocus() {
		// Set focus
	}

	private void update() {

		tableViewerTelemetry.setInput(telemetry);
		
		
		int subsystemID = Integer.parseInt(subSys.getName(), 16);
		String commandsDirectory = Platform.getInstallLocation().getURL().getPath();
		File file = new File(commandsDirectory + "/commands/CommandTextFile.txt");

		ArrayList<Command> commandList = new ArrayList<Command>();
		if (file.exists()) {
			String sCurrentLine;

			try {
				BufferedReader br = new BufferedReader(new FileReader(file));

				while ((sCurrentLine = br.readLine()) != null) {
					String[] split = sCurrentLine.split(",");
					
					if(sCurrentLine.isEmpty()) {
						continue;
					}
					
					if(subsystemID==Integer.parseInt(split[0],16)){
						
						Command command= Ma6icmodelFactory.eINSTANCE.createCommand();
						command.setCommandId(split[1]);
						command.setTelecommand(split[2]);
						commandList.add(command);
					
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tableViewerCmdHistory.setInput(commandList);
			

			loadSubsystemCommandFile(subsystemID);

	}
	

	}


	private void loadSubsystemCommandFile(int subsystemID) {
		String commandsDirectory = Platform.getInstallLocation()
				.getURL().getPath()
				+ "/commands";
		File file = new File(commandsDirectory + "/" + subsystemID
				+ ".txt");

		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						file));
				String sCurrentLine = "";
				while ((sCurrentLine = br.readLine()) != null) {

					if(sCurrentLine.isEmpty()) {
						continue;
					}
					String[] split = sCurrentLine.split(",");
					String commandID = split[1];
					if (!duplicateCommand(commandID)) {
						Command command = Ma6icmodelFactory.eINSTANCE
								.createCommand();
						command.setTelecommand(split[0]);
						command.setCommandDescription(split[2]);

						command.setCommandId(commandID);
						if (split.length == 4) {
							command.setCommandData(split[3]);
						}
						subSys.getCommand().add(command);
					}
				}

				comboViewer.setInput(subSys.getCommand());
				if(subSys.getCommand().size() > 0) {
					comboViewer.setSelection(new StructuredSelection(subSys.getCommand().get(0)));
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
	}
	
	private boolean duplicateCommand(String commandID) {
		EList<Command> commands = subSys.getCommand();
		for (Command command : commands) {
			if (command.getCommandId().equals(commandID)) {
				return true;
			}
		}
		return false;
	}

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			
			if (structuredSelection.getFirstElement() instanceof Subsystem) {
				subSys = (Subsystem) structuredSelection.getFirstElement();
				telemetry =  subSys.getTelemetry();
			}
			
		
		} else {
			telemetry = null;
		}
		update();
	}

	public void commit(boolean onSave) {
		// Commit
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isStale() {
		return false;
	}

	public void refresh() {
		update();
	}

}
