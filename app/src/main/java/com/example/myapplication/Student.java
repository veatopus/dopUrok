package com.example.myapplication;

class Student {
    private String name;
    private String group;

    Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    String getName() {
        return name;
    }

    String getGroup() {
        return group;
    }
}