package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wei tan
 */
public class _3 {
    public int lengthOfLongestSubstring(String s) {

        //store the result
        int result = 0;

        //Store all characters
        Set<Character> set = new HashSet<>();

        //store the first index of the current subString;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            //when adding fails, means it has contained this element.
            while (!set.add(s.charAt(i))) {
                //remove from the left side until, adding successfully.
                //it means the last one char is the same as the first one char in the sub string.
                //So remove the left one and move the left index to the next;
                set.remove(s.charAt(left));
                left++;
            }

            //when jump the loop, record the result
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
