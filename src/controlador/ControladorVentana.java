/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Booth;
import vista.Ventana;

/**
 *
 * @author Hp
 */
public class ControladorVentana implements ActionListener{
    public Booth algoritmo;
    public Ventana v;
    
    public ControladorVentana(Ventana ventanaPrincipal){
        algoritmo= new Booth();
        this.v=ventanaPrincipal;
        this.v.botonCalcular.addActionListener(this);
        this.v.botonLimpiar.addActionListener(this);;
    }
    
    public void mostrarVentana(){
        v.setVisible(true);
        
    }
    
    public void mostrarTablas(){
       v.tablaArreglos.setModel(new javax.swing.table.DefaultTableModel(
            algoritmo.arreglos(),
            new String [] {
                "", "Bit 1", "Bit 2", "Bit 3", "Bit 4", "Bit 5", "Bit 6", "Bit 7", "Bit 8", "Bit 9", "Bit 10", "Bit 11", "Bit 12", "Bit 13", "bit 14", "Bit 15", "Bit 16", "Bit E"
            }
        ));
        
        v.tablaIteraciones.setModel(new javax.swing.table.DefaultTableModel(
            algoritmo.matriz,
            new String [] {
                "P", "Bit 1", "Bit 2", "Bit 3", "Bit 4", "Bit 5", "Bit 6", "Bit 7", "Bit 8", "Bit 9", "Bit 10", "Bit 11", "Bit 12", "Bit 13", "bit 14", "Bit 15", "Bit 16", "Bit E"
            }
        ) );
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int numero1;
        int numero2;
        String multiplicandoBi;
        String multiplicadorBi;
        if(e.getSource()==v.botonCalcular){
            numero1= Integer.parseInt(v.textoMultiplicando.getText());
            numero2= Integer.parseInt(v.textoMultiplicador.getText());
            
            multiplicandoBi=algoritmo.binario(numero1);
            
            multiplicadorBi=algoritmo.binario(numero2);
            
            v.textoMultiplicandoBin.setText(multiplicandoBi);
            v.textoMultiplicadorBin.setText(multiplicadorBi);
            v.textoMultiplicandoCom.setText(algoritmo.complemento2(numero1));
            v.textoMultiplicadorCom.setText(algoritmo.complemento2(numero2));
            v.textoOperacion.setText(numero1 + " * "+numero2);
        
            algoritmo.calcular(numero1, numero2);
            this.mostrarTablas();
            v.textoResultadoBin.setText(algoritmo.resultadoBinario());
           v.textoResultadoDe.setText(""+numero1*numero2);
        }
        if(e.getSource()==v.botonLimpiar){
            v.limpiar();
        }
        
    }
    
}
