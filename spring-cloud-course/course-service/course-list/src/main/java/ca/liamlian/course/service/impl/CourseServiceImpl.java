package ca.liamlian.course.service.impl;

import ca.liamlian.course.dao.CourseMapper;
import ca.liamlian.course.entity.Course;
import ca.liamlian.course.service.CourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseListService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getCourseList() {
        return courseMapper.findValidCourses();
    }
}
