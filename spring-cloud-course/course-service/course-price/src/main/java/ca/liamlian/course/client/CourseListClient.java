package ca.liamlian.course.client;

import ca.liamlian.course.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "course-list", fallback = CourseListClientHystrix.class)
@Primary
public interface CourseListClient {
    // add dependency on module 'course-list'
    @GetMapping("/courses")
    List<Course> courseList();
}
