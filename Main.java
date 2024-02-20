//клас-виконавець

public class Main {

    public static void main(String[] args) {
        int maxSize = DataInput.getInt("Скільки факультетів матиме університет? ");
        University university = new University(maxSize);

        // Додавання факультетів
        university.createFaculty("Інформатики");
        university.createFaculty("Міжнародних відносин");
        university.createFaculty("Філології");

        // Показати початковий список факультетів
        university.Faculties();

    }

    
}
