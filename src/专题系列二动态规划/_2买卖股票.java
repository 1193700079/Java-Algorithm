package 专题系列二动态规划;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 21:01
 **/
public class _2买卖股票 {
    /**
     * 动态 维护  最大差值
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
