package com.spintech.ma6ic.ui;
import java.io.*;

public class Test{
   public static void main(String args[]){
      String Str = new String("1A4122E8303E100E480111110201");

      System.out.print("Return Value :" );
      System.out.println(Str.substring(10) );

      System.out.print("Return Value :" );
      System.out.println(Str.substring(3, 6) );
      
   }
}