import java.util.Iterator;

/**
 * * 求模运算:
 *      * - 如果除数是2的n次方
 *      * - 那么被除数的后n位即为余数(模)
 *      * - 求被除数的后n位方法: 与2^n - 1按位与
 * * 判断是否为2^n:
 *      * - 假设k 为 2^n的数
 *      * - 则k & (k - 1) 肯定为0
 * @param <E> 泛型
 *
 *
 */

public class CircularArrayQueue2<E> implements Iterable {
    private E[] array;
    private int _head;
    private int _tail;
    private int _capacity = 8;

    public CircularArrayQueue2(){
         array = (E[]) new Object[_capacity];
         _head = 0;
         _tail = 0;
    }

    /**
     *
     * @param capacity 保证数组的长度为2^n
     */
    public CircularArrayQueue2(int capacity){
        // 如果传进来不是2^n
//        if((capacity & (capacity - 1))!= 0){
//            // 1.抛异常
//            throw new IllegalArgumentException("capacity 非2^n的数");
//        }     // 2.修改成接近的2^n

//        if ((capacity & (capacity - 1)) != 0) {
//            // 修正值k
//            int k =(int) (Math.log(capacity) / Math.log(2) + 1);
//            _capacity = 1 << k;
//        }else{
//            _capacity = capacity;
//        }



        capacity -= 1;
        capacity |= capacity >> 1;
        capacity |= capacity >> 2;
        capacity |= capacity >> 4;
        capacity |= capacity >> 8;
        capacity |= capacity >> 16;
        capacity += 1;
        _capacity = capacity;
        array = (E[]) new Object[_capacity];
        _head = 0;
        _tail = 0;

    }

    public boolean offer(E value){
        if(isFull()){
            return false;
        }
        array[_tail & (_capacity - 1)] = value;
        _tail++;
        return true;
    }

    public E poll(){
        if(isEmpty()){
            return null;
        }
        E value = array[_head & (_capacity - 1)];
        _head++;
        return value;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return array[_head & (_capacity - 1)];
    }

    public boolean isFull(){
        return _tail - _head == _capacity;
    }

    public boolean isEmpty(){
        return _tail == _head;
    }

    public int get_capacity(){
        return _capacity;
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
                E value = array[p & (_capacity - 1)];
                p++;
                return value;
            }
        };
    }
}
