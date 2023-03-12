package org.example;

import java.util.*;

public class AnimalSimulator {

    // Define the Animal class with the added fields
    static class Animal {
        String type;
        boolean gender; // true for male, false for female
        double strength;

        // Constructor to initialize the fields
        public Animal(String type, boolean gender, double strength) {
            this.type = type;
            this.gender = gender;
            this.strength = strength;
        }
    }

    public static void main(String[] args) {
        // Initialize the animal list with some animals
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("lion", true, 5));
        animals.add(new Animal("lion", false, 3));
        animals.add(new Animal("tiger", true, 4));
        animals.add(new Animal("tiger", false, 2));
        animals.add(new Animal("bear", true, 6));
        animals.add(new Animal("bear", false, 4));

        // Print the initial list of animals
        System.out.println("Initial list of animals:");
        for (Animal animal : animals) {
            System.out.printf("%s %s %.2f%n", animal.type, animal.gender ? "male" : "female", animal.strength);
        }
        System.out.println();

        // Iterate through all pairs of animals and check for collisions
        for (int i = 0; i < animals.size(); i++) {
            for (int j = i+1; j < animals.size(); j++) {
                Animal animal1 = animals.get(i);
                Animal animal2 = animals.get(j);
                if (animal1.type.equals(animal2.type)) {
                    // Same type, check for gender and strength
                    if (animal1.gender != animal2.gender) {
                        // Different gender, create new animal
                        Animal baby = new Animal(animal1.type, Math.random() < 0.5, (animal1.strength + animal2.strength) / 2);
                        animals.add(baby);
                        System.out.printf("%s %s and %s %s had a baby: %s %s %.2f%n", animal1.type, animal1.gender ? "male" : "female", animal2.type, animal2.gender ? "male" : "female", baby.type, baby.gender ? "male" : "female", baby.strength);
                    } else if (animal1.strength > animal2.strength) {
                        // Same gender, but animal1 is stronger, remove animal2
                        animals.remove(j);
                        System.out.printf("%s %s killed %s %s%n", animal1.type, animal1.gender ? "male" : "female", animal2.type, animal2.gender ? "male" : "female");
                        j--;
                    } else if (animal1.strength < animal2.strength) {
                        // Same gender, but animal2 is stronger, remove animal1
                        animals.remove(i);
                        System.out.printf("%s %s killed %s %s%n", animal2.type, animal2.gender ? "male" : "female", animal1.type, animal1.gender ? "male" : "female");
                        i--;
                        break;
                    }
                }
            }
        }

        // Print the final list of animals
        System.out.println("\nFinal list of animals:");
        for (Animal animal : animals) {
            System.out.print(animal);
        }
    }
}