package com.sonu;

public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public boolean equals(Employee emp) {


        if (this.id == emp.id)
            return true;
        else
        return false;
    }

    /*@Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
