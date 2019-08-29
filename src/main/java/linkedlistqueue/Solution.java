package linkedlistqueue;

/**
 * @ClassName Solution
 * @Author chenchen
 * @Date 2019/7/24 23:12
 * @Version 1.0
 **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*public ListNode removeElements(ListNode head, int val){
        if(head==null){
            return null;
        }
        head.next=removeElements(head.next,val);
        return head.val==val?head.next:head;
    }*/
    /**
     * 调试
     */
    public ListNode removeElements(ListNode head, int val,int depth) {
     /*  */


        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if(head.val == val)
            ret = res;
        else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums={1,3,3,6};
        ListNode head=new ListNode(nums);
        System.out.println(head);
        ListNode res=(new Solution()).removeElements(head,3,0);
        System.out.println(head);
    }
}