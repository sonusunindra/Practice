package com.sonu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxOccurInString {
    public static void main(String[] args) {
        String str = "ababccddeeaaffhhii";
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                Integer j = map.get(ch[i]);
                map.put(ch[i], ++j);
            } else {
                map.put(ch[i], 1);
            }
        }
        Integer[] intArray = new Integer[map.size()];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Occurence of " + entry.getKey() + " is " + entry.getValue());


        }

        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxEntry == null || maxEntry.getValue().compareTo(entry.getValue()) > 1)
                maxEntry = entry;
        }
        System.out.println("Max Key:: " + maxEntry.getKey());


        System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());


    }
}
