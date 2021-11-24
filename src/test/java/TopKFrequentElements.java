import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

//Given an integer array nums and an integer k,
// return the k most frequent elements. You may return the answer in any order.
public class TopKFrequentElements {

    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        Assert.assertEquals(findTopFreqWithList(nums, k), expected);
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        Assert.assertEquals(findTopFreqWithList(nums, k), expected);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        Assert.assertEquals(findTopFreqWithHeap(nums, k), expected);
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        Assert.assertEquals(findTopFreqWithTreeMap(nums, k), expected);
    }

    private int[] findTopFreqWithTreeMap(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] result = new int[k];
        Map<Integer,Integer> freqMap = getFreqMap(nums);
        TreeMap<Integer,Integer> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            //swapping key and value, tree map is sorted by key
            treeMap.put(entry.getValue(), entry.getKey());
        }
        for (int i = 0; i < k; i++) {
            result[i] = treeMap.pollFirstEntry().getValue();
        }
        return result;
    }


    //    Runtime: 9 ms, faster than 86.78% of Java online submissions for Top K Frequent Elements.
//    Memory Usage: 41.5 MB, less than 78.09% of Java online submissions for Top K Frequent Elements.
    private int[] findTopFreqWithHeap(int[] nums, int top) {
        if (nums.length == 1) {
            return nums;
        }
        int[] result = new int[top];
        Map<Integer, Integer> freq = getFreqMap(nums);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue());
        maxHeap.addAll(freq.entrySet());
        for (int i = 0; i < top; i++) {
            result[i] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }
        return result;
    }

    private int[] findTopFreqWithList(int[] nums, int top) {
        if (nums.length == 1) {
            return nums;
        }
        int[] result = new int[top];
        Map<Integer, Integer> freq = getFreqMap(nums);
        List<Map.Entry<Integer, Integer>> order = new ArrayList<>(freq.entrySet());
        System.out.println(freq);
        order.sort((o1, o2) -> {
            //sort in reverse
            return o2.getValue() - o1.getValue();
        });
        System.out.println(order);

        for (int i = 0; i < top; i++) {
            result[i] = order.get(i).getKey();
        }
        return result;
    }

    private Map<Integer, Integer> getFreqMap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq;
    }


}
