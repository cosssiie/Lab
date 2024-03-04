import java.io.IOException;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Menu.main(args); //вивід меню
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?\n");
        University1 university = new University1(maxSize);
        int choose = DataInput.getInt("Оберiть дiю: ");
        int ID = 0;

        while (choose < 14) {
            switch (choose) {
                case 1:

                    int count = DataInput.getInt("Скiльки хочете додати зараз?");
                    for (int i = 0; i < count; i++) {
                        String nameOfFaculty = DataInput.getString("Введiть назву факультету");
                        university.createFaculty(nameOfFaculty, university);
                    }

                    System.out.println("Виводимо на екран щойно додані факультети: ");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Виводимо список фаультетів");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty());
                        }
                    }

                    String previousName = DataInput.getString("Попередня назва факультету: ");
                    String newName = DataInput.getString("Нова назва факультету: ");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(previousName)) {
                                university.getUniversityFaculties()[i].setNameOfFaculty(newName);
                            }
                        }
                    }
                    System.out.println("Ім'я факультету було успішно змінено на " + newName);
                    System.out.println();
                    System.out.println("Виводимо на екран оновлений список факультетів");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty());
                        }
                    }


                    break;
                case 3:
                    System.out.println("Виводимо список фаультетів");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty());
                        }
                    }

                    String nameOfFaculty = DataInput.getString("Назва факультету, який хочете видалити");
                    university.deleteFaculty(nameOfFaculty);
                    System.out.println("Виводимо на екран оновлений список факультетів");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty());
                        }
                    }


                    break;

                case 4:

                    count = DataInput.getInt("Скiльки хочете додати кафедр зараз?");

                    for (int i = 0; i < count; i++) {
                        String nameOfDepartment = DataInput.getString("Назва кафедри, яку хочете додати");


                        System.out.println("Виводимо список факультетів: ");
                        for (int j = 0; j < university.getUniversityFaculties().length; j++) {
                            if (university.getUniversityFaculties()[j] != null) {
                                System.out.println((j + 1) + ".: " + university.getUniversityFaculties()[j].getNameOfFaculty());
                            }
                        }


                        nameOfFaculty = DataInput.getString("Назва факультету, куди додати кафедру");

                        int nameFaculty = 0;
                        for (int j = 0; j < university.getUniversityFaculties().length; j++) {
                            if (university.getUniversityFaculties()[j] != null) {
                                if (nameOfFaculty.equals(university.getUniversityFaculties()[j].getNameOfFaculty())) {
                                    nameFaculty = j;
                                    break;
                                }
                            }
                        }

                        university.getUniversityFaculties()[nameFaculty].createDepartment(nameOfDepartment, nameOfFaculty, university);
                        for (int j = 0; j < university.getUniversityFaculties()[nameFaculty].getArrayOfDepartmentsOfFaculty().length; j++) {
                            if (university.getUniversityFaculties()[nameFaculty].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                university.addDepartmentsOfFacultyToUniversity(university.getUniversityFaculties()[nameFaculty].getArrayOfDepartmentsOfFaculty()[j]);
                            }
                        }

                    }

                    System.out.println("Виводимо на екран щойно створені кафедри і факультети, до яких вони належать");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                    System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty() + ": ");
                                    System.out.println(university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].getNameOfDepartment());
                                    System.out.println();
                                }

                            }
                        }
                    }

                    System.out.println("Виводимо на екран усі кафедри університету");
                    for (int i = 0; i < university.getUniversityDepartments().length; i++) {
                        if (university.getUniversityDepartments()[i] != null) {
                            System.out.println(university.getUniversityDepartments()[i].getNameOfDepartment());
                        }
                    }

                    //додаємо кафедри факультету до кафедр університету
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                    university.addDepartmentsOfFacultyToUniversity(university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                }
                            }

                        }
                    }
                    /**
                     * ТЕСТИ
                     */
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println("Виводимо усі кафедри факультету");
                            System.out.println("*" + university.getUniversityFaculties()[i].getNameOfFaculty());
                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                    System.out.println(university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].getNameOfDepartment());
                                }
                            }
                        }
                    }


                    break;
                //додати студента
                case 5:
                    //перевірка, чи були створені кафедри


                    if (university.getUniversityDepartments().length == 0) {
                        System.out.println("На жаль, жодної кафедри ще не було додано до списку, створіть спочатку кафедру, а потім додавайте студента!");
                        break;
                    }


                    String name = DataInput.getString("Введіть ім'я студента: ");

                    int age = DataInput.getInt("Введіть вік студента: ");
                    while (age < 0 || age > 100) {
                        age = DataInput.getInt("Введіть вік студента(0-100): ");
                    }

                    String position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    while (true) {
                        if (position.equals("лектор")) {
                            break;
                        }
                        if (position.equals("студент")) {
                            break;
                        }
                        position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    }
                    int grade = DataInput.getInt("Введіть середню оцінку студента: ");
                    while (grade < 0 || grade > 100) {
                        grade = DataInput.getInt("Введіть середню оцінку студента (від 0 до 100): ");
                    }

                    int course = DataInput.getInt("Введіть курс, на якому навчається студент: ");
                    while (course < 1 || course > 4) {
                        course = DataInput.getInt("Введіть курс, на якому навчається студент (1-4): ");
                    }

                    String studentFaculty = DataInput.getString("Введіть факультет, на якому навчаєтьcя студент: ");

                    int nameOfFacultyWhatINeed = 0;
                    boolean facultyIsPresent = false;
                    while (!facultyIsPresent) {
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (studentFaculty.equals(university.getUniversityFaculties()[i].getNameOfFaculty())) {
                                    nameOfFacultyWhatINeed = i;
                                    facultyIsPresent = true;
                                    break;
                                }
                            }
                        }
                        if (!facultyIsPresent) {
                            studentFaculty = DataInput.getString("Факультете введено неправильно, введіть факультет, на якому навчаєтьcя студент: ");
                        }
                    }
                    int countOdDepartments = DataInput.getInt("Введіть кількість кафедр, до яких належить студент: ");


                    /**
                     * * СТВОРЕННЯ ОБ'ЄКТА НАШОГО СТУДЕНТА
                     **/
                    Student1 student = new Student1(name, age, position, grade, course, studentFaculty, countOdDepartments, ID++);


                    //перевірка, щоб введена нами кількість кафедр вміщалася у кількість кафедр факультету
                    int freeSpace = 0;
                    for (int i = 0; i < university.getUniversityDepartments().length; i++) {
                        if (university.getUniversityDepartments()[i] != null) {
                            freeSpace++;
                        }
                    }

                    if (countOdDepartments > freeSpace) {
                        System.out.println("На факультеті існує всього " + freeSpace + " кафедр!");
                        break;
                    }

                    /**
                     * Виводимо кафедри, які достуепні для обрання студентом
                     */

                    System.out.println("Кафедри, які доступні для обрання студентом");
                    for (int i = 0; i < university.getUniversityDepartments().length; i++) {
                        if (university.getUniversityDepartments()[i] != null) {
                            System.out.print(university.getUniversityDepartments()[i].getNameOfDepartment() + " |*| ");
                        }
                    }
                    System.out.println();


                    //додаємо назви кафедр до масифу кафедр студента, до яких він належить
                    for (int i = 0; i < countOdDepartments; i++) {
                        String f = DataInput.getString("Введіть кафедру, до якої належить студент: ");
                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[i] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                            if (!isBelongsTo) {
                                f = DataInput.getString("Кафедру введено неправильно, введіть кафедру, на якому навчаєтьcя студент: ");
                            }
                        }

                    }
/**
 *
 */

                    //додаємо студента в масив студентів кафедр
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                    for (int k = 0; k < student.getArrayOfDepartmentsStudentToBelongs().length; k++) {
                                        if (student.getArrayOfDepartmentsStudentToBelongs()[k] != null) {
                                            if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].getNameOfDepartment().equals(student.getArrayOfDepartmentsStudentToBelongs()[k])) {
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(student, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }


                    System.out.println("Виводимо інфорамцію про доданого студента: ");
                    System.out.println(student);
                    System.out.println();

                    //додаємо студентів кафедри в масив студентів факультету
                    for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                        if (university.getUniversityFaculties()[k] != null) {
                            if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(studentFaculty)) {
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                break;
                            }
                        }
                    }

                    //додаємо студента в масив студентів університету
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(studentFaculty)) {
                                university.addStudentsOfFacultyToUniversity(student, university);
                                break;
                            }
                        }
                    }


                    System.out.println("Виводимо масив студентів факультету");
                    for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                        if (university.getUniversityFaculties()[k] != null) {
                            System.out.println(university.getUniversityFaculties()[k].getNameOfFaculty());
                            System.out.println(Arrays.toString(university.getUniversityFaculties()[k].getStudentsOfFaculty()));
                        }
                    }
                    System.out.println("Виводимо масив студентів університету: ");
                    System.out.println(Arrays.toString(university.getUniversityStudents()) + "\n");
                    break;
                //додати викладача
                case 6:
                    name = DataInput.getString("Введіть ім'я викладача: ");
                    age = DataInput.getInt("Введіть вік викладача: ");
                    position = DataInput.getString("Введіть посаду <студент/лектор>: ");
                    while (true) {
                        if (position.equals("лектор")) {
                            break;
                        }
                        if (position.equals("студент")) {
                            break;
                        }
                        position = DataInput.getString("Введіть посаду <студент/летор>: ");
                    }


                    String lecturerFaculty = DataInput.getString("Введіть назву факультету, до якого належить викладач: ");

                    nameOfFacultyWhatINeed = 0;
                    facultyIsPresent = false;
                    while (!facultyIsPresent) {
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (lecturerFaculty.equals(university.getUniversityFaculties()[i].getNameOfFaculty())) {
                                    nameOfFacultyWhatINeed = i;
                                    facultyIsPresent = true;
                                    break;
                                }
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
                    Lecturer1 lecturer = new Lecturer1(name, age, position, countOdDepartments, lecturerFaculty, ID++);


                    //перевірка, щоб введена нами кількість кафедр вміщалася у кількість кафедр факультету
                    freeSpace = 0;
                    for (int i = 0; i < university.getUniversityDepartments().length; i++) {
                        if (university.getUniversityDepartments()[i] != null) {
                            System.out.print(university.getUniversityDepartments()[i].getNameOfDepartment() + " |*| ");
                            freeSpace++;
                        }
                    }
                    System.out.println();

                    if (countOdDepartments > freeSpace) {
                        System.out.println("На факультеті існує всього " + freeSpace + " кафедр!");
                        break;
                    }


                    //додаємо назви кафедр до масифу кафедр викладачі, до яких він належить
                    for (int i = 0; i < countOdDepartments; i++) {
                        String f = DataInput.getString("Введіть кафедру, до якої належить викладач: ");
                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[i] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                            if (!isBelongsTo) {
                                f = DataInput.getString("Кафедру введено неправильно, введіть кафедру, на якій викладає викладач: ");
                            }
                        }

                    }
/**
 *
 */

                    //додаємо викладача в масив викладачів кафедр
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                    for (int k = 0; k < lecturer.getArrayOfDepartmentsLecturerToBelongs().length; k++) {
                                        if (lecturer.getArrayOfDepartmentsLecturerToBelongs()[k] != null) {
                                            if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].getNameOfDepartment().equals(lecturer.getArrayOfDepartmentsLecturerToBelongs()[k])) {
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addLecturerToDepartment(lecturer, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }


                    System.out.println("Виводимо інфорамцію про доданого студента: ");
                    System.out.println(lecturer);
                    System.out.println();

                    //додаємо студентів кафедри в масив студентів факультету
                    for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                        if (university.getUniversityFaculties()[k] != null) {
                            if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturerFaculty)) {
                                university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                break;
                            }
                        }
                    }

                    //додаємо викладача в масив викладачів університету
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturerFaculty)) {
                                university.addLecturersOfFacultyToUniversity(lecturer, university);
                                break;
                            }
                        }
                    }


                    System.out.println("Виводимо масив викладачів факультету");
                    for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                        if (university.getUniversityFaculties()[k] != null) {
                            System.out.println(university.getUniversityFaculties()[k].getNameOfFaculty());
                            System.out.println(Arrays.toString(university.getUniversityFaculties()[k].getLecturerOfFaculty()));
                        }
                    }
                    System.out.println("Виводимо масив викладачів університету: ");
                    System.out.println(Arrays.toString(university.getUniversityLecturers()) + "\n");
                    break;


                case 7:
                    //видалити студента
                    // Спочатку перевіряємо чи взагалі масив студентів не пустий, щоб нам було що видаляти, якщо стається помилка і масив пустий,
                    // то виводимо відповідне повідомлення і виходимо з методу за допомогою break

                    if (university.getUniversityStudents().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого видаляти! ");
                        break;
                    }

                    int IDtoDelete = DataInput.getInt("Введіть ID студента, якого хочете видалити: ");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            university.deleteStudentsOfUniversity(IDtoDelete);
                            university.getUniversityFaculties()[i].deleteStudentsOfFaculty(IDtoDelete, university.getUniversityFaculties()[i]);
                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
                                    university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].deleteStudentsOfDepartment(IDtoDelete, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                }
                            }
                        }
                    }


                    System.out.println("Виводимо масив студентів університету після видалення: ");
                    System.out.println(Arrays.toString(university.getUniversityStudents()));

                    System.out.println("Виводимо маси факультетів і їхніх студентів після видалення: ");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(Arrays.toString(university.getUniversityFaculties()[i].getStudentsOfFaculty()));

                        }
                    }


                    break;
                case 8:
                    //видалити викладача

                    if (university.getUniversityStudents().length == 0) {
                        System.out.println("Масив викладачів порожній, немає кого видаляти! ");
                        break;
                    }
                    IDtoDelete = DataInput.getInt("Введіть ID викладача, якого хочете видалити: ");
                    university.deleteLecturersOfUniversity(IDtoDelete);

                    System.out.println();

                    System.out.println("Виводимо Масив викладачів університету після видалення викладача: ");
                    System.out.println(Arrays.toString(university.getUniversityLecturers()));


                    break;
                case 9:
                    //редагувати студента

                    if (university.getUniversityStudents().length == 0) {
                        System.out.println("Масив студентів порожній, немає кого редагувати! ");
                        break;
                    }

                    int IDtoEdit = DataInput.getInt("Введіть ID студента, якого хочете відрадагувати: ");
                    university.editStudent(IDtoEdit);

                    System.out.println("Виводимо інфорамцію про доданого студента після редагування: ");
                    System.out.println(university.editStudent(IDtoEdit));
                    System.out.println();

                    break;
                case 10:
                    //редагувати викладача
                    if (university.getUniversityLecturers().length == 0) {
                        System.out.println("Масив викладачів порожній, немає кого редагувати! ");
                        break;
                    }
                    IDtoEdit = DataInput.getInt("Введіть ID викладача, якого хочете відрадагувати: ");
                    university.editLecturer(IDtoEdit);

                    System.out.println("Виводимо інфорамцію про доданого викладача після редагування: ");

                    System.out.println();

                case 11:
                    //Виводимо список кафедр

                    for (int i = 0; i < university.getUniversityDepartments().length; i++) {
                        if (university.getUniversityDepartments()[i] != null) {
                            System.out.println((i + 1) + ".: " + university.getUniversityDepartments()[i].getNameOfDepartment());
                        }
                    }
                    String departmentName = DataInput.getString("Введіть назву кафедри: ");

                    int nameOfdepartmentWhatINeed = 0;
                    facultyIsPresent = false;
                    while (!facultyIsPresent) {
                        for (int i = 0; i < university.getUniversityDepartments().length; i++) {
                            if (university.getUniversityDepartments()[i] != null) {
                                if (departmentName.equals(university.getUniversityDepartments()[i].getNameOfDepartment())) {
                                    nameOfdepartmentWhatINeed = i;
                                    facultyIsPresent = true;
                                    break;
                                }
                            }
                        }
                        if (!facultyIsPresent) {
                            departmentName = DataInput.getString("Кафедру введено неправильно, введіть іншу кафедру: ");
                        }
                    }
                    university.getUniversityDepartments()[nameOfdepartmentWhatINeed].setNameOfDepartment("Введіть нову назву факультету: ");
                    System.out.println("Назву успішно змінено! ");


                    break;
                case 12:
                    System.out.println("1.Вивести всіх студентів впорядкованих за курсами.");
                    Sorting.bubbleSortStudentsByCourse(university.getUniversityStudents());
                    Sorting.printStudentsByCourse(university.getUniversityStudents());

                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("2.Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.");

                    String f = DataInput.getString("Введіть назву факультету: ");
                    Sorting.bubbleSortStudentsOfFacultyByName(f, university);
                    Sorting.printStudentsOfFacultyByName(f, university);


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("3.Вивести всіх студентів кафедри впорядкованих за курсами.");
                    f = DataInput.getString("Введіть назву кафедри: ");
                    Sorting.bubbleSortStudentsOfDepartmentByCourse(f, university);


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("4.Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.");
                    Sorting.bubbleSortStudentsOfDepartmentByName(university, DataInput.getString("Введіть назву кафедри"));


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println(" 5.Вивести всіх студентів кафедри вказаного курсу.");
                    Sorting.bubbleSortStudentsOfDepartmentByCourse(DataInput.getString("Введіть назву кафедри"), university);


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("6.Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.");
                    Sorting.bubbleSortStudentsByName(university, DataInput.getInt("Введіть курс"), DataInput.getString("Введіть назву кафедри"));

                    break;
            }


            Menu.main(args); //вивід меню
            choose = DataInput.getInt("Оберiть дiю: ");

        }
    }
}