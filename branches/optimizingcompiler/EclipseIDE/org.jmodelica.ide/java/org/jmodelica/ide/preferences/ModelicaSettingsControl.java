package org.jmodelica.ide.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.jmodelica.ide.IDEConstants;
import org.jmodelica.ide.helpers.Util;

public class ModelicaSettingsControl  {

	private List<String> libraryPaths;

	private Button delLibraryButton;
	private Button addLibraryButton;
	private Table libraryTable;
	private Group libraryGroup;

	private MessageBox error;
	private DirectoryDialog libraryDlg;

	public ModelicaSettingsControl() {
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		libraryDlg = createDlg(shell, "to load libraries from");
		error = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);

		libraryPaths = new ArrayList<String>();
	}

	public String getLibraryPaths() {
		return Util.implode(IDEConstants.PATH_SEP, libraryPaths);
	}

	public void setLibraryPaths(String libStr) {
		libraryPaths.clear();
		if (libStr != null)
			libraryPaths.addAll(Arrays.asList(libStr.split(IDEConstants.PATH_SEP)));
		updateLibraryPaths();
	}

	private void updateLibraryPaths() {
		if (libraryTable != null) {
			libraryTable.removeAll();
			for (String lib : libraryPaths)
				addLibrary(lib);
			for (TableColumn tc : libraryTable.getColumns())
				tc.pack();
		}
	}
	
	public Control createControl(Composite parent) {
		libraryGroup = createLibraryGroup(parent);
		updateLibraryPaths();
		return libraryGroup;
	}

	private DirectoryDialog createDlg(Shell shell, String desc) {
		DirectoryDialog dlg = new DirectoryDialog(shell);
		dlg.setMessage("Select directory " + desc);
		dlg.setText("Select directory");
		return dlg;
	}

	private Group createLibraryGroup(Composite parent) {
		Group grp = new Group(parent, SWT.NONE);
		grp.setText("Library paths");
		grp.setLayout(new GridLayout(1, false));
		createLibrariesComposite(grp);
		return grp;
	}

	private void createLibrariesComposite(Composite parent) {
		Composite container = createContainer(parent, 2);
		createLibraryTable(container);
		createLibraryButtonsComposite(container);
		container.pack();
	}

	private void createLibraryButtonsComposite(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
		container.setLayout(marginlessGridLayout(1));

		addLibraryButton = createButton(container, "Add");
		addLibraryButton.addSelectionListener(new AddListener());

		delLibraryButton = createButton(container, "Remove");
		delLibraryButton.addSelectionListener(new DeleteListener());
		delLibraryButton.setEnabled(false);

		container.pack();
	}

	private Table createLibraryTable(Composite parent) {
		libraryTable = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		libraryTable.setLinesVisible(true);
		libraryTable.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 100;
		libraryTable.setLayoutData(data);

		for (String columnName : new String[] { "Path" })
			new TableColumn(libraryTable, SWT.NONE).setText(columnName);

		libraryTable.addSelectionListener(new TableSelectionListener());
		
		return libraryTable;
	}

	private Composite createContainer(Composite parent, int layoutNbrCols) {
		Composite container = new Composite(parent, SWT.None);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(marginlessGridLayout(layoutNbrCols));

		return container;
	}

	private Button createButton(Composite parent, String title) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(title);
		button.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		return button;
	}

	private GridLayout marginlessGridLayout(int cols) {
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = cols;
		return layout;
	}

	private void addLibrary(String library) {
		new TableItem(libraryTable, SWT.NONE).setText(0, library);
	}


	public class AddListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			String path = libraryDlg.open();
			if (path != null) {
				if (libraryPaths.contains(path)) {
					error.setMessage("Library path already added.");
					error.open();
				} else {
					libraryPaths.add(path);
					addLibrary(path);
				}
			}
		}

	}

	public class DeleteListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			libraryTable.getSelectionIndex();
			int i = libraryTable.getSelectionIndex();
			libraryTable.remove(i);
			libraryPaths.remove(i);
		}

	}

	public class TableSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(e);
		}

		public void widgetSelected(SelectionEvent e) {
			delLibraryButton.setEnabled(e.item != null);
		}

	}

}
