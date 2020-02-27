package com.sonu;

import java.util.HashMap;
import java.util.Map;

public class HashTest {

    public static void main(String[] args) {
        Map<Emp,String> hashMap=new HashMap<>();
        hashMap.put(new Emp(),"ss");
        hashMap.put(new Emp(),"RR");
        hashMap.put(new Emp(),"tt");
        hashMap.put(new Emp(),"ee");
        System.out.println(hashMap);

    }

}
class Emp {

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}