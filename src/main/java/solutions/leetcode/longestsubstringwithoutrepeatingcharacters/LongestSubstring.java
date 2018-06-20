package solutions.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int lastCopy = -1;
        int maxLen = 0;
        Map<Character, Integer> chars = new HashMap<Character, Integer>();

        for(int i=0; i<size; i++) {
            Character c = s.charAt(i);
            if (chars.containsKey(c))
                lastCopy = Math.max(chars.get(c), lastCopy);
            chars.put(c, i);
            maxLen = Math.max(maxLen, i - lastCopy);
        }
        
        return maxLen;
    }
}