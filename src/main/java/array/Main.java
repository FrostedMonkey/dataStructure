package array;

import stack.ArrayStack;

/**
 * @ClassName Main
 * @Author chenchen
 * @Date 2019/7/16 22:05
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
       /* Array<Integer> arr=new Array<Integer>(10);
        for(int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.insert(100,1);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);*/

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
