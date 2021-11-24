import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public int[] getProductOfArray(int[] nums) {
        int[] result = new int[nums.length];
        Map<Integer, Integer> data = new HashMap<>();
        result[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " " + result[i]);
            result[nums[i]] = result[nums[i]] * result[nums[i + 1]];
        }
        return result;
    }

    @Test
    public void test1(){
        int[] input1 = {1,2,3,4};
        int[] exp = {24,12,8,6};
        Assert.assertEquals(getProductOfArray(input1), exp);
    }

    @Test
    public void test2(){
        int[] input1 = {-1,1,0,-3,3};
        int[] exp = {0,0,9,0,0};
        Assert.assertEquals(getProductOfArray(input1), exp);
    }

    @Test
    public void testBuzz(){
       int remainder = 5 % 3;
       System.out.println(remainder);
    }
}


//
//import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.function.*;
//        import java.util.regex.*;
//        import java.util.stream.*;
//        import static java.util.stream.Collectors.joining;
//        import static java.util.stream.Collectors.toList;
//
//
//
//class Result {
//
//    /*
//     * Complete the 'fizzBuzz' function below.
//     *
//     * The function accepts INTEGER n as parameter.
//     */
//
//    public static void fizzBuzz(int n) {
//        // Write your code here
//        for (int i=1; i<=n; i++) {
//            if ((i % 5 == 0) && (i % 3 == 0)) {
//                System.out.println("FizzBuzz");
//            }
//            else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            }
//            else if (i % 5 == 0) {
//                System.out.println("Buzz");
//            }
//            else {
//                System.out.println(i);
//            }
//        }
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        Result.fizzBuzz(n);
//
//        bufferedReader.close();
//    }
//}