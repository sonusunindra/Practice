package test.oops.basic;

public class FirstNonRepeatingString {

    static int[] count = new int[256];
    /* calculate count of characters
           in the passed string */
    static void getCount(String str) {
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }


    }

    static int getIndex(String str) {
        int index = 0;
        for (int k = 0; k < str.length(); k++) {
            if (count[str.charAt(k)] == 1) {
                index = k;
                break;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        String str = "aabbcddd";
        getCount(str);
        for (int j = 0; j < count.length; j++) {
            System.out.println("at index " + j + " count is --> " +  (int)count[j]);
        }
        int index = getIndex(str);
        System.out.println("First non repeative character at index " + getIndex("firstflight") + "\n The character is " + str.charAt(index));
    }

}
