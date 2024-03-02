import java.util.Arrays;

public class Faculty {


    private  Student[] studentsOfFaculty = new Student[0];
    private Lecturer[] lecturerOfFaculty = new Lecturer[0];
    private Student[] newStudents = new Student[0];
    private Lecturer[] newLecturers = new Lecturer[0];

    private String nameOfFaculty;



    private  Department[] departments = new Department[0];
    //геттер для кафедри
    public Department[] getDepartments() {
        return departments;
    }



    private int size;

    public Faculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public Faculty(int departmentCount) {
        departments = new Department[departmentCount];
        size = 0;
    }

    public Student[] getStudentsOfFaculty() {
        return studentsOfFaculty;
    }

    public Lecturer[] getLecturerOfFaculty() {
        return lecturerOfFaculty;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    // Метод для створення кафедри з вказаною назвою
    public void createDepartment(String nameOfDepartment, String nameOfFaculty) {
        if (size < departments.length) {
            Department department = new Department(nameOfDepartment);
            departments[size] = department;
            size++;
            System.out.println("Кафедра " + nameOfDepartment + " успiшно створена на факультетi " + nameOfFaculty);
        } else {
            System.out.println("Неможливо додати нову кафедру. Максимальна кiлькiсть досягнута");
        }
    }

    // Метод для редагування кафедри з вказаною попередньою та новою назвою
    public void editDepartment(String previousName, String newName) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (departments[i].getNameOfDepartment().equals(previousName)) {
                departments[i].setNameOfDepartment(newName);
                found = true;
                System.out.println("Назву кафедри " + previousName + " успiшно змiнено на " + newName);
                break;
            }
        }
        if (!found) {
            System.out.println("Кафедра з назвою " + previousName + " не знайдена на факультеті " + nameOfFaculty);
        }
    }


    public void addStudentsOfDepartmentToFaculty(Student[] studentsOfDepartment, Student[] studentsOfFaculty) {
        boolean isFull = true;

        for (Student student : studentsOfFaculty) {
            if (student == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            newStudents = new Student[(studentsOfFaculty.length + 1) * 2];
            for (int i = 0; i < studentsOfDepartment.length; i++) {
                newStudents[i] = studentsOfDepartment[i];
            }
            this.studentsOfFaculty = newStudents;

        }


        for (Student student : studentsOfDepartment) {
            if (student != null && !containsStudent(studentsOfFaculty, student)) {
                for (int i = 0; i < studentsOfFaculty.length; i++) {
                    if (studentsOfFaculty[i] == null) {
                        studentsOfFaculty[i] = student;
                        break;
                    }
                }
            }
        }


    }

    public void addLecturersOfDepartmentToFaculty(Lecturer[] lecturersOfDepartment, Lecturer[] lecturersOfFaculty) {
        boolean isFull = true;

        for (Lecturer lecturer : lecturersOfFaculty) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            newLecturers = new Lecturer[(lecturersOfFaculty.length + 1) * 2];
            for (int i = 0; i < lecturersOfDepartment.length; i++) {
                newLecturers[i] = lecturersOfDepartment[i];
            }
            this.lecturerOfFaculty = newLecturers;

        }


        for (Lecturer lecturer : lecturersOfDepartment) {
            if (lecturer != null && !containsLecturer(lecturersOfFaculty, lecturer)) {
                for (int i = 0; i < lecturersOfFaculty.length; i++) {
                    if (lecturersOfFaculty[i] == null) {
                        lecturersOfFaculty[i] = lecturer;
                        break;
                    }
                }
            }
        }
    }

    //видаляємо студента факультету
    public void deleteStudentsOfFaculty(Student someStudent) {

        for (int i = 0; i < studentsOfFaculty.length; i++) {
            if (studentsOfFaculty[i].equals(someStudent)) {
                studentsOfFaculty[i] = null;
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < studentsOfFaculty.length - 1; j++) {
                studentsOfFaculty[j] = studentsOfFaculty[j + 1];

            }
            studentsOfFaculty[studentsOfFaculty.length - 1] = null;
            break;
        }
    }


    //видаляємо викладача факультету
    public void deleteLecturerOfFaculty(Lecturer someLecturer) {
        for (int i = 0; i < lecturerOfFaculty.length; i++) {
            if (lecturerOfFaculty[i].equals(someLecturer)) {
                lecturerOfFaculty[i] = null;
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < lecturerOfFaculty.length - 1; j++) {
                lecturerOfFaculty[j] = lecturerOfFaculty[j + 1];

            }
            lecturerOfFaculty[lecturerOfFaculty.length - 1] = null;
            break;
        }
    }


    // метод перевіряє чи присутні вже студенти в масиві студентів факультету
    private static boolean containsStudent(Student[] students, Student target) {
        for (Student student : students) {
            if (student != null && student.equals(target)) {
                return true;
            }
        }
        return false;
    }



    // метод перевіряє чи присутні вже студенти в масиві студентів факультету
    private static boolean containsLecturer(Lecturer[] lecturers, Lecturer target) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer != null && lecturer.equals(target)) {
                return true;
            }
        }
        return false;
    }


    // Інші методи вашого класу...
}