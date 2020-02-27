package test.cts.map;

import java.io.FileInputStream;

public class FinallyTest {
    public static void main(String[] args)throws Exception {
        try(FileInputStream file=new FileInputStream("")){
            System.out.println("Inside try");
            throw new OutOfMemoryError();
        }catch(Error ex){
            System.out.println("InSide Error");
        }
        finally {
            System.out.println("Inside finally");
        }
    }
}
