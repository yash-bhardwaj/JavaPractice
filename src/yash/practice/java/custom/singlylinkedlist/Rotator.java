package yash.practice.java.custom.singlylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class Rotator {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        MyList list = null;
        for(int i=0; i<a.size(); i++) {
            list = addNode(list, a.get(i));
        }
        // rotate list d time
        for(int i=0; i<d; i++) {
            list = rotateLt(list);
        }

        return getList(list);
    }

    private static List<Integer> getList(MyList node) {
        List<Integer> list = new ArrayList<>();
        while(node!=null) {
            list.add(node.value);
            node = node.next;
        }
        return list;
    }

    private static MyList rotateLt(MyList node) {
        MyList head = node, current = node, temp = null;
        while (current.next != null) {
            current = current.next;
        }
        temp = head.next;
        current.next = head;
        head.next = null;
        return temp;

    }

    private static MyList addNode(MyList node, Integer data) {
        if(node == null) {
            node = new MyList();
            node.value = data;
            node.next = null;
        } else {
            node.next = addNode(node.next, data);
        }
        return node;
    }

}
class MyList {
    MyList next;
    Integer value;
}