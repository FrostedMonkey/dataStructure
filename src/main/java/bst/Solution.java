package bst;

import java.util.TreeSet;

/**
 * @ClassName Solution
 * @Author chenchen
 * @Date 2019/7/31 21:20
 * @Version 1.0
 **/
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set=new TreeSet();
        for (String word:words) {
            StringBuilder res=new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i)-'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }


}
