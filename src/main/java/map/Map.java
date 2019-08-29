package map;

/**
 * map
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {
    /**
     * 添加
     * @param key
     * @param value
     */
    void add(K key,V value);

    /**
     * 删除
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 判断是否包含
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 获取值
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 获取大小
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    void set(K key,V newValue);

}
