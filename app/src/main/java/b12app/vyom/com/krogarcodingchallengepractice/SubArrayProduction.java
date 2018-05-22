package b12app.vyom.com.krogarcodingchallengepractice;

public class SubArrayProduction {

    static long count(int[] nums,int total){
        int first = 0;
        int productResult = 1;
        long result = 0;

        for(;first<nums.length;first++){
            if(nums[first]<total){
                result++;
            }

            for( int next = first+1;next<nums.length;next++){
                productResult *= nums[next];
                if(productResult<total){
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] input = {1,2,3};
       long result =  count(input,36);
        System.out.println(result);

    }
}
