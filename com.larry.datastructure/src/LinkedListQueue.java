import java.util.Iterator;

public class LinkedListQueue<E> implements Iterable<E> {
    /**
     * 队列:
     * 先进先出
     * 添加那端为尾部,删除那端为头部
     * */

    /**
     * 几个属性
     */
    private Node<E> _head = new Node<>(null, null);
    private Node<E> _tail = _head;
    private int _size;  // 结点数
    private int _capacity = Integer.MAX_VALUE;


    /**
     * 简单的构造函数
     */
    public LinkedListQueue() {
        _tail._next = _head;
        _size = 0;
    }

    /**
     * @param capacity:指定容量大小,不指定则默认为最大值
     */
    public LinkedListQueue(int capacity){
        _tail._next = _head;
        _size = 0;
        _capacity = capacity;
    }

    /**
     *
     * @param value:需要插入的值
     * @return 插入失败返回false,插入成功返回true
     */
    boolean offer(E value) {
        if(isFull()){
            // 满了则插入失败
            return false;
        }
        Node p = new Node<>(value, _tail._next);
        _tail._next = p;
        _tail = p;
        ++_size;
        return true;
    }

    /**
     * 从队头获取值,并移除
     * @return:如果队列为空则返回null,否则返回队头值,并且移除队头
     */
    E poll() {
        if (isEmpty()) {
            return null;
        }
        // 接下来非空
        Node p = _head._next;
        if (p._next == _head) {
            // 只有一个结点
            _tail = _head;
        }
        _head._next = p._next;
        --_size;

        return (E) p._value;
    }

    /**
     * 从队头获取值,不移除
     * @return:如果队列为空,返回null,非空则返回队头值
     */
    E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) _head._next._value;
    }

    /**
     * 判断队列是否为空
     * @return 如果为空返回true,非空则false
     */
    boolean isEmpty() {
        return _head == _tail;
    }

    /**
     * 检查队列是否已满
     * @return 满返回true,否则返回false
     */
    boolean isFull(){
        return _size == _capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = _head._next;

            @Override
            public boolean hasNext() {
                // 当前结点是否有值
                return p != _head;
            }

            @Override
            public E next() {
                E value = p._value;
                p = p._next;
                return value;
            }
        };
    }

    private static class Node<E> {
        /**
         * @param _value:是结点存储的值,_next是下一个结点
         */
        E _value;
        Node<E> _next;

        /**
         * Node的三个构造函数
         */
        Node() {
            _value = null;
            _next = null;
        }

        Node(E value) {
            _value = value;
            _next = null;
        }

        Node(E value, Node next) {
            _value = value;
            _next = next;
        }
    }

}

