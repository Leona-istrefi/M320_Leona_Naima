package org.example;

import java.util.*;

public class Friendships {
    private Map<String, List<String>> friendshipsMap;

    public Friendships() {
        friendshipsMap = new HashMap<>();
    }

    public void addFriend(String person, String friend) {
        friendshipsMap.computeIfAbsent(person, k -> new ArrayList<>()).add(friend);
    }

    public List<String> getFriendsList(String person) {
        return friendshipsMap.getOrDefault(person, new ArrayList<>());
    }

    public boolean areFriends(String person, String friend) {
        return friendshipsMap.getOrDefault(person, new ArrayList<>()).contains(friend);
    }

    public String findPerson(String name) {
        for (String person : friendshipsMap.keySet()) {
            if (person.equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;

    }
}