public class Faculty {

    private String nameOfFaculty;

    private Department[] departments;
    private int size;

    public Faculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public Faculty(int departmentCount) {
        departments = new Department[departmentCount];
        size = 0;
    }

    public String getNameOfFaculty() {
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
    public void editDepartment(String previousName, String newName) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (departments[i].getNameOfDepartment().equals(previousName)) {
                departments[i].setNameOfDepartment(newName);
                found = true;
                System.out.println("Назву кафедри " + previousName + " успiшно змiнено на " + newName);
                break;
            }
        }
        if (!found) {
            System.out.println("Кафедра з назвою " + previousName + " не знайдена на факультеті " + nameOfFaculty);
        }
    }

    // Інші методи вашого класу...
}
