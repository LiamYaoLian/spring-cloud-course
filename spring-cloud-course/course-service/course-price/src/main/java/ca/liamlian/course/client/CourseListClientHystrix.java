package ca.liamlian.course.client;

import ca.liamlian.course.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Spring Cloud has removed Hystrix in later versions
 */
@Component
public class CourseListClientHystrix implements CourseListClient {

    @Override
    public List<Course> courseList() {
//        List<Course> defaultCourses = new ArrayList<>();
//        Course course = new Course();
//        course.setId(1);
//        course.setCourseId(1);
//        course.setCourseName("default course");
//        course.setValid(1);
//        defaultCourses.add(course);
//        return defaultCourses;
        // or
        return Collections.emptyList();
    }
}
