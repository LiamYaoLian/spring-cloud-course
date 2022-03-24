package ca.liamlian.course.controller;

import ca.liamlian.course.entity.Course;
import ca.liamlian.course.service.CourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseListController {

    @Autowired
    CourseListService courseListService;

    @GetMapping("/courses")
    public List<Course> courseList() {
        return courseListService.getCourseList();
    }
}
