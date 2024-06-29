package Ex1801_2100.Ex2073_TimeNeededBuyTickets;

public class Solution {

    /**
     * 类似Ex1700, 该算法的核心是直接对数组进行遍历而不是进行操作的模拟 (但是Array的order是需要保留的)
     * - 对于排在target之前的人, 需要买的票就是 min(自己要买的, target要买的), 因为如果自己买的少那么后面就跳出队伍了
     * - 对于排在target之后的人, 需要买的票就是 min(自己要买的, target要买的 - 1), 这里的-1是因为, target买好自己票之后不再管后面的人了, 所以他们额外买(即使同一轮次), target也不等了
     */
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int times = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                times += Math.min(tickets[i], tickets[k]);
            } else {
                times += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 2, 3}, 0));
    }
}
