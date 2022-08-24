package com.spintech.ma6ic.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class MA6ICPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();
        layout.setEditorAreaVisible(false);
        IFolderLayout interface_command = layout.createFolder("interface_command", 3, 0.6F, editorArea);
//        interface_command.addView("com.spintech.ma6ic.ui.interfaceNew");
        interface_command.addView("com.spintech.ma6ic.ui.views.InterfaceView");
        layout.addView("com.spintech.ma6ic.ui.views.GraphView", 2, 0.69F, "interface_command");
        layout.addView("com.spintech.ma6ic.ui.views.UnknownParametersView", 4, 0.68F, "interface_command");
        layout.addView("com.spintech.ma6ic.ui.views.ErrorView", 2, 0.5F, "com.spintech.ma6ic.ui.views.UnknownParametersView");
        IFolderLayout packet = layout.createFolder("packet", 4, 0.5F, editorArea);
        packet.addView("com.spintech.ma6ic.ui.views.PacketView");
        packet.addView("com.spintech.ma6ic.ui.views.CommandHistoryView");
        IFolderLayout telemetry_adapter = layout.createFolder("telemetry_adapter", 2, 0.3F, "packet");
        telemetry_adapter.addView("com.spintech.ma6ic.ui.views.TelemetryAdapterView");
        IFolderLayout telemetry_subsystem = layout.createFolder("telemetry_subsystem", 2, 0.48F, "telemetry_adapter");
        telemetry_subsystem.addView("com.spintech.ma6ic.ui.views.TelemetrySubsystemView");
//        IFolderLayout history_command = layout.createFolder("telemetry", 2, 0.49F, "telemetry_subsystem");
 
    }

}
