package map;

import bst.BST;

/**
 * @ClassName BSTMap
 * @Author chenchen
 * @Date 2019/7/31 22:31
 * @Version 1.0
 * 基于二分搜索树的map
 **/
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;
    public BSTMap(){
        root=null;size=0;
    }
    @Override
    public void add(K key, V value) {
        root=add(root,key,value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if(root==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else{
            node.value=value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node=getNode(root,key);
        if(node!=null){
            root=remove(root,key);
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if(node==null){
            throw new IllegalArgumentException(key+"doesn't exist");
        }
        node.value=newValue;
    }

    /**
     * 返回以node为根节点的二分搜索树，key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node,K key){
        if(node==null){
            return null;
        }
        if(key.compareTo(node.key)==0){
            return node;
        }else if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else{
            return getNode(node.right,key);
        }
    }

    /**
     * 寻找二分搜索树的最小元素所在节点
     * @return
     */
    public Node minmum(Node node){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minmum(node.left);
    }

    /**
     * 从二分搜索树种删除最小元素所在节点
     * @return
     */
    public Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    /**
     * 删除以node为根的二分搜索树中的元素e节点
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node nodeRight = node.right;
                node.right = null;
                size--;
                return nodeRight;
                //待删除节点右子树为空的情况
            } else if (node.right == null) {
                Node nodeLeft = node.left;
                node.left = null;
                size--;
                return nodeLeft;
            }
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
}
