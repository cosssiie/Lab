//клас-виконавець

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu.main(args); //вивід меню
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?\n");
        University university = new University(maxSize);
        int choose = DataInput.getInt("Оберiть дiю: ");

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


                //додати студента
                case 5:
                    String name = DataInput.getString("Введіть ім'я студента: ");
                    int age = DataInput.getInt("Введіть вік студента: ");
                    String position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    int grade = DataInput.getInt("Введіть середню оцінку студента: ");
                    int course = DataInput.getInt("Введіть курс, на якрму навчається студент: ");
                    Student student = new Student(name, age, position, grade, course);
                    //додаємо студента в масив студентів
                    Department.addStudent(student);
                    System.out.println("Виводимо інфорамцію про доданого студента: ");
                    System.out.println(student);
                    System.out.println();
                    System.out.println("Виводимо масив студентів: ");
                    System.out.println(Arrays.toString(Department.getStudentsOdDepartment()));
                    System.out.println();

                    Faculty.addStudentsOfDepartmentToFaculty(Department.getStudentsOdDepartment(), Faculty.getStudentsOfFaculty());

                    System.out.println("Виводимо масив студентів факультету : " + Arrays.toString(Faculty.getStudentsOfFaculty()));
                    break;


                //доадти викладача
                case 6:
                    name = DataInput.getString("Введіть ім'я викладача: ");
                    age = DataInput.getInt("Введіть вік викладача: ");
                    position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    String nameOfDepartment = DataInput.getString("Введіть назву кафедри, до якої належить викладач: ");
                    Lecturer lecturer = new Lecturer(name, age, position, nameOfDepartment);

                    //додаємо викладача в масив викладачів
                    Department.addLecturer(lecturer);
                    System.out.println("Виводимо інфорамцію про доданого викладача: ");
                    System.out.println(lecturer);

                    System.out.println();

                    System.out.println("Виводимо масив викладачів: ");
                    System.out.println(Arrays.toString(Department.getLecturersOfDepartment()));
                    System.out.println();
                    Faculty.addLecturersOfDepartmentToFaculty(Department.getLecturersOfDepartment(), Faculty.getLecturerOfFaculty());

                    System.out.println("Виводимо масив викладачів факультету : " + Arrays.toString(Faculty.getLecturerOfFaculty()));

                    break;
                case 7:
                    //видалити студента
                    // Спочатку перевіряємо чи взагалі масив виклалдачів не пустий, щоб нам було що видаляти, якщо стається помилка і масив пустий,
                    // то виводимо відпрвідне повідомлення і виходимо з методу за дом=помогою return

                    if (Department.getStudentsOdDepartment().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого видаляти! ");
                        break;
                    }
                    String nameOfStudent = DataInput.getString("Введіть ім'я студента, якого хочете видалити: ");
                    for (int i = 0; i < Department.getStudentsOdDepartment().length; i++) {

                        if (Department.getStudentsOdDepartment()[i].getName().equals(nameOfStudent)) {

                            System.out.println("Виводимо інформацію про даного студента: ");
                            System.out.println(Department.getStudentsOdDepartment()[i]);
                            System.out.println();
                            //видаляємо студента спочатку на факультеті
                            Faculty.deleteStudentsOfFaculty(Department.getStudentsOdDepartment()[i]);
                            //видаляємо студента на кафедрі
                            Department.deleteStudent(Department.getStudentsOdDepartment()[i]);
                            System.out.println("Виводимо масив без цього студента: ");
                            System.out.println(Arrays.toString(Department.getStudentsOdDepartment()));


                            System.out.println("Виводимо масив студентів факультету: " + Arrays.toString(Faculty.getStudentsOfFaculty()));
                            break;
                        }
                    }
                    break;
                case 8:
                    //видалити викладача
                    if (Department.getLecturersOfDepartment().length == 0) {
                        System.out.println("Масив викладачів порожній, немає кого видаляти! ");
                        break;
                    }
                    String nameOfLecturer = DataInput.getString("Введіть ім'я викладача, якого хочете видалити: ");
                    for (int i = 0; i < Department.getLecturersOfDepartment().length; i++) {
                        if (Department.getLecturersOfDepartment()[i].getName().equals(nameOfLecturer)) {
                            System.out.println("Виводимо інформацію про даного викладача: ");
                            System.out.println(Department.getLecturersOfDepartment()[i]);
                            System.out.println();
                            //видаляємо виклаадча спочатку на факультеті
                            Faculty.deleteLecturerOfFaculty(Department.getLecturersOfDepartment()[i]);
                            //видаляємо викладача на кафедрі
                            Department.deleteLecturer(Department.getLecturersOfDepartment()[i]);
                            System.out.println("Виводимо масив без цього викладача: ");
                            System.out.println(Arrays.toString(Department.getLecturersOfDepartment()));
                            break;
                        }
                    }
                    break;
                case 9:
                    //редагувати студента

                    if (Department.getStudentsOdDepartment().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого редагувати! ");
                        break;
                    }

                    nameOfStudent = DataInput.getString("Введіть ім'я студента, інформацію про якого хочете відредагувати: ");
                    for (int i = 0; i < Department.getStudentsOdDepartment().length; i++) {
                        if (Department.getStudentsOdDepartment()[i].getName().equals(nameOfStudent)) {
                            System.out.println("Виводимо інформацію про даного студента: ");
                            System.out.println(Department.getStudentsOdDepartment()[i]);
                            System.out.println();
                            Department.editStudent(Department.getStudentsOdDepartment()[i]);
                            System.out.println("Виводимо відредаговану інформацію про цього студента: ");
                            System.out.println(Department.getStudentsOdDepartment()[i]);
                            Faculty.addStudentsOfDepartmentToFaculty(Department.getStudentsOdDepartment(), Faculty.getStudentsOfFaculty());
                            break;
                        }
                    }

                    break;
                case 10:
                    //редагувати викладача
                    if (Department.getLecturersOfDepartment().length == 0) {
                        System.out.println("Масив викладачів порожній, немає кого редагувати! ");
                        break;
                    }

                    nameOfLecturer = DataInput.getString("Введіть ім'я студента, інформацію про якого хочете відредагувати: ");
                    for (int i = 0; i < Department.getLecturersOfDepartment().length; i++) {
                        if (Department.getLecturersOfDepartment()[i].getName().equals(nameOfLecturer)) {
                            System.out.println("Виводимо інформацію про даного викладача: ");
                            System.out.println(Department.getLecturersOfDepartment()[i]);
                            System.out.println();
                            Department.editLecturer(Department.getLecturersOfDepartment()[i]);
                            System.out.println("Виводимо відредаговану інформацію про цього викладача: ");
                            System.out.println(Department.getLecturersOfDepartment()[i]);
                            break;
                        }
                    }

                case 11:
                    university.Faculties();
                    String facultyName = DataInput.getString("Введіть назву факультету: ");
                    faculty = university.findFacultyByName(facultyName);
                    if (faculty != null) {
                        String previousDepartmentName = DataInput.getString("Введіть попередню назву кафедри: ");
                        String newDepartmentName = DataInput.getString("Введіть нову назву кафедри: ");
                        faculty.editDepartment(previousDepartmentName, newDepartmentName);
                        System.out.println(facultyName);
                    } else {
                        System.out.println("Факультет з назвою " + facultyName + " не знайдено");
                    }
                    break;
            }
            Menu.main(args); //вивід меню
            choose = DataInput.getInt("Оберiть дiю: ");


        }
    }


}