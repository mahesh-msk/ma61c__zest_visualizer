package com.spintech.ma6ic.application;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    
	private IWorkbenchAction exitAction;
	private IContributionItem showViewOthersAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction helpAction;
	private IWorkbenchAction showViewAction;
	private IWorkbenchAction preferenceAction;
	
	

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
   
    	
    	exitAction = ActionFactory.QUIT.create(window);
    	showViewOthersAction = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
    	showViewAction = ActionFactory.SHOW_VIEW_MENU.create(window);
    	//showWindowAction = ContributionItemFactory.VIEWS_SHOW_IN.create(window.getShell().);
    	aboutAction = ActionFactory.ABOUT.create(window);
//    	helpAction = ActionFactory.HELP_CONTENTS.create(window);
    	preferenceAction = ActionFactory.PREFERENCES.create(window);

    
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager mgrFile = new MenuManager("File",IWorkbenchActionConstants.M_FILE);
    	mgrFile.add(preferenceAction);
    	mgrFile.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    	mgrFile.add(exitAction);
    	menuBar.add(mgrFile);
    	
    	MenuManager mgrWindow = new MenuManager("Window"); 
    	menuBar.add(mgrWindow);
    	    	
    	MenuManager mgrViewWindow = new MenuManager("Show View");    	
    	mgrViewWindow.add(showViewOthersAction);
    	mgrWindow.add(mgrViewWindow); 
    	
    	MenuManager mgrHelp = new MenuManager("Help",IWorkbenchActionConstants.M_HELP);
//    	mgrHelp.add(helpAction);
    	mgrHelp.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    	mgrHelp.add(aboutAction);    	
    	menuBar.add(mgrHelp);
    	 	
    }    
}
