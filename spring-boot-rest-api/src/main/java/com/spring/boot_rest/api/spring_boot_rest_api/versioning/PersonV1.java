package com.spring.boot_rest.api.spring_boot_rest_api.versioning;

public class PersonV1 {
    private String name;
    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
