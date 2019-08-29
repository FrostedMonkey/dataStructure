package MaxHeep;

/**
 * @ClassName MaxHeap
 * @Author chenchen
 * @Date 2019/8/6 21:23
 * @Version 1.0
 * 堆
 **/
public class MaxHeap<E extends Comparable> {
    private Array<E> data;
    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }
    public MaxHeap(){
        data=new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树组中，一个索引所表示的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("index 0doesn't have parent");
        }
        return (index-1)/2;
    }

    /**
     * 返回完全二叉树组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */

    /**
     * 返回完全二叉树组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index*2+1;
    }

    private int rightChild(int index){
        return index*2+2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    /**
     * 元素上浮（堆中某个节点的值总是不大于其父亲节点的值）
     * @param i
     */
    private void siftUp(int i) {
        while(i>0&&data.get(parent(i)).compareTo(data.get(i))<0){
            data.swap(i,parent(i));
            i=parent(i);
        }
    }

    /**
     * 看堆中的最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     * @return
     */
    public E extractMax(){
        E ret=findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉
     * @param i
     */
    private void siftDown(int i) {
        //当i已经是叶子结点时循环结束  如果i为叶子结点则i的左孩子的索引肯定大于data.size
        while(leftChild(i)<data.getSize()){
            int j=leftChild(i);
            if(j+1<data.getSize() &&data.get(j+1).compareTo(data.get(j))>0){
                j=rightChild(i);
            }
            //此时data[j]是leftChild和rightChild中的最大值
            if(data.get(i).compareTo(data.get(j))>0){
                break;
            }
            data.swap(i,j);
            i=j;
        }
    }
}
