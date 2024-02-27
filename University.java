//клас університету
public class University {

    private Faculty[] faculties;
    private int size;

    public University(int maxSize) {
        faculties = new Faculty[maxSize];
        size = 0;
    }

    /**метод виводу всіх факультетів університету */
    public void Faculties() {
        System.out.println("Список факультетiв:");
        for (int i = 0; i < size; i++) {
            System.out.println((i+1) + ". "+  faculties[i].getNameOfFaculty());
        }
        if (size == 0){
            System.out.println("Наразi ви не додали жоден факультет");
        }
    }

    /*  методи створення/редагування/видалення факультету  */
    public void createFaculty(String nameOfFaculty){
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
    


}