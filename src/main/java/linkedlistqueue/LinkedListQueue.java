package linkedlistqueue;

import linkedlist.LinkedList;
import queue.Queue;

/**
 * @ClassName LinkedListQueue
 * @Author chenchen
 * @Date 2019/7/24 22:00
 * @Version 1.0
 * 使用链表实现队列
 **/
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 节点
     */
    private class Node{
        public E e;
        public LinkedListQueue.Node next;
        public Node(E e, LinkedListQueue.Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if(tail==null){
            tail=new Node(e);
            head=tail;
        }else{
            tail.next=new Node(e);
            tail=tail.next;
        }
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw  new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode=head;
        head=head.next;
        retNode.next=null;
        if(head==null){
            tail=null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }

        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue :front");
        Node cur=head;
        while(cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue=new LinkedListQueue<>();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
