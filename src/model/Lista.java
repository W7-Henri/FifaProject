package model;

import java.util.LinkedList;

public class Lista<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void add(T elemento) {
        elementos.addLast(elemento);
    }

    public LinkedList<T> getElementos() {
        return elementos;
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
