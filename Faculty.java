public class Faculty {

    private String nameOfFaculty;
    private Department[] departments;
    private int size;

    public Faculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
        this.departments = new Department[15]; // Наприклад, початковий розмір 10
        this.size = 0;
    }

    public Faculty(String nameOfFaculty, int departmentCount) {
        this.nameOfFaculty = nameOfFaculty;
        this.departments = new Department[departmentCount];
        this.size = 0;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    // public void Departments() {
    //     System.out.println("Факультет: " + nameOfFaculty);
    //     System.out.println("Список кафедр:");
    //     for (int i = 0; i < size; i++) {
    //         System.out.println(departments[i].getNameOfDepartment());
    //     }
    //     if (size == 0) {
    //         System.out.println("Наразi немає створених факультетів ");
    //     }
    // }

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

    public Department[] getDepartments() {
        return departments;
    }

    public void deleteDepartment(String nameOfDepartment) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (departments[i].getNameOfDepartment().equals(nameOfDepartment)) {
                for (int j = i; j < size - 1; j++) {
                    departments[j] = departments[j + 1];
                }
                size--;
                found = true;
                System.out.println("\n" + "Кафедра " + nameOfDepartment + " успiшно видалена");
                break;
            }
        }
        if (!found) {
            System.out.println("\n" +"Кафедра з назвою " + nameOfDepartment + " не знайдена");
        }
    }

    public void editDepartment(){
        
    }

    
    
}
