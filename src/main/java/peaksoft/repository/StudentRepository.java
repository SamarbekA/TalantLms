package peaksoft.repository;

import peaksoft.model.Instructor;
import peaksoft.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents(Long courseId);
    List<Student> getStudentList();

    void addStudent(Long id, Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student, Long id);

    void deleteStudent(Long id);

    void assignStudent(Long groupId, Long studentId) throws IOException;
}
