package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();

        StudentList students = datasource.readData();

        assertEquals("First", students.findStudentById("6710400001").getName());
        assertEquals("Second", students.findStudentById("6710400002").getName());
        assertEquals("Third", students.findStudentById("6710400003").getName());
        assertEquals("Fourth", students.findStudentById("6710400004").getName());
        assertNull(students.findStudentById("6710450945"));
    }
}