package yash.practice.java.custom.map;

public class Node<T, U> {
    public Node<T, U> next;
    public Entry<T, U> entry;

    public Node(Entry<T, U> newEntry) {
        this.entry = newEntry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T, U> temp = this;
        while(null != temp) {
            sb.append(temp.entry).append(", ");
            temp = temp.next;
        }
        return sb.substring(0, sb.length()-2) + "]";

    }
}
