import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testLinkedListStack {
    @Test
    @DisplayName("测试push")
    public void test(){
        LinkedListStack<Integer> l = new LinkedListStack<>();
        l.push(1);
        l.push(2);
        l.push(3);
        Assertions.assertIterableEquals(List.of(3,2,1),l);

        LinkedListStack<Integer> l1 = new LinkedListStack<>();
        Assertions.assertTrue(l1.isEmpty());
    }

    @Test
    @DisplayName("测试pop")
    public void test01(){
        LinkedListStack<Integer> l = new LinkedListStack<>();
        l.push(3);
        l.push(2);
        l.push(1);

        int actual01 = l.pop();
        int expected01 = 1;
        Assertions.assertEquals(expected01,actual01);

        l.pop();
        l.pop();
        Assertions.assertTrue(l.isEmpty());
    }

    @Test
    @DisplayName("测试迭代")
    public void test02(){
        LinkedListStack<Integer> l = new LinkedListStack<>();
        l.push(3);
        l.push(2);
        l.push(1);

        for(Object i : l){
            System.out.println(i);      // 1,2,3
        }
    }
}
