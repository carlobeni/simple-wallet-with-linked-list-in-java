/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class Nodo<E> { 

    private E dato;
    private Nodo<E> next;
    
    public Nodo() {
        this.dato=null;
        this.next=null;
    }
    
    public Nodo(E dato) {
        this.dato = dato;
        this.next = null;
    }

    public E getDato() {
        return dato;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
    
    
    
}
