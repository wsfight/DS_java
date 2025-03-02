import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;



public class test {
    @Test
    @DisplayName("循环")
    public void test1(){
        singleLinkedList<Integer> list = new singleLinkedList<Integer>();
        list.addFisrt(1);
        list.addFisrt(2);
        list.addFisrt(3);
        list.loop(value->{
            // 简单while循环
            System.out.println(value);
        });        // 3 2 1
        list.loop2(value->{
            // 简单for循环
            System.out.println(value);
        });
        for(int v:list){
            // 增强for循环
            System.out.println(v);
        }
    }

    @Test
    public void test02(){
        singleLinkedList<Integer> l = new singleLinkedList<Integer>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        Assertions.assertIterableEquals(List.of(1,2,3,4,5),l);
        Assertions.assertEquals(4,l.get(3));

    }


}
