class Student {
    private String name;
    private int age;
    private String regNumber;
    private double gpa;

    public Student(String name, int age, String regNumber, double gpa) {
        this.name = name;
        this.age = age;
        this.regNumber = regNumber;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getRegNumber() { return regNumber; }
    public double getGpa() { return gpa; }

    public void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age +
                           ", Reg#: " + regNumber + ", GPA: " + gpa);
    }
}

class StudentArrayOps {

    public void printAll(Student[] students) {
        for (Student s : students) s.printDetails();
    }

    public Student getOldest(Student[] students) {
        Student oldest = students[0];
        for (Student s : students)
            if (s.getAge() > oldest.getAge()) oldest = s;
        return oldest;
    }

    public Student getYoungest(Student[] students) {
        Student youngest = students[0];
        for (Student s : students)
            if (s.getAge() < youngest.getAge()) youngest = s;
        return youngest;
    }

    public Student getTopGPA(Student[] students) {
        Student top = students[0];
        for (Student s : students)
            if (s.getGpa() > top.getGpa()) top = s;
        return top;
    }

    public void printClassHolders(Student[] students) {
        for (Student s : students)
            if (s.getGpa() >= 3.0) s.printDetails();
    }

    public Student searchByReg(Student[] students, String regNumber) {
        for (Student s : students)
            if (s.getRegNumber().equals(regNumber)) return s;
        return null;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Student[] students = new Student[10];

        students[0] = new Student("Suleka", 22, "REG001", 3.9);
        students[1] = new Student("Nuwan", 21, "REG002", 2.5);
        students[2] = new Student("Kavindi", 23, "REG003", 2.8);
        students[3] = new Student("Tharindu", 20, "REG004", 3.2);
        students[4] = new Student("Ishara", 22, "REG005", 2.7);
        students[5] = new Student("Ravindu", 24, "REG006", 3.6);
        students[6] = new Student("Dinithi", 19, "REG007", 2.4);
        students[7] = new Student("Sahan", 25, "REG008", 3.1);
        students[8] = new Student("Chamodi", 20, "REG009", 2.9);
        students[9] = new Student("Pasindu", 21, "REG010", 3.3);

        StudentArrayOps ops = new StudentArrayOps();

        System.out.println("Particular Student:");
        Student found = ops.searchByReg(students, "REG003");
        if (found != null) found.printDetails();

        System.out.println("\nOldest Student:");
        ops.getOldest(students).printDetails();

        System.out.println("\nYoungest Student:");
        ops.getYoungest(students).printDetails();

        System.out.println("\nClass Holders:");
        ops.printClassHolders(students);
    }
}