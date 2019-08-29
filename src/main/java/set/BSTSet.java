package set;

import bst.BST;

/**
 * @ClassName BSTSet
 * @Author chenchen
 * @Date 2019/7/29 23:21
 * @Version 1.0
 * 基于二叉树的集合
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E>{
    private BST<E> bst;
    public BSTSet(){
        bst=new BST<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
