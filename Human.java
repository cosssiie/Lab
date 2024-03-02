import java.util.Arrays;
import java.util.Scanner;

class Human {

    Human(){}

    //ім'я прізвище людини
    private String name;

    //вік людини
    private int age;


    /*
    створюємо масив кафедр, до яких належить один студент і також створюємо геттер
     */


    //посада людини, по типу: студент, викладач
    private String position;


    //конструктор створення людини, в подальшому класи наслідуватимуть його
    public Human(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // геттери і сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}

class Student extends Human {
    Student(){

    }
    public static String[] helper;
    private int grades;


    private String belongsToTheDepartment;


    private String faculty;

    private int course;
    private String[] arrayOfDepartmentsStudentToBelongs = new String[0];


    public String[] getArrayOfDepartmentsStudentToBelongs() {
        return arrayOfDepartmentsStudentToBelongs;
    }

    public void setArrayOfDepartmentsStudentToBelongs(String[] arrayOfDepartmentsStudentToBelongs) {
        this.arrayOfDepartmentsStudentToBelongs = arrayOfDepartmentsStudentToBelongs;
    }

    public static String[] getHelper() {
        return helper;
    }


    public static void setHelper(String[] helper) {
        Student.helper = helper;
    }

    public String getBelongsToTheDepartment() {
        return belongsToTheDepartment;
    }

    public void setBelongsToTheDepartment(String belongsToTheDepartment) {
        this.belongsToTheDepartment = belongsToTheDepartment;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    public Student(String name, int age, String position, int grades, int course, String faculty, int countOfFaculties) {
        super(name, age, position);
        this.setGrades(grades);
        this.setCourse(course);
        this.setPosition(position);
        this.setFaculty(faculty);
        arrayOfDepartmentsStudentToBelongs = new String[countOfFaculties];

    }

    public String getFaculty() {
        return faculty;
    }

    //геттери і сеттери для курсу студента
    public int getCourse() {
        return course;
    }


    // геттери і сеттери для оцінок
    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }


    //виведення інформації про об'єкт "Student"

    @Override
    public String toString() {
        return "Позиція: " + getPosition() + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Курс: " + getCourse() + "\n" +
                "Вік студента: " + getAge() + "\n" +
                "Середня оцінка: " + getGrades() + "\n" +
                "Факультет: " + getFaculty() + "\n" +
                "Кафедра: " + Arrays.toString(getArrayOfDepartmentsStudentToBelongs()) + "\n";
    }
}


class Lecturer extends Human {
    Lecturer(){

    }

    private String[] arrayOfDepartmentsLecturerToBelongs = new String[0];
    private String department;
    private String faculty;

    public Lecturer(String name, int age, String position, String faculty, int countOfDepartments) {
        super(name, age, position);
        this.department = department;
        this.faculty = faculty;
        arrayOfDepartmentsLecturerToBelongs = new String[countOfDepartments];
    }

    public String[] getArrayOfDepartmentsLecturerToBelongs() {
        return arrayOfDepartmentsLecturerToBelongs;
    }

    public void setArrayOfDepartmentsLecturerToBelongs(String[] arrayOfDepartmentsLecturerToBelongs) {
        this.arrayOfDepartmentsLecturerToBelongs = arrayOfDepartmentsLecturerToBelongs;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //виведення інформації про об'єкт "Teacher"
    @Override
    public String toString() {
        return "Позиція: " + getPosition() + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Вік викладача: " + getAge() + "\n" +
                "Факультет: " + getFaculty() + "\n" +
                "Кафедра: " + getDepartment() + "\n";
    }

}


