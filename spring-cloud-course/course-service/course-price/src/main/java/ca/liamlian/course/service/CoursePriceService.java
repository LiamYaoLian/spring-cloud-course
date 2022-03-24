package ca.liamlian.course.service;

import ca.liamlian.course.entity.CourseAndPrice;
import ca.liamlian.course.entity.CoursePrice;

import java.util.List;

public interface CoursePriceService {
    CoursePrice getCoursePrice(Integer courseId);
    List<CourseAndPrice> getCoursesAndPrice();
}
