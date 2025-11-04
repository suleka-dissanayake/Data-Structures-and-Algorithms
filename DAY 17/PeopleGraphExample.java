import java.util.*;

class Person {
    private String name;
    private int age;
    private String city;
    private List<Person> friends;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person person) {
        if (!friends.contains(person)) {
            friends.add(person);
        }
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}

class Graph {
    private List<Person> people;

    public Graph() {
        people = new ArrayList<>();
    }

    public void addPerson(String name, int age, String city) {
        if (getPersonByName(name) == null) {
            people.add(new Person(name, age, city));
        }
    }

    public void addConnection(String name1, String name2) {
        Person p1 = getPersonByName(name1);
        Person p2 = getPersonByName(name2);
        if (p1 != null && p2 != null) {
            p1.addFriend(p2);
            p2.addFriend(p1);
        }
    }

    private Person getPersonByName(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public void printGraph() {
        for (Person p : people) {
            System.out.print(p + " -> ");
            for (Person f : p.getFriends()) {
                System.out.print(f.getName() + " ");
            }
            System.out.println();
        }
    }
}

public class PeopleGraphExample {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addPerson("Kumar", 23, "Vavuniya");
        graph.addPerson("Bala", 25, "Jaffna");
        graph.addPerson("Silva", 24, "Galle");
        graph.addPerson("Perera", 24, "Colombo");

        graph.addConnection("Kumar", "Bala");
        graph.addConnection("Kumar", "Perera");
        graph.addConnection("Bala", "Ravi");

        graph.printGraph();
    }
}