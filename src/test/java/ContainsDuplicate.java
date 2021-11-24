import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
 and return false if every element is distinct.
 */
public class ContainsDuplicate {

    /*
    Runtime: 5 ms, faster than 79.33% of Java online submissions for Contains Duplicate.
    Memory Usage: 46.6 MB, less than 39.71% of Java online submissions for Contains Duplicate.
     */
    public boolean checkIfContainsDuplicate(int[] nums) {
        Set<Integer> dedup = new HashSet<>();
        for (int num : nums) {
            dedup.add(num);
        }

        return dedup.size() != nums.length;
    }

    @Test
    public void test1(){
        int[] input1 = {1,2,3,4};
        Assert.assertFalse(checkIfContainsDuplicate(input1));
    }

    @Test
    public void test2(){
        int[] input1 = {1,1,1,3,3,4,3,2,4,2};
        Assert.assertTrue(checkIfContainsDuplicate(input1));
    }


}
