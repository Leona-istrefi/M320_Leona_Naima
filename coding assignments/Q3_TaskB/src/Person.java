import java.util.*;

class Person {
    String name;
    boolean hasCar;
    List<Person> friends;

    public Person(String name, boolean hasCar) {
        this.name = name;
        this.hasCar = hasCar;
        this.friends = new ArrayList<>();
    }

    public void addFriend(Person friend) {
        this.friends.add(friend);
        friend.friends.add(this); // Bidirektionale connection
    }
}