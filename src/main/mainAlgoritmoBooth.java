/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorVentana ;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import vista.Ventana;

/**
 *
 * @author Hp
 */
public class mainAlgoritmoBooth {
    public static void main(String []args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        //Cambia el look and feel de la ventana
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
        //Marca de agua (numeros binarios)
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
        
        SubstanceLookAndFeel.setSkin("SubstanceFieldView");
        
        Ventana v= new Ventana();
        
        ControladorVentana c= new ControladorVentana(v);
        
        c.mostrarVentana();        
    }
}
