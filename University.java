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
        System.out.println("Список факультетів:");
        for (int i = 0; i < size; i++) {
            System.out.println(faculties[i].getNameOfFaculty());
        }
    }

    /*  методи створення/редагування/видалення факультету  */
    public void createFaculty(String nameOfFaculty){
        if (size < faculties.length) {
            Faculty faculty = new Faculty(nameOfFaculty);
            faculties[size] = faculty;
            size++;
            System.out.println("Факультет " + nameOfFaculty + " успішно створений.");
        } else {
            System.out.println("Неможливо додати новий факультет. Максимальна кількість факультетів досягнута.");
        }
    }

    public void deleteFaculty(){
        
    }

    public void editFaculty(){
        
    }

}
