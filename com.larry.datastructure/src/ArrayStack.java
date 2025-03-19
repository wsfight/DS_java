import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>,Iterable {
    private E[] _array;
    private int _top = 0;    // 栈顶+1 的指针

    /*
     * 底         顶
     * 1  2   3   4
     * */
    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        _array = (E[]) new Object[capacity];
    }

    /**
     * @param value :压入值
     * @return 压入成功返回true, 压入失败返回false
     */
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        // 没有满
        _array[_top++] = value;
        return true;
    }

    /**
     * @return 不为空返回栈顶值并弹出栈顶元素, 为空返回null
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E ans = _array[--_top];
        return ans;
    }

    /**
     * @return 不为空返回栈顶值, 为空返回null
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E ans = _array[_top - 1];
        return ans;
    }

    /**
     * @return 为空返回true,不为空返回false
     */
    @Override
    public boolean isEmpty() {
        return _top == 0;
    }

    @Override
    public boolean isFull() {
        return _top == _array.length;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int p = _top - 1;
            @Override
            public boolean hasNext() {
                return p >= 0;
            }

            @Override
            public E next() {
                E temp = _array[p];
                p--;
                return temp;
            }
        };
    }
}
