package test.oops.basic;

public class SingeltonJava {
    static {
        System.out.println("SingeltonJava Loaded");
    }
    static int var =9;
    private  SingeltonJava(){}

    private static class SingeltonHelper{
        static{
            System.out.println("SingeltonHelper Loaded");
        }
        private static final SingeltonJava SINGELTON_JAVA=new SingeltonJava();
    }
    public static SingeltonJava getSingeltonHelper(){
        return SingeltonHelper.SINGELTON_JAVA;
    }
}
