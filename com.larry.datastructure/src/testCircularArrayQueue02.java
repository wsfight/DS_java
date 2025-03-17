import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testCircularArrayQueue02 {
    @Test
    @DisplayName("offer")
    public void test01() {
        CircularArrayQueue2<Integer> l = new CircularArrayQueue2<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        Assertions.assertIterableEquals(List.of(1, 2, 3), l);
    }

    @Test
    @DisplayName("poll")
    public void test02() {
        CircularArrayQueue2<Integer> l = new CircularArrayQueue2<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        l.poll();
        l.poll();
        l.poll();
        Assertions.assertTrue(l.isEmpty());
    }

    @Test
    @DisplayName("迭代")
    public void test03() {
        CircularArrayQueue2<Integer> l = new CircularArrayQueue2<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);


        for (Object i : l) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("测试构造函数")
    public void test04(){
        CircularArrayQueue2<Integer> l = new CircularArrayQueue2<>(8);
        CircularArrayQueue2<Integer> l1 = new CircularArrayQueue2<>(16);
        CircularArrayQueue2<Integer> l2 = new CircularArrayQueue2<>(32);
        CircularArrayQueue2<Integer> l3 = new CircularArrayQueue2<>(1024);
    }

    @Test
    @DisplayName("测试构造函数2")
    public void test05(){
        CircularArrayQueue2<Integer> l = new CircularArrayQueue2<>(9);
        Assertions.assertEquals(16,l.get_capacity());
        CircularArrayQueue2<Integer> l1 = new CircularArrayQueue2<>(16);
        Assertions.assertEquals(16,l1.get_capacity());
        CircularArrayQueue2<Integer> l2 = new CircularArrayQueue2<>(21);
        Assertions.assertEquals(32,l2.get_capacity());

    }
}