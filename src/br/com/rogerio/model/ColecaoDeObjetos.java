/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rogerio.model;

import java.util.Iterator;

/**
 *
 * @author roger
 */
public class ColecaoDeObjetos implements Iterator {

    Aluno[] array = null;
    int pos = 0;

    public ColecaoDeObjetos(Aluno[] array) throws Exception {
        if (array == null) {
            throw new Exception("Coleção não enviada");
        }
        this.array = array;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos != array.length;
    }

    @Override
    public Object next() {
        return array[pos++];
    }
}
