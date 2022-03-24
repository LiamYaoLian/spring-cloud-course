package ca.liamlian.course.service.impl;

import ca.liamlian.course.client.CourseListClient;
import ca.liamlian.course.dao.CoursePriceMapper;
import ca.liamlian.course.entity.Course;
import ca.liamlian.course.entity.CourseAndPrice;
import ca.liamlian.course.entity.CoursePrice;
import ca.liamlian.course.service.CoursePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursePriceServiceImpl implements CoursePriceService {

    @Autowired
    CoursePriceMapper coursePriceMapper;

    @Autowired
    CourseListClient courseListClient;

    @Override
    public CoursePrice getCoursePrice(Integer courseId) {
        return coursePriceMapper.findCoursePrice(courseId);
    }

    @Override
    public List<CourseAndPrice> getCoursesAndPrice() {
        List<CourseAndPrice> courseAndPriceList = new ArrayList<>();
        List<Course> courses = courseListClient.courseList();
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course != null) {
                CoursePrice coursePrice = getCoursePrice(course.getCourseId());
                CourseAndPrice courseAndPrice = new CourseAndPrice();
                courseAndPrice.setPrice(coursePrice.getPrice());
                courseAndPrice.setName(course.getCourseName());
                courseAndPrice.setId(course.getId());
                courseAndPrice.setCourseId(course.getCourseId());
                courseAndPriceList.add(courseAndPrice);
            }


        }
        return courseAndPriceList;
    }
}
