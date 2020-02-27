package com.sonu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RestrictedMap<String, Employee> extends HashMap<String, Employee> {

    @Override
    public Employee put(String key, Employee value) {
        if (!isExist(value))

            return super.put(key, value);
        return value;
    }

    boolean isExist(Employee emp) {
        Set<String> keys = this.keySet();
        boolean flag = false;
        for (String empl : keys) {
            Employee emple = this.get(empl);
            if (emp.equals(emple))
                flag = true;
            break;
        }

        return flag;
    }
}
