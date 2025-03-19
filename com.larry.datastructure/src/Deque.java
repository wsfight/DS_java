public interface Deque<E> {
    /**
     * 双端队列
     * 双端都可以插入和弹出
     * Deque: double ended
     */
    /**
     * 对头部进行插入
     * @return  插入成功返回true,插入失败返回false
     */
    boolean offerFirst(E value);
    /**
     * 对尾端进行插入
     * @return 插入成功返回true,插入失败返回false;
     */
    boolean offerLast(E value);

    /**
     * 返回头端的值,并弹出
     * @return  返回头端的值,并弹出,如果无返回则返回null
     */
    E pollFisrt();

    /**
     * 返回尾端的值,并弹出
     * @return  返回尾端的值,并弹出,如果无返回则返回null
     */
    E pollLast();

    /**
     * 返回头端的值
     * @return  返回头端的值,如果无返回则返回null
     */
    E peekFirst();

    /**
     * 返回尾端的值
     * @return  返回尾端的值,如果无返回则返回null
     */
    E peekLast();

    /**
     * 如果双端队列为空 则返回true
     * @return 如果双端队列为空,则返回true
     */
    boolean isEmpty();

    /**
     * 如果双端队列为满,则返回true
     * @return  如果双端队列为满,则返回true
     */
    boolean isFull();
}
