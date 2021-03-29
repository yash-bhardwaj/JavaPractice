package yash.practice.java.custom.map;

import java.util.Arrays;

public class YashMap<T, U> {
    Node<T, U>[] nodeList = new Node[10];
    int size = 0;

    public YashMap() {}

    // put
    public void put(T key, U value) {
        if(size > this.nodeList.length) {
            // resize();
        }

        Node<T, U> existingNode = this.getNodeForKey(key);

        if(containsKey(key)) {
            Node<T, U> temp = existingNode;
            while(temp != null) {
                if(this.areNodeEquals(key, temp)) {
                    temp.entry.setValue(value);
                    break;
                }
                temp = temp.next;
            }
        } else {
            // persist if not exists
            Entry<T, U> newEntry = new Entry<>(key, value);
            Node<T, U> newNode = new Node<>(newEntry);
            newNode.next = null;
            this.nodeList[this.getHashIndex(key)] = this.addNewNode(existingNode, newNode);
        }
        // increase size
        this.size++;
    }

    private boolean areNodeEquals(T key, Node<T, U> temp) {
        return temp.entry.getKey().equals(key);
    }

    private Node<T, U> addNewNode(Node<T, U> existingNode, Node<T, U> newNode) {
        if (null == existingNode) {
            return newNode;
        } else {
            existingNode.next = addNewNode(existingNode.next, newNode);
            return existingNode;
        }
    }

    // containsKey
    public Boolean containsKey(T key) {
        Node<T, U> temp = this.getNodeForKey(key);
        while(temp != null) {
            if(this.areNodeEquals(key, temp)) {
                return Boolean.TRUE;
            }
            temp = temp.next;
        }
        return Boolean.FALSE;
    }

    private int getHashIndex(T key) {
        int hashCode = key.hashCode();
        return hashCode & this.nodeList.length-1;
    }
    // get
    public U get(T key) {
        Node<T, U> temp = this.getNodeForKey(key);
        while(temp != null) {
            if(this.areNodeEquals(key, temp)) {
                return temp.entry.value;
            }
            temp = temp.next;
        }
        return null;
    }

    private Node<T, U> getNodeForKey(T key) {
        int index = this.getHashIndex(key);
        return this.nodeList[index];
    }

    // remove
    public int remove(T key) {
        Node<T, U> existingNode = this.getNodeForKey(key);
        Node<T, U> head = new Node<>(new Entry<>());
        head.next = existingNode;
        Node<T, U> current = existingNode;
        Node<T, U> previous = existingNode;
        if (null == existingNode) {
            return -1;
        } else {
            try {
                if (this.areNodeEquals(key, current)) {
                    head.next = current.next;
                    return 0;
                }
                while (!current.entry.getKey().equals(key)) {
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                return 0;
            } finally {
                current = null;
                nodeList[getHashIndex(key)] = head.next;
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YashMap)) return false;
        YashMap<?, ?> yashMap = (YashMap<?, ?>) o;
        return Arrays.equals(nodeList, yashMap.nodeList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(nodeList);
    }

    public Node<T, U>[] entries() {
        return this.nodeList;
    }
}
