package model;

import java.util.LinkedList;

public class Pilha<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void push(T elemento) {
        elementos.addFirst(elemento);
    }

    public T pop() {
        return elementos.removeFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
