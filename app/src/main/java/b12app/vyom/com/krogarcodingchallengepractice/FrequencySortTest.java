package b12app.vyom.com.krogarcodingchallengepractice;

import android.support.annotation.NonNull;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class FrequencySortTest {

   static void sortArrayByFrequency(int[] inputArray){

       Map<Integer,Integer> frequencyMap = new HashMap<>();
       for(int elementIndex = 0; elementIndex<inputArray.length; elementIndex++){
           if(frequencyMap.containsKey(inputArray[elementIndex])){

               frequencyMap.put(inputArray[elementIndex],frequencyMap.get(inputArray[elementIndex])+1);
           } else {

               frequencyMap.put(inputArray[elementIndex],1);
           }
       }


           Iterator mapIterator = frequencyMap.entrySet().iterator();
            List<PairResult> resultList = new ArrayList<>();

       while (mapIterator.hasNext()){
           Map.Entry pairToadd = (Map.Entry) mapIterator.next();

       }

       System.out.println(frequencyMap);
    }

    static class PairResult implements Comparable<PairResult>{
       int item, count;
        public PairResult(int item,int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public int compareTo(@NonNull PairResult pairResult2) {
            if(count==pairResult2.count){
                return 0;
            } else if(count > pairResult2.count){
                return -1;
            } else {
                return 1;
            }
        }
    }






    public static void main(String[] args) {

        int[] array = {1,2,3,2,4,4,5,1,1};
        sortArrayByFrequency(array);
    }
}
