/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class Billete {
    private int valor;
    private String denominacion;
    
    private static TreeMap<Integer, String> map = new TreeMap<>();

    public Billete() {
        update_values_cash();
        valor=100000;
        denominacion=map.get(valor);
    }
    
    
    public Billete(int valor) {
        update_values_cash();
        denominacion=map.get(valor);
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }

    public String getDenominacion() {
        return denominacion;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    public String toString(){
        return String.valueOf(valor)+" - "+denominacion;
    }
    
    public static ArrayList<String> templates_arraylist(){
        update_values_cash();
        ArrayList<String> text = new ArrayList<>();
        for(int i=0;i<map.keySet().size();i++) text.add(map.keySet().toArray()[i].toString());
        return text;
    }
    
    private static void update_values_cash(){
        map.put(100000,"Cien mil guaranies");
        map.put(50000,"Cincuenta mil guaranies");
        map.put(20000,"Veinte mil guaranies");
        map.put(10000,"Diez mil guaranies");
        map.put(5000,"Cinco mil guaranies");
        map.put(2000,"Dos mil guaranies");
        //map.put(1000,"Mil guaranies"); 
        //map.put(500,"Quinientos guaranies"); 
        //map.put(100,"Quinientos guaranies"); 
        //map.put(50,"Cincuenta guaranies"); 
    }
}
