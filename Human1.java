import java.util.Arrays;

public class Human1 {
    /**
     * поля класу
     */
    private String name;
    private int age;
    public int ID = 0;

    private String position;

    /**
     * геттери і сеттери
     */


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
        while(age<0 || age > 100){
            age = DataInput.getInt("Ввеідіть правильний вік!");
        }
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    Human1(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.setID(ID++);
        this.position = position;
    }
}

class Student1 extends Human1 {

    private int averageGrade;
    private int course;


    private String faculty;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        while (averageGrade<0 || averageGrade>100){
            averageGrade = DataInput.getInt("Введіть правильний бал (0-100)");
        }
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        while (course<0 || course>4){
            course = DataInput.getInt("Введіть правильний курс(1-4): ");
        }
        this.course = course;
    }

    public String[] getArrayOfDepartmentsStudentToBelongs() {
        return arrayOfDepartmentsStudentToBelongs;
    }

    public void setArrayOfDepartmentsStudentToBelongs(String[] arrayOfDepartmentsStudentToBelongs) {
        this.arrayOfDepartmentsStudentToBelongs = arrayOfDepartmentsStudentToBelongs;
    }

    private String[] arrayOfDepartmentsStudentToBelongs;

    Student1(String name, int age, String position, int averageGrade, int course, String studentFaculty, int arraySize, int ID) {
        super(name, age, position);
        this.averageGrade = averageGrade;
        this.course = course;
        this.faculty = studentFaculty;
        this.ID = ID;
        arrayOfDepartmentsStudentToBelongs = new String[arraySize];
    }


    @Override
    public String toString() {
        return "Позиція: " + getPosition() + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Курс: " + getCourse() + "\n" +
                "Вік студента: " + getAge() + "\n" +
                "Середня оцінка: " + getAverageGrade() + "\n" +
                "Факультет: " + getFaculty() + "\n" +
                "ID: " + getID() + "\n" +
                "Кафедра: " + Arrays.toString(getArrayOfDepartmentsStudentToBelongs()) + "\n";
    }
}


class Lecturer1 extends Human1 {
    private String[] arrayOfDepartmentsLecturerToBelongs = new String[0];

    private String faculty;


    public String[] getArrayOfDepartmentsLecturerToBelongs() {
        return arrayOfDepartmentsLecturerToBelongs;
    }
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setArrayOfDepartmentsLecturerToBelongs(String[] arrayOfDepartmentsLecturerToBelongs) {
        this.arrayOfDepartmentsLecturerToBelongs = arrayOfDepartmentsLecturerToBelongs;
    }


    Lecturer1(String name, int age, String position, int arraySize,String faculty, int ID) {
        super(name, age, position);
        this.arrayOfDepartmentsLecturerToBelongs = new String[arraySize];
        this.faculty = faculty;
        this.ID = ID;
    }

    //виведення інформації про об'єкт "Lecturer"
    @Override
    public String toString() {
        return "Позиція: " + getPosition() + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Вік викладача: " + getAge() + "\n" +
                "Факультет викладача: " + getFaculty() + "\n" +
                "ID викладача: " + getID() + "\n" +
                "Кафедра: " + Arrays.toString(getArrayOfDepartmentsLecturerToBelongs()) + "\n";
    }
}