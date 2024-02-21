package org.example.models;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "CoursesTable")
public class Course {
    private static final String[] titles = new String[]{"a,", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "courseName")
    private String courseName;
    @Column(name = "courseDuration")
    private int courseDuration;

    public Course(){}

    public Course(String courseName, int courseDuration) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    public static Course create(){
        return new Course(titles[random.nextInt(titles.length)], random.nextInt(30, 40));
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void updateCourseName(){
        courseName = titles[random.nextInt(titles.length)];
    }

    public void updateCourseDuration(){
        courseDuration = random.nextInt(30,40);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseDuration=" + courseDuration +
                '}';
    }
}
