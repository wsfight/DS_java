import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testPriqueue {
    @Test
    @DisplayName("offer")
    public void test(){
        PriorityQueue<Entry> l = new PriorityQueue<>();
        l.offer(new Entry("task1",10));
        l.offer(new Entry("task2",2));
        l.offer(new Entry("task3",5));
        l.offer(new Entry("task4",1));
        Assertions.assertEquals(10,l.poll().priority());
        Assertions.assertEquals(5,l.poll().priority());
        Assertions.assertEquals(2,l.poll().priority());
        Assertions.assertEquals(1,l.poll().priority());
    }

}