//клас-виконавець

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
 
        System.out.println("1. ~Додати факультет~ ");
        System.out.println("2. ~Редагувати факультет~ ");
        System.out.println("3. ~Видалити факультет~ ");
        System.out.println("4. ~Додати кафедру до факультету~ ");
        // System.out.println("5. ~Вивести кафедри факультета~");
        System.out.println("6. ~Вихiд~");

        // створення університету (тобто його факультети)
        int maxSize = DataInput.getInt("\n" +"Скiльки факультетiв матиме унiверситет?");
        University university = new University(maxSize);
        
        int choose = DataInput.getInt("\n" + "Оберiть дiю: ");

        while (choose < 6) {
        switch (choose) {
        case 1:
            System.out.println("\n" + "Створення факультетiв");
            int count = DataInput.getInt( "\n" + "Скiльки хочете додати зараз?");
            for (int i = 0; i < count; i++){
            String nameOfFaculty = DataInput.getString("\n" +"Введiть назву факультету");
            university.createFaculty(nameOfFaculty);
            }
            university.Faculties();
            
        break;
        
        case 2:
            System.out.println("\n" + "Редагування факультету");
            university.Faculties();
            String previousName = DataInput.getString("\n" +"Попередня  назва факультету: ");
            String newName = DataInput.getString("\n" +"Нова назва факультету: ");
            university.editFaculty(previousName,newName);
            university.Faculties();

        break;

        case 3:
            System.out.println("\n" + "Видалення факультету ");
            university.Faculties();
            String nameOfFaculty = DataInput.getString("\n" +"Назва факультету, який хочете видалити");
            university.deleteFaculty(nameOfFaculty);
            university.Faculties();

        break;

        case 4:
        nameOfFaculty = DataInput.getString("Назва факультету, куди хочете додати кафедру: ");
        
        Faculty faculty = university.findFacultyByName(nameOfFaculty);
        if (faculty != null) {
            int departmentCount = DataInput.getInt("Кiлькiсть кафедр, якi хочете додати зараз: ");
            
            for (int i = 0; i < departmentCount; i++) {
                String nameOfDepartment = DataInput.getString("Назва кафедри, яку хочете додати: ");
                faculty.createDepartment(nameOfDepartment, nameOfFaculty);
            }
        } else {
            System.out.println("Факультет з такою назвою не знайдено!");
        }
        break;

        case 5:


        default:    

        break;
        }
        choose = DataInput.getInt("\n" +"Оберiть дiю: ");

    }
}


}
