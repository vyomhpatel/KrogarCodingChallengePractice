package b12app.vyom.com.krogarcodingchallengepractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PersonalisedCouponFilter {

    static List<Map<String,Object>> filterPersonalisedCoupons(List<Map<String,Object>> inputCouponList,List<String> prefferedCategories){
        Queue<Map<String, Object>> resultQueue = new PriorityQueue<>(11,new DiscountComparator());

        for(Map<String,Object> inputCoupon: inputCouponList){

            if(prefferedCategories.contains(inputCoupon.get("category"))){

                inputCoupon.remove("code");

                resultQueue.offer(inputCoupon);

                if(resultQueue.size()>10){
                    resultQueue.poll();
                }
            }
        }

    return new LinkedList<Map<String,Object>> (resultQueue);
    }

    static class DiscountComparator implements Comparator<Map<String, Object>> {

        @Override
        public int compare(Map<String, Object> couponX, Map<String, Object> couponY) {

            if((Float)couponX.get("itemPrice")/(Float) couponX.get("couponAmount")==(Float)couponY.get("itemPrice")/(Float) couponY.get("couponAmount")){
            return 0;
            } else if((Float)couponX.get("itemPrice")/(Float) couponX.get("couponAmount")>(Float)couponY.get("itemPrice")/(Float) couponY.get("couponAmount")){
                return -1;
            } else
                return 1;
        }
    }

    public static void main(String[] args) {

        Map<String, Object> coupon1 = new HashMap<>();
        coupon1.put("code", "code1");
        coupon1.put("category", "category1");
        coupon1.put("itemPrice", 100.0f);
        coupon1.put("couponAmount", 10.0f);


        Map<String, Object> coupon2 = new HashMap<>();
        coupon2.put("code", "code2");
        coupon2.put("category", "category1");
        coupon2.put("itemPrice", 100.0f);
        coupon2.put("couponAmount", 20.0f);


        Map<String, Object> coupon3 = new HashMap<>();
        coupon3.put("code", "code3");
        coupon3.put("category", "category2");
        coupon3.put("itemPrice", 100.0f);
        coupon3.put("couponAmount", 30.0f);

        Map<String, Object> coupon4 = new HashMap<>();
        coupon4.put("code", "code3");
        coupon4.put("category", "category2");
        coupon4.put("itemPrice", 100.0f);
        coupon4.put("couponAmount", 40.0f);


        Map<String, Object> coupon5 = new HashMap<>();
        coupon5.put("code", "code3");
        coupon5.put("category", "category1");
        coupon5.put("itemPrice", 100.0f);
        coupon5.put("couponAmount", 50.0f);


        Map<String, Object> coupon6 = new HashMap<>();
        coupon6.put("code", "code3");
        coupon6.put("category", "category1");
        coupon6.put("itemPrice", 200.0f);
        coupon6.put("couponAmount", 60.0f);


        Map<String, Object> coupon7 = new HashMap<>();
        coupon7.put("code", "code3");
        coupon7.put("category", "category1");
        coupon7.put("itemPrice", 100.0f);
        coupon7.put("couponAmount", 52.0f);


        Map<String, Object> coupon8 = new HashMap<>();
        coupon8.put("code", "code3");
        coupon8.put("category", "category1");
        coupon8.put("itemPrice", 100.0f);
        coupon8.put("couponAmount", 51.0f);


        Map<String, Object> coupon9 = new HashMap<>();
        coupon9.put("code", "code3");
        coupon9.put("category", "category1");
        coupon9.put("itemPrice", 100.0f);
        coupon9.put("couponAmount", 56.0f);


        Map<String, Object> coupon10= new HashMap<>();
        coupon10.put("code", "code3");
        coupon10.put("category", "category1");
        coupon10.put("itemPrice", 100.0f);
        coupon10.put("couponAmount", 55.0f);


        Map<String, Object> coupon11 = new HashMap<>();
        coupon11.put("code", "code3");
        coupon11.put("category", "category1");
        coupon11.put("itemPrice", 100.0f);
        coupon11.put("couponAmount", 53.0f);


        Map<String, Object> coupon12 = new HashMap<>();
        coupon12.put("code", "code3");
        coupon12.put("category", "category1");
        coupon12.put("itemPrice", 100.0f);
        coupon12.put("couponAmount", 49.0f);

        Map<String, Object> coupon13 = new HashMap<>();
        coupon13.put("code", "code3");
        coupon13.put("category", "category1");
        coupon13.put("itemPrice", 100.0f);
        coupon13.put("couponAmount", 48.0f);

        //----------
        List<Map<String, Object>> coupons = new ArrayList<>();
        coupons.add(coupon1);
        coupons.add(coupon2);
        coupons.add(coupon3);
        coupons.add(coupon4);
        coupons.add(coupon5);
        coupons.add(coupon6);
        coupons.add(coupon7);
        coupons.add(coupon8);
        coupons.add(coupon9);
        coupons.add(coupon10);
        coupons.add(coupon11);
        coupons.add(coupon12);
        coupons.add(coupon13);

        List<String> categories = new ArrayList<>();
        categories.add("category1");


        System.out.println(filterPersonalisedCoupons(coupons,categories));
    }
}
