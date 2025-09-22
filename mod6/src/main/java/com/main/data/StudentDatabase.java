package com.main.data;

import java.util.ArrayList;

public class StudentDatabase {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static Student getStudentByNim(String nim) {
        for (Student student : students) {
            if (student.getNim().equals(nim)) {
                return student;
            }
        }
        return null;
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("List of Registered Students:");
            System.out.println("NIM\tName\t\tFaculty\tProgram Studi");
            for (Student student : students) {
                System.out.println(student.getNim() + "\t" + student.getName() + "\t" + student.getFaculty() + "\t"
                        + student.getProgramStudi());
            }
        }
    }
}
