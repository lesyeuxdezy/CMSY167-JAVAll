/**
 * Exercise - Planet Facts (Collection)
 * Copyright 2023 Howard Community College
 *
 * @author Jeryzza Tomas
 * @version 3.2
 */

package src;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Prints facts about planets - practice using Collections methods
 */
public class PlanetsMain {
    public static void main(String[] args) {
        // Source https://nssdc.gsfc.nasa.gov/planetary/factsheet/
        List<Planet> planets = new ArrayList<>(9);
        planets.add(new Planet("Mercury", 0.33, 58));
        planets.add(new Planet("Venus", 4.87, 108));
        planets.add(new Planet("Earth", 5.97, 150));
        planets.add(new Planet("Mars", .642, 228));
        planets.add(new Planet("Jupiter", 1898, 779));
        planets.add(new Planet("Saturn", 568, 1434));
        planets.add(new Planet("Uranus", 86.8, 2873));
        planets.add(new Planet("Neptune", 102, 4495));
        planets.add(new Planet("Pluto", 0.0146, 5906));

        System.out.println("Original order:");
        printPlanets(planets);

        // Randomize the order of the planets
        Collections.shuffle(planets);

        System.out.println("Planets in a random order:");
        printPlanets(planets);

        // Remove Pluto
        planets.removeIf(p -> p.getName().equals("Pluto"));

        System.out.println("Removed Pluto:");
        printPlanets(planets);

        // Sort by distance from sun using natural ordering (implemented in Planet class)
        Collections.sort(planets);

        System.out.println("Sorted by distance from sun:");
        printPlanets(planets);

        // Sort alphabetically using a Comparator class
        Comparator<Planet> nameComparator = Comparator.comparing(Planet::getName);
        Collections.sort(planets, nameComparator);

        System.out.println("Sorted alphabetically:");
        printPlanets(planets);

        // Sort by mass using a Comparator class
        Comparator<Planet> massComparator = Comparator.comparing(Planet::getMass);
        Collections.sort(planets, massComparator);

        System.out.println("Sorted by mass:");
        printPlanets(planets);

        // Add each planet in your list to a Map (name => Planet)
        Map<String, Planet> planetMap = new HashMap<>();
        for (Planet planet : planets) {
            planetMap.put(planet.getName(), planet);
        }

        System.out.println("Earth: " + planetMap.get("Earth"));

        // Retrieve and print Mars
        System.out.println("Mars: " + planetMap.get("Mars"));
    }

    /**
     * Print the planet list in a table
     */
    private static void printPlanets(List<Planet> planets) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-15s%-10s%n%n", "Planet", "Mass", "Distance");
        for (Planet planet : planets) {
            System.out.printf("%-10s%-15.3f%-10d%n", planet.getName(),
                    planet.getMass(), planet.getDistance());
        }
        System.out.println("------------------------------------------------------------\n");
    }
}