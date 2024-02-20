import java.util.Arrays;

class Human {

    //ім'я прізвище людини
    private String name;

    //вік людини
    private int age;

    //посада людини, по типу: студент, викладач
    private String position;



    public Human(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // Getters and setters
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

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Student extends Human {
    private String[] grades;

    public Student(String name, int age, String position, String[] grades) {
        super(name, age, position);
        this.grades = grades;
    }

    // геттери і сеттери для оцінок
    public String[] getGrades() {
        return grades;
    }

    public void setGrades(String[] grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Студент: " + getName() + "\n" +
                "Середня оцінка: " + Arrays.toString(grades) + "\n" + ""  ;
    }
}

class Teacher extends Human {
    private String department;

    public Teacher(String name, int age, String position, String department) {
        super(name, age, position);
        this.department = department;
    }

    // Getter and setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}


