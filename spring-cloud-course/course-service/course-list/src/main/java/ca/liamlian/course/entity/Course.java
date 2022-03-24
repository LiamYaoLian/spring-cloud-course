package ca.liamlian.course.entity;

public class Course {
    private Integer id;
    private Integer courseId;
    private String courseName;
    private Integer valid;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getValid() {
        return valid;
    }
}
