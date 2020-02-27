package com.sonu;

public class RemoveDuplicateFromArray {

    public static void main(String[] args) {
        int temp,counter = 0;
        int ar[]=new int[]{1,2,3,4,1,2,44,54,66,75,2,44};

        for(int i=0;i<ar.length;i++){
            for(int j=i+1;j<ar.length;j++){
                if(ar[i]>ar[j]){
                    temp=ar[i];
                    ar[i]=ar[j];
                    ar[j]=temp;
                }

            }
        }

        for(int r:ar){
            System.out.print(r+"\t");
        }
        //System.out.println(counter);
       /* int arnd[]=new int [counter];
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length;j++){
                if(ar[i]!=ar[j]){
                    arnd[i]=ar[i];
                }
            }
        }*/


    }
}