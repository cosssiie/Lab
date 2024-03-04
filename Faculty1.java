import java.io.IOException;

public class Faculty1 {
    /**
     * ПОЛЯ
     */

    private Student1[] studentsOfFaculty = new Student1[0];
    private Lecturer1[] lecturerOfFaculty = new Lecturer1[0];

    private Faculty1[] arrayOfFacultiesOfFaculty = new Faculty1[0];

    private Department1[] arrayOfDepartmentsOfFaculty = new Department1[0];

    private String nameOfFaculty;

    public Faculty1(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    /**
     * ГЕТТЕРИ І СЕТТЕРИ
     */
    public Faculty1[] getArrayOfFacultiesOfFaculty() {
        return arrayOfFacultiesOfFaculty;
    }

    public void setArrayOfFacultiesOfFaculty(Faculty1[] arrayOfFacultiesOfFaculty) {
        this.arrayOfFacultiesOfFaculty = arrayOfFacultiesOfFaculty;
    }

    public Student1[] getStudentsOfFaculty() {
        return studentsOfFaculty;
    }

    public void setStudentsOfFaculty(Student1[] studentsOfFaculty) {
        this.studentsOfFaculty = studentsOfFaculty;
    }

    public Lecturer1[] getLecturerOfFaculty() {
        return lecturerOfFaculty;
    }

    public void setLecturerOfFaculty(Lecturer1[] lecturerOfFaculty) {
        this.lecturerOfFaculty = lecturerOfFaculty;
    }

    public Department1[] getArrayOfDepartmentsOfFaculty() {
        return arrayOfDepartmentsOfFaculty;
    }

    public void setArrayOfDepartmentsOfFaculty(Department1[] arrayOfDepartmentsOfFaculty) {
        this.arrayOfDepartmentsOfFaculty = arrayOfDepartmentsOfFaculty;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }


    /**
     * МЕТОДИ
     */


    //додаємо студента із масиву студентів кафедри до масиву студентів факультету
    public void addStudentsOfDepartmentToFaculty(Student1 someStudent) {
        for (Student1 student : studentsOfFaculty) {
            if (student != null && student.equals(someStudent)) {
                return;
            }
        }


        boolean isFull = true;

        for (Student1 student : studentsOfFaculty) {
            if (student == null) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Student1[] newStudent = new Student1[(studentsOfFaculty.length + 1) * 2];
            for (int i = 0; i < studentsOfFaculty.length; i++) {
                newStudent[i] = studentsOfFaculty[i];
            }
            studentsOfFaculty = newStudent;
        }

        for (int i = 0; i < studentsOfFaculty.length; i++) {
            if (studentsOfFaculty[i] == null) {
                studentsOfFaculty[i] = someStudent;
                return;
            }
        }

    }


    //додаємо викладача із масиву викладачів кафедри до масиву викладачів факультету
    public void addSLecturerOfDepartmentToFaculty(Lecturer1 someLecturer) {
        for (Lecturer1 lecturer : lecturerOfFaculty) {
            if (lecturer != null && lecturer.equals(someLecturer)) {
                return;
            }
        }


        boolean isFull = true;

        for (Lecturer1 lecturer : lecturerOfFaculty) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Lecturer1[] newLecturer = new Lecturer1[(lecturerOfFaculty.length + 1) * 2];
            for (int i = 0; i < lecturerOfFaculty.length; i++) {
                newLecturer[i] = lecturerOfFaculty[i];
            }
            lecturerOfFaculty = newLecturer;
        }

        for (int i = 0; i < lecturerOfFaculty.length; i++) {
            if (lecturerOfFaculty[i] == null) {
                lecturerOfFaculty[i] = someLecturer;
                return;
            }
        }

    }


    //видаляємо кафедру на факультету
    public void deleteDepartmentOfFaculty(Department1 department1) {
        boolean found = false;

        for (int i = 0; i < arrayOfDepartmentsOfFaculty.length; i++) {
            if (arrayOfDepartmentsOfFaculty[i] != null && arrayOfDepartmentsOfFaculty[i].equals(department1)) {
                found = true;
                arrayOfDepartmentsOfFaculty[i] = null;

                for (int j = i; j < arrayOfDepartmentsOfFaculty.length - 1; j++) {
                    arrayOfDepartmentsOfFaculty[j] = arrayOfDepartmentsOfFaculty[j + 1];
                }
                arrayOfDepartmentsOfFaculty[arrayOfDepartmentsOfFaculty.length - 1] = null;

                break;
            }
        }

    }


    //видаляємо факультет
    public void deleteFacultyOfFaculty(Faculty1 faculty1) {
        boolean found = false;
        for (int i = 0; i < arrayOfFacultiesOfFaculty.length; i++) {
            if (arrayOfFacultiesOfFaculty[i] != null && arrayOfFacultiesOfFaculty[i].equals(faculty1)) {
                found = true;
                arrayOfFacultiesOfFaculty[i] = null;

                for (int j = i; j < arrayOfFacultiesOfFaculty.length - 1; j++) {
                    arrayOfFacultiesOfFaculty[j] = arrayOfFacultiesOfFaculty[j + 1];
                }
                arrayOfFacultiesOfFaculty[arrayOfFacultiesOfFaculty.length - 1] = null;

                break;
            }
        }
    }


    //видаляємо викладача факультету
    public Lecturer1 deleteLecturerOfFaculty(int ID, Faculty1 faculty1) {
        Lecturer1 lecturer1 = null;
        for (int i = 0; i < lecturerOfFaculty.length; i++) {
            if (lecturerOfFaculty[i].getID() == ID) {
                lecturer1 = lecturerOfFaculty[i];
                lecturerOfFaculty[i] = null;
                break;
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < lecturerOfFaculty.length - 1; j++) {
                lecturerOfFaculty[j] = lecturerOfFaculty[j + 1];

            }
            lecturerOfFaculty[lecturerOfFaculty.length - 1] = null;
            break;
        }
        return lecturer1;
    }


    //видаляємо студента факультету
    public Student1 deleteStudentsOfFaculty(int ID, Faculty1 faculty1) {
        Student1 student1 = null;
        for (int i = 0; i < studentsOfFaculty.length; i++) {
            if(studentsOfFaculty[i]!=null) {
                if (studentsOfFaculty[i].getID() == ID) {
                    student1 = studentsOfFaculty[i];
                    studentsOfFaculty[i] = null;
                    break;
                }
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < studentsOfFaculty.length - 1; j++) {
                studentsOfFaculty[j] = studentsOfFaculty[j + 1];

            }
            studentsOfFaculty[studentsOfFaculty.length - 1] = null;
            break;
        }
        return student1;
    }


    // метод перевіряє чи присутні вже студенти в масиві студентів факультету
    private static boolean containsStudent(Student1[] students, Student1 target) {
        for (Student1 student : students) {
            if (student != null && student.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDepartment(Department1[] departmentsArray, Department1 department) {
        for (Department1 dept : departmentsArray) {
            if (dept != null && dept.equals(department)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLecturer(Lecturer1[] lecturersArray, Lecturer1 lecturer) {
        for (Lecturer1 l : lecturersArray) {
            if (l != null && l.equals(lecturer)) {
                return true;
            }
        }
        return false;
    }


    private int size;

    // Метод для створення кафедри з вказаною назвою
    public void createDepartment(String nameOfDepartment, String nameOfFaculty, University1 university1) {
        int facultyName = 0;
        for (int i = 0; i < university1.getUniversityFaculties().length; i++) {
            if (nameOfFaculty.equals(university1.getUniversityFaculties()[i].getNameOfFaculty())) {
                facultyName = i;
                break;
            }
        }

        boolean isFull = true;

        for (Department1 department1 : university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty) {
            if (department1 == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            Department1[] newDepartment1 = new Department1[(university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty.length + 1) * 2];
            for (int i = 0; i < university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty.length; i++) {
                newDepartment1[i] = university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty[i];
            }
            university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty = newDepartment1;


        }
        //додаємо елемент у масив
        for (int i = 0; i < university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty.length; i++) {
            if (university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty[i] == null) {
                university1.getUniversityFaculties()[facultyName].arrayOfDepartmentsOfFaculty[i] = new Department1(nameOfDepartment);
                return;
            }
        }
/*
        if (size < departments.length) {
            Department1 department = new Department1(nameOfDepartment);
            departments[size] = department;
            size++;
            System.out.println("Кафедра " + nameOfDepartment + " успiшно створена на факультетi " + nameOfFaculty);
        } else {
            System.out.println("Неможливо додати нову кафедру. Максимальна кiлькiсть досягнута");
        }

 */
    }

    // Метод для редагування кафедри з вказаною попередньою та новою назвою
    public void editDepartment(String previousName, String newName) {
        boolean departmentFound = false;

        // Шукаємо кафедру за попередньою назвою та редагуємо її, якщо знайдено
        for (int i = 0; i < arrayOfDepartmentsOfFaculty.length; i++) {
            if (arrayOfDepartmentsOfFaculty[i] != null && arrayOfDepartmentsOfFaculty[i].getNameOfDepartment().equals(previousName)) {
                departmentFound = true;
                arrayOfDepartmentsOfFaculty[i].setNameOfDepartment(newName);
                System.out.println("Назву кафедри \"" + previousName + "\" успішно змінено на \"" + newName + "\"");
                break;
            }
        }
        if (!departmentFound) {
            System.out.println("Кафедру з назвою \"" + previousName + "\" не знайдено!");
        }
    }

    //метод, для видалення кафедри
    public void deleteDepartment(String nameOfDepartment) {
        // Перевіряємо, чи масив кафедр не є порожнім
        if (arrayOfDepartmentsOfFaculty.length == 0) {
            System.out.println("Немає кафедр для видалення, масив кафедр порожній!");
            return;
        }
        boolean departmentFound = false;

        // Шукаємо кафедру за назвою та видаляємо її, якщо знайдено
        for (int i = 0; i < arrayOfDepartmentsOfFaculty.length; i++) {
            if (arrayOfDepartmentsOfFaculty[i] != null && arrayOfDepartmentsOfFaculty[i].getNameOfDepartment().equals(nameOfDepartment)) {
                departmentFound = true;
                arrayOfDepartmentsOfFaculty[i] = null;

                // Переставляємо всі наступні елементи масиву вліво, щоб заповнити порожні місця
                for (int j = i; j < arrayOfDepartmentsOfFaculty.length - 1; j++) {
                    arrayOfDepartmentsOfFaculty[j] = arrayOfDepartmentsOfFaculty[j + 1];
                }
                break;
            }
        }
        if (departmentFound) {
            System.out.println("Кафедру \"" + nameOfDepartment + "\" успішно видалено!");
        } else {
            System.out.println("Кафедру з назвою \"" + nameOfDepartment + "\" не знайдено!");
        }
    }

    public String[] arrayOfNamesOfStudentsAndLecturers;

    public static String[] getNamesOfStudentsAndLecturers(University1 university, String facultyName) {
        // Assuming University1 has methods to retrieve students and lecturers by faculty name
        String[] students = university.getStudentsByFaculty(facultyName);
        String[] lecturers = university.getLecturersByFaculty(facultyName);

        // Merge the arrays
        String[] combinedArray = mergeArrays(students, lecturers);

        return combinedArray;
    }

    private static String[] mergeArrays(String[] array1, String[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int combinedLength = length1 + length2;

        // If the combined length is more than double the length of one array, aggregate them to size 2
        if (combinedLength >= Math.max(length1, length2) * 2) {
            combinedLength = 2;
        }

        String[] mergedArray = new String[combinedLength];

        // Copy elements from the first array
        System.arraycopy(array1, 0, mergedArray, 0, Math.min(length1, combinedLength));

        // Copy elements from the second array
        int offset = Math.min(length1, combinedLength);
        System.arraycopy(array2, 0, mergedArray, offset, Math.min(length2, combinedLength - offset));

        return mergedArray;
    }


}
