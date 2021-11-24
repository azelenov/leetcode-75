import org.testng.Assert;
import org.testng.annotations.Test;

//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//Constraints: 1 <= n <= 45
public class ClimbingStairs {

    @Test
    public void test1() {
        int n = 2;
        int exp = 2;
        //Explanation: There are two ways to climb to the top.
        //1. 1 step + 1 step
        //2. 2 steps
        Assert.assertEquals(climbStairs(n), exp);
    }

    @Test
    public void test2() {
        int n = 3;
        int exp = 3;
//        Explanation: There are three ways to climb to the top.
//        1. 1 step + 1 step + 1 step
//        2. 1 step + 2 steps
//        3. 2 steps + 1 step
        Assert.assertEquals(climbStairs(n), exp);
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    //Memory Usage: 37.8 MB, less than 15.52% of Java online submissions for Climbing Stairs.
    private int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for (int i=0; i<n -1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}
