import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class brtest {
    @Test
    @DisplayName("递归使用bisearch!")
    public void test01(){
        int[] l = {1,2,3,4,5,6,7,8,9,10};
        int expected = 4;
        int ret = bisearchRecursion.bisearchRecursion(l,5,0,9);
        int ret01 = bisearchRecursion.bisearchRecursion(l,11,0,9);
        int ret02 = bisearchRecursion.bisearchRecursion(l,0,0,9);
        Assertions.assertEquals(expected,ret);
        Assertions.assertEquals(-1,ret01);
        Assertions.assertEquals(-1,ret02);;

    }

}
