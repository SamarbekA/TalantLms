package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
//    private final StudentRepository studentRepository;
//    @Autowired
//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//
//    @Override
//    public List<Student> getAllStudents(Long courseId) {
//        return studentRepository.getAllStudents(courseId);
//    }
//
//    @Override
//    public void addStudent(Long id, Student student) {
//        studentRepository.addStudent(id,student);
//
//    }
//
//    @Override
//    public Student getStudentById(Long id) {
//        return studentRepository.getStudentById(id);
//    }
//
//    @Override
//    public void updateStudent(Student student, Long id) {
//        studentRepository.updateStudent(student,id);
//
//    }
//
//    @Override
//    public void deleteStudent(Student student) {
//        studentRepository.deleteStudent(student);
//
//    }
//
//    @Override
//    public void assignStudent(Long groupId, Long studentId) {
//        studentRepository.assignStudent(groupId,studentId);
//
//    }
}
