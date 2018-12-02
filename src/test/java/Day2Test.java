import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    private Day2 target = new Day2();

    @Test
    void partOne() {
        assertEquals(5681, target.partOne());
    }

    @Test
    void partTwo() {
        assertEquals("uqyoeizfvmbistpkgnocjtwld", target.partTwo());
    }
}