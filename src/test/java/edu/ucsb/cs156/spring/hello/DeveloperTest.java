package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from
        // https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-f25-teams>
        assertEquals("Andrew S.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("andrewzshen", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team team = Developer.getTeam();
        assertEquals(team.getName(), "f25-06");
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team team = Developer.getTeam();
        assertTrue(team.getMembers().contains("Andrew Zhuo"), "Team should contain Andrew Zhuo.");
        assertTrue(team.getMembers().contains("Austin"), "Team should contain Austin.");
        assertTrue(team.getMembers().contains("Abhiram"), "Team should contain Abhiram.");
        assertTrue(team.getMembers().contains("Julia"), "Team should contain Julia.");
        assertTrue(team.getMembers().contains("Longjiao"), "Team should contain Longjiao.");
        assertTrue(team.getMembers().contains("Natalie Marie"), "Team should contain Natalie Marie.");
    }
}
