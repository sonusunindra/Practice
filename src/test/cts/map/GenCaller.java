package test.cts.map;

public class GenCaller {
    public static void main(String[] args) {
        GenType<String> stringGenType=new GenType<>();
        stringGenType.setObj("sonu");
        System.out.println(stringGenType.getObj());
    }
}
