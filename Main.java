//клас-виконавець

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?");
        University university = new University(maxSize);
        System.out.println("*************************************************************************");
        System.out.println("*   1. ~Додати факультет~                   5 ~Додати студента~         *");
        System.out.println("*   2. ~Редагувати факультет~               6 ~Додати викладача~        *");
        System.out.println("*   3. ~Видалити факультет~                 7 ~Видалити студента~       *");
        System.out.println("*   4. ~Додати кафедру до факультету~       8 ~Видалити викладача~      *");
        System.out.println("*   11. ~Вихiд~                             9 ~Редагувати студента~     *");
        System.out.println("*                                          10 ~Редагувати викладача~    *");
        System.out.println("*************************************************************************");

        int choose = DataInput.getInt("Оберiть дiю: ");

        while (choose < 12) {
            switch (choose) {
                case 1:

                    int count = DataInput.getInt("Скiльки хочете додати зараз?");
                    for (int i = 0; i < count; i++) {
                        String nameOfFaculty = DataInput.getString("Введiть назву факультету");
                        university.createFaculty(nameOfFaculty);
                    }
                    university.Faculties();

                    break;

                case 2:
                    university.Faculties();
                    String previousName = DataInput.getString("Попередня  назва факультету: ");
                    String newName = DataInput.getString("Нова назва факультету: ");
                    university.editFaculty(previousName, newName);
                    university.Faculties();

                    break;

                case 3:
                    university.Faculties();
                    String nameOfFaculty = DataInput.getString("Назва факультету, який хочете видалити");
                    university.deleteFaculty(nameOfFaculty);
                    university.Faculties();

                    break;

                case 4:
                    int departmentCount = DataInput.getInt("Кiлькiсть кафедр: ");
                    Faculty faculty = new Faculty(departmentCount);

                    count = DataInput.getInt("Скiльки хочете додати зараз?");
                    for (int i = 0; i < count; i++) {
                        String nameOfDepartment = DataInput.getString("Назва кафедри, яку хочете додати");
                        university.Faculties();
                        nameOfFaculty = DataInput.getString("Назва факультету, куди додати кафедру");
                        faculty.createDepartment(nameOfDepartment, nameOfFaculty);
                    }
//ілліо

                    break;

                case 5:

                    String name = DataInput.getString("Введіть ім'я студента: ");
                    int age = DataInput.getInt("Введіть вік студента: ");
                    String position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    int grade = DataInput.getInt("Введіть середню оцінку студента: ");
                    int course = DataInput.getInt("Введіть курс, на якрму навчається студент: ");
                    Student student = new Student(name, age, position, grade, course);
                    //додаємо студента в масив студентів
                    Department.addStudent(student);
                    System.out.println(Arrays.toString(Department.getStudents()));
                    break;

                case 6:
                    name = DataInput.getString("Введіть ім'я викладача: ");
                    age = DataInput.getInt("Введіть вік викладача: ");
                    position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    String nameOfDepartment = DataInput.getString("Введіть назву кафедри, до якої належить викладач: ");
                    Lecturer lecturer = new Lecturer(name, age, position, nameOfDepartment);

                    //додаємо викладача в масив викладачів
                    Department.addLecturer(lecturer);
                    break;
                case 7:
                    //видалити студента
                    String nameOfStudent = DataInput.getString("Введіть ім'я студента, якого хочете видалити: ");
                    for (int i = 0; i < Department.getStudents().length; i++) {
                        if (Department.getStudents()[i].getName() == nameOfStudent) {
                            Department.deleteStudent(Department.getStudents()[i]);
                        }
                    }
                    break;
                case 8:
                    //видалити викладача
                    String nameOfLecturer = DataInput.getString("Введіть ім'я студента, якого хочете видалити: ");
                    for (int i = 0; i < Department.getLecturers().length; i++) {
                        if (Department.getLecturers()[i].getName() == nameOfLecturer) {
                            Department.deleteLecturer(Department.getLecturers()[i]);
                        }
                    }
                    break;
                case 9:
                    //редагувати студента
                    nameOfStudent = DataInput.getString("Введіть ім'я студента, інформацію про якого хочете відредагувати: ");
                    for (int i = 0; i < Department.getStudents().length; i++) {
                        if (Department.getStudents()[i].getName() == nameOfStudent) {
                            Department.editStudent(Department.getStudents()[i]);
                        }
                    }

                    break;
                case 10:
                    //редагувати викладача
                    nameOfLecturer = DataInput.getString("Введіть ім'я студента, інформацію про якого хочете відредагувати: ");
                    for (int i = 0; i < Department.getLecturers().length; i++) {
                        if (Department.getLecturers()[i].getName() == nameOfLecturer) {
                            Department.editLecturer(Department.getLecturers()[i]);
                        }
                    }

                    break;


                default:

                    break;
            }
            choose = DataInput.getInt("Оберiть дiю: ");

        }
    }


}