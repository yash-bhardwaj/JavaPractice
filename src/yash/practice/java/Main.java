package yash.practice.java;

import yash.practice.java.custom.map.Node;
import yash.practice.java.custom.map.YashMap;

public class Main {
    public static void main(String[] args) {

        YashMap<Integer, String > myMap = new YashMap<>();
        myMap.put(5, "Yash5");
        myMap.put(15, "Yash15");
        myMap.put(25, "Yash25");
        myMap.put(75, "Yash75");
        myMap.put(71, "Yash75");
        myMap.put(72, "Yash75");
        myMap.put(73, "Yash75");
        myMap.put(74, "Yash75");
        myMap.put(76, "Yash75");
        myMap.put(78, "Yash75");
        myMap.put(82, "Yash85");
        System.out.println(myMap.get(25));
        System.out.println(myMap.containsKey(9));
        Node<Integer, String>[] list = myMap.entries();
        for (Node<Integer, String> customEntry : list) {
            System.out.println(customEntry);
        }

        myMap.remove(75);

        System.out.println("\n");
        for (Node<Integer, String> customEntry : list) {
           System.out.println(customEntry);
        }
    }
}
