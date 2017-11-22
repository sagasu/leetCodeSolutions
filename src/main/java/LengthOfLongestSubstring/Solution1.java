package LengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This solution is not good enough - timeout problem.
// Last executed input: "nlpfrekwzoxwynbwjqetiuhakidtykkoxavpefngvketzfpivudgqkgasmvtygjxiemmjzuhlyakfsudoyjekrhffcydkjbsnphy"
// 973 / 983 test cases passed.
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s.toCharArray(), 0, new ArrayList<Character>());
    }

    Map<String, Integer> map = new HashMap<String, Integer>();

    private String toString(List<Character> l){
        StringBuilder sb = new StringBuilder(l.size());
        for(int i = 0; i < l.size(); i ++){
            sb.append(l.get(i));
        }
        return sb.toString();
    }

    public int lengthOfLongestSubstring(char[] ar, int index, List<Character> used) {
        String ind = index+"-"+toString(used);
        Integer m = map.get(ind);
        if(m != null)
            return m;

        if(index == ar.length){
            map.put(ind, used.size());
            return used.size();
        }

        if(used.contains(ar[index])){
            map.put(ind, used.size());
            return used.size();
        }

        used.add(ar[index]);
        int l1 = lengthOfLongestSubstring(ar, index+1, used);

        used = new ArrayList<Character>();
        int l2 = lengthOfLongestSubstring(ar, index+1, used);

        int max = Math.max(l1, l2);
        map.put(ind, max);
        return max;
    }
}
