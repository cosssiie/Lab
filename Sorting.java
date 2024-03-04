import java.util.Arrays;

public class Sorting {

    /*

    1.Вивести всіх студентів впорядкованих за курсами.
    2.Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.
    3.Вивести всіх студентів кафедри впорядкованих за курсами.
    4.Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.
    5.Вивести всіх студентів кафедри вказаного курсу.
    6.Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.

    **/

    // сортування 1
    public static void bubbleSortStudentsByCourse(Student1[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getCourse() > students[j + 1].getCourse()) {
                    // Міняємо місцями студентів, якщо курс першого більший за курс другого
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void printStudentsByCourse(Student1[] students) {
        System.out.println("Студенти відсортовані за курсами:");
        for (Student1 student : students) {
            System.out.println("Ім'я: " + student.getName() + ", Курс: " + student.getCourse() + ", Середній бал: " + student.getAverageGrade());
        }
    }

    //сортування 2
    public static void bubbleSortStudentsOfFacultyByName(String faculty, University1 university1) {
        String[] names = Faculty1.getNamesOfStudentsAndLecturers(university1, faculty); // Припустимо, що у факультету є метод, який повертає масив імен студентів і викладачів
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Замініть порівняння рядків на порівняння за іменами студентів або викладачів
                if (names[j].compareTo(names[j + 1]) > 0) {
                    // Переставляємо елементи, якщо вони не впорядку
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
    }

    public static void printStudentsOfFacultyByName(String faculty, University1 university1) {
        String[] names = Faculty1.getNamesOfStudentsAndLecturers(university1, faculty); // Припустимо, що у факультету є метод, який повертає масив імен студентів і викладачів
        for (String name : names) {
            System.out.println(name);
        }
    }


    //сортування 3
    public static void bubbleSortStudentsOfDepartmentByCourse(String department, University1 university1) {
        Student1[] students = new Student1[university1.getUniversityStudents().length];
        for (int i = 0; i < university1.getUniversityStudents().length; i++) {
            if (university1.getUniversityStudents()[i] != null) {
                for (int j = 0; j < (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length); j++) {
                    if (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs() != null) {
                        if (department.equals(university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j])) {
                            students[i] = university1.getUniversityStudents()[i];
                        }
                    }
                }
            }
        }

        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getCourse() > students[j + 1].getCourse()) {
                    // Переставляємо студентів, якщо вони не впорядку за курсом
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Студенти кафедри " + department + " впорядковані за курсами:");
        for (Student1 student : students) {
            System.out.println(student.getName() + " - " + student.getCourse() + " курс");
        }

    }


    // сортування 4    4.Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.
    public static void bubbleSortStudentsOfDepartmentByName(University1 university1, String department) {
        Student1[] students = new Student1[university1.getUniversityStudents().length];
        for (int i = 0; i < university1.getUniversityStudents().length; i++) {
            if (university1.getUniversityStudents()[i] != null) {
                for (int j = 0; j < (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length); j++) {
                    if (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs() != null) {
                        if (department.equals(university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j])) {
                            students[i] = university1.getUniversityStudents()[i];
                        }
                    }
                }
            }
        }

        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                    // Переставляємо елементи, якщо вони не впорядку
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Студенти кафедри " + department + ", відсортовані за алфавітом:");
        for (Student1 student : students) {
            System.out.println(student.getName());
        }
    }

    //сортування 5
    public void bubbleSortStudentsOfDepartmentByCourse(University1 university1, int course, String department) {
        Student1[] students = new Student1[university1.getUniversityStudents().length];
        for (int i = 0; i < university1.getUniversityStudents().length; i++) {
            if (university1.getUniversityStudents()[i] != null) {
                for (int j = 0; j < (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length); j++) {
                    if (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs() != null) {
                        if (department.equals(university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j])) {
                            students[i] = university1.getUniversityStudents()[i];
                        }
                    }
                }
            }
        }


        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getCourse() > students[j + 1].getCourse()) {
                    // Переставляємо елементи, якщо вони не впорядку
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Студенти кафедри " + department + " " + course + " курсу:");
        for (Student1 student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }


    //сортування 6
    public static void bubbleSortStudentsByName(University1 university1, int course, String department) {
        Student1[] students = new Student1[university1.getUniversityStudents().length];
        for (int i = 0; i < university1.getUniversityStudents().length; i++) {
            if (university1.getUniversityStudents()[i] != null) {
                for (int j = 0; j < (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length); j++) {
                    if (university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs() != null) {
                        if (department.equals(university1.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j])) {
                            students[i] = university1.getUniversityStudents()[i];
                        }
                    }
                }
            }
        }
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                    // Переставляємо елементи, якщо вони не впорядку
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Студенти кафедри " + department + " " + course + " курсу впорядковані за алфавітом:");

        // Відфільтруємо студентів за курсом
        Student1[] studentsByCourse = new Student1[0];
        for (Student1 student : students) {
            if (student.getCourse() == course) {
                studentsByCourse = Arrays.copyOf(studentsByCourse, studentsByCourse.length + 1);
                studentsByCourse[studentsByCourse.length - 1] = student;
            }
        }
        // Виводимо відсортованих студентів на екран
        for (Student1 student : studentsByCourse) {
            System.out.println(student.getName());
        }

    }

}




