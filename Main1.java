import java.io.IOException;
import java.util.Arrays;

public class Main1 {
    public static int counteStudent = 0;
    public static int counteLecturer = 0;

    public static void main(String[] args) throws IOException {
        Menu.main(args); //вивід меню


        /**
         * Припустимо, що університету вже має заздалегідь 3 створені факультети
         */
        System.out.println("Припустимо, що університету вже має заздалегідь 3 створені факультети: ");
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?\n");
        University1 university = new University1(maxSize);
        int choose = DataInput.getInt("Оберiть дiю: ");
        int ID = 0;

        while (choose < 13) {
            switch (choose) {
                case 1:
                    int count = 3;
                    String nameOfFaculty = "ФІ";
                    university.createFaculty(nameOfFaculty, university);
                    nameOfFaculty = "ФГН";
                    university.createFaculty(nameOfFaculty, university);
                    nameOfFaculty = "ФСНСТ";
                    university.createFaculty(nameOfFaculty, university);

                    System.out.println("Інсує вже 3 створених факультети: ");
                    System.out.println("{");
                    for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                        if (university.getUniversityFaculties()[i] != null) {
                            System.out.println(university.getUniversityFaculties()[i].getNameOfFaculty());
                        }
                    }
                    System.out.println("}");

                    count = DataInput.getInt("Скiльки хочете додати до них зараз?");
                    for (int i = 0; i < count; i++) {
                        nameOfFaculty = DataInput.getString("Введiть назву факультету");
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

                    nameOfFaculty = DataInput.getString("Назва факультету, який хочете видалити");
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
                        boolean found = false;
                        while (!found) {
                            for (int j = 0; j < university.getUniversityFaculties().length; j++) {
                                if (university.getUniversityFaculties()[j] != null) {
                                    if (nameOfFaculty.equals(university.getUniversityFaculties()[j].getNameOfFaculty())) {
                                        nameFaculty = j;
                                        found = true;
                                        break;
                                    }
                                }
                            }
                            if (!found) {
                                nameOfFaculty = DataInput.getString("Назва факультету введена неправильно, введіть назву факультету куди додати кафедру");

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

                    if (counteStudent == 0) {
                        /** 1 студент **/
                        Student1 student = new Student1("Вікторія Романюк", 18, "студент", 89, 1, "ФІ", 2, ID++);


                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        String f = "математики";
                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 2 студент **/

                        student = new Student1("Ангеліна Скорик", 18, "студент", 91, 1, "ФСНСТ", 2, ID++);


                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }
/** 3 студент **/

                        student = new Student1("Олег Майстренко", 17, "студент", 65, 2, "ФГН", 3, ID++);

                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 4 студент **/
                        student = new Student1("Катерина Леперт", 17, "студент", 42, 3, "ФІ", 2, ID++);


                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }


/** 5 студент **/
                        student = new Student1("Олександра Костецька", 17, "студент", 32, 4, "ФІ", 1, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }


/** 6 студент **/
                        student = new Student1("Діана Романенко", 17, "студент", 88, 1, "ФГН", 4, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "політології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[3] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }
/** 7 студент **/
                        student = new Student1("Жанна Ломонос", 17, "студент", 45, 2, "ФІ", 2, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 8 студент **/
                        student = new Student1("Зара Ілляшенко", 17, "студент", 71, 3, "ФСНСТ", 3, ID++);

                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "політології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "психології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }
/** 9 студент **/
                        student = new Student1("Катерина Бойчук", 17, "студент", 76, 4, "ФСНСТ", 1, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "психології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 10 студент **/
                        student = new Student1("Соломія Мороз", 17, "студент", 81, 1, "ФІ", 3, ID++);

                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }
/** 11 студент **/
                        student = new Student1("Софія Іваненко", 17, "студент", 61, 2, "ФГН", 2, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 12 студент **/
                        student = new Student1("Сергій Ачілов", 17, "студент", 95, 3, "ФІ", 2, ID++);

                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 13 студент **/
                        student = new Student1("Елеонора Соколова", 17, "студент", 47, 4, "ФГН", 2, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "політології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 14 студент **/
                        student = new Student1("Хельга Кондратенко", 17, "студент", 85, 1, "ФІ", 3, ID++);

                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }
/** 15 студент **/
                        student = new Student1("Фаїна Марченко", 17, "студент", 99, 2, "ФГН", 4, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


                        f = "політології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[3] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 16 студент **/
                        student = new Student1("Роман Андрієвський", 17, "студент", 100, 3, "ФСНСТ", 2, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 17 студент **/
                        student = new Student1("Богдан Соломаха", 17, "студент", 54, 4, "ФСНСТ", 3, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 18 студент **/
                        student = new Student1("Артем Іваненко", 17, "студент", 69, 1, "ФСНСТ", 2, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 19 студент **/
                        student = new Student1("Максим Шприндель", 17, "студент", 86, 2, "ФСНСТ", 1, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 20 студент **/
                        student = new Student1("Максим Козеренко", 17, "студент", 69, 3, "ФГН", 1, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить
                        f = "політології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }


/** 21 студент **/
                        student = new Student1("Степан Романюк", 17, "студент", 70, 4, "ФГН", 2, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 22 студент **/
                        student = new Student1("Дмитро Сікорський", 17, "студент", 64, 1, "ФГН", 3, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 23 студент **/
                        student = new Student1("Ярослав Пивовар", 17, "студент", 67, 2, "ФГН", 3, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "політології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }


/** 24 студент **/
                        student = new Student1("Дмитро Палига", 17, "студент", 84, 3, "ФСНСТ", 3, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

/** 25 студент **/
                        student = new Student1("Даніель Буряковський", 17, "студент", 62, 4, "ФІ", 3, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }


/** 26 студент **/
                        student = new Student1("Артур Стефановський", 17, "студент", 94, 1, "ФІ", 4, ID++);
                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "англійської мови";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[3] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }


/** 27 студент **/

                        student = new Student1("Володимир Бойчук", 17, "студент", 69, 3, "ФІ", 4, ID++);

                        //додаємо назви кафедр до масифу кафедр студента, до яких він належить

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        student.getArrayOfDepartmentsStudentToBelongs()[3] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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
                        //додаємо студентів кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.getUniversityFaculties()[k].addStudentsOfDepartmentToFaculty(student);
                                    break;
                                }
                            }
                        }

                        //додаємо студента в масив студентів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(student.getFaculty())) {
                                    university.addStudentsOfFacultyToUniversity(student, university);
                                    break;
                                }
                            }
                        }

                        counteStudent++;

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

                    if (university.getUniversityDepartments().length == 0) {
                        System.out.println("На жаль, жодної кафедри ще не було додано до списку, створіть спочатку кафедру, а потім додавайте викладачів!");
                        break;
                    }


                    if (counteLecturer == 0) {
/** Викладач №1 **/
                        Lecturer1 lecturer = new Lecturer1("Вікторія Василівна Бондар ", 45, "викладач", 3, "ФСНСТ", ID++);

                        //додаємо назви кафедр до масифу кафедр викладачів, до яких він належить

                        String f = "філософії";
                        boolean isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "психології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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

                        //додаємо викладача кафедри в масив викладачів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }


                        lecturer = new Lecturer1("Валерії Володимирович Марченко ", 30, "викладач", 3, "ФІ", ID++);

                        //додаємо назви кафедр до масифу кафедр викладачів, до яких він належить

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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

                        //додаємо викладача кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }
/** Викладач №3 **/
                        lecturer = new Lecturer1("Оксана В'ячеславівна Калиновська", 45, "викладач", 3, "ФГН", ID++);

                        //додаємо назви кафедр до масифу кафедр студентів, до яких він належить

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "психології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "історії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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

                        //додаємо викладача кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }

                        /** Викладач №4 **/
                        lecturer = new Lecturer1("Світлана Анатоліївна Савіна", 55, "викладач", 2, "ФІ", ID++);

                        //додаємо назви кафедр до масифу кафедр студентів, до яких він належить

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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

                        //додаємо викладача кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }

/** Викладач №4 **/
                        lecturer = new Lecturer1("Елеонора Семенівна Павленко", 40, "викладач", 2, "ФСНСТ", ID++);

                        //додаємо назви кафедр до масифу кафедр студентів, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "психології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

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

                        //додаємо викладача кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }


/** Викладач №5 **/
                        lecturer = new Lecturer1("Марія Ігнатівна Босанець", 60, "викладач", 3, "ФІ", ID++);

                        //додаємо назви кафедр до масифу кафедр студентів, до яких він належить

                        f = "математики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "інформатики";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[2] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }


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

                        //додаємо викладача кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }

/** Викладач №6 **/
                        lecturer = new Lecturer1("Сергій Сергійович Артикуца", 78, "викладач", 2, "ФСНСТ", ID++);

                        //додаємо назви кафедр до масифу кафедр студентів, до яких він належить

                        f = "соціології";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[0] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

                        f = "філософії";
                        isBelongsTo = false;
                        while (!isBelongsTo) {
                            for (int j = 0; j < university.getUniversityDepartments().length; j++) {
                                if (university.getUniversityDepartments()[j] != null) {
                                    if (f.equals(university.getUniversityDepartments()[j].getNameOfDepartment())) {
                                        lecturer.getArrayOfDepartmentsLecturerToBelongs()[1] = f;
                                        isBelongsTo = true;
                                        break;
                                    }
                                }
                            }
                        }

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

                        //додаємо викладача кафедри в масив студентів факультету
                        for (int k = 0; k < university.getUniversityFaculties().length; k++) {
                            if (university.getUniversityFaculties()[k] != null) {
                                if (university.getUniversityFaculties()[k].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.getUniversityFaculties()[k].addSLecturerOfDepartmentToFaculty(lecturer);
                                    break;
                                }
                            }
                        }

                        //додаємо викладача в масив викладачів університету
                        for (int i = 0; i < university.getUniversityFaculties().length; i++) {
                            if (university.getUniversityFaculties()[i] != null) {
                                if (university.getUniversityFaculties()[i].getNameOfFaculty().equals(lecturer.getFaculty())) {
                                    university.addLecturersOfFacultyToUniversity(lecturer, university);
                                    break;
                                }
                            }
                        }

                        counteLecturer++;

                    }


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


                    System.out.println("Виводимо інфорамцію про доданого викладача: ");
                    System.out.println(lecturer);
                    System.out.println();

                    //додаємо викладачів кафедри в масив викладачів факультету
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

                    if (university.getUniversityLecturers().length == 0) {
                        System.out.println("Масив викладачів порожній, немає кого видаляти! ");
                        break;
                    }
                    IDtoDelete = DataInput.getInt("Введіть ID викладача, якого хочете видалити: ");
                    university.deleteLecturersOfUniversity(IDtoDelete);

                    System.out.println();

                    System.out.println("Виводимо масив викладачів університету після видалення викладача: ");
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

                    System.out.println("Виводимо інфорамцію студента після редагування: ");
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

                    System.out.println("Викладача успішно змінено: ");

                    System.out.println("Виводимо масив викладачів університету після редагування: ");
                    System.out.println(Arrays.toString(university.getUniversityLecturers()));

                    break;

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
                    System.out.println("Виводимо студентів: ");
                    Sorting.displayStudentsSortedAlphabeticallyUsingBubbleSort(university.getUniversityFaculties()[pos].getStudentsOfFaculty());
                    System.out.println();
                    System.out.println("Виводимо викладачів: ");
                    Sorting.displayLecturersSortedAlphabeticallyUsingBubbleSort(university.getUniversityFaculties()[pos].getLecturerOfFaculty());
                    System.out.println();


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
                    while (choose<0){
                        course = DataInput.getInt("Введіть курс: ");
                    }
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
                    while (choose<0){
                        course = DataInput.getInt("Введіть курс: ");
                    }

                    Sorting.displayStudentsOfSpecifiedCourseSortedAlphabeticallyUsingBubbleSort(student1s, course);
                    break;
            }


            Menu.main(args); //вивід меню
            choose = DataInput.getInt("Оберiть дiю: ");

        }
    }
}