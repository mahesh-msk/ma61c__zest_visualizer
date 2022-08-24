package editors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.spintech.ma6ic.ui.labelproviders.tableViewerTelemetryAdapterLabelProvider;

import ma6icmodel.Adapter;
import ma6icmodel.Ma6ic;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;

public class InterfaceDetailBlock implements IDetailsPage {

	private Ma6ic ma6ic;
	private IManagedForm managedForm;
	private TableViewer tableViewerTelemetry;
	private Table table;
	private EList<Telemetry> telemetry;

	public InterfaceDetailBlock(Ma6ic ma6ic) {
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

		Composite composite2 = new Composite(composite, SWT.NONE);
		GridData gd_composite2 = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_composite2.heightHint = 571;
		composite2.setLayoutData(gd_composite2);
		composite2.setLayout(new GridLayout(3, false));
		
		tableViewerTelemetry = new TableViewer(composite2, SWT.BORDER | SWT.FULL_SELECTION);
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

		

	}

	public void dispose() {
		// Disposet
	}

	public void setFocus() {
		// Set focus
	}

	private void update() {

		tableViewerTelemetry.setInput(telemetry);
	

	}

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			
			if (structuredSelection.getFirstElement() instanceof Adapter) {
				Adapter adapter = (Adapter) structuredSelection.getFirstElement();;
				telemetry =  adapter.getTelemetry();
			}else if (structuredSelection.getFirstElement() instanceof Subsystem) {
				Subsystem subSys = (Subsystem) structuredSelection.getFirstElement();
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
