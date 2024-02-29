//клас кафедри

import java.io.IOException;

public class Department {
    //назва кафедри
    private String nameOfDepartment;
    //створюємо масив студентів типу Student
    private static Student[] studentsOdDepartment = new Student[0];


    //створюємо масив викладачів типу Lecturer
    private static Lecturer[] lecturersOfDepartment = new Lecturer[0];



    public Department(String nameOfDepartment, int countOfStudents, int countOfLecturers) {
        this.nameOfDepartment = nameOfDepartment;
        this.studentsOdDepartment = new Student[countOfStudents];
        this.lecturersOfDepartment = new Lecturer[countOfLecturers];
    }
    public Department(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

//геттери сеттери масиву викладачі і масиву студентів
    public static Student[] getStudentsOdDepartment() {
        return studentsOdDepartment;
    }

    public static void setStudentsOdDepartment(Student[] studentsOdDepartment) {
        Department.studentsOdDepartment = studentsOdDepartment;
    }

    public static Lecturer[] getLecturersOfDepartment() {
        return lecturersOfDepartment;
    }

    public static void setLecturersOfDepartment(Lecturer[] lecturersOfDepartment) {
        Department.lecturersOfDepartment = lecturersOfDepartment;
    }


    public static void addLecturer(Lecturer oneLecturer) {
        // Створюємо змінну для перевірки того чи наш масив повний (якщо повний, то далі створюємо масив,
        // у 2 рази більший розміром ніж цей, копіюємо туди елементи і додаємо викладача)
        boolean isFull = true;

        //перебираємо масив посилань на об'єкти типу Lecturer і якщо в комірці відсутнє посилання,
        // то змінюємо змінну isFull на false
        for (Lecturer lecturer : lecturersOfDepartment) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }

        //умова виконується, якщо масив переповнений
        if (isFull) {
            // Створюємо *2 масив
            Lecturer[] newLecturers = new Lecturer[(lecturersOfDepartment.length +1) * 2];

            // Копіюємо елементи зі старого
            for (int i = 0; i < lecturersOfDepartment.length; i++) {
                newLecturers[i] = lecturersOfDepartment[i];
            }

            //Оновлюємо посилання
            lecturersOfDepartment = newLecturers;
        }

        // Додаємо елемент у масив
        for (int i = 0; i < lecturersOfDepartment.length; i++) {
            if (lecturersOfDepartment[i] == null) {
                lecturersOfDepartment[i] = oneLecturer;
                System.out.println("Викладач успішно доданий! ");
                //Виходимо з методу після додавання викладача
                return;
            }
        }

    }


    //аналогічно створений  метод addStudent
    public static void addStudent(Student someStudent) {
        boolean isFull = true;

        for (Student student : studentsOdDepartment) {
            if (student == null) {
                isFull = false;
                //виходимо із циклу
                break;
            }
        }


        if (isFull) {
            Student[] newStudent = new Student[(studentsOdDepartment.length +1) * 2];
            for (int i = 0; i < studentsOdDepartment.length; i++) {
                newStudent[i] = studentsOdDepartment[i];
            }
            studentsOdDepartment = newStudent;
            for (int i = 0; i < studentsOdDepartment.length; i++) {
                if (studentsOdDepartment[i] == null) {
                    studentsOdDepartment[i] = someStudent;
                    return;
                }
            }
        }
        // Додаємо елемент у масив
        for (int i = 0; i < studentsOdDepartment.length; i++) {
            if (studentsOdDepartment[i] == null) {
                studentsOdDepartment[i] = someStudent;
                System.out.println("Студент успішно доданий! ");
                //Виходимо з методу після додавання викладача
                return;
            }
        }

    }

    public static void deleteLecturer(Lecturer lecturerToRemove) {


        //Перевіряємо булевою змінною чи існує дане посилання на об'єкт в масиві
        boolean lecturerFound = false;

        for (int i = 0; i < lecturersOfDepartment.length; i++) {
            //((перевіряємо чи комірка не зсилається на null)) і чи посилання на наш об'єкт == посиланню на об'єкт в масиві;
            // (()) - цю умову перевіряємо для того, щоб переконатися, що комірка не пуста,
            // адже наше посилання "lecturerToRemove" може також посилатися на null
            if (lecturersOfDepartment[i] != null && lecturersOfDepartment[i].equals(lecturerToRemove)) {
                lecturerFound = true;
                // Видаляємо об'єкт і перепосилаємо посилання відповідної комірки на null
                lecturersOfDepartment[i] = null;
                // просто для краси структури масиву прибираємо пробіл з null посиланням
                // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
                for (int j = i; j < lecturersOfDepartment.length - 1; j++) {
                    lecturersOfDepartment[j] = lecturersOfDepartment[j + 1];

                }
                lecturersOfDepartment[lecturersOfDepartment.length - 1] = null;
                //виходимо з циклу після видадення лектора
                break;
            }
        }

        //якщо булева змінна == false, тобто жодна з умов циклу for не виконалась, то виводимо відповідне повідомлення
        if (!lecturerFound) {
            System.out.println("Такого викладача не існує! ");
        }
    }


    //за аналогією видалення викладачів дописуємо метод видалення студентів
    public static void deleteStudent(Student studentToRemove) {


        boolean studentFound = false;

        for (int i = 0; i < studentsOdDepartment.length; i++) {
            if (studentToRemove != null && studentsOdDepartment[i].equals(studentToRemove)) {
                studentsOdDepartment[i] = null;
                studentFound = true;

                for (int j = i; j < studentsOdDepartment.length - 1; j++) {
                    studentsOdDepartment[j] = studentsOdDepartment[j + 1];
                }

                studentsOdDepartment[studentsOdDepartment.length - 1] = null;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Такого студента не існує! ");
        }


    }

    // Метод, який буде редагувати поля даного нам на вхід студента
    // метод статичний, бо він не повинен мати ніякої прив'язки до якогось класу
    public static void editStudent(Student student) throws IOException {
        int choice = DataInput.getInt("Які поля студента ви хочете змінити: " + "\n" +
                "Щоб змінити <Ім'я> введіть 1" + "\n" +
                "Щоб змінити <Вік> введіть 2" + "\n" +
                "Щоб змінити <Середню оцінку> введіть 3" + "\n" +
                "Щоб змінити <Посаду> введіть 4" + "\n" +
                "Щоб змінити <Курс> введіть 5" + "\n");

        switch (choice) {
            case 1:
                student.setName(DataInput.getString("Введіть нове ім'я: "));
                break;
            case 2:
                student.setAge(DataInput.getInt("Введіть новий вік студента: "));
                break;
            case 3:
                student.setGrades(DataInput.getInt("Введіть нову середню оцінку студента: "));
                break;
            case 4:
                student.setPosition(DataInput.getString("Введіть нову посаду студента: "));
                break;
            case 5:
                student.setPosition(DataInput.getString("Введіть новий курс студента: "));
                break;
            default:
                System.out.println("Не існує такої опції ");
        }
    }

    public static void editLecturer(Lecturer lecturer) throws IOException {
        int choice = DataInput.getInt("Які поля викладача ви хочете змінити: " + "\n" +
                "Щоб змінити <Ім'я> введіть 1" + "\n" +
                "Щоб змінити <Вік> введіть 2" + "\n" +
                "Щоб змінити <Кафедра> введіть 3" + "\n");
        switch (choice) {
            case 1:
                lecturer.setName(DataInput.getString("Введіть нове ім'я викладача: "));
                break;
            case 2:
                lecturer.setAge(DataInput.getInt("Введіть новий вік викладача: "));
                break;
            case 3:
                lecturer.setPosition(DataInput.getString("Введіть нову кафедру викладача: "));
                break;
            default:
                System.out.println("Не існує такої опції ");
        }
    }


}

