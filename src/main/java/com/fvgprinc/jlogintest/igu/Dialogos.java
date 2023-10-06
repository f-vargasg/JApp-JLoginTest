/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fvgprinc.jlogintest.igu;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author garfi
 */
public class Dialogos {
    
    // Tipos de dialog 
    static final int TD_INFO = 0;   // informacion
    static final int TD_ERROR = 1;  // Error
    
    
    
    public static void mostrarMensaje(String mensaje, int tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        
        if (tipo == TD_INFO) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if (tipo == TD_ERROR) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
