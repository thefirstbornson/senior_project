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

    @OneToMany(mappedBy = "course")
    private Set<RecipeCourse> recipeCourses = new HashSet<>();

    public Course() {
    }

    public Course(String course) {
        this.course = course;
    }

    public void addRecipeCourse(RecipeCourse recipeCourse) {
        this.recipeCourses.add(recipeCourse);
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

    public Set<RecipeCourse> getRecipeCourse() {
        return recipeCourses;
    }

    public void setRecipeCourse(Set<RecipeCourse> recipeCourse) {
        this.recipeCourses = recipeCourse;
    }
}
