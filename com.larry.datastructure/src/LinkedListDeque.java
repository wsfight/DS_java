import java.util.Iterator;

/**
 * 使用双向链表进行双端队列操作
 * @param <E> 泛型
 */
public class LinkedListDeque<E> implements Deque<E>,Iterable{
    // 1.头结点,尾结点
    Node _head;
    Node _tail;
    // 2.容量
    int _capacity = 10;
    int _size = 0;

    LinkedListDeque(){
        _head = new Node<>(null,null,null);
        _tail = _head;
    }
    LinkedListDeque(int capacity){
        _head = new Node<>(null,null,null);
        _tail = _head;
        _capacity = capacity;
    }
    @Override
    public boolean offerFirst(E value) {
        // 对头端进行添加
        if(isFull()){
            return false;
        }
        // 如果插入的是第一个结点呢?

        Node p = new Node<>(value,_head,_head._next);
        if(_head._next == null){
            _tail = p;
        }
        _head._next = p;
        ++_size;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if(isFull()){
            return false;
        }
        Node p = new Node<>(value,_tail,_tail._next);
        _tail._next = p;
        _tail = p;
        ++_size;
        return true;
    }

    @Override
    public E pollFisrt() {
        if(isEmpty()){
            return null;
        }
        // 如果只有一个元素呢?
        E temp = (E) _head._next._val;
        if(_head._next._next == null){
            _tail = _head;
        }
        _head._next = _head._next._next;
        --_size;
        return temp;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        E temp = (E) _tail._val;
        _tail = _tail._prev;
        _tail._next = null;
        --_size;
        return temp;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return (E) _head._next._val;
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return (E) _tail._val;
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
            Node p = _head._next;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E temp = (E) p._val;
                p = p._next;
                return temp;
            }
        };
    }

    public class Node<E>{
        // 双向结点
        Node _prev;
        E _val;
        Node _next;
        Node(E value,Node prev,Node next){
            _val = value;
            _prev = prev;
            _next = next;
        }
    }
}
