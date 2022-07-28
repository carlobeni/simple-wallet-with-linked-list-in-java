/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework.exceptions;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class PosicionIncorrecta extends Exception {

    public PosicionIncorrecta() {
        super("Error: Posicion Incorrecta");
    }
    public PosicionIncorrecta(String message) {
        super(message);
    }
}
