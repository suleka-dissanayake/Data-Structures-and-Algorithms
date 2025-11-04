import java.util.ArrayList;

class Person {
    String name;
    int age;
    String city;
    ArrayList<Person> children;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}

public class TreeObjects {

    static void displayTree(Person root, String indent) {
        System.out.println(indent + root);

        for (Person child : root.children) {
            displayTree(child, indent + "   ");
        }
    }

    public static void main(String[] args) {
        Person grandParent = new Person("John", 70, "New York");
        Person parent1 = new Person("Michael", 45, "Chicago");
        Person parent2 = new Person("Sarah", 42, "Boston");
        Person child1 = new Person("Emma", 20, "Boston");
        Person child2 = new Person("Lucas", 18, "Boston");
        Person child3 = new Person("Sophia", 16, "Chicago");

        grandParent.addChild(parent1);
        grandParent.addChild(parent2);

        parent1.addChild(child3);
        parent2.addChild(child1);
        parent2.addChild(child2);

        System.out.println("Family Tree:");
        displayTree(grandParent, "");
    }
}
