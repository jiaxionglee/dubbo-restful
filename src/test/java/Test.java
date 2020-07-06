import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import sun.nio.cs.CharsetMapping;

/**
 * @author jiaxiong
 * @date 2020/5/17 9:10 上午
 */
public class Test {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {7, 6, 4, 3, 1};
        String a = "1010";
        String b = "1011";
        System.out.println(test.maxProfit(nums));
//        System.out.println(9^4^2);

//        float sum;
//        int i;
//        sum=0;
//        for ( i = 0; i < 100; i++) {
//            sum +=0.1;
//        }
//        System.out.println(sum);
    }
}
