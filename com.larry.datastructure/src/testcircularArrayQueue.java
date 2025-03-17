import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testcircularArrayQueue {
    @Test
    @DisplayName("offer")
    public void test01() {
        CircularArrayQueue<Integer> l = new CircularArrayQueue<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        Assertions.assertIterableEquals(List.of(1, 2, 3), l);
    }

    @Test
    @DisplayName("poll")
    public void test02() {
        CircularArrayQueue<Integer> l = new CircularArrayQueue<>();
        l.offer(1);
        l.offer(2);
        l.offer(3);
        l.poll();
        l.poll();
        l.poll();
        Assertions.assertTrue(l.isEmpty());
    }
}