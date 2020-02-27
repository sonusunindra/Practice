package com.sonu;

import java.util.HashMap;
import java.util.Map;

public class OccurString {

    public static void main(String[] args) {
        int []ar={1,10,5,5,10,15,3,3,3};
        Map<Integer,Integer> has=new HashMap<>();


        for(int i:ar) {
            if (!has.containsKey(i)) {
                int j=1;
                has.put(i,j);
            }
            else{
               int k= has.get(i);
               has.put(i,++k);
            }

        }
        System.out.println(has);
    }

}
