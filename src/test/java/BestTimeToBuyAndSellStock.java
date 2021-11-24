import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 52 MB, less than 77.28% of Java online submissions for Best Time to Buy and Sell Stock.
     */
    public int findBestTimeToBuyAndSellStock(int[] prices) {
        int result = 0;
        int minPrice = prices[0];
        for (int i=1; i<prices.length;i++) {
            int diff = prices[i] - minPrice;
            if (diff > result) {
                result = diff;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return result;
    }

    @Test
    public void test1(){
        int[] input1 = {7,1,5,3,6,4};
        int exp = 5;

        int result = findBestTimeToBuyAndSellStock(input1);
        Assert.assertEquals(result, exp);
    }

    @Test
    public void test2(){
        int[] input1 = {7,6,4,3,1};
        int exp = 0;

        int result = findBestTimeToBuyAndSellStock(input1);
        Assert.assertEquals(result, exp);
    }

}
