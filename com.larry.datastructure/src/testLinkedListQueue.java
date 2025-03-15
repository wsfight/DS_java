import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testLinkedListQueue {
    @Test
    @DisplayName("测试尾插函数offer")
    public void test01(){
        LinkedListQueue<Integer> l = new LinkedListQueue<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        l.offer(4);
        l.offer(5);         // 1,2,3,4,5
        Assertions.assertIterableEquals(List.of(1,2,3,4,5),l);
    }
    @Test
    @DisplayName("测试poll函数")
    public void test02(){
        LinkedListQueue<Integer> l = new LinkedListQueue<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        l.offer(4);
        l.offer(5);
        l.poll();
        l.poll();
        l.poll();
        l.poll();
        l.poll();
        Assertions.assertIterableEquals(List.of(),l);
    }

    @Test
    @DisplayName("测试peek函数")
    public void test03(){
        LinkedListQueue<Integer> l = new LinkedListQueue<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        l.offer(4);
        l.offer(5);
        int actual_01 = l.peek();
        int expected_01 = 1;
        Assertions.assertEquals(expected_01,actual_01);

        l.poll();
        int actual_02 = l.peek();
        int expected_02 = 2;
        Assertions.assertEquals(expected_02,actual_02);
    }


}
