//клас факультету 
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


    /**метод виводу кафедр певного факультета */
    public void Departments() {
        System.out.println("Факультет: " + nameOfFaculty);
        System.out.println("Список кафедр:");
        for (int i = 0; i < size; i++) {
            System.out.println(departments[i].getNameOfDepartment());
        }
        if (size == 0){
            System.out.println("Наразi ви не додали жодну кафедру");
        }
    }


    /*  методи створення/редагування/видалення кафедри  */
    public void createDepartment(String nameOfDepartment, String nameOfFaculty){
        if (size < departments.length) {
            Department department = new Department(nameOfDepartment);
            departments[size] = department;
            size++;
            System.out.println("Кафедра " + nameOfDepartment + " успiшно створена на факультетi " + nameOfFaculty);
        } else {
            System.out.println("Неможливо додати нову кафедру. Максимальна кiлькiсть досягнута");
        }
    }

    public void deleteDepartment(){

    }

    public void editDepartment(){

    }

}