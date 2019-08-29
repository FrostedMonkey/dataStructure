package stack;

import array.Array;

/**
 * @ClassName ArrayStack
 * @Author chenchen
 * @Date 2019/7/17 21:44
 * @Version 1.0
 **/
public class  ArrayStack<E> implements Stack<E> {

    Array<E> array;
    public ArrayStack(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
