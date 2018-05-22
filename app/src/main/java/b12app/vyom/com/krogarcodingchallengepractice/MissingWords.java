package b12app.vyom.com.krogarcodingchallengepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MissingWords {
    static String[] missingWords(String s, String t) {
        List<String> trimmedWholeString = new ArrayList<>(Arrays.asList(s.trim().split(" ")));
        List<String> trimmedString = new ArrayList<>(Arrays.asList(t.trim().split(" ")));
        List<String> missingString =new LinkedList<>();
        int wholeLen=trimmedWholeString.size();
        int wholeIndex=0;
        for(int index = 0;index<trimmedString.size() && wholeIndex<wholeLen;){

            if(trimmedWholeString.get(wholeIndex).equals(trimmedString.get(index))){
                wholeIndex++;
                index++;
            } else{
                missingString.add(trimmedWholeString.get(wholeIndex));
                wholeIndex++;
            }
        }
        while(wholeIndex<wholeLen){
            missingString.add(trimmedWholeString.get(wholeIndex++));
        }

        return missingString.toArray(new String[missingString.size()]);

    }

    public static void main(String[] args) {
        String s = "i am using hackerrank to improve programming";
        String s1= "i am hackerrank to improve";
        String[] result = missingWords(s,s1);
        System.out.println(Arrays.toString(result));
    }

}
