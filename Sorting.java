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
    public static void bubbleSortStudentsByCourseAndDisplay(Student1[] students) {
        int n = students.length;

        int actualLength = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] != null) {
                actualLength++;
            }
        }

        for (int i = 0; i < actualLength - 1; i++) {
            for (int j = 0; j < actualLength - i - 1; j++) {
                if (students[j].getCourse() > students[j + 1].getCourse()) {

                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }


        for (Student1 student : students) {
            if (student != null) {
                System.out.println(student.getName() + " - Курс: " + student.getCourse());
            } else {
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
    public static void displayStudentsSortedAlphabeticallyUsingBubbleSort(Student1[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students[j] == null || students[j + 1] == null) {
                    continue;
                }

                if (students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }



        // виводимо масив на екран
        for (Student1 student : students) {
            if (student != null) {
                System.out.println(student.getName() + " - курс: " + student.getCourse());
            } else {
            }
        }
    }

    public static void printLecturersSortedAlphabeticallyUsingBubbleSort(Lecturer1[] lecturers) {

        int n = lecturers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lecturers[j] == null || lecturers[j + 1] == null) {
                    continue;
                }
                if (lecturers[j].getName().compareTo(lecturers[j + 1].getName()) > 0) {
                    Lecturer1 temp = lecturers[j];
                    lecturers[j] = lecturers[j + 1];
                    lecturers[j + 1] = temp;
                }
            }
        }
        for (Lecturer1 lecturer : lecturers) {
            if (lecturer != null) {
                System.out.println("ім'я: " + lecturer.getName());
            }
        }
    }

    //сортування 3
    public static void displayStudentsSortedByCourseUsingBubbleSort(Student1[] students) {
        int n = students.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students[j] == null || students[j + 1] == null) {
                    continue;
                }

                if (students[j].getCourse() > students[j + 1].getCourse()) {
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        for (Student1 student : students) {
            if (student != null) {
                System.out.println(student.getName() + " - курс: " + student.getCourse());
            }
        }
    }


    // сортування 4    4.Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.
    public static void displayStudentsOfDepartmentSortedAlphabeticallyUsingBubbleSort(Student1[] students) {
        int n = students.length;


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students[j] == null || students[j + 1] == null) {
                    continue;
                }

                if (students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        for (Student1 student : students) {
            if (student != null) {
                System.out.println(student.getName() + " - курс: " + student.getCourse());
            }
        }
    }

    public static void displayLecturersOfDepartmentSortedAlphabeticallyUsingBubbleSort(Lecturer1[] lecturer1s) {
        int n = lecturer1s.length;


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (lecturer1s[j] == null || lecturer1s[j + 1] == null) {
                    continue;
                }

                if (lecturer1s[j].getName().compareTo(lecturer1s[j + 1].getName()) > 0) {
                    Lecturer1 temp = lecturer1s[j];
                    lecturer1s[j] = lecturer1s[j + 1];
                    lecturer1s[j + 1] = temp;
                }
            }
        }

        for (Lecturer1 lecturer1 : lecturer1s) {
            if (lecturer1 != null) {
                System.out.println(lecturer1.getName());
            }
        }
    }

    //сортування 5
    public static void displayStudentsOfSpecifiedCourseUsingBubbleSort(Student1[] students, int course) {
        int n = students.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students[j] == null || students[j + 1] == null) {
                    continue;
                }

                if (students[j].getCourse() != course && students[j + 1].getCourse() == course) {
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }


        for (Student1 student : students) {
            if (student != null && student.getCourse() == course) {
                System.out.println(student.getName() + " - курс: " + student.getCourse());
            }
        }
    }


    //сортування 6
    public static void displayStudentsOfSpecifiedCourseSortedAlphabeticallyUsingBubbleSort(Student1[] students, int course) {
        int n = students.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students[j] == null || students[j + 1] == null) {
                    continue;
                }

                if (students[j].getCourse() != course && students[j + 1].getCourse() == course) {
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (students[j] == null || students[j + 1] == null ||
                        students[j].getCourse() != course || students[j + 1].getCourse() != course) {
                    continue;
                }

                if (students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }


        for (Student1 student : students) {
            if (student != null && student.getCourse() == course) {
                System.out.println(student.getName() + " - курс: " + student.getCourse());
            }
        }
    }
}