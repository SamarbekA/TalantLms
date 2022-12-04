package peaksoft.service;

import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(Long id);

    void addCourse(Course course, Long id);

    Course getCourseById(Long id);

    void updateCourse(Course course, Long id);

    void deleteCourse(Long id);
}

