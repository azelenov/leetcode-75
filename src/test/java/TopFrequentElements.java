//# Top K Frequqent Elements
//       Intput = [1,2,1,1,2,4] K = 2
//       Output = [1,2]
//Tiktok

import org.testng.annotations.Test;

import java.util.*;

public class TopFrequentElements {


    public void returnTopElements(List<Integer> list , int topK) {
        //1, 2
        //1:4, 2:2, 4:1
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer integer : list) {
            if (freq.containsKey(integer)) {
                freq.put(freq.get(integer) + 1, integer);
            } else {
                freq.put(1, integer);
            }
        }
        System.out.println(freq);

        List<Integer> top = new ArrayList<>(freq.keySet());
        Collections.sort(top);

        for (int i = 0; i < topK; i++) {
            System.out.println(top.get(i) + ":" + freq.get(top.get(i)));
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer integer : nums) {
            if (freq.containsKey(integer)) {
                freq.put(freq.get(integer) + 1, integer);
            } else {
                freq.put(1, integer);
            }
        }
        System.out.println(freq);
        List<Integer> top = new ArrayList<>(freq.keySet());
        top.sort(Collections.reverseOrder());
        int[] result = new int[2];
        result[0] = freq.get(top.get(0));
        result[1] = freq.get(top.get(1));
        return result;
    }

//    public int[] topKFrequent(final int[] nums, final int k) {
//        //counting statistic number:count to shrink initial array from duplicates
//        final Map<Integer, Integer> map = new HashMap<>();
//        for (final int el : nums) {
//            int count = map.getOrDefault(el, 0);
//            map.put(el, count + 1);
//        }
//        //organize pq with sorting in reverse order by value and adding all entries
//        final PriorityQueue<Map.Entry<Integer, Integer>> queue =
//                new PriorityQueue<>(Map.Entry.<Integer, Integer>comparingByValue().reversed());
//        queue.addAll(map.entrySet());
//        final int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            //polling k elements from the top. They are in reverse order due to pq reverse sorting state
//            final Map.Entry<Integer, Integer> entry = queue.remove();
//            result[i] = entry.getKey();
//        }
//        return result;
//    }


    @Test
    public void test1() {
        int[] list = {0,1,1,1,2,2,4};
        int[] ints = topKFrequent(list, 2);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
