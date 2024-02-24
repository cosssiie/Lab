//клас-виконавець

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int maxSize = DataInput.getInt("Скiльки факультетiв матиме унiверситет?");
        University university = new University(maxSize);
        
        System.out.println("1. ~Додати факультет~ ");
        System.out.println("2. ~Редагувати факультет~ ");
        System.out.println("3. ~Видалити факультет~ ");
        System.out.println("4. ~Додати кафедру до факультету~ ");
        System.out.println("5. ~Вихiд~");

        int choose = DataInput.getInt("Оберiть дiю: ");

        while (choose < 5) {
        switch (choose) {
        case 1:

            int count = DataInput.getInt("Скiльки хочете додати зараз?");
            for (int i = 0; i < count; i++){
            String nameOfFaculty = DataInput.getString("Введiть назву факультету");
            university.createFaculty(nameOfFaculty);
            }
            university.Faculties();
            
        break;
        
        case 2:
            university.Faculties();
            String previousName = DataInput.getString("Попередня  назва факультету: ");
            String newName = DataInput.getString("Нова назва факультету: ");
            university.editFaculty(previousName,newName);
            university.Faculties();

        break;

        case 3:
            university.Faculties();
            String nameOfFaculty = DataInput.getString("Назва факультету, який хочете видалити");
            university.deleteFaculty(nameOfFaculty);
            university.Faculties();

        break;

        case 4:
            int departmentCount = DataInput.getInt("Кiлькiсть кафедр: ");
            Faculty faculty = new Faculty(departmentCount);

            count = DataInput.getInt("Скiльки хочете додати зараз?");
            for (int i = 0; i < count; i++){
                String nameOfDepartment = DataInput.getString("Назва кафедри, яку хочете додати");
                university.Faculties();
                nameOfFaculty = DataInput.getString("Назва факультету, куди додати кафедру");
                faculty.createDepartment(nameOfDepartment, nameOfFaculty);
            }

        break;

        default:

        break;
        }
        choose = DataInput.getInt("Оберiть дiю: ");

    }
}


}
