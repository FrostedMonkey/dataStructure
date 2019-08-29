package stack;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author chenchen
 * @Date 2019/7/17 22:31
 * @Version 1.0
 **/
public class Solution {
    public static boolean isValid(String s){
        //定义左右括号匹配关系
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        int length = s.length();//字符串长度
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0;i<length;i++){
            //如果为左括号，入栈
            if(map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            //如果为右括号，判断栈是否为空
            if(map.containsKey(s.charAt(i))){
                if(stack.isEmpty()){
                    return false;
                }
                else if (stack.peek() == map.get(s.charAt(i))){
                    stack.pop();
                }
                else return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        String s="(1111){}[]";
        System.out.println(isValid(s));
    }
}
