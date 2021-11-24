import org.testng.Assert;
import org.testng.annotations.Test;

//Given a string s, find the length of the longest substring without repeating characters.
//Runtime: 8 ms, faster than 41.44% of Java online submissions for Longest Substring Without Repeating Characters.
//Memory Usage: 39.4 MB, less than 49.79% of Java online submissions for Longest Substring Without Repeating Characters.
public class LongestSubstringWithoutRepeating {

    private int findLongestSubstring(String str1) {
        int maxLength = -1;
        StringBuilder buffer = new StringBuilder();

        if (str1.length() == 0) {
            return 0;
        } else if (str1.length() == 1) {
            return 1;
        }

        for (char curChar: str1.toCharArray()) {
            String curString = String.valueOf(curChar);
            if (buffer.toString().contains(curString)) {
                //shrinking buffer to the new length
                buffer = new StringBuilder(buffer.substring(buffer.indexOf(curString) + 1));
            } else {
                buffer.append(curChar);
                int bufferLength = buffer.length();
                if (bufferLength > maxLength) {
                    maxLength = bufferLength;
                }
            }
        }

        return maxLength;
    }


    @Test
    public void test1() {
        String str1 = "abcabcbb";
        Assert.assertEquals(findLongestSubstring(str1), 3);
    }

    @Test
    public void test2() {
        String str1 = "bbbbb";
        Assert.assertEquals(findLongestSubstring(str1), 1);
    }

    @Test
    public void test3() {
        String str1 = "pwwkew";
        Assert.assertEquals(findLongestSubstring(str1), 3);
    }

    @Test
    public void test4() {
        String str1 = "";
        Assert.assertEquals(findLongestSubstring(str1), 0);
    }
}
