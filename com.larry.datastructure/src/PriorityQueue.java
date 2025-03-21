/**
 * 优先级队列: 一端进 另一端出 按优先级出队
 * 普通队列: 一端进,另一端出  按入队顺序出队
 */
public class PriorityQueue<E extends Priority> implements Queue<E> {
    int _size;
    int _capacity = 10;     // 默认为10
    private E[] _array;

    @SuppressWarnings("")
    PriorityQueue() {
        _array = (E[]) new Priority[_capacity];
    }

    PriorityQueue(int capacity) {
        _capacity = capacity;
        _array = (E[]) new Priority[_capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        _array[_size++] = value;
        return true;
    }

    /**
     * 返回优先级最高的索引值
     *
     * @return
     */
    private int selectMax() {
        int max = 0;
        for (int i = 0; i < _size; i++) {
            if (_array[i].priority() > _array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E temp = _array[max];
        remove(max);
        return temp;
    }

    private void remove(int index) {
        if (index < _size - 1) {
            // index之后的元素向前移动
            System.arraycopy(_array, index + 1, _array, index, _size - index + 1);
        }
        _size--;
        return;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return _array[max];
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public boolean isFull() {
        return _size == _capacity;
    }
}