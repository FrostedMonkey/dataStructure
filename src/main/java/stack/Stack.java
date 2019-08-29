package stack;

/**
 * 数组栈
 * @param <E>
 */
public interface Stack<E> {

    /**
     * 获取栈的大小
     * @return
     */
   int getSize();

    /**
     * 判断栈是否为空
     * @return
     * 时间复杂度O(1)
     */
   boolean isEmpty();

    /**
     * 入栈
     * @param e
     * 时间复杂度O(1) 均摊
     */
   void push(E e);

    /**
     * 出栈
     * @return
     * 时间复杂度O(1) 均摊
     */
   E pop();

    /**
     * 栈顶元素
     * @return
     * 时间复杂度O(1)
     */
   E peek();


}
