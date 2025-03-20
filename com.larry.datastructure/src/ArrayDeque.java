import java.util.Iterator;

/**
 * 基于循环数组的特点来实现
 * - _tail:用来保存最后一个元素的下一个位置
 * - _head:用来保存头部元素
 * - 会牺牲一个元素空间来判断数组已满
 *
 * @param <E>
 */
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

    /**
     * h - _head 永远指向队头位置
     * t - _tail 永远指向队尾的下一个位置
     * capacity == 4
     * t
     * h
     * 5  4      2   3
     * [0  1  2  3  4]
     * <p>
     * offerLast(5)
     * offerLast(4)
     * offerFirst(3)   一旦h-1<0; h = array.length() - 1
     * offerFirst(2)   t == 2 ,h == 3  (t + 1)%5 == h
     */
    int _head = 0;
    int _tail = 0;
    int _capacity = 10;     // 默认为10
    int _size = 0;
    E[] _array;

    ArrayDeque() {
        _array = (E[]) new Object[_capacity];
    }

    ArrayDeque(int capacity) {
        _capacity = capacity;
        _array = (E[]) new Object[_capacity];
    }

    @Override
    public boolean offerFirst(E value) {
        // 头部添加
        if (isFull()) {
            return false;
        }
        _head = dec(_head, _capacity);
        _array[_head] = value;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        _array[_tail] = value;
        _tail = inc(_tail, _capacity);
        return true;
    }

    @Override
    public E pollFisrt() {
        if (isEmpty()) {
            return null;
        }
        E temp = _array[_head];
        _array[_head] = null;   // 垃圾回收
        _head = inc(_head, _capacity);
        return temp;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        _tail = dec(_tail, _capacity);
        E temp = _array[_tail];
        _array[_tail] = null;   // 垃圾回收
        return temp;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return _array[_head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return _array[dec(_tail, _capacity)];
    }

    @Override
    public boolean isEmpty() {
        return _tail == _head;
    }

    @Override
    public boolean isFull() {
        return (_tail + 1) % _capacity == _head;
    }

    /**
     * @param tail     尾指针
     * @param capacity 数组容量
     * @return 尾指针+1后的值
     */
    public int inc(int tail, int capacity) {
        if (tail + 1 >= capacity) {
            // 表明尾指针越界
            tail = 0;
        } else {
            ++tail;
        }
        return tail;
    }

    /**
     * @param head     头指针
     * @param capacity 数组容量
     * @return 头指针减一后的值
     */
    public int dec(int head, int capacity) {
        if (head - 1 < 0) {
            head = capacity - 1;
        } else {
            head = head - 1;
        }
        return head;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int p = _head;
            @Override
            public boolean hasNext() {
                return p != _tail;
            }

            @Override
            public E next() {
                E temp = _array[p];
                p = inc(p,_capacity);
                return temp;
            }
        };
    }
}
