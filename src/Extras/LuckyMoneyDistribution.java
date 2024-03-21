package Extras;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 类似微信红包的方式进行金额分配
 */
public class LuckyMoneyDistribution {

    public static List<BigDecimal> distribution(String totalAmtInYUAN, int peopleNum) {

        Random random = new Random();
        List<BigDecimal> resultList = new LinkedList<>();
        BigDecimal remainAmtInFen = new BigDecimal(totalAmtInYUAN).multiply(new BigDecimal("100"));

        int remainPeopleNum = peopleNum;

        // 只分配n-1个人, 最后一人拿走剩余
        for (int i = 0; i < peopleNum - 1; i++) {

            // 需要为剩余的n人, 保留n分钱
            BigDecimal curPeopleMax = remainAmtInFen.subtract(new BigDecimal(remainPeopleNum - 1));

            // 进行随机分配, 保底1分钱
            int randAmtInFen = 1 + random.nextInt(curPeopleMax.intValue());

            // 更新并保存, 存储的金额单位元
            BigDecimal curRandAmtInFen = new BigDecimal(randAmtInFen);
            resultList.add(curRandAmtInFen.divide(new BigDecimal("100")));
            remainAmtInFen = remainAmtInFen.subtract(curRandAmtInFen);
            remainPeopleNum--;
        }

        // 最后1人拿走全部
        resultList.add(remainAmtInFen.divide(new BigDecimal("100")));
        return resultList;
    }

    public static void main(String[] args) {
        List<BigDecimal> distribution = distribution("100", 5);
        for (BigDecimal amtInYuan : distribution) {
            System.out.println(amtInYuan);
        }
    }

}
