import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prev = new HashMap<>();
        int[] result = new int[2];
        prev.put(nums[0], 0);
        for (int i=1; i< nums.length; i++) {
            if (prev.containsKey(target - nums[i])) {
                result[0] = prev.get(target - nums[i]);
                result[1] = i;
            }
            else {
                prev.put(nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void testTwoSum(){
        int[] input1 = {2,7,11,15};
        int[] exp = {0, 1};

        int[] result = twoSum(input1, 9);
        System.out.println("Result");
        for (int j : result) {
            System.out.println(j);
        }
        Assert.assertEquals(result, exp);
    }

    @Test
    public void testTwoSum2(){
        int[] input1 = {3,2,4};
        int[] exp = {1,2};
        int[] result = twoSum(input1, 6);
        Assert.assertEquals(result, exp);
    }

    @Test
    public void testTwoSum3(){
        int[] input1 = {3,3};
        int[] exp = {0,1};
        int[] result = twoSum(input1, 6);
        Assert.assertEquals(result, exp);
    }

}
