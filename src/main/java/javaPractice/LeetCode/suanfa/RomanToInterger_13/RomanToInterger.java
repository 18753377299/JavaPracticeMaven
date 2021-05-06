package javaPractice.LeetCode.suanfa.RomanToInterger_13;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.LinkedHashMap;
import java.util.Map;

@Api(value="整数转化为罗马数字和罗马数字转整数")
public class RomanToInterger {
    private static Map<String,Integer> map = new LinkedHashMap<>();

    static {
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
    };

    private static Map<Character,Integer> mapChar = new LinkedHashMap<Character,Integer>(){{
        put('M',1000);
        put('D',500);
        put('C',100);
        put('L',50);
        put('X',10);
        put('V',5);
        put('I',1);
    }};


    public static void main(String[] args) {
        Integer  num = 12300;
       String result = calculateRoman(num);
        System.out.println("====>"+result);

        Integer sum =  romanToIntSwitch("CVI");
        System.out.println("==sum==>"+sum);
    }

   public static int getSwitchValue(Character val){
        switch (val){
            case 'M':  return 1000;
            case 'D':  return 500;
            case 'C':  return 100;
            case 'L':  return 50;
            case 'X':  return 10;
            case 'V':  return 5;
            case 'I':  return 1;
            default: return 0;
        }
   }

   @ApiOperation(value="method2")
    public static  Integer romanToIntSwitch(String romanNum){
        Integer sum = 0;
        if(null == romanNum || "" == romanNum){
            return sum;
        }
        int length = romanNum.length();
//        if(length ==1){
//            Character value = romanNum.charAt(0);
//            sum = getSwitchValue(value);
//        }
        int i=1;
        Character before = romanNum.charAt(0);
        while(i < length){
            Character current = romanNum.charAt(i);
//            if(i == length-1){
//                sum += getSwitchValue(current);
//            }
            if(getSwitchValue(before) < getSwitchValue(current)){
                sum  -= getSwitchValue(before);
            }else {
                sum  += getSwitchValue(before);
            }
            before = current;
            i++;
        }
        sum += getSwitchValue(before);
        return sum;
    }

    @ApiOperation(value="method1:罗马数字转整数",
            notes="如果左侧的值小于右侧，那么久减去该值，否则就加上一个值," +
                    "注： 将map换成switch将大大提高效率")
    public static  Integer romanToInteger(String romanNum){
        Integer sum = 0;
        if(null == romanNum || "" == romanNum){
            return sum;
        }
        int length = romanNum.toCharArray().length;
        if(length ==1){
            Character value = romanNum.charAt(0);
            if(mapChar.containsKey(value)){
                sum = mapChar.get(value);
            }
        }
        int i=1;
        Character before = romanNum.charAt(0);
        while(i < length){
            Character current = romanNum.charAt(i);
            if(i == length-1){
                sum += mapChar.get(current);
            }
            if(mapChar.get(before) < mapChar.get(current)){
                sum  -= mapChar.get(before);
            }else {
                sum  += mapChar.get(before);
            }
            before = current;
            i++;
        }
        return sum;
    }
    @ApiOperation(value="整数转化为罗马数字")
    public static  String calculateRoman(Integer num){
        StringBuilder builder = new StringBuilder("");
        if(num<=0) {
            return null;
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            Integer value = entry.getValue();
            if(num/value >0){
                for(int i=0;i<num/value;i++){
                    builder.append(entry.getKey());
                }
                num = num%value;
            }
        }
        return builder.toString();
    }



}
