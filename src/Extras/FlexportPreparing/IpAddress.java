package Extras.FlexportPreparing;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddress {

    /**
     * 题目1. 判断ip是否合法
     */
    public boolean checkIpValidity(String inputIp) {

        // 但是这个做法可能: 012.234.001.02也认为合法

        // 1. contain 3 '.' points, that can be split into 4 parts
        String[] split = inputIp.split("\\.");
        if (split.length < 4) {
            // only xx.xx.xx.xx could be valid
            return false;
        }

        // 2. for each 'slot', it must within 255, also the first slot cannot be 0
        try {
            Integer sum = 0;
            for (String s : split) {
                Integer sinSlotNum = Integer.valueOf(s);
                if (sinSlotNum > 255) {
                    // greater than 255, is not a valid ipv4 address
                    return false;
                }
                // plus each slot's number
                sum += sinSlotNum;
            }

            // 3. special condition for 0.0.0.0
            if (sum.equals(0)) {
                return false;
            }
        } catch (NumberFormatException e) {
            // when parsing ip format throw exception, it must be invalid
            return false;
        }

        // pass all conditions
        return true;
    }

    //    private static final String IP_EXPRESSION = "([2][0-5]\\d|[1]\\d{2}|\\d)(\\.([2][0-5]\\d|[1]\\d{2}|\\d)){3}";
    String zeroTo255 = "(\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])";
    String IP_EXPRESSION = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

    private static final String LOCAL_IP = "0.0.0.0";

    public boolean checkIpValidityByRegularExpression(String inputIp) {
        Pattern ipPattern = Pattern.compile(IP_EXPRESSION);
        Matcher matcher = ipPattern.matcher(inputIp);
        if (matcher.matches()) {
            if (!LOCAL_IP.equals(inputIp)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        IpAddress test = new IpAddress();

        // for question 1
        List<String> testList = new LinkedList<>();
        // valid
        testList.add("123.1.2.40");
        testList.add("255.1.2.40");
        testList.add("255.255.255.255");
        // invalid
        testList.add("123.256.2.40");
        testList.add("023.35.001.40");
        testList.add("123.1.240");
        testList.add("0.0.0.0");
        testList.add("1");

        for (String s : testList) {
//            System.out.println("Ip: " + s + ", is " + test.checkIpValidity(s));
            System.out.println("Ip: " + s + ", is " + test.checkIpValidityByRegularExpression(s));
        }


        // for question 2
    }


    /**
     * 题目2. 找出该字符串合法的ip形式
     */
//    public List<String> allValidIpFormat(String )
}
