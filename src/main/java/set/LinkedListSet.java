package set;

import linkedlist.LinkedList;

/**
 * @ClassName LinkedListSet
 * @Author chenchen
 * @Date 2019/7/29 23:29
 * @Version 1.0
 * 基于链表的set
 **/
public class LinkedListSet<E> implements Set<E>{
    private LinkedList<E> list;
    public LinkedListSet(){
        list=new LinkedList<>();
    }
    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
