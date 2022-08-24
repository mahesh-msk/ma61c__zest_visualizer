package com.spintech.ma6ic.ui;

import java.io.File;
import java.io.IOException;
import org.eclipse.jface.window.ApplicationWindow;

public class HelpPDFViewer extends ApplicationWindow {
 

/////////////////////////////////////////////////////////////////////////
//                         Constructor                                 //
/////////////////////////////////////////////////////////////////////////
public HelpPDFViewer() {
   super(null);
}

/////////////////////////////////////////////////////////////////////////
//                             run()                                   //
/////////////////////////////////////////////////////////////////////////
public void run() {
   File file = new File("c:\\Teamcenter\\Tc8.3\\portal\\temp\\james.pdf");
//   PDFViewer pdfv = new PDFViewer(true);
//   try {
//      pdfv.openFile(file) ;
//   }
//   catch (IOException e) {
//      e.printStackTrace();
//   }
//   pdfv.setEnabling();
//   pdfv.pack();
//   pdfv.setVisible(true);
   }
}