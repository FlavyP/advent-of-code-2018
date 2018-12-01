import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    private Day1 target = new Day1();

    @Test
    void partOne() {
        assertEquals(439, target.partOne());
    }

    @Test
    void partTwo() {
        assertEquals(124645, target.partTwo());
    }
}