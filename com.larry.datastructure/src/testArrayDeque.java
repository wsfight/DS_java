import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class testArrayDeque {
    @Test
    @DisplayName("offer")
    public void test(){
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.offerFirst(1);
        l.offerFirst(2);
        l.offerFirst(3);    // 3 2 1
        l.offerLast(4);
        l.offerLast(5);
        l.offerLast(6);     // 3 2 1 4 5 6
        Assertions.assertIterableEquals(List.of(3,2,1,4,5,6),l);
    }

    @Test
    @DisplayName("poll")
    public void test01(){
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.offerFirst(1);
        l.offerFirst(2);
        l.offerFirst(3);    // 3 2 1
        l.offerLast(4);
        l.offerLast(5);
        l.offerLast(6);     // 3 2 1 4 5 6
        int temp = l.pollFisrt();
        Assertions.assertEquals(3,temp);
        temp = l.pollLast();
        Assertions.assertEquals(6,temp);
        l.pollFisrt();
        l.pollLast();
        l.pollFisrt();
        l.pollLast();
        Assertions.assertNull(l.pollLast());
        Assertions.assertTrue(l.isEmpty());

    }
}
