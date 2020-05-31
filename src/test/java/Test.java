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

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        String str = "(]";
        System.out.println(removeElement(nums, 3));
    }
}
