package com.codewithbrian.springboot;

public class SoftwareEngineerNotFoundException extends RuntimeException {
    public SoftwareEngineerNotFoundException(Integer id) {
        super("Software Engineer with id " + id + " not found");
    }
}
