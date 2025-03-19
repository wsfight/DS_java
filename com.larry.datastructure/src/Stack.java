/**
 * 数据结构:栈
 * 栈只允许从一端操作,遵从后进先出.
 * @param <E>
 */
public interface Stack<E> {
    /**
     * 向栈顶压入元素
     * @param value :压入值
     * @return 压入成功返回true,否则返回flase
     */
    boolean push(E value);



    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素,栈为空则返回null
     */
    E pop();

    /**
     * 返回栈顶元素,并不弹出
     * @return 返回栈顶元素,栈为空则返回null
     */
    E peek();

    /**
     * 返回是否为空
     * @return 栈为空返回true,栈为非空则返回flase
     */
    boolean isEmpty();

    /**
     * 返回是否满
     * @return 栈为满返回true,栈为非满则返回false
     */
    boolean isFull();
}
