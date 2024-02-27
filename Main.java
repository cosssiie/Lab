//клас-виконавець

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        Menu.main(args); //вивід меню
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?\n");
        University university = new University(maxSize);

        int choose = DataInput.getInt("\nОберiть дiю: ");

        while (choose < 13) {
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

                    break;

                case 5:
                    //додавння студента
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
                    //додавання викладача
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
                        if (Department.getStudents()[i].getName().equals(nameOfStudent)) {
                            Department.deleteStudent(Department.getStudents()[i]);
                        }
                    }
                    break;
                case 8:
                    //видалити викладача
                    String nameOfLecturer = DataInput.getString("Введіть ім'я студента, якого хочете видалити: ");
                    for (int i = 0; i < Department.getLecturers().length; i++) {
                        if (Department.getLecturers()[i].getName().equals(nameOfLecturer)) {
                            Department.deleteLecturer(Department.getLecturers()[i]);
                        }
                    }
                    break;
                case 9:
                    //редагувати студента
                    nameOfStudent = DataInput.getString("Введіть ім'я студента, інформацію про якого хочете відредагувати: ");
                    for (int i = 0; i < Department.getStudents().length; i++) {
                        if (Department.getStudents()[i].getName().equals(nameOfStudent)) {
                            Department.editStudent(Department.getStudents()[i]);
                        }
                    }

                    break;
                case 10:
                    //редагувати викладача
                    nameOfLecturer = DataInput.getString("Введіть ім'я студента, інформацію про якого хочете відредагувати: ");
                    for (int i = 0; i < Department.getLecturers().length; i++) {
                        if (Department.getLecturers()[i].getName().equals(nameOfLecturer)) {
                            Department.editLecturer(Department.getLecturers()[i]);
                        }
                    }

                    break;

                case 11:

                    university.Faculties();
                    String facultyName = DataInput.getString("Введіть назву факультету: ");
                    faculty = university.findFacultyByName(facultyName);
                    if (faculty != null) {
                        String previousDepartmentName = DataInput.getString("Введіть попередню назву кафедри: ");
                        String newDepartmentName = DataInput.getString("Введіть нову назву кафедри: ");
                        faculty.editDepartment(previousDepartmentName, newDepartmentName);
                    } else {
                        System.out.println("Факультет з назвою " + facultyName + " не знайдено");
                    }
                    break;



                default:

                    break;
            }
            Menu.main(args); //вивід меню
            choose = DataInput.getInt("Оберiть дiю: ");


        }
    }


}