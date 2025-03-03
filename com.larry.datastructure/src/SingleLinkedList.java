import java.util.Iterator;
import java.util.function.Consumer;

public class SingleLinkedList<T> implements Iterable<T> {
    private final Node _head;         // 头结点
    private Node _last;
    private int _size;

    public SingleLinkedList() {
        _head = new Node();
        _last = _head;
        _size = 0;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public int size() {
        return _size;
    }

    public void clear() {
        _head.next = null;
        _last = _head;
        _size = 0;
    }

    public void addFirst(T val) {
        Node p = new Node(val, _head.next);
        _head.next = p;
        if (p.next == null) {
            _last = p;
        }
        _size++;
    }

    public void addLast(T val) {
        Node p = new Node(val, null);
        if (_head.next == null) {
            _head.next = p;
        } else {
            _last.next = p;
        }
        _last = p;
        _size++;
    }

    public Node findIndex(int index) {
        if (index < -1)
            throw new IllegalArgumentException("无效索引!");
        if (index == -1) {
            return _head;
        }
        int i = 0;
        for (Node p = _head.next; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public T get(int index) {
        Node node = findIndex(index);
        if (node == null) {
            throw new IllegalArgumentException(String.format("index %d 不合法!", index));
        }
        return node.value;
    }

    public void insert(int index, T value) {
        // 1.首先找到index-1结点
        // 2.连接
        if (index < 0) {
            throw new IllegalArgumentException("索引不能小于0!");
        }
        Node p = findIndex(index - 1);
        Node ret = new Node(value, p.next);
        p.next = ret;
        // 3.更新_last;
        if (ret.next == null) {
            _last = ret;
        }
        _size++;
    }

    public T remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("索引不能小于0!");
        }
        Node prev = findIndex(index - 1);
        if (prev.next == null) {
            throw new IllegalArgumentException("索引越界!");
        }
        Node ret = prev.next;
        prev.next = prev.next.next;
        if (ret == _last) {
            _last = prev;
        }
        _size--;
        return ret.value;
    }

    public void loop(Consumer<T> consumer) {
        Node p = _head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<T> consumer) {
        Node p = _head.next;
        for (; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    private void recursion(Node cur, Consumer<T> consumer) {
        if (cur == null) {
            return;
        }
        consumer.accept(cur.value);
        recursion(cur.next, consumer);
    }

    public void loop3(Consumer<T> consumer) {
        recursion(_head.next, consumer);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class Node {
        // 与外部类有类型关系
        T value;
        Node next;

        public Node(T val) {
            value = val;
            next = null;
        }

        public Node(T val, Node n) {
            value = val;
            next = n;
        }

        public Node() {
            next = null;
        }
    }

    private class MyIterator implements Iterator<T> {
        Node p = _head.next;

        @Override
        public boolean hasNext() {  // 检查当前位置是否存在元素
            return p != null;
        }

        @Override
        public T next() {       // 返回当前元素的值,并且更新至下一个元素
            T ele = p.value;
            p = p.next;
            return ele;
        }

    }
}
