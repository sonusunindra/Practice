package com.sonu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ExceptionTest {

    public static void main(String[] args)throws IOException {
        File file=new File("");
        FileInputStream fis=new FileInputStream(file);



    }
}
class HelloA{
    public void m1() throws NullPointerException{

    }
}

class HaiA extends HelloA{
    public void m1() throws RuntimeException{
        HashSet set =new HashSet();
    }
}