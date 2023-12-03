package Task2;

import lombok.Builder;

@Builder
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
}

enum Gender {
    MALE, FEMALE
}