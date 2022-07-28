/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework;

import com.pack_billete.java_homework.Nodo;
import com.pack_billete.java_homework.exceptions.ListaVacia;
import com.pack_billete.java_homework.exceptions.PosicionIncorrecta;
import java.util.ArrayList;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class ListaEnlazada<T> {
    private Nodo<T> frente;
    private Nodo<T> ultimo;
    private int size;

    public ListaEnlazada() {
        this.frente = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void insertar(T dato,int pos) throws PosicionIncorrecta{
        if(pos<1||pos>(size+1)) throw new PosicionIncorrecta();
        if(pos<=size){
            Nodo<T> index=frente;
            for(int j=1;j<pos;j++) index=index.getNext();
            index.setDato(dato);
        }else{
            Nodo<T> temp=new Nodo(dato);
            if(size==0) frente=temp;
            else ultimo.setNext(temp);
            ultimo=temp;
            size++;
        }
        System.out.println("Cargado ["+pos+"] = "+dato.toString());
    }
    public T eliminar(int pos)throws PosicionIncorrecta,ListaVacia{
        if(size==0) throw new ListaVacia();
        if(pos<1||pos>size) throw new PosicionIncorrecta();
        Nodo<T> e;
        if(pos==1){
            e=frente;
            frente=frente.getNext();
        }else{
            Nodo<T> index=frente;
            for(int j=1;j<pos-1;j++) index=index.getNext();
            if(pos==size) ultimo=index;
            e=index.getNext();
            index.setNext(e.getNext());
        }
        System.out.println("Eliminado ["+pos+"] = "+e.getDato().toString());
        size--;
        return e.getDato();
    }
 
    public T consultar(int pos)throws PosicionIncorrecta,ListaVacia{
        if(size==0) throw new ListaVacia();
        if(pos<1||pos>size) throw new PosicionIncorrecta();
        Nodo<T> index=frente;
        for(int j=1;j<pos;j++) index=index.getNext();
        return index.getDato();
    }
    public int buscar(T dato){
        Nodo<T> index=frente;
        for(int j=1;j<=size;j++){
            if(index.getDato().equals(dato)) return j;
            index=index.getNext();
        }
        return 0;
    }
    public ArrayList<T> to_array() throws PosicionIncorrecta, ListaVacia{
        ArrayList<T> temp=new ArrayList<T>();
        for(int i=1;i<=size;i++) temp.add(consultar(i));
        return temp;
    }
    public int get_size(){return size;}
    public boolean is_empty(){return size==0;}
    
    
    
    
    
    
}
