//клас кафедри

import java.io.IOException;

public class Department {
    //назва кафедри
    private String nameOfDepartment;
    
    //створюємо масив студентів типу Student
    private static Student[] students = new Student[1];

    //створюємо масив викладачів типу Lecturer
    private static Lecturer[] lecturers = new Lecturer[1];



    public Department(String nameOfDepartment, int countOfStudents, int countOfLecturers) {
        this.nameOfDepartment = nameOfDepartment;
        this.students = new Student[countOfStudents];
        this.lecturers = new Lecturer[countOfLecturers];
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
    public static Student[] getStudents() {
        return students;
    }

    public static void setStudents(Student[] students) {
        Department.students = students;
    }

    public static Lecturer[] getLecturers() {
        return lecturers;
    }

    public static void setLecturers(Lecturer[] lecturers) {
        Department.lecturers = lecturers;
    }


    public static void addLecturer(Lecturer oneLecturer) {
        // Створюємо змінну для перевірки того чи наш масив повний (якщо повний, то далі створюємо масив,
        // у 2 рази більший розміром ніж цей, копіюємо туди елементи і додаємо викладача)
        boolean isFull = true;

        //перебираємо масив посилань на об'єкти типу Lecturer і якщо в комірці відсутнє посилання,
        // то змінюємо змінну isFull на false
        for (Lecturer lecturer : lecturers) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }

        //умова виконується, якщо масив переповнений
        if (isFull) {
            // Створюємо *2 масив
            Lecturer[] newLecturers = new Lecturer[lecturers.length * 2];

            // Копіюємо елементи зі старого
            for (int i = 0; i < lecturers.length; i++) {
                newLecturers[i] = lecturers[i];
            }

            //Оновлюємо посилання
            lecturers = newLecturers;
        }

        // Додаємо елемент у масив
        for (int i = 0; i < lecturers.length; i++) {
            if (lecturers[i] == null) {
                lecturers[i] = oneLecturer;
                System.out.println("Викладач успішно доданий! ");
                //Виходимо з методу після додавання викладача
                return;
            }
        }
    }


    //аналогічно створений  метод addStudent
    public static void addStudent(Student someStudent) {
        boolean isFull = true;

        for (Student student : students) {
            if (student == null) {
                isFull = false;
                //виходимо із циклу
                break;
            }
        }

        if (isFull) {
            Student[] newStudent = new Student[students.length * 2];
            for (int i = 0; i < students.length; i++) {
                newStudent[i] = students[i];
            }
            students = newStudent;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = someStudent;
                    return;
                }
            }
        }
        // Додаємо елемент у масив
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = someStudent;
                System.out.println("Студент успішно доданий! ");
                //Виходимо з методу після додавання викладача
                return;
            }
        }

    }

    public static void deleteLecturer(Lecturer lecturerToRemove) {
        // Спочатку перевіряємо чи взагалі масив виклалдачів не пустий, щоб нам було що видаляти, якщо стається помилка і масив пустий,
        // то виводимо відпрвідне повідомлення і виходимо з методу за дом=помогою return
        if (lecturers.length == 0) {
            System.out.println("Немає кого видаляти, масив викладачів порожній! ");
            return;
        }

        //Перевіряємо булевою змінною чи існує дане посилання на об'єкт в масиві
        boolean lecturerFound = false;

        for (int i = 0; i < lecturers.length; i++) {
            //((перевіряємо чи комірка не зсилається на null)) і чи посилання на наш об'єкт == посиланню на об'єкт в масиві;
            // (()) - цю умову перевіряємо для того, щоб переконатися, що комірка не пуста,
            // адже наше посилання "lecturerToRemove" може також посилатися на null
            if (lecturers[i] != null && lecturers[i].equals(lecturerToRemove)) {
                lecturerFound = true;
                // Видаляємо об'єкт і перепосилаємо посилання відповідної комірки на null
                lecturers[i] = null;
                // просто для краси структури масиву прибираємо пробіл з null посиланням
                // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
                for (int j = i; j < lecturers.length - 1; j++) {
                    lecturers[j] = lecturers[j + 1];
                }
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
        if (students.length == 0) {
            System.out.println("Немає кого видаляти, масив студентів порожній! ");
            return;
        }

        boolean studentFound = false;

        for (int i = 0; i < students.length; i++) {
            if (studentToRemove != null && students[i].equals(studentToRemove)) {
                students[i] = null;
                studentFound = true;

                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
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
                System.out.println("Ім'я успішно змінено!");
                break;
            case 2:
                student.setAge(DataInput.getInt("Введіть новий вік студента: "));
                System.out.println("Вік успішно змінено!");
                break;
            case 3:
                student.setGrades(DataInput.getInt("Введіть нову середню оцінку студента: "));
                System.out.println("Бал успішно змінено!");
                break;
            case 4:
                student.setPosition(DataInput.getString("Введіть нову посаду студента: "));
                System.out.println("Посаду успішно змінено!");
                break;
            case 5:
                student.setPosition(DataInput.getString("Введіть новий курс студента: "));
                System.out.println("Курс успішно змінено!");
                break;
            default:
                System.out.println("Не існує такої опції ");
        }
    }

    public static void editLecturer(Lecturer lecturer) throws IOException {
        int choice = DataInput.getInt("Які поля викладача ви хочете змінити: " + "\n" +
                "Щоб змінити <Ім'я> введіть 1" + "\n" +
                "Щоб змінити <Вік> введіть 2" + "\n" +
                "Щоб змінити <Посаду> введіть 3" + "\n");
        switch (choice) {
            case 1:
                lecturer.setName(DataInput.getString("Введіть нове ім'я викладача: "));
                break;
            case 2:
                lecturer.setAge(DataInput.getInt("Введіть новий вік викладача: "));
                break;
            case 3:
                lecturer.setPosition(DataInput.getString("Введіть нову посаду викладача: "));
                break;
            default:
                System.out.println("Не існує такої опції ");
        }
    }
    
}
