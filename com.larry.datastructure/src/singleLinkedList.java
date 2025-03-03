import java.util.Iterator;
import java.util.function.Consumer;

public class singleLinkedList<T> implements Iterable<T>{
    private class Node{
        // 与外部类有类型关系
        T value;
        Node next;
        public Node(T val){
            value = val;
            next = null;
        }
        public Node(T val,Node n){
            value = val;
            next = n;
        }
        public Node(){
            next = null;
        }
    }

    private Node _head;         // 头结点
    private Node _last;
    public singleLinkedList(){
        _head = new Node();
        _last = _head;
    }

    public void addFisrt(T val){
        Node p = new Node(val,_head.next);
        _head.next = p;
        if(p.next == null){
            _last = p;
        }
    }
    public void addLast(T val){
        Node p = new Node(val,null);
        if(_head.next == null){
            _head.next = p;
        }else{
            _last.next = p;
        }
        _last = p;
    }
    public Node findIndex(int index){
        if(index == -1){
            return _head;
        }
        int i = 0;
        for (Node p = _head.next;p!=null;p=p.next,i++) {
            if(i == index){
                return p;
            }
        }
        return null;
    }
    public T get(int index){
        Node node = findIndex(index);
        if(node == null){
            throw new IllegalArgumentException(String.format("index %d 不合法!",index));
        }
        return node.value;
    }

    public T remove(int index){
        Node p = findIndex(index - 1);
        Node ret = p.next;
        p.next = p.next.next;
        return ret.value;
    }

    public void loop(Consumer<T>consumer){
        Node p = _head.next;
        while(p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<T>consumer){
        Node p = _head.next;
        for(;p != null;p = p.next){
            consumer.accept(p.value);
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
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
}
