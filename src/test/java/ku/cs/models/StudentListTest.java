package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList students;

    @BeforeEach
    void init() {
        students = new StudentList();
    }

    @Test
    void testAddNewStudent() {
        students.addNewStudent("6710450945", "Thanathip Singkaew");
        assertEquals("6710450945", students.findStudentById("6710450945").getId());

        // Test Duplicated Id
        students.addNewStudent("6710450945", "Tak");
        assertEquals("Thanathip Singkaew", students.findStudentById("6710450945").getName());
    }

    @Test
    void testFindStudentById() {
        students.addNewStudent("6710450945", "Thanathip Singkaew");

        Student targetStudent = students.findStudentById("6710450945");
        assertEquals("Thanathip Singkaew", targetStudent.getName());

        Student targetStudent2 = students.findStudentById("000");
        assertNull(targetStudent2);
    }

    @Test
    void testFilterByName() {
        students.addNewStudent("6710450945", "Tak");
        students.addNewStudent("6710450946", "Thanathip Singkaew");
        students.addNewStudent("6711111111", "Jozho");

        StudentList filteredStudents = students.filterByName("J");
        assertEquals("Jozho", filteredStudents.findStudentById("6711111111").getName());
        assertNull(filteredStudents.findStudentById("6710450945"));
    }

    @Test
    void testGiveScoreToId() {
        students.addNewStudent("6710450945", "Tak");
        students.giveScoreToId("6710450945", 80);

        assertEquals(80, students.findStudentById("6710450945").getScore());
    }

    @Test
    void testViewGradeOfId() {
        students.addNewStudent("6710450945", "Tak", 80);
        assertEquals("A", students.viewGradeOfId("6710450945"));
    }
}