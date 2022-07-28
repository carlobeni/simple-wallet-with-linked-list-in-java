/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework;

import com.pack_billete.java_homework.exceptions.BilleteraVacia;
import com.pack_billete.java_homework.exceptions.ListaVacia;
import com.pack_billete.java_homework.exceptions.PosicionIncorrecta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class Billetera {

    private ListaEnlazada<Billete> mymoney=new ListaEnlazada<>();
    private static String name_file = "billetes.txt";
    
    public Billetera() {}
    
    public static String get_name_file(){return name_file;}
    
    public void init() throws IOException{
        File file = new File(name_file);
        if (!file.exists()) file.createNewFile();
    }
    //Lee los billetes del txt
    public void cargar_billetes() throws FileNotFoundException, IOException, PosicionIncorrecta{
        BufferedReader in;
        in = new BufferedReader(new FileReader(name_file));
        while(in.ready()){
            String str_value=in.readLine().split(" - ")[0];
            agregar_billete(Integer.valueOf(str_value));
        }
        in.close();
    }
    
    //Escribe los billetes en el txt
    public void guardar_billetes() throws IOException, PosicionIncorrecta, ListaVacia{
        BufferedWriter ou;
        ou = new BufferedWriter(new FileWriter(name_file));
        for(int i=1;i<=mymoney.get_size();i++) ou.write(mymoney.consultar(i).toString()+"\n");
        ou.close();
    }
    
    //Agrega los billetes al list
    public void agregar_billete(int valor) throws PosicionIncorrecta{
        mymoney.insertar(new Billete(valor),mymoney.get_size()+1);
    }
    public void agregar_billete_with_pos(int valor,int pos) throws PosicionIncorrecta{
        mymoney.insertar(new Billete(valor),pos);
    }
    //Quita los billetes dada una posicion
    public void quitar_billete_with_pos(int pos) throws PosicionIncorrecta, ListaVacia, BilleteraVacia{
        if(mymoney.get_size()==0) throw new BilleteraVacia();
        mymoney.eliminar(pos);
    }
    //Quita el primer billete encontrado con el valor dado 
    public void quitar_billete(int valor) throws PosicionIncorrecta, ListaVacia, BilleteraVacia{
        if(mymoney.get_size()==0) throw new BilleteraVacia();
        int pos=mymoney.buscar(new Billete(valor));
        mymoney.eliminar(pos);
    }
    //Debuelve el primer billete con el valor dado
    public int buscar_billete(int valor) throws BilleteraVacia{
        if(mymoney.get_size()==0) throw new BilleteraVacia();
        return mymoney.buscar(new Billete(valor));
    }
    public Billete ver_billete(int pos) throws PosicionIncorrecta, ListaVacia, BilleteraVacia{
        if(mymoney.get_size()==0) throw new BilleteraVacia();
        return mymoney.consultar(pos);
    }
    public ArrayList get_billetes() throws PosicionIncorrecta, ListaVacia{
        ArrayList<Integer> values=new ArrayList<>();
        for(int i=0;i<mymoney.get_size();i++) values.add(mymoney.to_array().get(i).getValor());
        return values;
    }
    public  ArrayList get_val_with_text() throws PosicionIncorrecta, ListaVacia{
        ArrayList<String> text=new ArrayList<>();
        for(int i=0;i<mymoney.get_size();i++) text.add(mymoney.consultar(i+1).toString());
        return text;
    }
    public int total_billetera() throws PosicionIncorrecta, ListaVacia{
        int sum=0;
        for(int i=0;i<mymoney.get_size();i++) sum+=mymoney.to_array().get(i).getValor();
        return sum;
    }
    public int get_cant_billetes(){return mymoney.get_size();}
}
