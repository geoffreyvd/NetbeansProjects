/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht1c;

import java.util.Iterator;

/**
 *
 * @author geoffrey
 */
public class Opdracht1C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

}

class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
        Node newNode = new Node(item);
        //Als er nog geen node in de deque zit dan is de nieuwe node zowel de
        //eerste als de laatste node.
        if (first == null && last == null) {
            first = newNode;
            last = newNode;
        } else {
            //De nieuwe node wordt voor de eerste node geplakt.
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void pushRight(Item item) {
        Node newNode = new Node(item);
        if (first == null && last == null) {
            first = newNode;
            last = newNode;
        } else {
            //De nieuwe node wordt achter de laatste node geplaatst.
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    public Item popLeft() {
        //Maak een temporary item aan zodat de data van de verwijderde node
        //gereturned kan worden. Vervolgens wordt de previous referentie van
        //de tweede node op null gezet en de tweede node wordt de eerste node.
        //Als laatste wordt de size van de deque met 1 vermindert.
        Item temp = first.item;
        first.next.previous = null;
        first = first.next;
        size--;
        return temp;
    }

    public Item popRight() {
        Item temp = last.item;
        last.previous.next = null;
        last = last.previous;
        size--;
        return temp;
    }

    public void changeLeft(int k, Item newItem) {
        //Check of de opgegeven index binnen de grote van de deque zit.
        if (k > 0 && k <= size) {
            //Begin bij de eerste node
            Node currentNode = first;
            for (int i = 1; i < k; i++) {
                //De loop gaat net zo lang door tot hij bij index k is.
                currentNode = currentNode.next;
            }
            //De inhoud van de node ofwel het item, wordt het opgegeven item.
            currentNode.item = newItem;
        } else {
            //Als de opgegeven index niet binnen de grote van de deque zit
            //wordt de indexOutOfBounds exceptie terug gegeven.
            throw new IndexOutOfBoundsException();
        }
    }

    public void changeRight(int k, Item newItem) {
        //Het zelfde als changeLeft behalve dat deze methode van de rechter
        //(achterkant) van de deque begint
        if (k > 0 && k <= size) {
            Node currentNode = last;
            for (int i = 1; i < k; i++) {
                currentNode = currentNode.previous;
            }
            currentNode.item = newItem;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        //Hier wordt het iterator object gereturned.
        return new DequeIterator(first);
    }

    private class Node {

        private Item item;
        private Node next;
        private Node previous;

        public Node(Item item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    private class DequeIterator implements Iterator {
        //Uit de opdracht werd mij niet duidelijk welke kant de iteratie op
        //moet gaan, dus ik heb  de queue iteratie geïmplementeert

        private Node current;

        public DequeIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            //zolang de current Node niet null is kan er nog een iteratie
            //plaats vinden.
            return current != null;
        }

        @Override
        public Item next() {
            //De curent node wordt in een temporary Node geplaatst, zodat
            //de data(item) na de rewrite van current uitgelezen kan worden.
            Node temp = current;
            current = current.next;
            return temp.item;
        }

    }

}
