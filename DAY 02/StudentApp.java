class Student {
    String name;
    String regNo;
    int age;
    double gpa;
    boolean isClassHolder;

    public Student(String name, String regNo, int age, double gpa, boolean isClassHolder) {
        this.name = name;
        this.regNo = regNo;
        this.age = age;
        this.gpa = gpa;
        this.isClassHolder = isClassHolder;
    }

    public void printDetails() {
        System.out.println("Name: " + name + ", RegNo: " + regNo + ", Age: " + age +
                           ", GPA: " + gpa);
    }
}

class StudentArrayOps {

    public void printAllStudents(Student[] students) {
        for (Student s : students) {
            s.printDetails();
        }
    }

    public Student getYoungest(Student[] students) {
        Student youngest = students[0];
        for (Student s : students) {
            if (s.age < youngest.age) {
                youngest = s;
            }
        }
        return youngest;
    }

    public Student getOldest(Student[] students) {
        Student oldest = students[0];
        for (Student s : students) {
            if (s.age > oldest.age) {
                oldest = s;
            }
        }
        return oldest;
    }

    public Student getHighestGPA(Student[] students) {
        Student topStudent = students[0];
        for (Student s : students) {
            if (s.gpa > topStudent.gpa) {
                topStudent = s;
            }
        }
        return topStudent;
    }

    public Student[] getClassHolders(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s.isClassHolder) count++;
        }

        Student[] holders = new Student[count];
        int index = 0;
        for (Student s : students) {
            if (s.isClassHolder) {
                holders[index++] = s;
            }
        }
        return holders;
    }

    public Student searchByRegNo(Student[] students, String regNo) {
        for (Student s : students) {
            if (s.regNo.equalsIgnoreCase(regNo)) {
                return s;
            }
        }
        return null;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Tom", "S001", 23, 3.8, true),
            new Student("John", "S002", 22, 3.5, true),
            new Student("Kira", "S003", 22, 3.9, true),
            new Student("Jim", "S004", 20, 2.8, false),
			new Student("Ravi", "S005", 21, 2.9, false),
			new Student("Kasun", "S006", 22, 3.6, true),
			new Student("Pavan", "S007", 24, 2.9, false),
			new Student("Pamuda", "S008", 21, 3.4, true),
			new Student("Suleka", "S009", 21, 4.0, true),
			new Student("Abishek", "S010", 21, 3.6, true)
        };

        StudentArrayOps ops = new StudentArrayOps();
		System.out.println();

        ops.printAllStudents(students);
		System.out.println();
        System.out.println("Youngest: " + ops.getYoungest(students).name);
        System.out.println("Oldest: " + ops.getOldest(students).name);
        System.out.println("Top GPA: " + ops.getHighestGPA(students).name);
		System.out.println();

        System.out.println("Class Holders:");
        for (Student s : ops.getClassHolders(students)) {
            s.printDetails();
        }
		System.out.println();

        Student found = ops.searchByRegNo(students, "S005");
        if (found != null) {
            System.out.println("Found student:");
            found.printDetails();
        } else {
            System.out.println("Student not found.");
        }
    }
}