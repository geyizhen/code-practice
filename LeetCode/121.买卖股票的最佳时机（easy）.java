/*
** Data     ：2018-12-26 11:05:43
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Say you have an array for which the i th element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/
//记录当前最小值soFarMin，计算往后每个值与最小值的差的最大值max
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || prices == null)
            return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < len; i ++){
            soFarMin = Math.min(soFarMin, prices[i]);//java.lang.Math 包自动引入 不需要操作
            max = Math.max(max, prices[i] - soFarMin);
        }
        return max;
    }
}