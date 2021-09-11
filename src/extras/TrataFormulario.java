/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 *
 * @author andre
 */
public class TrataFormulario {
    public static void limparCampos(JFrame form) throws Exception{
        limparCampos(form.getContentPane().getComponents());
    }
    public static void limparCampos(JInternalFrame form) throws Exception{
        limparCampos(form.getContentPane().getComponents());
    }
    private static void limparCampos(Component[] campos) throws Exception{
        for(Component c: campos){
            if(c instanceof JTextField){
                JTextField t =  (JTextField)c;
                t.setText("");
            }
            if(c instanceof JComboBox){
                JComboBox t =  (JComboBox)c;
                t.setSelectedIndex(0);
            }
        }
    }
    public static void habilitarCampos(JInternalFrame form, boolean b) throws Exception {
        habilitarCampos(form.getContentPane().getComponents(),b);
    }
    private static void habilitarCampos(Component[] campos,boolean b) throws Exception {
        for(Component c: campos)
            c.setEnabled(b);
    }
}
