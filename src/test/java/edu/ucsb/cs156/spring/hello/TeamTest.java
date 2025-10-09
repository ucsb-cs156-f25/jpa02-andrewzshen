package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_not_instanceof() {
        assertFalse(team.equals("Not a team object"));
    }

    @Test 
    public void equals_names_equal_and_members_equal() {
        Team other = new Team("test-team");
        assertTrue(team.equals(other));    
    }
    
    @Test 
    public void equals_names_equal_but_members_not_equal() {
        Team other = new Team("test-team");
        other.addMember("Andrew");
        assertFalse(team.equals(other));    
    }

    @Test 
    public void equals_members_equal_but_names_not_equal() {
        Team other = new Team("other-team");
        assertFalse(team.equals(other));    
    }

    @Test 
    public void equals_neither_names_or_members_equal() {
        Team other = new Team("other-team");
        other.addMember("Andrew");
        assertFalse(team.equals(other));    
    }

    @Test
    public void hashCode_same_hash() {
        Team other = new Team("test-team");
        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_expected_match() {
        int result = team.hashCode();
        int expected = -1226298695;
        assertEquals(expected, result);
    }
}
