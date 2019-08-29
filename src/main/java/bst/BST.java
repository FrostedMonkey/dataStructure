package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BST
 * @Author chenchen
 * @Date 2019/7/26 20:14
 * @Version 1.0
 * 二分搜索树
 * 左子树都小于根节点
 * 右子树都大于根节点
 * 本代码不包括相等的情况
 * 如果要包含重复元素，可以让左子数小于等于或右子树大于等于
 **/
public class BST<E extends Comparable<E>> {
    private class Node{
        public Node left;
        public Node right;
        public E e;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 向二分搜索树添加元素
     * @param e
     */
    public void add(E e){
         root=add(root,e);
    }

    /**
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     */
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }

    /**
     * 看二分搜索树是不是包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 查看以node为根的二分搜索树是否包含元素e
     * @param node
     * @param e
     * @return
     */
    private  boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    /**
     * 前序遍历(根左右)
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 非递归前序遍历
     */
    public void preOrderNR(){
        Stack stack=new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=(Node)stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }

        }
    }

    /**
     * 前序遍历以node为根的二分搜索树
     * @param node
     */
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树
     * @param node 节点
     */
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }


    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param root
     * @param
     * @param res
     */
    private void generateBSTString(Node root, int depth,StringBuilder res) {
        if(root==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+root.e+"\n");
        generateBSTString(root.left,depth+1,res);
        generateBSTString(root.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    /**
     * 层序遍历（广度优先遍历）
     * 使用队列思想
     */
    public void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur= queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }

        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minmum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minmum(root).e;
    }

    /**
     * 寻找以node为根的二分搜索树的最小值所在节点
     * @param node
     * @return
     */
    private Node minmum(Node node){
        if(node.left==null){
            return node;
        }
        return minmum(node.left);
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E maxmum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxmum(root).e;
    }

    /**
     * 寻找以node为根的二分搜索树的最小值所在节点
     * @param node
     * @return
     */
    private Node maxmum(Node node){
        if(node.right==null){
            return node;
        }
        return maxmum(node.right);
    }

    /**
     * 从二分搜索树种删除最小元素所在节点
     * @return
     */
    public E removeMin(){
        E ret=minmum();
        root=removeMin(root);
        return ret;
    }

    /**
     * 删除已node为根的二分搜索树中最小的节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
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
     * 从二分搜索树种删除最大元素所在节点
     * @return
     */
    public E removeMax(){
        E ret=maxmum();
        root=removeMax(root);
        return ret;
    }

    /**
     * 删除已node为根的二分搜索树中最大的节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if(node.right==null){
            Node rightNode=node.left;
            node.left=null;
            size--;
            return rightNode;
        }
        node.right=removeMin(node.right);
        return node;

    }

    /**
     * 删除节点
     * 删除左右都有孩子的节点  找到s=min（d->right）
     * s是d的后继
     * 也就是找到该节点的右子树中的最小元素
     * 然后让s.left=d.left s.right=d.right
     *
     */

    /**
     * 从二分搜索树中删除元素e
     * @param e
     */
    public void remove(E e){
        root=remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中的元素e节点
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else{
            //待删除节点左子树为空的情况
            if(node.left==null){
                Node nodeRight=node.right;
                node.right=null;
                size--;
                return nodeRight;
                //待删除节点右子树为空的情况
            }else if(node.right==null){
                Node nodeLeft=node.left;
                node.left=null;
                size--;
                return nodeLeft;
            }
            /**
             *  待删除节点左右子树都不为空
             *  找到必待删除节点大的最小节点，即删除节点右子树的最小节点
             *  用这个节点顶替待删除元素
             *  size--不需要了因为removeMin中size--过了
             */
            Node successor=minmum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }

    /**
     * 关于二分搜索树
     * 寻找一个元素的floor和ceil
     *
     *
     * 二分搜索树的rank 给出一个元素 求其在二分搜索树中的排名
     */
}
