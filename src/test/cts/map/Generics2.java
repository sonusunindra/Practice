package test.cts.map;

import java.util.ArrayList;

public class Generics2<T> {
    public static void main(String[] args) {
        ArrayList<Object> al=new ArrayList<>();
        al.add("23");
        al.add("sonu");
        al.add("raj");
        al.add("rohit");
        al.add("jk");
        System.out.println(al);
    }
}
