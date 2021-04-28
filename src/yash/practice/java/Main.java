package yash.practice.java;

import yash.practice.java.custom.singlylinkedlist.Node;

public class Main {
    public static void main(String[] args) {
//        Node<Integer> list = new Node<>();
//        Node<Integer> head = null;
//
//
//        head = list.add(head, 10);
//        head = list.add(head, 100);
//        head = list.add(head, 104);
//        head = list.add(head, 102);
//        head = list.add(head, 100);
//        head = list.addNodeOnIndexFromEnd(head, 111, 5);
//        list.printList(head);
//        System.out.println();
//        head = head.reverse(head);
//        list.printList(head);

        for(int i=0; i<10;i++) {
            for(int j=10; j>i-1;j--) {
                System.out.print("");
            }
            for(int j=i; j>=0;j--) {
                System.out.print("* ");
            }

//            for(int j=10; j>=i+1;j--) {
//                System.out.print(" *");
//            }
            System.out.println();
        }
        System.out.println();
        for(int i=0; i<10;i++) {
            for(int j=0; j<=i;j++) {
                System.out.print("  ");
            }
            for(int j=10; j>=i+1;j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
