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
                    //перевірка, чи були створені кафедри

                  /*
                    if (Faculty.getDepartments().length == 0) {
                        System.out.println("На жаль, жодної кафедри ще не було додано до списку, створіть спочатку кафедру, а потім додавайте студента!");
                        break;
                    }

                   */

                    String name = DataInput.getString("Введіть ім'я студента: ");
                    int age = DataInput.getInt("Введіть вік студента: ");
                    String position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    int grade = DataInput.getInt("Введіть середню оцінку студента: ");
                    int course = DataInput.getInt("Введіть курс, на якому навчається студент: ");
                    String studentFaculty = DataInput.getString("Введіть факультет, на якому навчаєтьcя студент: ");

                    int nameOfFacultyWhatINeed = 0;
                    boolean facultyIsPresent = false;
                    while (!facultyIsPresent) {
                        for (int i = 0; i < new University().getFaculties().length; i++) {
                            if (studentFaculty.equals(new University().getFaculties()[i].getNameOfFaculty())) {
                                nameOfFacultyWhatINeed = i;
                                facultyIsPresent = true;
                                break;
                            }
                        }
                        if (!facultyIsPresent) {
                            studentFaculty = DataInput.getString("Факультете введено неправильно, введіть факультет, на якому навчаєтьcя студент: ");
                        }
                    }
                    int countOdDepartments = DataInput.getInt("Введіть кількість кафедр, до яких належить студент: ");


                    /**
                     * СТВОРЕННЯ ОБ'ЄКТА НАШОГО СТУДЕНТА
                     **/
                    Student student = new Student(name, age, position, grade, course, studentFaculty, countOdDepartments);


                    //перевірка, щоб введена нами кількість кафедр вміщалася у кількість кафедр факультету
                    if (countOdDepartments > University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length) {
                        System.out.println("На факультеті існує всього " + University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length + " кафедр!");
                        break;
                    }

                    //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                    for (int i = 0; i < countOdDepartments; i++) {
                        String f = DataInput.getString("Введіть кафедру, до якої належить студент: ");
                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length; j++) {
                                if (f.equals(University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[j].getNameOfDepartment())) {
                                    student.getArrayOfDepartmentsStudentToBelongs()[i] = f;
                                    isBelongsTo = true;
                                }
                            }
                            if (!isBelongsTo) {
                                f = DataInput.getString("Кафедру введено неправильно, введіть кафедру, на якому навчаєтьcя студент: ");
                            }
                        }

                        //додаємо до масиву університету студента


                    }


                    //додаємо студента в масив студентів кафедр
                    for (int i = 0; i < countOdDepartments; i++) {
                        University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i].addStudent(student);

                    }

                    System.out.println("Виводимо інфорамцію про доданого студента: ");
                    System.out.println(student);
                    System.out.println();

                    for (int i = 0; i < countOdDepartments; i++) {
                        System.out.println("Виводимо масив студентів кафедри: " + University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i]);
                        System.out.println(Arrays.toString(University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i].getStudentsOdDepartment()));
                        System.out.println();

                    }


                    //додаємо студента до студентів факультету
                    for (int i = 0; i < countOdDepartments; i++) {
                        University.getFaculties()[nameOfFacultyWhatINeed].addStudentsOfDepartmentToFaculty(University.getFaculties()[nameOfFacultyWhatINeed].getStudentsOfFaculty(), University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i].getStudentsOdDepartment());
                    }

                    System.out.println("Виводимо масив студентів факультету : " + Arrays.toString(University.getFaculties()[nameOfFacultyWhatINeed].getStudentsOfFaculty()));
                    break;


                //доадти викладача
                case 6:
                    /*
                    if (University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length == 0) {
                        System.out.println("На жаль, жодної кафедри ще не було додано до списку, створіть спочатку кафедру, а потім додавайте викладача!");
                        break;
                    }
                     */

                    name = DataInput.getString("Введіть ім'я викладача: ");
                    age = DataInput.getInt("Введіть вік викладача: ");
                    position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    String lecturerFaculty = DataInput.getString("Введіть назву факультету, до якого належить викладач: ");

                    nameOfFacultyWhatINeed = 0;
                    facultyIsPresent = false;
                    while (!facultyIsPresent) {
                        for (int i = 0; i < new University().getFaculties().length; i++) {
                            if (lecturerFaculty.equals(new University().getFaculties()[i].getNameOfFaculty())) {
                                nameOfFacultyWhatINeed = i;
                                facultyIsPresent = true;
                                break;
                            }
                        }
                        if (!facultyIsPresent) {
                            lecturerFaculty = DataInput.getString("Факультет введено неправильно, введіть факультет, до якого належить виклдач: ");
                        }
                    }
                    countOdDepartments = DataInput.getInt("Введіть кількість кафедр, до яких належить викладач: ");


/**
 * СТВОРЕННЯ ОБ'ЄКТА НАШОГО ВИКЛАДАЧА
 **/
                    Lecturer lecturer = new Lecturer(name, age, position, lecturerFaculty, countOdDepartments);


                    //перевірка, щоб введена нами кількість кафедр вміщалася у кількість кафедр факультету
                    if (countOdDepartments > University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length) {
                        System.out.println("На факультеті існує всього " + University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length + " кафедр!");
                        break;
                    }

                    //додаємо назви кафедр до масифу кафедр викладача, до яких він належить

                    for (int i = 0; i < countOdDepartments; i++) {
                        String f = DataInput.getString("Введіть кафедру, до якої належить викладач: ");
                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < University.getFaculties()[nameOfFacultyWhatINeed].getDepartments().length; j++) {
                                if (f.equals(University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[j].getNameOfDepartment())) {
                                    lecturer.getArrayOfDepartmentsLecturerToBelongs()[i] = f;
                                    isBelongsTo = true;
                                }
                            }
                            if (!isBelongsTo) {
                                f = DataInput.getString("Кафедру введено неправильно, введіть кафедру, на якому викладає лектор: ");
                            }
                        }

                        //додаємо до масиву університету викладача


                    }

                    //додаємо викладача в масив викладачів кафедр
                    for (int i = 0; i < countOdDepartments; i++) {
                        University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i].addLecturer(lecturer);

                    }

                    System.out.println("Виводимо інфорамцію про доданого викладача: ");
                    System.out.println(lecturer);
                    System.out.println();


                    for (int i = 0; i < countOdDepartments; i++) {
                        System.out.println("Виводимо масив викладачів кафедри: " + University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i]);
                        System.out.println(Arrays.toString(University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i].getLecturersOfDepartment()));
                        System.out.println();

                    }


                    //додаємо студента до студентів факультету
                    for (int i = 0; i < countOdDepartments; i++) {
                        University.getFaculties()[nameOfFacultyWhatINeed].addLecturersOfDepartmentToFaculty(University.getFaculties()[nameOfFacultyWhatINeed].getLecturerOfFaculty(), University.getFaculties()[nameOfFacultyWhatINeed].getDepartments()[i].getLecturersOfDepartment());
                    }

                    System.out.println("Виводимо масив викладачів факультету : " + Arrays.toString(University.getFaculties()[nameOfFacultyWhatINeed].getLecturerOfFaculty()));
                    break;


                case 7:
                    //видалити студента
                    // Спочатку перевіряємо чи взагалі масив студентів не пустий, щоб нам було що видаляти, якщо стається помилка і масив пустий,
                    // то виводимо відповідне повідомлення і виходимо з методу за допомогою break

                    if (University.getUniversityStudents().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого видаляти! ");
                        break;
                    }


                    String nameOfStudent = DataInput.getString("Введіть ім'я студента, якого хочете видалити: ");
                    String facultyOfStudent = DataInput.getString("Введіть факультет студента, на якому він навчається: ");
                    String departmentOfStudent = DataInput.getString("Введіть кафедру студента, на якій він навчається: ");
                    for (int i = 0; i < University.getFaculties().length; i++) {
                        if (University.getFaculties()[i].equals(facultyOfStudent)) {
                            for (int j = 0; j < University.getFaculties()[i].getDepartments().length; j++) {
                                if (University.getFaculties()[i].getDepartments()[j].equals(departmentOfStudent)) {
                                    for (int k = 0; k < University.getFaculties()[i].getDepartments()[j].getStudentsOdDepartment().length; k++) {
                                        if (University.getFaculties()[i].getDepartments()[j].getStudentsOdDepartment()[k].getName().equals(nameOfStudent)) {
                                            University.getFaculties()[i].getDepartments()[j].deleteStudent(University.getFaculties()[i].getDepartments()[j].getStudentsOdDepartment()[k]);
                                            for (int l = 0; l < University.getUniversityStudents().length; l++) {
                                                if (University.getUniversityStudents()[k].getName().equals(nameOfStudent)) {
                                                    University.deleteStudentsOfUniversiyt(University.getUniversityStudents()[k]);
                                                    break;
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }

                    }

                    break;
                case 8:
                    //видалити викладача

                    if (University.getUniversityStudents().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого видаляти! ");
                        break;
                    }

                    String nameOfLecturer = DataInput.getString("Введіть ім'я фикладача, якого хочете видалити: ");
                    String facultyOfLecturer = DataInput.getString("Введіть факультет викладача: ");
                    String departmentOfLecturer = DataInput.getString("Введіть кафедру викладача: ");
                    for (int i = 0; i < University.getFaculties().length; i++) {
                        if (University.getFaculties()[i].equals(facultyOfLecturer)) {
                            for (int j = 0; j < University.getFaculties()[i].getDepartments().length; j++) {
                                if (University.getFaculties()[i].getDepartments()[j].equals(departmentOfLecturer)) {
                                    for (int k = 0; k < University.getFaculties()[i].getDepartments()[j].getLecturersOfDepartment().length; k++) {
                                        if (University.getFaculties()[i].getDepartments()[j].getLecturersOfDepartment()[k].getName().equals(nameOfLecturer)) {
                                            University.getFaculties()[i].getDepartments()[j].deleteLecturer(University.getFaculties()[i].getDepartments()[j].getLecturersOfDepartment()[k]);
                                            for (int l = 0; l < University.getUniversityLecturers().length; l++) {
                                                if (University.getUniversityLecturers()[k].getName().equals(nameOfLecturer)) {
                                                    University.deleteLecturerOfUniversity(University.getUniversityLecturers()[k]);
                                                    break;
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }

                    }

                    break;
                case 9:
                    //редагувати студента

                    if (University.getUniversityStudents().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого редагувати! ");
                        break;
                    }
                    nameOfStudent = DataInput.getString("Введіть ім'я студента, якого хочете відредагувати: ");
                    facultyOfStudent = DataInput.getString("Введіть факультет студента, на якому він навчається: ");
                    departmentOfStudent = DataInput.getString("Введіть кафедру студента, на якій він навчається: ");
                    for (int i = 0; i < University.getFaculties().length; i++) {
                        if (University.getFaculties()[i].equals(facultyOfStudent)) {
                            for (int j = 0; j < University.getFaculties()[i].getDepartments().length; j++) {
                                if (University.getFaculties()[i].getDepartments()[j].equals(departmentOfStudent)) {
                                    for (int k = 0; k < University.getFaculties()[i].getDepartments()[j].getStudentsOdDepartment().length; k++) {
                                        if (University.getFaculties()[i].getDepartments()[j].getStudentsOdDepartment()[k].getName().equals(nameOfStudent)) {
                                            University.getFaculties()[i].getDepartments()[j].editStudent(University.getFaculties()[i].getDepartments()[j].getStudentsOdDepartment()[k]);
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                    }


                    break;
                case 10:
                    //редагувати викладача
                    if (University.getUniversityStudents().length == 0) {
                        System.out.println("Масив викладачів порожній, немає кого редагувати! ");
                        break;
                    }

                    nameOfLecturer = DataInput.getString("Введіть ім'я фикладача, якого хочете відредагувати: ");
                    facultyOfLecturer = DataInput.getString("Введіть факультет викладача: ");
                    departmentOfLecturer = DataInput.getString("Введіть кафедру викладача: ");
                    for (int i = 0; i < University.getFaculties().length; i++) {
                        if (University.getFaculties()[i].equals(facultyOfLecturer)) {
                            for (int j = 0; j < University.getFaculties()[i].getDepartments().length; j++) {
                                if (University.getFaculties()[i].getDepartments()[j].equals(departmentOfLecturer)) {
                                    for (int k = 0; k < University.getFaculties()[i].getDepartments()[j].getLecturersOfDepartment().length; k++) {
                                        if (University.getFaculties()[i].getDepartments()[j].getLecturersOfDepartment()[k].getName().equals(nameOfLecturer)) {
                                            University.getFaculties()[i].getDepartments()[j].editLecturer(University.getFaculties()[i].getDepartments()[j].getLecturersOfDepartment()[k]);
                                            break;
                                        }
                                    }
                                }
                            }
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