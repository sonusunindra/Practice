package test.oops.basic;


public class OverridingTest1 {

    public static void main(String[] args) {
        Over3 over3 = new Over3();
        over3.m1(12);
        System.out.println("===main over");
    }
}

class Over3 {
    //4.
   /* void m1(Number number){
        System.out.println("====number====> "+number);
    }*/
   /* 3. void m1(Integer integer){
        System.out.println(("====integer======>"+integer));
    }*/
   /* 1. void m1(int i){
        System.out.println(("====int======>"+i));
    }*/
   /*2. void m1(long lg){
        System.out.println(("====long======>"+lg));
    }
*/
   //5.
    void m1(Integer... varargs) {
        System.out.println(("====varargs======" + varargs[0]));
    }

}