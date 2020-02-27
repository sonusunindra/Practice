package test.oops.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class A11 {
    public static void main(String[] args) {
        A21 a21=new A22();
        HashMap<String,String> myhashMap=new HashMap<>();
        myhashMap.put("Sonu","1");
        myhashMap.put("Ajay","2");
       Collection<String> list=myhashMap.values();
      List<String> arrayList= list.stream().collect(Collectors.toList());
      myhashMap.values().stream().collect(Collectors.toList());
       //ArrayList<String> strings= (ArrayList<String>)list;
        System.out.println(arrayList);
        //.m1();
    }
}
class A21{

}

class A22 extends A21{
    public void m1(){

    }
}