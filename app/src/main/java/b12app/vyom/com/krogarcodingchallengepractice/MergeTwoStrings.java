package b12app.vyom.com.krogarcodingchallengepractice;

public class MergeTwoStrings {

    static String mergeTwoStrings(String a, String b) {
        String result = "";
        int index = 0;


        do {
            result += a.charAt(index);
            result += b.charAt(index);
            index++;
        } while ((index < a.length()));

        if (b.length() > a.length()) {
            result += b.substring(a.length());
        }

        return result;
    }

    public static void main(String[] args) {

        String a = "patel";
        String b = "vyomkumar";
        System.out.println(mergeTwoStrings(a, b));
    }
}
