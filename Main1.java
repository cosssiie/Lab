import java.io.IOException;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Menu.main(args); //вивід меню
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?\n");
        University1 university = new University1(maxSize);
        int choose = DataInput.getInt("Оберiть дiю: ");
        int ID = 23;

        university.createFaculty("Інформатики", university);
        university.createFaculty("Природничий", university);
        university.createFaculty("Економічний", university);

        while (choose < 13) {
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
                    if (university.getUniversityFaculties().length == 0) {
                        System.out.println("Жодного факультету було створено");
                        return;
                    }
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
                    if (university.getUniversityFaculties().length == 0) {
                        System.out.println("Жодного факультету було створено");
                        return;
                    }
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
                        university.getUniversityFaculties()[nameFaculty].createDepartment("ІПЗ", "Інформатика", university);
                        university.getUniversityFaculties()[nameFaculty].createDepartment("КН", "Інформатика", university);
                        university.getUniversityFaculties()[nameFaculty].createDepartment("Екологія", "Природничий", university);
                        university.getUniversityFaculties()[nameFaculty].createDepartment("Біологія", "Природничий", university);
                        university.getUniversityFaculties()[nameFaculty].createDepartment("Маркетинг", "Економічний", university);

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
//
//                    System.out.println("Виводимо на екран усі кафедри університету");
//                    for (int i = 0; i < university.getUniversityDepartments().length; i++) {
//                        if (university.getUniversityDepartments()[i] != null) {
//                            System.out.println(university.getUniversityDepartments()[i].getNameOfDepartment());
//                        }
//                    }
//
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
//                    /**
//                     * ТЕСТИ
//                     */
//                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
//                        if (university.getUniversityFaculties()[i] != null) {
//                            System.out.println("Виводимо усі кафедри факультету");
//                            System.out.println("*" + university.getUniversityFaculties()[i].getNameOfFaculty());
//                            for (int j = 0; j < university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty().length; j++) {
//                                if (university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j] != null) {
//                                    System.out.println(university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].getNameOfDepartment());
//                                }
//                            }
//                        }
//                    }


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


                    Student1 st1 = new Student1("Андрохіна Валерія Вікторівна", 19, "студент", 78, 2 , "Інформатики", 1, 0);
                    Student1 st2 = new Student1("Ярош Олена Андріївна", 23, "студент", 91, 4 , "Економічний", 1, 1);
                    Student1 st3 = new Student1("Баранова Аріна Семенівна", 22, "студент", 72, 3 , "Природничий", 1, 2);
                    Student1 st4 = new Student1("Довбуш Олексій Олегович", 18, "студент", 70, 1 , "Економічний", 1, 3);
                    Student1 st5 = new Student1("Руєва Дарія Микитівна", 23, "студент", 88, 4 , "Природничий", 1, 4);
                    Student1 st6 = new Student1("Котельнікова Марія Андріївна", 17, "студент", 75, 1 , "Природничий", 1, 5);
                    Student1 st7 = new Student1("Шевченко Ярослав Анатолійович", 19, "студент", 78, 2 , "Природничий", 1, 6);
                    Student1 st8 = new Student1("Анісімова Олена Романівна", 22, "студент", 98, 4 , "Інформатики", 1, 7);
                    Student1 st9 = new Student1("Дмитрюк Володимир Сергійович", 21, "студент", 81, 3 , "Економічний", 1, 8);
                    Student1 st10 = new Student1("Гордій Олексій Валерійович", 17, "студент", 70, 1 , "Інформатики", 1, 9);
                    Student1 st11 = new Student1("Савін Костянтин Олегович", 19, "студент", 92, 2 , "Природничий", 1, 10);
                    Student1 st12 = new Student1("Савченко Валерія Артемівна", 17, "студент", 69, 1 , "Інформатики", 1, 11);
                    Student1 st13 = new Student1("Позова Вікторія Вікторівна", 23, "студент", 86, 4 , "Економічний", 1, 12);
                    Student1 st14 = new Student1("Носова Світлана Вікторівна", 19, "студент", 89, 2 , "Інформатики", 1, 13);
                    Student1 st15 = new Student1("Бачинська Христина Василівна", 19, "студент", 73, 1 , "Природничий", 1, 14);
                    Student1 st16 = new Student1("Лапаєва Марія Андріївна", 19, "студент", 79, 3 , "Економічний", 1, 15);
                    Student1 st17 = new Student1("Самойлов Михайло Володимирович", 21, "студент", 85, 3 , "Економічний", 1, 16);
                    Student1 st18 = new Student1("Андрієв Ярослав Олегович", 19, "студент", 92, 2 , "Природничий", 1, 17);
                    Student1 st19 = new Student1("Биков Андрій Романович", 17, "студент", 69, 1 , "Інформатики", 1, 18);
                    Student1 st20 = new Student1("Валуєва Вікторія Яківна", 23, "студент", 86, 3 , "Економічний", 1, 19);
                    Student1 st21 = new Student1("Лозова Анастасія Євгенівна", 19, "студент", 89, 2 , "Економічний", 1, 20);
                    Student1 st22 = new Student1("Бритова Єлизавета Сергіївна", 19, "студент", 73, 1 , "Природничий", 1, 21);
                    Student1 st23 = new Student1("Омельникова Марія Андріївна", 19, "студент", 79, 3 , "Економічний", 1, 22);

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
                        String d1 = "Екологія";
                        String d2 = "Біологія";
                        String d3 = "ІПЗ";
                        String d4 = "КН";
                        String d5 = "Маркетинг";


                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[i] = f;
                                        st1.getArrayOfDepartmentsStudentToBelongs()[i] = d3;
                                        st2.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st3.getArrayOfDepartmentsStudentToBelongs()[i] = d2;
                                        st4.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st5.getArrayOfDepartmentsStudentToBelongs()[i] = d1;
                                        st6.getArrayOfDepartmentsStudentToBelongs()[i] = d1;
                                        st7.getArrayOfDepartmentsStudentToBelongs()[i] = d2;
                                        st8.getArrayOfDepartmentsStudentToBelongs()[i] = d4;
                                        st9.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st10.getArrayOfDepartmentsStudentToBelongs()[i] = d3;
                                        st11.getArrayOfDepartmentsStudentToBelongs()[i] = d2;
                                        st12.getArrayOfDepartmentsStudentToBelongs()[i] = d3;
                                        st13.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st14.getArrayOfDepartmentsStudentToBelongs()[i] = d4;
                                        st15.getArrayOfDepartmentsStudentToBelongs()[i] = d2;
                                        st16.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st17.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st18.getArrayOfDepartmentsStudentToBelongs()[i] = d2;
                                        st19.getArrayOfDepartmentsStudentToBelongs()[i] = d4;
                                        st20.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st21.getArrayOfDepartmentsStudentToBelongs()[i] = d5;
                                        st22.getArrayOfDepartmentsStudentToBelongs()[i] = d1;
                                        st23.getArrayOfDepartmentsStudentToBelongs()[i] = d5;







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
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st1, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st2, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st3, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st4, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st5, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st6, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st7, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st8, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st9, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st10, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st11, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st12, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st13, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st14, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st15, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st16, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st17, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st18, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st19, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st20, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st21, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st22, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);
                                                university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j].addStudentToDepartment(st23, university.getUniversityFaculties()[i].getArrayOfDepartmentsOfFaculty()[j]);


                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }


                    System.out.println("Виводимо інфорамцію про доданого студента: " );
                    System.out.println(student);
                    System.out.println();

                    //додаємо студентів кафедри в масив студентів факультету
                    for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                        if (university.getUniversityFaculties()[k] != null) {
                            if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(studentFaculty)) {
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st1);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st2);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st3);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st4);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st5);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st6);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st7);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st8);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st9);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st10);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st11);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st12);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st13);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st14);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st15);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st16);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st17);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st18);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st19);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st20);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st21);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st22);
                                university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(st23);



                                break;
                            }
                        }
                    }

                    //додаємо студента в масив студентів університету
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(studentFaculty)) {
                                university.addStudentsOfFacultyToUniversity(student, university);
                                university.addStudentsOfFacultyToUniversity(st1, university);
                                university.addStudentsOfFacultyToUniversity(st2, university);
                                university.addStudentsOfFacultyToUniversity(st3, university);
                                university.addStudentsOfFacultyToUniversity(st4, university);
                                university.addStudentsOfFacultyToUniversity(st5, university);
                                university.addStudentsOfFacultyToUniversity(st6, university);
                                university.addStudentsOfFacultyToUniversity(st7, university);
                                university.addStudentsOfFacultyToUniversity(st8, university);
                                university.addStudentsOfFacultyToUniversity(st9, university);
                                university.addStudentsOfFacultyToUniversity(st10, university);
                                university.addStudentsOfFacultyToUniversity(st11, university);
                                university.addStudentsOfFacultyToUniversity(st12, university);
                                university.addStudentsOfFacultyToUniversity(st13, university);
                                university.addStudentsOfFacultyToUniversity(st14, university);
                                university.addStudentsOfFacultyToUniversity(st15, university);
                                university.addStudentsOfFacultyToUniversity(st16, university);
                                university.addStudentsOfFacultyToUniversity(st17, university);
                                university.addStudentsOfFacultyToUniversity(st18, university);
                                university.addStudentsOfFacultyToUniversity(st19, university);
                                university.addStudentsOfFacultyToUniversity(st20, university);
                                university.addStudentsOfFacultyToUniversity(st21, university);
                                university.addStudentsOfFacultyToUniversity(st22, university);
                                university.addStudentsOfFacultyToUniversity(st23, university);


                                break;
                            }
                        }
                    }


//                    System.out.println("Виводимо масив студентів факультету" + "\n");
//                    for (int k = 0; k < university.getUniversityFaculties().length; k++) {
//                        if (university.getUniversityFaculties()[k] != null) {
//                            System.out.println(university.getUniversityFaculties()[k].getNameOfFaculty());
//                            System.out.println(Arrays.toString(university.getUniversityFaculties()[k].getStudentsOfFaculty()) + "\n");
//                        }
//                    }
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
                    String newNameOfDepartment = DataInput.getString("Введіть нову назву кафедри");
                    university.getUniversityDepartments()[nameOfdepartmentWhatINeed].setNameOfDepartment(newNameOfDepartment);
                    System.out.println("Назву успішно змінено! ");


                    break;
                case 12:
                    System.out.println("1.Вивести всіх студентів впорядкованих за курсами.");
                    Sorting.bubbleSortStudentsByCourseAndDisplay(university.getUniversityStudents());


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("2.Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.");

                    String f = DataInput.getString("Введіть назву факультету: ");
                    int pos = 0;
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(f)) {
                                pos = i;
                                break;
                            }
                        }
                    }
                    Sorting.displayStudentsSortedAlphabeticallyUsingBubbleSort(university.getUniversityFaculties()[pos].getStudentsOfFaculty());
                    Sorting.printLecturersSortedAlphabeticallyUsingBubbleSort(university.getUniversityFaculties()[pos].getLecturerOfFaculty());

                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("3.Вивести всіх студентів кафедри впорядкованих за курсами.");
                    f = DataInput.getString("Введіть назву кафедри: ");
                    Student1[] student1s = new Student1[university.getUniversityStudents().length];
                    for (int i = 0; i < university.getUniversityStudents().length; i++) {
                        if (university.getUniversityStudents()[i] != null) {
                            for (int j = 0; j < university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length; j++) {
                                if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j] != null) {
                                    if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j].equals(f)) {
                                        student1s[i] = university.getUniversityStudents()[i];
                                    }
                                }
                            }
                        }
                    }


                    Sorting.displayStudentsSortedByCourseUsingBubbleSort(student1s);


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("4.Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.");
                    f = DataInput.getString("Введіть назву кафедри: ");
                    student1s = new Student1[university.getUniversityStudents().length];
                    for (int i = 0; i < university.getUniversityStudents().length; i++) {
                        if (university.getUniversityStudents()[i] != null) {
                            for (int j = 0; j < university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length; j++) {
                                if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j] != null) {
                                    if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j].equals(f)) {
                                        student1s[i] = university.getUniversityStudents()[i];
                                    }
                                }
                            }
                        }
                    }

                    Lecturer1[] lecturer1 = new Lecturer1[university.getUniversityLecturers().length];
                    for (int i = 0; i < university.getUniversityLecturers().length; i++) {
                        if (university.getUniversityLecturers()[i] != null) {
                            for (int j = 0; j < university.getUniversityLecturers()[i].getArrayOfDepartmentsLecturerToBelongs().length; j++) {
                                if (university.getUniversityLecturers()[i].getArrayOfDepartmentsLecturerToBelongs()[j] != null) {
                                    if (university.getUniversityLecturers()[i].getArrayOfDepartmentsLecturerToBelongs()[j].equals(f)) {
                                        lecturer1[i] = university.getUniversityLecturers()[i];
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Студенти: ");
                    Sorting.displayStudentsOfDepartmentSortedAlphabeticallyUsingBubbleSort(student1s);
                    System.out.println();
                    System.out.println("Викладачі: ");
                    Sorting.displayLecturersOfDepartmentSortedAlphabeticallyUsingBubbleSort(lecturer1);


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println(" 5.Вивести всіх студентів кафедри вказаного курсу.");
                    f = DataInput.getString("Введіть назву кафедри: ");
                    student1s = new Student1[university.getUniversityStudents().length];
                    for (int i = 0; i < university.getUniversityStudents().length; i++) {
                        if (university.getUniversityStudents()[i] != null) {
                            for (int j = 0; j < university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length; j++) {
                                if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j] != null) {
                                    if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j].equals(f)) {
                                        student1s[i] = university.getUniversityStudents()[i];
                                    }
                                }
                            }
                        }
                    }
                    course = DataInput.getInt("Введіть курс: ");
                    Sorting.displayStudentsOfSpecifiedCourseUsingBubbleSort(student1s, course);


                    System.out.println();
                    System.out.println("*******************************************************************");
                    System.out.println("6.Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.");
                    f = DataInput.getString("Введіть назву кафедри: ");
                    student1s = new Student1[university.getUniversityStudents().length];
                    for (int i = 0; i < university.getUniversityStudents().length; i++) {
                        if (university.getUniversityStudents()[i] != null) {
                            for (int j = 0; j < university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs().length; j++) {
                                if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j] != null) {
                                    if (university.getUniversityStudents()[i].getArrayOfDepartmentsStudentToBelongs()[j].equals(f)) {
                                        student1s[i] = university.getUniversityStudents()[i];
                                    }
                                }
                            }
                        }
                    }
                    course = DataInput.getInt("Введіть курс: ");

                    Sorting.displayStudentsOfSpecifiedCourseSortedAlphabeticallyUsingBubbleSort(student1s, course);
                    break;
            }


            Menu.main(args); //вивід меню
            choose = DataInput.getInt("Оберiть дiю: ");

        }
    }
}