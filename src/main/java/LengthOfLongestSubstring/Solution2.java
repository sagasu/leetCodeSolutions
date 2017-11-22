package LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i))+1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(i-j+1, max);
        }

        return max;
    }

    Map<Character, Integer> map = new HashMap<Character, Integer>();
}
