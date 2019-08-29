package queue;

/**
 * 数组队列
 * @param <E>
 */
public interface Queue<E> {
    /**
     * 获取元素个数
     * @return
     * 时间复杂度 O(1)
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     * 时间复杂度 O(1)
     */
    boolean isEmpty();

    /**
     * 进入队列
     * @param e
     * 时间复杂度 O(1) 均摊
     */
    void enqueue(E e);

    /**
     * 出队列
     * @return
     * 时间复杂度 O(n)
     */
    E dequeue();

    /**
     * 获得队首元素
     * @return
     * 时间复杂度 O(1)
     */
    E getFront();

}
