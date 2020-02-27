package test.oops.basic;

public class SingeltonTester {
    public static void main(String[] args) {

        //Class cls=SingeltonJava.class;
        //System.out.println(cls);
         int var=SingeltonJava.var;
        //System.out.println(var);
        SingeltonJava singeltonJava=SingeltonJava.getSingeltonHelper();
        System.out.println(singeltonJava);

        SingeltonJava singeltonJava1=SingeltonJava.getSingeltonHelper();
        System.out.println(singeltonJava1);


        SingeltonJava singeltonJava2=SingeltonJava.getSingeltonHelper();
        System.out.println(singeltonJava2);

        SingeltonJava singeltonJava3=SingeltonJava.getSingeltonHelper();
        System.out.println(singeltonJava3);

        SingeltonJava singeltonJava4=SingeltonJava.getSingeltonHelper();
        System.out.println(singeltonJava4);
/**/

    }
}
