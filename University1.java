import java.io.IOException;

public class University1 {
    private Lecturer1[] universityLecturers = new Lecturer1[0];
    private Student1[] universityStudents = new Student1[0];

    private Faculty1[] universityFaculties = new Faculty1[0];

    private Department1[] universityDepartments = new Department1[0];

    /**
     *
     */

    public Faculty1[] getUniversityFaculties() {
        return universityFaculties;
    }

    public void setUniversityFaculties(Faculty1[] universityFaculties) {
        this.universityFaculties = universityFaculties;
    }

    public Department1[] getUniversityDepartments() {
        return universityDepartments;
    }

    public void setUniversityDepartments(Department1[] universityDepartments) {
        this.universityDepartments = universityDepartments;
    }

    public Lecturer1[] getUniversityLecturers() {
        return universityLecturers;
    }

    public void setUniversityLecturers(Lecturer1[] universityLecturers) {
        this.universityLecturers = universityLecturers;
    }

    public Student1[] getUniversityStudents() {
        return universityStudents;
    }

    public void setUniversityStudents(Student1[] universityStudents) {
        this.universityStudents = universityStudents;
    }

    private int size;

    public University1(int maxSize) {
        universityFaculties = new Faculty1[maxSize];
        size = 0;
    }

    public void Faculties() {
        System.out.println("Список факультетiв:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + getUniversityFaculties()[i].getNameOfFaculty());
        }
        if (size == 0) {
            System.out.println("Наразi ви не додали жоден факультет");
        }
    }

    /*  методи створення/редагування/видалення факультету  */

    public void createFaculty(String nameOfFaculty, University1 university) throws IOException {

        Faculty1 newFaculty = new Faculty1(nameOfFaculty);
        university.addFacultiesToUniversity(newFaculty);
        System.out.println("Факультет " + newFaculty.getNameOfFaculty() + " успішно було створено! ");
    }


    public void deleteFaculty(String nameOfFaculty) {
        boolean found = false;
        int c = 0;
        for (int i = 0; i < universityFaculties.length; i++) {
            if (universityFaculties[i] != null) {
                if (universityFaculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                    universityFaculties[i] = null;
                    found = true;
                    System.out.println("Факультет " + nameOfFaculty + " успiшно видалений");
                    c = i;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Факультет з назвою " + nameOfFaculty + " не знайдено");
        }
        for (int j = c; j < universityFaculties.length - 1; j++) {
            universityFaculties[j] = universityFaculties[j + 1];

        }
        universityFaculties[universityFaculties.length - 1] = null;

    }

    public void editFaculty(String previousName, String newName) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (universityFaculties[i].getNameOfFaculty().equals(previousName)) {
                universityFaculties[i].setNameOfFaculty(newName);
                found = true;
                System.out.println("Назву факультету успiшно змiнено з " + previousName + " на " + newName);
                break;
            }
        }
        if (!found) {
            System.out.println("Факультет з назвою " + previousName + " не знайдено");
        }
    }

    //додаємо студентів факультету до студентів усього університету
    public void addStudentsOfFacultyToUniversity(Student1 someStudent, University1 university1) {

        for (Student1 student : universityStudents) {
            if (student != null && student.equals(someStudent)) {
                return;
            }
        }
        boolean isFull = true;

        for (Student1 student : universityStudents) {
            if (student == null) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Student1[] newStudent = new Student1[(universityStudents.length + 1) * 2];
            for (int i = 0; i < universityStudents.length; i++) {
                newStudent[i] = universityStudents[i];
            }
            universityStudents = newStudent;
        }
        // Додаємо елемент у масив
        for (int i = 0; i < universityStudents.length; i++) {
            if (universityStudents[i] == null) {
                universityStudents[i] = someStudent;
                return;
            }
        }

    }


    //додаємо викладачів факультету до викладачів усього університету
    public void addLecturersOfFacultyToUniversity(Lecturer1 someLecturer, University1 university1) {
        for (Lecturer1 lecturer : universityLecturers) {
            if (lecturer != null && lecturer.equals(someLecturer)) {
                return;
            }
        }
        boolean isFull = true;

        for (Lecturer1 lecturer : universityLecturers) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Lecturer1[] newLecturer = new Lecturer1[(universityLecturers.length + 1) * 2];
            for (int i = 0; i < universityLecturers.length; i++) {
                newLecturer[i] = universityLecturers[i];
            }
            universityLecturers = newLecturer;
        }
        // Додаємо елемент у масив
        for (int i = 0; i < universityLecturers.length; i++) {
            if (universityLecturers[i] == null) {
                universityLecturers[i] = someLecturer;
                return;
            }
        }

    }


    //додаємо кафедри факультету до кафедр усього університету
    public void addDepartmentsOfFacultyToUniversity(Department1 department1s) {
        // перевірка чи вже існує дана кафедра в масиві кафедр факультету
        for (Department1 department : universityDepartments) {
            if (department != null && department.equals(department1s)) {
                return;
            }
        }


        boolean isFull = true;

        for (Department1 department : universityDepartments) {
            if (department == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            Department1[] newDepartments = new Department1[(universityDepartments.length + 1) * 2];

            for (int i = 0; i < universityDepartments.length; i++) {
                newDepartments[i] = universityDepartments[i];
            }
            universityDepartments = newDepartments;
        }


        for (int i = 0; i < universityDepartments.length; i++) {
            if (universityDepartments[i] == null) {
                universityDepartments[i] = department1s;
                break;
            }
        }
    }


    //додаємо факультет до факультетів усього університету
    public void addFacultiesToUniversity(Faculty1 faculty1s) {

        // перевірка чи існує вже таки факультет в масиві факультетів універистету
        for (Faculty1 f : universityFaculties) {
            if (f != null && f.equals(faculty1s)) {
                return;
            }
        }


        boolean isFull = true;

        for (Faculty1 f : universityFaculties) {
            if (f == null || universityFaculties.length == 0) {
                isFull = false;
                break;
            }
        }


        if (isFull) {
            Faculty1[] newFaculties = new Faculty1[(universityFaculties.length + 1) * 2];

            for (int i = 0; i < universityFaculties.length; i++) {
                newFaculties[i] = universityFaculties[i];
            }
            universityFaculties = newFaculties;
        }

        for (int i = 0; i < universityFaculties.length; i++) {
            if (universityFaculties[i] == null) {
                universityFaculties[i] = faculty1s;
                break;
            }
        }
    }


    public Student1 deleteStudentsOfUniversity(int ID) {
        Student1 student1 = null;
        for (int i = 0; i < universityStudents.length; i++) {
            if (universityStudents[i] != null) {
                if (universityStudents[i].getID() == ID) {
                    student1 = universityStudents[i];
                    universityStudents[i] = null;
                    break;
                }
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < universityStudents.length - 1; j++) {
                universityStudents[j] = universityStudents[j + 1];

            }
            universityStudents[universityStudents.length - 1] = null;
            break;
        }
        return student1;
    }

    public Lecturer1 deleteLecturersOfUniversity(int ID) {
        Lecturer1 lecturer1 = null;
        for (int i = 0; i < universityLecturers.length; i++) {
            if (universityLecturers[i] != null) {
                if (universityLecturers[i].getID() == ID) {
                    lecturer1 = universityLecturers[i];
                    universityLecturers[i] = null;
                    break;
                }
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < universityLecturers.length - 1; j++) {
                universityLecturers[j] = universityLecturers[j + 1];

            }
            universityLecturers[universityLecturers.length - 1] = null;
            break;
        }
        return lecturer1;
    }


    private static boolean containsStudent(Student1[] students, Student1 target) {
        for (Student1 student : students) {
            if (student != null && student.equals(target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLecturer(Lecturer1[] lecturers, Lecturer1 target) {
        for (Lecturer1 lecturer : lecturers) {
            if (lecturer != null && lecturer.equals(target)) {
                return true;
            }
        }
        return false;
    }


    public Faculty1 findFacultyByName(String nameOfFaculty) {
        for (int i = 0; i < size; i++) {
            if (universityFaculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                return universityFaculties[i];
            }
        }
        return null; // Якщо факультет з такою назвою не знайдено
    }

    // Метод, який буде редагувати поля даного нам на вхід студента
    // метод статичний, бо він не повинен мати ніякої прив'язки до якогось класу
    public Student1 editStudent(int IDtoEdit) throws IOException {

        int positionOfStudent = 0;
        for (int i = 0; i < universityStudents.length; i++) {
            if (universityStudents[i].getID() == IDtoEdit) {
                positionOfStudent = i;
                break;
            }
        }

        System.out.println("Виводимо інформатицію про студента до редагування: ");
        System.out.println(universityStudents[positionOfStudent]);

        int choice = DataInput.getInt("Які поля студента ви хочете змінити: " + "\n" +
                "Щоб змінити <Ім'я> введіть 1" + "\n" +
                "Щоб змінити <Вік> введіть 2" + "\n" +
                "Щоб змінити <Середню оцінку> введіть 3" + "\n" +
                "Щоб змінити <Посаду> введіть 4" + "\n" +
                "Щоб змінити <Курс> введіть 5" + "\n" +
                "Щоб змінити <Факультет> введіть 6" + "\n" +
                "Щоб змінити <Кафедру> введіть 7" + "\n");

        while (choice < 1 || choice > 7) {
            choice = DataInput.getInt("Які поля студента ви хочете змінити: " + "\n" +
                    "Щоб змінити <Ім'я> введіть 1" + "\n" +
                    "Щоб змінити <Вік> введіть 2" + "\n" +
                    "Щоб змінити <Середню оцінку> введіть 3" + "\n" +
                    "Щоб змінити <Посаду> введіть 4" + "\n" +
                    "Щоб змінити <Курс> введіть 5" + "\n" +
                    "Щоб змінити <Факультет> введіть 6" + "\n" +
                    "Щоб змінити <Кафедру> введіть 7" + "\n");
        }

        switch (choice) {
            case 1:
                universityStudents[positionOfStudent].setName(DataInput.getString("Введіть нове ім'я: "));
                break;
            case 2:
                universityStudents[positionOfStudent].setAge(DataInput.getInt("Введіть новий вік студента: "));
                break;
            case 3:
                universityStudents[positionOfStudent].setAverageGrade(DataInput.getInt("Введіть нову середню оцінку студента: "));
                break;
            case 4:
                universityStudents[positionOfStudent].setPosition(DataInput.getString("Введіть нову посаду студента: "));
                break;
            case 5:
                universityStudents[positionOfStudent].setCourse(DataInput.getInt("Введіть новий курс студента: "));
                break;
            case 6:
                universityStudents[positionOfStudent].setFaculty(DataInput.getString("Введіть новий Факультет студента: "));
                break;
            case 7:

                for (int i = 0; i < universityStudents[positionOfStudent].getArrayOfDepartmentsStudentToBelongs().length; i++) {
                    String newDepartment = DataInput.getString("Введіть нову кафедру");
                    universityStudents[positionOfStudent].getArrayOfDepartmentsStudentToBelongs()[i] = newDepartment;
                }
                break;
        }

        System.out.println("Виводимо інформатицію про студента після редагування: ");
        System.out.println(universityStudents[positionOfStudent]);
        return universityStudents[positionOfStudent];
    }

    public Lecturer1 editLecturer(int ID) throws IOException {
        int positionOfLecturer = 0;
        for (int i = 0; i < universityLecturers.length; i++) {
            if (universityLecturers[i].getID() == ID) {
                positionOfLecturer = i;
                break;
            }
        }
        System.out.println("Виводимо інформатицію про викладача до редагування: ");
        System.out.println(universityLecturers[positionOfLecturer]);

        int choice = DataInput.getInt("Які поля викладача ви хочете змінити: " + "\n" +
                "Щоб змінити <Ім'я> введіть 1" + "\n" +
                "Щоб змінити <Вік> введіть 2" + "\n" +
                "Щоб змінити <Посаду> введіть 3" + "\n" +
                "Щоб змінити <Факультет> введіть 4" + "\n" +
                "Щоб змінити <Кафедру> введіть 5" + "\n");

        while (choice < 1 || choice > 5) {
            choice = DataInput.getInt("Які поля викладача ви хочете змінити: " + "\n" +
                    "Щоб змінити <Ім'я> введіть 1" + "\n" +
                    "Щоб змінити <Вік> введіть 2" + "\n" +
                    "Щоб змінити <Посаду> введіть 3" + "\n" +
                    "Щоб змінити <Факультет> введіть 4" + "\n" +
                    "Щоб змінити <Кафедру> введіть 5" + "\n");
        }

        switch (choice) {
            case 1:
                universityLecturers[positionOfLecturer].setName(DataInput.getString("Введіть нове ім'я: "));
                break;
            case 2:
                universityLecturers[positionOfLecturer].setAge(DataInput.getInt("Введіть новий вік викладача: "));
                break;
            case 3:
                universityLecturers[positionOfLecturer].setPosition(DataInput.getString("Введіть нову посаду викладача: "));
                break;
            case 4:
                universityLecturers[positionOfLecturer].setFaculty(DataInput.getString("Введіть новий факультет викладача: "));
                break;
            case 5:
                for (int i = 0; i < universityLecturers[positionOfLecturer].getArrayOfDepartmentsLecturerToBelongs().length; i++) {
                    String newDepartment = DataInput.getString("Введіть нову кафедру: ");
                    universityLecturers[positionOfLecturer].getArrayOfDepartmentsLecturerToBelongs()[i] = newDepartment;
                }
                break;
            default:
                System.out.println("Не існує такої опції ");
        }

        System.out.println("Виводимо інфорамцію про доданого викладача після редагування: ");
        System.out.println(universityLecturers[positionOfLecturer]);

        return universityLecturers[positionOfLecturer];
    }

    String[] ar1;
    String[] ar2;

    public String[] getStudentsByFaculty(String facultyName) {
        for (int i = 0; i < universityFaculties.length; i++) {
            if (universityFaculties[i] != null) {
                if (universityFaculties[i].getNameOfFaculty().equals(facultyName)) {
                    ar1 = new String[universityFaculties[i].getStudentsOfFaculty().length];
                    for (int j = 0; j < universityFaculties[i].getStudentsOfFaculty().length; j++) {
                        if (universityFaculties[i].getStudentsOfFaculty()[j] != null) {
                            ar1[j] = universityFaculties[i].getStudentsOfFaculty()[j].getName();
                        }
                    }
                    break;
                }
            }

        }
        return ar1;
    }

    public String[] getLecturersByFaculty(String facultyName) {
        for (int i = 0; i < universityFaculties.length; i++) {
            if (universityFaculties[i] != null) {
                if (universityFaculties[i].getNameOfFaculty().equals(facultyName)) {
                    ar2 = new String[universityFaculties[i].getLecturerOfFaculty().length];
                    for (int j = 0; j < universityFaculties[i].getLecturerOfFaculty().length; j++) {
                        if (universityFaculties[i].getLecturerOfFaculty()[j] != null) {
                            ar1[j] = universityFaculties[i].getLecturerOfFaculty()[j].getName();
                        }
                    }
                    break;
                }
            }

        }
        return ar2;
    }
}