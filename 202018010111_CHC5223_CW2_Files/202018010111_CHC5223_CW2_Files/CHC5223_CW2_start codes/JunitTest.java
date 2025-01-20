package CHC5223;

import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test
    public void testStackInt() {
        AbsStackInt  stackInt = new StackInt(10);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < a.length; i++) {
            stackInt.push(a[i]);
        }
        Assert.assertEquals(10, stackInt.getCapacity());
        Assert.assertEquals(10, stackInt.getSize());
        Assert.assertEquals(10, stackInt.peek());
        Assert.assertEquals(10, stackInt.pop());
        Assert.assertEquals(9, stackInt.pop());
        Assert.assertEquals(8, stackInt.pop());
        Assert.assertEquals(7, stackInt.getSize());

    }

    @org.junit.Test
    public void testSetInt() {
        AbsSetInt setInt = new SetInt(10);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < a.length; i++) {
            setInt.include(a[i]);
        }
        Assert.assertEquals(10, setInt.getCapacity());
        Assert.assertEquals(10, setInt.getSize());
        Assert.assertTrue(setInt.contains(10));
        setInt.exclude(10);
        Assert.assertFalse(setInt.contains(10));
        Assert.assertEquals(9, setInt.getSize());
        setInt.exclude(9);
        Assert.assertFalse(setInt.contains(9));
        Assert.assertEquals(8, setInt.getSize());
    }

    @org.junit.Test
    public void testQueueInt() {
        AbsQueueInt queueInt = new QueueInt(10);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < a.length; i++) {
            queueInt.addToBack(a[i]);
        }
        Assert.assertEquals(10, queueInt.getCapacity());
        Assert.assertEquals(10, queueInt.getSize());
        Assert.assertEquals(1, queueInt.removeFromFront());
        Assert.assertEquals(2, queueInt.removeFromFront());
        Assert.assertEquals(3, queueInt.removeFromFront());
        queueInt.addToBack(11);
        Assert.assertEquals(8, queueInt.getSize());

    }

    @org.junit.Test
    public void testListInt() {
        AbsListInt listInt = new ListInt(10);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < a.length; i++) {
            listInt.append(a[i]);
        }
        Assert.assertEquals(10, listInt.getCapacity());
        Assert.assertEquals(10, listInt.getSize());
        for (int i = 0; i < a.length; i++) {
            Assert.assertTrue(listInt.contains(a[i]));
        }
    }
}