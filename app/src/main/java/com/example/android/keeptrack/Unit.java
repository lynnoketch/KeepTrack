package com.example.android.keeptrack;

public class Unit {
    static String Uname;
    static String faculty;
    static String year;
    static String semester;
    static String lecturer;
    public Unit(String name, String faculty)
    {}
    public Unit(String uname, String faculty, String year, String semester, String lecturer) {
        this.Uname = uname;
        this.faculty = faculty;
        this.year = year;
        this.semester = semester;
        this.lecturer = lecturer;
    }


    public static String getUname() {
        return Uname;
    }

    public static String getFaculty() {
        return faculty;
    }

    public static String getYear() {
        return year;
    }

    public static String getSemester() {
        return semester;
    }

    public static String getLecturer() {
        return lecturer;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
