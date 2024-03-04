import java.io.IOException;

public class Department1 {
    //назва кафедри
    private String nameOfDepartment;
    //створюємо масив студентів типу Student
    private Student1[] studentsOfDepartment = new Student1[0];

    //створюємо масив викладачів типу Lecturer
    private Lecturer1[] lecturersOfDepartment = new Lecturer1[0];

    //створюємо масив усіх кафедр
    private Department1[] arrayOfDepartmentsOfCurrentDepartment = new Department1[0];

    private int[] arrayofID;

    public Department1(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }


    /**
     * @return
     */

    public Department1[] getArrayOfDepartmentsOfCurrentDepartment() {
        return arrayOfDepartmentsOfCurrentDepartment;
    }

    public void setArrayOfDepartmentsOfCurrentDepartment(Department1[] arrayOfDepartmentsOfCurrentDepartment) {
        this.arrayOfDepartmentsOfCurrentDepartment = arrayOfDepartmentsOfCurrentDepartment;
    }


    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public Student1[] getStudentsOfDepartment() {
        return studentsOfDepartment;
    }

    public void setStudentsOfDepartment(Student1[] studentsOfDepartment) {
        this.studentsOfDepartment = studentsOfDepartment;
    }

    public Lecturer1[] getLecturersOfDepartment() {
        return lecturersOfDepartment;
    }

    public void setLecturersOfDepartment(Lecturer1[] lecturersOfDepartment) {
        this.lecturersOfDepartment = lecturersOfDepartment;
    }

    /**
     *
     */


    //метод addStudent додає студента до студентів конкретної кафедри
    public void addStudentToDepartment(Student1 someStudent, Department1 department1) {
        boolean isFull = true;

        for (Student1 student : department1.studentsOfDepartment) {
            if (student == null) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Student1[] newStudent = new Student1[(department1.studentsOfDepartment.length + 1) * 2];
            for (int i = 0; i < department1.studentsOfDepartment.length; i++) {
                newStudent[i] = department1.studentsOfDepartment[i];
            }
            department1.studentsOfDepartment = newStudent;
        }
        // Додаємо елемент у масив
        for (int i = 0; i < department1.studentsOfDepartment.length; i++) {
            if (department1.studentsOfDepartment[i] == null) {
                department1.studentsOfDepartment[i] = someStudent;
                return;
            }
        }

    }


    //метод додає викладача до консктреної кафедри
    public void addLecturerToDepartment(Lecturer1 someLecturer, Department1 department1) {
        boolean isFull = true;

        for (Lecturer1 lecturer : department1.lecturersOfDepartment) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Lecturer1[] newLecturer = new Lecturer1[(department1.lecturersOfDepartment.length + 1) * 2];
            for (int i = 0; i < department1.lecturersOfDepartment.length; i++) {
                newLecturer[i] = department1.lecturersOfDepartment[i];
            }
            department1.lecturersOfDepartment = newLecturer;
        }
        // Додаємо елемент у масив
        for (int i = 0; i < department1.lecturersOfDepartment.length; i++) {
            if (department1.lecturersOfDepartment[i] == null) {
                department1.lecturersOfDepartment[i] = someLecturer;
                return;
            }
        }

    }

    public void deleteStudentsOfDepartment(int ID, Department1 department1) {

        for (int i = 0; i < studentsOfDepartment.length; i++) {
            if (studentsOfDepartment[i] != null) {

                if (studentsOfDepartment[i].getID() == ID) {
                    studentsOfDepartment[i] = null;
                }
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < studentsOfDepartment.length - 1; j++) {
                studentsOfDepartment[j] = studentsOfDepartment[j + 1];

            }
            studentsOfDepartment[studentsOfDepartment.length - 1] = null;
            break;
        }
    }


    public void deleteLecturerOfDepartment(int ID, Department1 department1) {

        for (int i = 0; i < lecturersOfDepartment.length; i++) {
            if (lecturersOfDepartment[i] != null) {
                if (lecturersOfDepartment[i].getID() == ID) {
                    lecturersOfDepartment[i] = null;
                }
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < lecturersOfDepartment.length - 1; j++) {
                lecturersOfDepartment[j] = lecturersOfDepartment[j + 1];

            }
            lecturersOfDepartment[lecturersOfDepartment.length - 1] = null;
            break;
        }
    }


}
