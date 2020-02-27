package test.oops.basic;

public class SecondLargestNumber {

    public static void main(String[] args) {
        int arr[]={4,5,21,34};
        int first,second,i;
        first=second=-1;
        for(i=0;i<arr.length;i++){

            if(arr[i]>first){
                second=first;
                first=arr[i];
            }
            if(arr[i]<first&&arr[i]>second){
                second=arr[i];
            }
        }

        System.out.println(second);
    }
}
