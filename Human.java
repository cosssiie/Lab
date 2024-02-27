
class Human {

    //ім'я прізвище людини
    private String name;

    //вік людини
    private int age;


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
    private int grades;


    private int course;

    public Student(String name, int age, String position, int grades, int course) {
        super(name, age, position);
        this.grades = grades;
        this.course = course;
    }

    //геттери і сеттери для курсу студента
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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
                "Середня оцінка: " + getGrades();
    }
}



class Lecturer extends Human {
    private String department;

    public Lecturer(String name, int age, String position, String department) {
        super(name, age, position);
        this.department = department;
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
        return  "Позиція: " + getPosition() + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Вік викладача: " + getAge() + "\n" +
                "Посада: " +  getDepartment();
    }

}
