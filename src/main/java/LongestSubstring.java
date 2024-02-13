//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }


    // abcabccdefghcdefgh
    // abca, bcab, cabc, abcc, cdefghc, defghcd, efghcde,

    //pwwkew
    //pww, kew
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)   return 0;
        if(s.length() == 1) return 1;
        int rs = 0;
        Set<String> setStr = new HashSet<>();
        String[] arrStr = s.split("");
        int counter = 0;
        for (int i = 0; i < arrStr.length; i++) {
            counter += 1;
            setStr.add(arrStr[i]);
            if(setStr.size() < counter){
                if(counter-1>rs)    rs = counter - 1;
                counter = 0;
                if(i>0) i = i-setStr.size();
                setStr = new HashSet<>();
            }
        }
        if (counter>rs) rs = counter;
        return rs;
    }
}
