package linkedlist;

/**
 * @ClassName Main
 * @Author chenchen
 * @Date 2019/7/24 20:42
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
       /* LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);*/
        int [] arr={1,2,3,4,5};
        System.out.println(sum(arr));
    }


    public static int sum(int []arr){
        return sum(arr,0);
    }
    public static int sum(int [] arr,int l){
        if(l==arr.length){
            return 0;
        }else{
            return arr[l]+sum(arr,l+1);
        }
    }



}
