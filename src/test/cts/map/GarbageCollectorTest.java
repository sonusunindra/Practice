package test.cts.map;

public class GarbageCollectorTest {
    public static void main(String[] args) throws InterruptedException{
        GcTester gcTester=new GcTester();
        String str="KK";
        System.out.println(str);
        str=null;
        gcTester=null;
        System.gc();
        Thread.sleep(4000);
        System.out.println("Garbage Collector Test Ended");
    }

}
class GcTester{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalized get called");
        throw new Exception();
    }
}