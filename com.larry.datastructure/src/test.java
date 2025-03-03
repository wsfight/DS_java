import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class test {
    @Test
    @DisplayName("loop!")
    public void test1() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.loop(value -> {
            // 简单while循环
            System.out.println(value);
        });        // 3 2 1
        list.loop2(value -> {
            // 简单for循环
            System.out.println(value);
        });
        for (int v : list) {
            // 增强for循环
            System.out.println(v);
        }
    }

    @Test
    @DisplayName("addLast!")
    public void test02() {
        SingleLinkedList<Integer> l = new SingleLinkedList<Integer>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5), l);
        Assertions.assertEquals(4, l.get(3));

    }

    @Test
    @DisplayName("remove!")
    public void test03() {
        SingleLinkedList<Integer> l = new SingleLinkedList<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.remove(0);
        l.remove(3);
        Assertions.assertIterableEquals(List.of(2, 3, 4), l);
    }

    @Test
    @DisplayName("insert!")
    public void test04() {
        SingleLinkedList<Integer> l = new SingleLinkedList<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addFirst(5);  // 5 1 2 3 4
        l.insert(1,10); // 5 10 1 2 3 4
        Assertions.assertIterableEquals(List.of(5,10,1,2,3,4),l);

    }

    @Test
    @DisplayName("recursion!")
    public void test05(){
        SingleLinkedList<Integer> l = new SingleLinkedList<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addFirst(5);  // 5 1 2 3 4
        l.insert(1,10); // 5 10 1 2 3 4
        l.loop3(value->{
            System.out.println(value);
        });
    }
}
