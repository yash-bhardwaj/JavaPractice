package yash.practice.java.custom.singlylinkedlist;

public class Node<T> {
    Node<T> next;
    T value;

    // 1. Add element to nth position from start of the list
    public Node<T> add(Node<T> head,T value) {
        if (null == head) {
            head = new Node<>();
            head.value = value;//10
            head.next = null;
        } else {
            head.next = add(head.next, value);
        }
        return head;
    }

    public Node<T> addNodeOnIndexFromStart(Node<T> head, T val, int index) {
        Node<T> node = new Node<T>() {{
            this.value = val;
            this.next = null;
        }};
        if (head == null) {
            return node;
        } else if (index == 0) {
            node.next = head;
            return node;
        } else {
            int i = 0;
            Node<T> current = head;
            Node<T> temp = current;
            while (i != index && current != null) {
                i++;
                temp = current;
                current = current.next;
            }
            node.next = temp.next;
            temp.next = node;
            return head;
        }
    }

    // 2. Remove element from nth position from start of the list
    // 3. Add element to nth position from end of the list
    // 4. Remove element from nth position from end of the list
    // 5. print all the elements
    public void printList(Node<T> head) {
        if (head!=null) {
            System.out.println(head.value);
            printList(head.next);
        }
    }
    // 6. reverse the list
    public Node<T> reverse(Node<T> head) {
        Node<T> current = head, temp = head, prev = null;
        while(temp != null) { //10 //101
            temp = current.next; // 101 // 104
            current.next = prev; // 101 -> 10 -> null
            prev = current; // 10 // 101
            current = temp; // 101 // 104
        }
        head = prev;
        return head;
    }

}
