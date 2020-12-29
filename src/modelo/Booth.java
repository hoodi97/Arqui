/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Booth {
    public String A;
    public String S;
    public String P;
    public String [][] matriz;
    
    public Booth(){
        A=null;
        S=null;
        P=null;
        matriz=new String [8][18] ;
    }
    
    
    public void calcular(int multiplicando, int multiplicador){
        
        String multiplicandoB=this.binario(multiplicando);
        String multiplicadorB=this.binario(multiplicador);
        String multiplicandoC=this.complemento2(multiplicando);
        String multiplicadorC=this.complemento2(multiplicador);
        
        if( multiplicando<0 ){    
            A=this.completarDerecha(multiplicandoC);
            S=this.completarDerecha(multiplicandoB);
        
        }else{    
            A=this.completarDerecha(multiplicandoB);
            S=this.completarDerecha(multiplicandoC);
        }
            
        if(multiplicador<0){
            P=this.completarIzquierda(multiplicadorC);
        }else{
            P=this.completarIzquierda(multiplicadorB);
        }  
        
        this.calculoIteraciones(multiplicando, multiplicador,P, S, A);
        
        
    }
    
    public String[][] arreglos(){
        String [][] matrizASP= new String [3][18];
        matrizASP[0][0] = "A";
        matrizASP[1][0] = "S";
        matrizASP[2][0] = "P";
        for(int i=1 ;i<18 ;i++){
            matrizASP[0][i] = ""+this.A.charAt(i-1);
            matrizASP[1][i] = ""+this.S.charAt(i-1);
            matrizASP[2][i] = ""+this.P.charAt(i-1);
        }
        return matrizASP;
}
    public String resultadoBinario(){
        String retorno="";
        for(int i=1;i<17;i++){
            retorno=retorno+matriz[7][i];
        }
        return retorno;
    }
     
    
     public void calculoIteraciones(int multiplicando, int multiplicador,String P, String S, String A) {
        char ultimo, penultimo;
        int iteracion = 8;
        for (int i = 0; i < iteracion; i++) {
            ultimo = P.charAt(P.length() - 1);
            penultimo = P.charAt(P.length() - 2);

            if (penultimo != ultimo) {
                if (penultimo == '0' && ultimo == '1') {
                    P = this.Suma(P, A);
                }
                if (penultimo == '1' && ultimo == '0') {
                    P = this.Suma(P, S);
                }
            }
            P = this.desplazamiento(P);
            
            
            
            matriz[i][0]=""+(i+1);
            System.out.println("aqui :"+ matriz[i][0]);
            
            
            for(int j=1;j<18;j++){
                matriz[i][j]= ""+P.charAt(j-1);
            }
            
           
            System.out.println(P);
        }
         System.out.println(matriz);
        String resultado = P.substring(0,16);
         System.out.println("\nResultado "+resultado);
         System.out.println(multiplicando*multiplicador);
         
         
    }
    
    public String binario(int numero){
        String numeroBi;
        numero= Math.abs(numero);
        numeroBi = Integer.toBinaryString(numero);
        while(numeroBi.length()<8){
           numeroBi= "0"+numeroBi;
        }
        
        return numeroBi;
    }
    
    public String complemento2(int numero){
        String numeroBi;
        numero=-Math.abs(numero);
        numeroBi = Integer.toBinaryString(numero);
        return numeroBi.substring(24,32);
    }
      
    public String completarDerecha(String binario){
        int cont=0;
        int condicion = binario.length()+1;
        while(condicion > cont){
            binario = binario+"0";
            cont++;
        }
        return binario;
    }
    
    public String completarIzquierda(String binario){
        int cont=0;
        int condicion = binario.length();
        while(condicion > cont){
            binario = "0"+binario;
            cont++;
        }
        binario = binario+"0";
        return binario;
    }
    
    public String Suma(String binario1, String binario2){
        int comp=1;
        String binariocomp = Integer.toBinaryString(comp);
        char aux=0;
        String suma="";
        
        for (int i = 0; i <binario1.length() ; i++) {
            //System.out.println("numeros:"+binario1.charAt(binario1.length()-1-i)+"-"+binario2.charAt(binario2.length()-1-i));
            if (aux==0){
                //System.out.println("sin acarreo");
                if (binario1.charAt(binario1.length()-1-i) != binario2.charAt(binario2.length()-1-i)){
                    suma="1"+suma;
                    aux=0;
                    //System.out.println("diferentes");
                }else{
                    if (binario1.charAt(binario1.length()-1-i)==binariocomp.charAt(0)){
                    suma="0"+suma;
                    aux=1;
                    //System.out.println("iguales (1)");      
                    }else{
                    suma="0"+suma;
                    aux=0;
                   // System.out.println("iguales (0)");  
                    }
                }
            }else {
               // System.out.println("con acarreo");
                if (binario1.charAt(binario1.length()-1-i) != binario2.charAt(binario2.length()-1-i)){
                    suma="0"+suma;
                    aux=1;
                    //System.out.println("diferentes y sin acarreo");
                    //System.out.println("diferentes");
                }else{
                    if (binario1.charAt(binario1.length()-1-i)==binariocomp.charAt(0)){
                    suma="1"+suma;
                    aux=1;
                    //System.out.println("iguales (1)"); 
                    }else{
                     suma="1"+suma;
                    aux=0;
                    // System.out.println("iguales (0)"); 
                    }
                }
            }            
            
        }
        //System.out.println(suma);
        //System.out.println("\n----------------------");
        return suma;
    }
    
    public String desplazamiento(String p){
        String desp="";
        int comp=1;
        String binariocomp = Integer.toBinaryString(comp);
        //System.out.println(p);
        
        for (int i = 2; i <= p.length(); i++) {           
        desp=p.charAt(p.length()-i)+desp;
        }
        
        //System.out.println("bit:"+p.charAt(0)+"comp"+comp);
        
        if (p.charAt(0)==binariocomp.charAt(0)) {
            //System.out.println("entra");
            desp="1"+desp;
        }else{
            desp="0"+desp;
        }
        
        //System.out.println(desp);
        return desp;
    }
    
}


