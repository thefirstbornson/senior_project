package datasets;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblCourse")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private long id;

    @Column(name="course")
    private String course;

    public Course() {
    }

    public Course(String course) {
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
