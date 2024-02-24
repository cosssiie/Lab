//клас кафедри

public class Department {

    private String nameOfDepartment;
    // private String[] students;
    // private String [] lecturers;

    public Department (String nameOfDepartment,String[] students, String [] lecturers  ) {
        this.nameOfDepartment = nameOfDepartment;
        //this.students = new String[10];
        //this.lecturers = new String[10];
    }

    
    public Department(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }


    public void addLecturer(){

    }

    public void addStudent(){

    }

    public void deleteLecturer(){
        
    }

    public void deleteStudent(){
        
    }

    public void editStudent(){
        
    }

    public void editLecturer(){
        
    }

  
    
}

