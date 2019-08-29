package array;

/**
 * 实现动态数组
 * @ClassName Array
 * @Author chenchen
 * @Date 2019/7/14 19:56
 * @Version 1.0
 **/
public class Array<E>{
    private E[] data;
    private int size;

    /**
     *传输数组的容量capacity构造Array
     * @param capacity 容量
     */
    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }

    /**
     * 默认capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }




    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size= %d ,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }

        }
        res.append(']');
        return res.toString();
    }
    /**
     * 向所有元素后添加一个新的元素
     * 时间复杂度O(1)
     */
    public void addLast(E e){
        insert(e,size);
    }

    /**
     * 向所有元素前添加一个新的元素
     * @param e
     * 时间复杂度O(n)
     */
    public void addFirst(E e){
        insert(e,0);
    }
    /**
     * 向指定位置插入元素
     * @param num 插入数据
     * @param index 插入位置
     * 如果当index=0时间复杂度O(n) 当index=size时间复杂度为O(1)取平均期望 基本上每次要向后移动1/2n元素所以时间复杂度为O(n/2)=O(n)
     */
    public void insert(E num,int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("insert faild.Require index>0 and index<size");
        }
        if(size==data.length){
            resize(2*data.length);
        }

        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=num;
        size++;
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param num
     * 时间复杂度O(1)
     */
    public void set(int index,E num){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        data[index]=num;
    }

    /**
     * 判断数组中是否包含
     * @param num
     * @return
     * 时间复杂度O(n)
     */
    public boolean contains(E num){
        for(int i=0;i<size;i++){
            if (data[i].equals(num)){
                return true;
            }
        }
        return false;
    }

    /**
     * 在数组中查找元素有则返回无则返回-1
     * @param num
     * @return
     * 时间复杂度O(n)
     */
    public int find(E num){
        for(int i=0;i<size;i++){
            if(data[i].equals(num)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除元素,并且返回删除元素
     * @param index
     * 时间复杂度O(n)
     */
    public E delete(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Remove failed,Index is illegal");
        }
        E ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return ret;

    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get (int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
         return get(0);
    }

    /**
     * 删除第一个元素 并返回
     * @return
     * 时间复杂度O(n)
     */
    public E removeFirst(){
        return delete(0);
    }

    /**
     * 删除最后一个元素 并返回
     * @return
     * 时间复杂度O(1)
     */
    public E removeLast(){
        return delete(size-1);
    }

    /**
     * 从数组中删除num
     * @param num
     */
    public void deleteElement(E num){
        int index=find(num);
        if(index!=-1){
            delete(index);
        }
    }

    /**
     *
     * 数组扩容
     * @param newCapaticy
     * 时间复杂度O(n)
     */
    private void resize(int newCapaticy) {
        E[] newData=(E[])new Object[newCapaticy];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
    /**
     * 均摊复杂度
     * 添加操作O(1) 最坏情况下会触发resize
     * 假设capacity=8并且每一次添加操作都是用addLast 9次addLast操作触发resize 总共进行了17次基本操作 9次add操作 8次复制操作
     * 假设capacity=n n+1次addLast触发resize 总共进行2n+1次基本操作平均每次addLast操作进行2次基本操作
     * 删除操作均摊复杂度也为O(1)
     *
     * 复杂度震荡
     * 假设capacity=n addLast O(n) removeLast O(n)
     * 出现问题的原因removeLast时resize过于着急
     * 解决方案Lazy
     * 缩容时等待，如果还有删除，当长度到达一定阈值（假设size==capacity/4）才将capacity减半
     */
}
