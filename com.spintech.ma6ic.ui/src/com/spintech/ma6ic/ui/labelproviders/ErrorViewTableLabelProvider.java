package com.spintech.ma6ic.ui.labelproviders;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import ma6icmodel.ErrorTelemetry;

public class ErrorViewTableLabelProvider extends LabelProvider
    implements ITableLabelProvider
{

    public Image getColumnImage(Object element, int columnIndex)
    {
        return null;
    }

    public String getColumnText(Object element, int columnIndex)
    {
        if(element instanceof ErrorTelemetry)
        {
            ErrorTelemetry errorTelemetry = (ErrorTelemetry)element;
            switch(columnIndex)
            {
            case 0: // '\0'
                return errorTelemetry.getTelemetry();

            case 1: // '\001'
                return errorTelemetry.getError();

            case 2: // '\002'
				if (errorTelemetry.getTime() != null) {
					return errorTelemetry.getTime().toString();
				}
            }
        }
        return null;
    }
}