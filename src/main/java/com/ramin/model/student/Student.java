package com.ramin.model.student;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String name;
    private String LastName;
    private Gender gender;
    private Boolean activeStatus;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> courseList = new ArrayList<>();

    public enum Gender {
        MALE("male"), FEMALE("female");
        private String displayName;

        Gender(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (studentId == null || name == null
                || LastName == null || gender == null
                || activeStatus == null)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, name, LastName, gender, activeStatus, courseList);
    }
}


