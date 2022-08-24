package com.spintech.ma6ic.ui.dialogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.spintech.ma6ic.ui.labelproviders.MyConfigLabelProvider;

import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Telemetry;

public class ConfigDialog extends Dialog {
	private Table table;
	private TableViewer tableViewer;
	private Combo combo;
	private Combo source;

	private ArrayList arraylist;
	private File fl2;
	private Button btnDeleteTelemetry;
	private Button btnAddTelemetry;
	private Combo combo_1;
	private Combo source1;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ConfigDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));

		Label lblType = new Label(container, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Type");

		combo_1 = new Combo(container, SWT.NONE);
		combo_1.setItems(new String[] { "Adapter", "SubSystem" });
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);

		

		combo_1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				source1 = (Combo) e.getSource();
				combo.removeAll();
				
				String curPath = Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs";
				File confFileDir = new File(curPath);
				File[] files = confFileDir.listFiles();

				if (source1.getText().isEmpty() || source1.getText() == null) {
					combo.setEnabled(false);

				} else if (source1.getText().equals("Adapter")) {

					combo.setEnabled(true);

					for (File file2 : files) {

						if (file2.getName().startsWith("Adapter")) {
							combo.add(file2.getName());
						}

					}
					combo.add("Add New");

				} else {
					combo.setEnabled(true);
					for (File file2 : files) {

						if (file2.getName().startsWith("SubSys")) {
							combo.add(file2.getName());
						}
					}
					combo.add("Add New");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Select File");

		combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.setEnabled(false);
		new Label(container, SWT.NONE);

		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_table.widthHint = 432;
		table.setLayoutData(gd_table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(200);
		tblclmnNewColumn_2.setText("Description");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Unit");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Size");

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new MyConfigLabelProvider());

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));

		btnAddTelemetry = new Button(composite, SWT.NONE);
		btnAddTelemetry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddDialog addDialog = new AddDialog(Display.getDefault().getActiveShell());
				int open = addDialog.open();

				if (open == IDialogConstants.OK_ID) {
					Telemetry telAdd = addDialog.getTelemetry();

					arraylist.add(telAdd);
					tableViewer.refresh();
				}

			}
		});
		// btnAddTelemetry.setText("Add");
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		btnAddTelemetry.setImage(sharedImages.getImage(ISharedImages.IMG_OBJ_ADD));

		btnDeleteTelemetry = new Button(composite, SWT.NONE);
		// btnDeleteTelemetry.setText("Remove");
		btnDeleteTelemetry.setImage(sharedImages.getImage(ISharedImages.IMG_ETOOL_DELETE));
		btnDeleteTelemetry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {

					Object firstElement = selection.getFirstElement();
					arraylist.remove(firstElement);
					tableViewer.refresh();
				}

			}
		});

		btnAddTelemetry.setEnabled(false);
		btnDeleteTelemetry.setEnabled(false);

		TableColumn[] columns = table.getColumns();

		CellEditor[] editors = new CellEditor[columns.length];
		for (int i = 0; i < editors.length; i++) {
			// TextCellEditor textCellEditor = new TextCellEditor(table);
			TextCellEditor textCellEditor = new TextCellEditor(table);
			editors[i] = textCellEditor;
			// editors[i]=textCellEditor;
			tableViewer.setCellEditors((org.eclipse.jface.viewers.CellEditor[]) editors);
			String[] strings = new String[] { "0", "1", "2", "3" };
			tableViewer.setColumnProperties(strings);
			tableViewer.setCellModifier(new ICellModifier() {

				@Override
				public void modify(Object element, String property, Object value) {
					Telemetry tel = (Telemetry) ((TableItem) element).getData();
					table.getSelectionIndex();
					if (property.equals("0")) {
						tel.setParameter(value.toString());

					} else if (property.equals("1")) {
						tel.setDescription(value.toString());
					} else if (property.equals("2")) {
						tel.setUnit(value.toString());
					} else if (property.equals("3")) {

						if (value.toString().equals("")) {
							tel.setLength(0);
						} else {
							tel.setLength(Integer.parseInt(value.toString()));
						}
					}
					tableViewer.refresh();

				}

				@Override
				public Object getValue(Object element, String property) {
					if (element instanceof Telemetry) {
						Telemetry tel = (Telemetry) element;
						if (property.equals("0")) {
							return tel.getParameter();
						}

						else if (property.equals("1")) {
							return tel.getDescription();
						} else if (property.equals("2")) {
							return tel.getUnit();

						} else if (property.equals("3")) {
							return Integer.toString(tel.getLength());
						}

					}

					return null;
				}

				@Override
				public boolean canModify(Object element, String property) {
					int index = tableViewer.getTable().getSelectionIndex();
					if (source1.getText().equals("Adapter")) {

						if (index <= 2) {
							return false;
						}

					} else {

						if (index <= 4) {
							return false;
						}

					}

					return true;

				}
			});

		}

		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				int index = tableViewer.getTable().getSelectionIndex();
				if (source1.getText().equals("Adapter")) {

					if (index <= 2) {

						btnAddTelemetry.setEnabled(true);
						btnDeleteTelemetry.setEnabled(false);
						return;

					}

				} else {

					if (index <= 4) {
						btnAddTelemetry.setEnabled(true);
						btnDeleteTelemetry.setEnabled(false);
						return;
					}

				}
				btnAddTelemetry.setEnabled(true);
				btnDeleteTelemetry.setEnabled(true);

			}
		});

		combo.addSelectionListener(new SelectionListener() {

			private String filePrefix;
			private String strs[];
			private FileWriter fw;

			@Override
			public void widgetSelected(SelectionEvent e) {
				arraylist = new ArrayList();
				source = (Combo) e.getSource();
				// Open the file
				FileInputStream fstream = null;

				if (source.getText().isEmpty() || source.getText() == null) {
					btnAddTelemetry.setEnabled(false);
					btnDeleteTelemetry.setEnabled(false);

				} else if (source.getText().equals("Add New")) {

					btnAddTelemetry.setEnabled(false);
					btnDeleteTelemetry.setEnabled(false);

					InputDialog inpDialog = new InputDialog(Display.getDefault().getActiveShell(), "New Configuration",
							"Please Enter the Name/Id of " + source1.getText(), null, null);
					int open = inpDialog.open();

					if (open == IDialogConstants.OK_ID) {

						if (source1.getText().equals("Adapter")) {
							filePrefix = "AdapterTelemetryConfig_";
							 strs = new String[] { "Adapter id|ID of the Adapter|-|2", "Number of Packet|Data recived from the subsystem |-|4", "Active interface|The interface connected with the subsystem|-|1" };
						} else {
							filePrefix = "SubSysTelemetryConfig_";
							 strs = new String[]  { "Subsystem name|Example Star tracker: 55 Every subsystem will have a specific id named to it. The each number in the range representing a specific subsystem. This number shall increase with the increase in the database.|-|3",
									    "Adapter id|ID of the Adapter|-|2", "Transmitted packet|Packet transmitted by the subsystem|-|3","Received packet|Data received from the adapter|-|3","Sub-system interface|The interface connected with the subsystem|-|1" };
						}
						
						File newconffPath = new File(Platform.getInstallLocation().getURL().getPath()
								+ "\\telemetryconfigs\\" + filePrefix + inpDialog.getValue() + ".txt");
					

						if (!newconffPath.exists()) {
							try {
								newconffPath.createNewFile();
								fw = new FileWriter(newconffPath);
							    for (int i = 0; i < strs.length; i++) {
								      fw.write(strs[i] + "\n");
								    }
								    fw.close();
								    
								    
								    
								    combo.add(filePrefix + inpDialog.getValue() + ".txt", combo.getItemCount()-1);

							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else {
							MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning", "File Already Exist.!!");
						}
					}

				} else if (source.getText().startsWith("Adapter")) {

					btnAddTelemetry.setEnabled(true);
					btnDeleteTelemetry.setEnabled(false);

					try {
						fstream = new FileInputStream(Platform.getInstallLocation().getURL().getPath()
								+ "\\telemetryconfigs\\" + source.getText());
						readFile(fstream);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

				} else {

					btnAddTelemetry.setEnabled(true);
					btnDeleteTelemetry.setEnabled(false);

					try {
						fstream = new FileInputStream(Platform.getInstallLocation().getURL().getPath()
								+ "\\telemetryconfigs\\" + source.getText());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

					readFile(fstream);

				}

			}

			@SuppressWarnings("unchecked")
			private void readFile(FileInputStream fstream) {
				String strLine;
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				// Read File Line By Line
				try {
					while ((strLine = br.readLine()) != null) {

						if (strLine.isEmpty()) {
							continue;
						}
						String[] parts = strLine.split("\\|");
						String part1 = parts[0]; // param
						String part2 = parts[1]; // desc
						String part3 = parts[2]; // Unit
						String part4 = parts[3]; // len

						Telemetry tel = Ma6icmodelFactory.eINSTANCE.createTelemetry();
						tel.setParameter(part1);
						tel.setDescription(part2);
						tel.setUnit(part3);
						tel.setLength(Integer.parseInt(part4));
						// cnfNames = Arrays.asList(part1, part2, part3, part4);
						arraylist.add(tel);
						// com.getTelemetry().add(tel);

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				// Close the input stream
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				tableViewer.setInput(arraylist);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
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
	protected void okPressed() {

		if (source.getText().startsWith("Adapter")) {
			fl2 = new File(
					Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs\\" + source.getText());
		} else {

			fl2 = new File(
					Platform.getInstallLocation().getURL().getPath() + "\\telemetryconfigs\\" + source.getText());
		}
		TableItem[] items = tableViewer.getTable().getItems();

		FileWriter flwr;
		int cls = tableViewer.getTable().getColumnCount();
		try {
			flwr = new FileWriter(fl2);
			for (int i = 0; i < items.length; i++) {
				for (int j = 0; j <= cls - 1; j++) {
					if (j == cls - 1) {
						flwr.write(items[i].getText(j));
					} else {
						flwr.write(items[i].getText(j) + "|");
					}
				}
				flwr.write("\n");
			}
			flwr.flush();
			flwr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		super.okPressed();

	};

	@Override
	protected Point getInitialSize() {
		return new Point(750, 300);
	}

	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}

}
