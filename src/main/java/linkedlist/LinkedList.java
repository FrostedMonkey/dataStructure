package linkedlist;

/**
 * @ClassName LinkedList
 * @Author chenchen
 * @Date 2019/7/19 23:31
 * @Version 1.0
 * 链表
 **/
public class LinkedList<E> {
    /**
     * 节点
     */
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
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

    /**
     * 虚拟头结点
     * 不存储值，只用来指向第一个节点之前的节点
     */
    private Node dummyHead;
    int size;
    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    /**
     * 获取链表中元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 在链表头添加元素e
     * @param e
     */
    public void addFirst(E e){
        /*Node node=new Node(e);
        node.next=head;
        head=node;*/
     /*   head=new Node(e,head);
        size++;*/
     add(0,e);
    }

    /**
     * 在指定索引位置处添加元素
     * 关键在于找到添加节点的前一个节点A,让A指向添加元素节点B，B指向原先A的next
     */
    public void add(int index,E e){
        /*if(index<0||index>size){
            throw new IllegalArgumentException("add failed,Illegal index");
        }
        if(index==0){
            addFirst(e);
        }else{
            Node prev=head;
            for(int i=0;i<index-1;i++){
                prev=prev.next;
            }
            *//**
             * 一下三行的顺序是固定的 prev是指向索引的前一个节点。
             *  node.next=prev.next; prev.next=node;
             *  如果颠倒顺序 prev.next=node;此时prev已经指向了要插入的元素节点 node.next=prev.next;这句话就成为把node的下一个节点设置为node本身
             *//*
            *//*Node node=new Node(e);
            node.next=prev.next;
            prev.next=node;*//*
            prev.next=new Node(e,prev.next);
            size++;
        }*/
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed,Illegal index");
        }
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        prev.next=new Node(e,prev.next);
        size++;

    }

    /**
     * 在链表末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的第index（0-based）个位置的元素
     * 在链表中不是一个常用的操作
     */
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get faild Illegal index");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }


    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改链表的第index（0-base）个位置的元素为e
     * 在链表中不常用
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get faild Illegal index");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }


    /**
     * 查找链表中是否存在元素e
     */
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while(cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        Node cur=dummyHead.next;
        while(cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("null");
        return res.toString();
    }

    /**
     * 从来表中删除index位置的元素
     * @param index
     */
    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("remove faild Illegal index");
        }
       Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;

    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        Node prev=dummyHead;
        while(prev.next!=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
        }
    }
}
