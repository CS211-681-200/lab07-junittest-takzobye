package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;

    @BeforeEach
    void init() {
        s = new Student("6710450945", "Tak");
    }

    @Test
    void testChangeName() {
        s.changeName("Thanathip Singkaew");
        assertEquals("Thanathip Singkaew", s.getName());
    }

    @Test
    void testAddScore() {
        s.addScore(50);
        assertEquals(50, s.getScore());
        s.addScore(25);
        assertEquals(75, s.getScore());
    }

    @Test
    void testCalculateGrade() {
        s.addScore(45);
        assertEquals("F", s.grade());
        s.addScore(5);
        assertEquals("D", s.grade());
        s.addScore(5);
        assertEquals("D+", s.grade());
        s.addScore(5);
        assertEquals("C", s.grade());
        s.addScore(5);
        assertEquals("C+", s.grade());
        s.addScore(5);
        assertEquals("B", s.grade());
        s.addScore(5);
        assertEquals("B+", s.grade());
        s.addScore(5);
        assertEquals("A", s.grade());
    }

    @Test
    void testIsId() {
        assertEquals("6710450945", s.getId());
    }

    @Test
    void testIsNameContains() {
        s.changeName("Thanathip Singkaew");
        assertTrue(s.isNameContains("Thana"));
    }
}