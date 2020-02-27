package test.oops.basic;

public class ConstructorChaining {

    public static void main(String[] args) {
        new B1();
    }
}
 class A1{
    public A1(){
        System.out.println("from A1");
    }
 }

 class B1 extends A1{
    public B1(){
        System.out.println("from B1");

    }
 }