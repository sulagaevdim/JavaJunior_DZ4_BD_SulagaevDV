package org.example;

import javax.persistence.*;

@Entity
@Table(name = "test.courses")
public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "title")
        private String name;
        @Column(name = "duration")
        private int duration;

    public Course() {
    }

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
