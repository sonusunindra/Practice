package test.oops.basic;

public class OverridingTest {

    public static void main(String[] args) {
        Over1 over1=new Over2();
        over1.m(23);
    }
}

class Over1{
    void m(Number num){
        System.out.println("From number");
    }
}

class Over2 extends Over1{
    void m(Integer integer){
        System.out.println(("From integer"));
    }
}