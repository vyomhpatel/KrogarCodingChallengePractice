package b12app.vyom.com.krogarcodingchallengepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreditCardValidation {

    public static final String CARD_UNIT = "cardUnit";
    public static final String IS_VALID = "isValid";
    public static final String IS_ALLOWED = "isAllowed";

    private static List<Map<String,Object>> validateInputCard(List<String> inputCardNumbers, List<String> bannedPrefixes){

        List<Map<String,Object>> resultList = new ArrayList<>();


        for(String singleCard: inputCardNumbers){

            Map<String,Object> cardMap = new LinkedHashMap<>();
            cardMap.put(CARD_UNIT,singleCard);
            cardMap.put(IS_VALID,luhnCheck(singleCard));
            cardMap.put(IS_ALLOWED,isCardAllowed(singleCard,bannedPrefixes));

            resultList.add(cardMap);
        }

        return resultList;
    }

    private static boolean luhnCheck(String cardNumber){

        int lastDigit = Integer.parseInt(cardNumber.substring(cardNumber.length()-1,cardNumber.length()));
        int total = 0;
        for(int digit = 0; digit < cardNumber.length()-1; digit++){
            total = total + Integer.parseInt(cardNumber.substring(digit,digit + 1)) * 2;
        }

        if(total%10==lastDigit){
        return true;
        }

        return false;
    }

    private static boolean isCardAllowed(String cardNumber, List<String> bannedPrefixes){

        for(int count = 0; count < bannedPrefixes.size(); count++) {
            if (cardNumber.startsWith(bannedPrefixes.get(count))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

            List<String> bannedPrefixesList = new ArrayList<>();
            bannedPrefixesList.add("1034");
            bannedPrefixesList.add("5");
            bannedPrefixesList.add("993934");
            bannedPrefixesList.add("33");
            bannedPrefixesList.add("9");
            bannedPrefixesList.add("20");

            List<String> creditcards = new ArrayList<>();
            creditcards.add("2552086989552589");
            creditcards.add("6724843711060148");
            creditcards.add("9758289300869651");
            creditcards.add("5048166833276726");
            creditcards.add("2864448008247645");
            creditcards.add("6803999652011971");
            creditcards.add("9758289300869650");
            creditcards.add("9083938527182086");
            creditcards.add("4563447869509114");
            creditcards.add("2552086989552588");


                System.out.println(validateInputCard(creditcards,bannedPrefixesList));

    }
}
