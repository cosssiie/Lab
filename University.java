//клас університету
public class University {


    private static Lecturer[] universityLecturers = new Lecturer[0];
    private static Student[] universityStudents = new Student[0];

    public static Lecturer[] getUniversityLecturers() {
        return universityLecturers;
    }

    public static void setUniversityLecturers(Lecturer[] universityLecturers) {
        University.universityLecturers = universityLecturers;
    }

    public static Student[] getUniversityStudents() {
        return universityStudents;
    }

    public static void setUniversityStudents(Student[] universityStudents) {
        University.universityStudents = universityStudents;
    }

    public static void setFaculties(Faculty[] faculties) {
        University.faculties = faculties;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        University.size = size;
    }

    private static Faculty[] faculties;

    public static Faculty[] getFaculties() {
        return faculties;
    }

    private static int size;

    public University() {

    }

    public University(int maxSize) {
        faculties = new Faculty[maxSize];
        size = 0;
    }

    /**
     * метод виводу всіх факультетів університету
     */
    public void Faculties() {
        System.out.println("Список факультетiв:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + faculties[i].getNameOfFaculty());
        }
        if (size == 0) {
            System.out.println("Наразi ви не додали жоден факультет");
        }
    }

    /*  методи створення/редагування/видалення факультету  */
    public static void createFaculty(String nameOfFaculty) {
        if (size < faculties.length) {
            Faculty faculty = new Faculty(nameOfFaculty);
            faculties[size] = faculty;
            size++;
            System.out.println("Факультет " + nameOfFaculty + " успiшно створений");
        } else {
            System.out.println("Неможливо додати новий факультет. Максимальна кiлькiсть факультетiв досягнута");
        }
    }

    public void deleteFaculty(String nameOfFaculty) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                for (int j = i; j < size - 1; j++) {
                    faculties[j] = faculties[j + 1];
                }
                size--;
                found = true;
                System.out.println("Факультет " + nameOfFaculty + " успiшно видалений");
                break;
            }
        }
        if (!found) {
            System.out.println("Факультет з назвою " + nameOfFaculty + " не знайдено");
        }
    }

    public void editFaculty(String previousName, String newName) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (faculties[i].getNameOfFaculty().equals(previousName)) {
                faculties[i].setNameOfFaculty(newName);
                found = true;
                System.out.println("Назву факультету успiшно змiнено з " + previousName + " на " + newName);
                break;
            }
        }
        if (!found) {
            System.out.println("Факультет з назвою " + previousName + " не знайдено");
        }
    }

    public Faculty findFacultyByName(String nameOfFaculty) {
        for (int i = 0; i < size; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                return faculties[i];
            }
        }
        return null; // Якщо факультет з такою назвою не знайдено
    }

    public static void addStudentsOfUniversityToFaculty(Student[] facultyStudents) {
        boolean isFull = true;

        for (Student student : facultyStudents) {
            if (student == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            Student[] newStudents = new Student[(facultyStudents.length + 1) * 2];
            for (int i = 0; i < facultyStudents.length; i++) {
                newStudents[i] = facultyStudents[i];
            }
            facultyStudents = newStudents;
        }

        for (Student student : universityStudents) {
            if (student != null && !containsStudent(facultyStudents, student)) {
                for (int i = 0; i < facultyStudents.length; i++) {
                    if (facultyStudents[i] == null) {
                        facultyStudents[i] = student;
                        break;
                    }
                }
            }
        }
    }

    public static void addLecturersOfUniversityToFaculty(Lecturer[] facultyLecturers) {
        boolean isFull = true;

        for (Lecturer lecturer : facultyLecturers) {
            if (lecturer == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            Lecturer[] newLecturer = new Lecturer[(facultyLecturers.length + 1) * 2];
            for (int i = 0; i < facultyLecturers.length; i++) {
                newLecturer[i] = facultyLecturers[i];
            }
            facultyLecturers = newLecturer;
        }

        for (Lecturer lecturer : universityLecturers) {
            if (lecturer != null && !containsLecturer(facultyLecturers, lecturer)) {
                for (int i = 0; i < facultyLecturers.length; i++) {
                    if (facultyLecturers[i] == null) {
                        facultyLecturers[i] = lecturer;
                        break;
                    }
                }
            }
        }
    }

    public static void deleteStudentsOfUniversiyt(Student someStudent) {

        for (int i = 0; i < universityStudents.length; i++) {
            if (universityStudents[i].equals(someStudent)) {
                universityStudents[i] = null;
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < universityStudents.length - 1; j++) {
                universityStudents[j] = universityStudents[j + 1];

            }
            universityStudents[universityStudents.length - 1] = null;
            break;
        }
    }

    public static void deleteLecturerOfUniversity(Lecturer someLecturer) {
        for (int i = 0; i < universityLecturers.length; i++) {
            if (universityLecturers[i].equals(someLecturer)) {
                universityLecturers[i] = null;
            }
            // просто для краси структури масиву прибираємо пробіл з null посиланням
            // методом зміщення всіх елементів масиву на 1, починаючи цикл з місця null
            for (int j = i; j < universityLecturers.length - 1; j++) {
                universityLecturers[j] = universityLecturers[j + 1];

            }
            universityLecturers[universityLecturers.length - 1] = null;
            break;
        }
    }


    private static boolean containsStudent(Student[] students, Student target) {
        for (Student student : students) {
            if (student != null && student.equals(target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLecturer(Lecturer[] lecturers, Lecturer target) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer != null && lecturer.equals(target)) {
                return true;
            }
        }
        return false;
    }


}