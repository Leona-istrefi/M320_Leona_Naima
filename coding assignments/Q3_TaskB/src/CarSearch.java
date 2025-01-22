import java.util.*;

public class CarSearch {
    public static Person findNearestCarOwner(Person start) {
        Queue<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();

            if (current.hasCar) {
                return current; // Person with car that was found
            }

            for (Person friend : current.friends) {
                if (!visited.contains(friend)) {
                    queue.add(friend);
                    visited.add(friend);
                }
            }
        }
        return null; // No car in friend group
    }

    public static void main(String[] args) {
        Person naima = new Person("naima", true);
        Person bob = new Person("bob", false);
        Person john = new Person("john", false);
        Person leona = new Person("leona", false);
        Person peter = new Person("peter", true);
        Person frank = new Person("frank", false);

        naima.addFriend(bob);
        bob.addFriend(john);
        bob.addFriend(peter);
        naima.addFriend(leona);
        leona.addFriend(frank);

        // Search for person with car
        Person result = findNearestCarOwner(frank);

        if (result != null) {
            System.out.println("Next person with car: " + result.name);
        } else {
            System.out.println("No person with car was found.");
        }
    }
}
