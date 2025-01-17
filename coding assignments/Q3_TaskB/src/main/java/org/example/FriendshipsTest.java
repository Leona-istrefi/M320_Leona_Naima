package org.example;

import org.example.Friendships;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FriendshipsTest {
    private Friendships friendships;

    @BeforeEach
    void setUp() throws Exception {
        friendships = new Friendships();
        // Dummy-Daten hinzufügen
        friendships.addFriend("Joe", "Audrey");
        friendships.addFriend("Joe", "Mike");
    }

    @AfterEach
    void tearDown() throws Exception {
        // Ressourcen freigeben, falls nötig
    }

    @Test
    void testGetFriendsList() {
        assertEquals(2, friendships.getFriendsList("Joe").size(), 0);
    }

    @Test
    void testAreFriends() {
        assertTrue(friendships.areFriends("Joe", "Audrey"));
        assertFalse(friendships.areFriends("Joe", "John")); // Beispiel für negative Test
    }

    @Test
    void testFindPerson() {
        assertEquals("Joe", friendships.findPerson("Joe"));
        assertNull(friendships.findPerson("NonExistentPerson"));
    }
}