public class Faculty {

    private static String nameOfFaculty;

    public static Department[] departments;
    private int size;

    public Faculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public Faculty(int departmentCount) {
        departments = new Department[departmentCount];
        size = 0;
    }

    public static String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    // Метод для створення кафедри з вказаною назвою
    public void createDepartment(String nameOfDepartment, String nameOfFaculty) {
        if (size < departments.length) {
            Department department = new Department(nameOfDepartment);
            departments[size] = department;
            size++;
            System.out.println("Кафедра " + nameOfDepartment + " успiшно створена на факультетi " + nameOfFaculty);
        } else {
            System.out.println("Неможливо додати нову кафедру. Максимальна кiлькiсть досягнута");
        }
    }

    // Метод для редагування кафедри з вказаною попередньою та новою назвою
    public static void editDepartment(String previousName, String newName) {
        boolean departmentFound = false;
    
        // Шукаємо кафедру за попередньою назвою та редагуємо її, якщо знайдено
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null && departments[i].getNameOfDepartment().equals(previousName)) {
                departmentFound = true;
                departments[i].setNameOfDepartment(newName);
                System.out.println("Назву кафедри \"" + previousName + "\" успішно змінено на \"" + newName + "\"");
                break;
            }
        }
    
        if (!departmentFound) {
            System.out.println("Кафедру з назвою \"" + previousName + "\" не знайдено!");
        }
    }
    

    public static void deleteDepartment(String nameOfDepartment) {
        // Перевіряємо, чи масив кафедр не є порожнім
        if (departments.length == 0) {
            System.out.println("Немає кафедр для видалення, масив кафедр порожній!");
            return;
        }
        boolean departmentFound = false;
    
        // Шукаємо кафедру за назвою та видаляємо її, якщо знайдено
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null && departments[i].getNameOfDepartment().equals(nameOfDepartment)) {
                departmentFound = true;
                departments[i] = null;
    
                // Переставляємо всі наступні елементи масиву вліво, щоб заповнити порожні місця
                for (int j = i; j < departments.length - 1; j++) {
                    departments[j] = departments[j + 1];
                }
                break;
            }
        }
        if (departmentFound) {
            System.out.println("Кафедру \"" + nameOfDepartment + "\" успішно видалено!");
        } else {
            System.out.println("Кафедру з назвою \"" + nameOfDepartment + "\" не знайдено!");
        }
    }

    public static void showDepartments(String facultyName) {
        boolean found = false;
        for (Department department : departments) {
            if (department != null && getNameOfFaculty().equals(facultyName)) {
                System.out.println("Кафедра: " + department.getNameOfDepartment());
                found = true;
            }
        }
        if (!found) {
            System.out.println("На факультеті " + facultyName + " немає жодної кафедри");
        }
    }
    
    
}

