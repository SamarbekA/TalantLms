package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Long id) {
        return courseRepository.getAllCourses(id);
    }

    @Override
    public void addCourse(Course course, Long id) {
        courseRepository.addCourse(course, id);

    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        courseRepository.updateCourse(course, id);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);

    }
}
