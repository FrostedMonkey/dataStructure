package bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName Main
 * @Author chenchen
 * @Date 2019/7/27 21:33
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
       /* BST<Integer> bst=new BST<>();
        int[] nums={5,3,6,8,4,2};
        for(int num:nums){
            bst.add(num);
        }*/
       /* bst.preOrder();
        System.out.println("----------------------");
       *//*
        System.out.println(bst);*//*
        bst.inOrder();
        System.out.println("----------------------");
        bst.postOrder();*/
       /* bst.levelOrder();*/
        BST<Integer> bst=new BST<>();
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> number=new ArrayList<>();
        while(!bst.isEmpty()){
            number.add(bst.removeMax());
        }
        System.out.println(number);
        for (int i = 1; i < number.size(); i++) {
            if(number.get(i-1)<number.get(i)){
                throw new IllegalArgumentException("error");
            }

        }
        System.out.println("ok");
    }


}
