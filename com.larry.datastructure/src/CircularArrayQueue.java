import java.util.Iterator;

public class CircularArrayQueue<E> implements Iterable {
    /**
     * 环形数组队列:
     * 先进先出
     * 起点和终点更为自由,不用考虑数据移动
     * 环意味着不会越界,但会有容量限制
     * 环形数组比较适合有界队列,ringbuffer等
     * 下标计算: 数组长度n 当前索引位置k 向前走i步,则对应索引为(k + i) % n  长度5,索引2,走5步  对应索引(2+5)%5 = 2
     * 判断满: 设置头指针与尾指针  一般预留一个位置: (_tail + 1) % n = _head
     * 判断空: _tail = _head
     *
     * 求模运算:
     * - 如果除数是2的n次方
     * - 那么被除数的后n位即为余数(模)
     * - 求被除数的后n位方法: 与2^n - 1按位与
     * */

    /**
     * 几个属性
     *
     * @param _head:指向头部  _tail:指向尾部的下一个元素
     */
    private E[] array;
    private int _head;
    private int _tail;
    private int _size;
    private int _capacity = 10;


    /**
     * 简单的构造函数
     */ {
        _size = 0;
        _head = 0;
        _tail = 0;
    }

    public CircularArrayQueue() {
        array = (E[]) new Object[_capacity + 1];        // 预留了一个位置用来判满
    }

    /**
     * @param capacity:指定容量大小,不指定则默认为10
     */
    public CircularArrayQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
        _capacity = capacity;
    }

    /**
     * @param value:需要插入的值
     * @return 插入失败返回false, 插入成功返回true
     */
    boolean offer(E value) {
        if (isFull()) {
            // 满了则插入失败
            return false;
        }
        array[_tail] = value;
        _tail = (_tail + 1) % (_capacity + 1);
        ++_size;
        return true;
    }

    /**
     * 从队头获取值,并移除
     *
     * @return:如果队列为空则返回null,否则返回队头值,并且移除队头
     */
    E poll() {
        if (isEmpty()) {
            return null;
        }
        // 接下来非空
        E temp = array[_head];
        _head = (_head + 1) % (_capacity + 1);
        return temp;
    }

    /**
     * 从队头获取值,不移除
     *
     * @return:如果队列为空,返回null,非空则返回队头值
     */
    E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[_head];
    }

    /**
     * 判断队列是否为空
     *
     * @return 如果为空返回true, 非空则false
     */
    boolean isEmpty() {
        return _head == _tail;
    }

    /**
     * 检查队列是否已满
     *
     * @return 满返回true, 否则返回false
     */
    boolean isFull() {
        return (_tail + 1) % (_capacity + 1) == _head;
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
            public Object next() {
                E temp = array[p];
                p = (p + 1) % (_capacity + 1);
                return temp;
            }
        };
    }
}
