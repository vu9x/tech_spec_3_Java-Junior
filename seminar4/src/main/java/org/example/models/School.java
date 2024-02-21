package org.example.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "schools")
public class School {

    private static final String[] titles = new String[]{"a,", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SchoolName")
    private String schoolName;
    @Column(name = "Duration")
    private int duration;

    public School() {
    }

    public School(String schoolName, int duration) {
        this.schoolName = schoolName;
        this.duration = duration;
    }

    public static School create(){
        return new School(titles[random.nextInt(titles.length)], random.nextInt(30, 40));
    }

    public School(int id, String schoolName, int duration) {
        this.id = id;
        this.schoolName = schoolName;
        this.duration = duration;
    }

    public void updateTitle(){
        schoolName = titles[random.nextInt(titles.length)];
    }

    public void updateDuration(){
        duration = random.nextInt(30,40);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", title='" + schoolName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
