package test;

import com.xeasony.Robot;

import static org.junit.Assert.*;

public class RobotTest {
    private int getTotalWay(int size) {
        Robot robot = new Robot(size);
        return robot.getTotalWay();
    }

    @org.junit.Test
    public void testGetTotalWayOne() throws Exception {
        assertEquals(1, getTotalWay(1));
    }

    @org.junit.Test
    public void testGetTotalWayTwo() throws Exception {
        assertEquals(2, getTotalWay(2));
    }

    @org.junit.Test
    public void testGetTotalWayThree() throws Exception {
        assertEquals(12, getTotalWay(3));
    }
}