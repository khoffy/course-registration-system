package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.StudentDto;


import java.util.ArrayList;
import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 2:10 AM
 */
public class Students {
    List<StudentDto> students = new ArrayList<>();

    public Students() {
    }

    public Students(List<StudentDto> students) {
        this.students = students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<StudentDto> getStudents() {
        return students;
    }
}
