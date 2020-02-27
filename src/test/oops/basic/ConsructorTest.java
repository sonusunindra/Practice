package test.oops.basic;

public class ConsructorTest {

    B b=new B();





}
class A{
    public A(int d){
    }
    final void m1(){}

}

class B extends A{

    public B(){
        super(5);
    }
    //void m1(){}

}