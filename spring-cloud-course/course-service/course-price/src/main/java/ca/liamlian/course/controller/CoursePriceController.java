package ca.liamlian.course.controller;

import ca.liamlian.course.client.CourseListClient;
import ca.liamlian.course.entity.Course;
import ca.liamlian.course.entity.CourseAndPrice;
import ca.liamlian.course.service.CoursePriceService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoursePriceController {

    @Autowired
    CoursePriceService coursePriceService;

    @Autowired
    CourseListClient courseListClient;

    // http://localhost:8082/price?courseId=678
    @GetMapping("/price")
    public Integer getCoursePrice(Integer courseId) {

         return coursePriceService.getCoursePrice(courseId).getPrice();
    }

    @GetMapping("/coursesInPrice")
    @CircuitBreaker(name="getCourseListInPrice", fallbackMethod = "courseListInPriceFallback")
    public List<Course> getCourseListInPrice(Integer courseId) {
        List<Course> courses = courseListClient.courseList();
        return courses;
    }

    public List<Course> courseListInPriceFallback(Exception e) {
        List<Course> defaultCourses = new ArrayList<>();
        Course course = new Course();
        course.setId(1);
        course.setCourseId(1);
        course.setCourseName("default course");
        course.setValid(1);
        defaultCourses.add(course);
        return defaultCourses;
        // or
        // return Collections.emptyList();
    }

    @GetMapping("/coursesAndPrice")
    public List<CourseAndPrice> getCoursesAndPrice() {
        return coursePriceService.getCoursesAndPrice();
    }




}
