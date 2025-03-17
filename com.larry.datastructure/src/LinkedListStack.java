import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable {
    private Node<E> _head = new Node<>();  // 哨兵结点
    // 无需尾指针,栈只需要在一端操作即可
    private int _capacity = 10;
    private int _size = 0;

    LinkedListStack() {}

    LinkedListStack(int capacity) {
        _capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        // 应该运用头插法
        if (isFull()) {
            return false;
        }
        Node<E> p = new Node<>(value, _head.next);
        _head.next = p;
        _size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E ans = (E) _head.next.value;
        _head.next = _head.next.next;
        --_size;
        return ans;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) _head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public boolean isFull() {
        return _size == _capacity;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node p = _head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E ans = (E) p.value;
                p = p.next;
                return ans;
            }
        };
    }

    class Node<E> {
        E value;
        Node next;

        Node() {
            value = null;
            next = null;
        }

        Node(E val, Node p) {
            value = val;
            next = p;
        }

    }
}
