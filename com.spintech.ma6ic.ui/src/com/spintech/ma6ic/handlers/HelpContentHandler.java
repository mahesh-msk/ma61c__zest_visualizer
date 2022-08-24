package com.spintech.ma6ic.handlers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.window.ApplicationWindow;


public class HelpContentHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		if (Desktop.isDesktopSupported()) {
		    try {
		        File myFile = new File(Platform.getInstallLocation().getURL().getPath()+"\\helpcontents\\ma61c-documentation.pdf");
		        Desktop.getDesktop().open(myFile);
		    } catch (IOException ex) {
		        // no application registered for PDFs
		    }
		}
		
		return null;
	}
	
public class HelpPDFViewer extends ApplicationWindow {
		 
/////////////////////////////////////////////////////////////////////////
//Constructor                                 //
/////////////////////////////////////////////////////////////////////////
public HelpPDFViewer() {
super(null);
}

/////////////////////////////////////////////////////////////////////////
//run()                                   //
/////////////////////////////////////////////////////////////////////////
public void run() {
File file = new File("c:\\Teamcenter\\Tc8.3\\portal\\temp\\james.pdf");
//PDFViewer pdfv = new PDFViewer(true);
//try {
//pdfv.openFile(file) ;
//}
//catch (IOException e) {
//e.printStackTrace();
//}
//pdfv.setEnabling();
//pdfv.pack();
//pdfv.setVisible(true);
}
}

}
