import java.util.Iterator;

public class LinkedListQueue<E> implements Iterable<E> {
    /**
     * 队列:
     * 先进先出
     * 添加那端为尾部,删除那端为头部
     * */

    /**
     * 这个链表是单向循环链表
     * attri:_head头结点,dummy结点; _tail尾结点
     */
    private Node<E> _head = new Node<>(null, null);
    private Node<E> _tail = _head;


    /**
     * 构造函数:
     * 连接了头和尾
     */
    public LinkedListQueue() {
        _tail._next = _head;
    }

    /**
     * 向队尾插入值
     * params:插入值
     * returns:插入返回true,失败返回false
     */
    boolean offer(E value) {
        // 什么情况下插入失败?
        Node p = new Node<>(value, _tail._next);
        _tail._next = p;
        _tail = p;
        return true;
    }

    /**
     * 从队头获取值,并移除
     * returns:如果队列为空则返回队头值,否则返回null
     */
    E poll() {
        Node p = _head._next;
        if (p == _head) {
            return null;
        } else if (p._next == _head) {
            // 那么tail呢?
            _tail = _head;
        }
        _head._next = p._next;
        return (E) p._value;
    }

    /**
     * 从队头获取值,不移除
     * returns:如果队列为空,返回null,非空则返回队头值
     */
    E peek() {
        return (E) _head._next._value;
    }

    /**
     * 判断队列是否为空
     * returns:如果为空返回true,非空则false
     */
    boolean isEmpty() {
        if (_head._next == _head) {
            return true;
        } else {
            return false;
        }
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
         * params: _value是结点存储的值,_next是下一个结点
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

