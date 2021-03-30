package yash.practice.java;

import yash.practice.java.custom.singlylinkedlist.Node;

public class Main {
    public static void main(String[] args) {
        Node<Integer> list = new Node<>();
        Node<Integer> head = null;


        head = list.add(head, 10);
        head = list.add(head, 101);
        head = list.add(head, 104);
        head = list.add(head, 102);
        head = list.add(head, 100);
        head = list.addNodeOnIndexFromStart(head, 111, 5);
        list.printList(head);
        System.out.println();
        head = head.reverse(head);
        list.printList(head);

    }
}
