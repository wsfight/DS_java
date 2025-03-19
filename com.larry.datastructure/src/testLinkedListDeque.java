import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testLinkedListDeque {
    @Test
    @DisplayName("offer")
    public void test(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.offerFirst(1);
        l.offerFirst(2);
        l.offerFirst(3);
        l.offerFirst(4);     // 4 3 2 1
        l.offerLast(5);
        l.offerLast(6);
        l.offerLast(7);
        Assertions.assertIterableEquals(List.of(4,3,2,1,5,6,7),l);
    }

    @Test
    @DisplayName("poll")
    public void test01(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.offerFirst(1);
        l.offerFirst(2);
        l.offerFirst(3);
        l.offerFirst(4);     // 4 3 2 1
        l.offerLast(5);
        l.offerLast(6);
        l.offerLast(7);     // 4 3 2 1 5 6 7
        l.pollFisrt();            // 3 2 1 5 6 7
        Assertions.assertIterableEquals(List.of(3,2,1,5,6,7),l);
        l.pollLast();
        l.pollLast();
        Assertions.assertIterableEquals(List.of(3,2,1,5),l);

    }

    @Test
    @DisplayName("迭代")
    public void test02(){
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.offerFirst(1);
        l.offerFirst(2);
        l.offerFirst(3);
        l.offerFirst(4);     // 4 3 2 1
        l.offerLast(5);
        l.offerLast(6);
        l.offerLast(7);
        for(Object i : l){
            System.out.println(i);
        }
    }
}
