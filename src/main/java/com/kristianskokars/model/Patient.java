package com.kristianskokars.model;

public class Patient implements Comparable<Patient> {
    private String personCode;
    private String name;
    private String surname;
    private int illnessLevel;

    public Patient(String personCode, String name, String surname, int illnessLevel) {
        setPersonCode(personCode);
        setName(name);
        setSurname(surname);
        setIllnessLevel(illnessLevel);
    }

    public Patient() {}

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIllnessLevel() {
        return illnessLevel;
    }

    public void setIllnessLevel(int illnessLevel) {
        this.illnessLevel = illnessLevel;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "personCode='" + personCode + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", illnessLevel=" + illnessLevel +
                '}';
    }

    @Override
    public int compareTo(Patient o) {
        return Integer.compare(illnessLevel, o.getIllnessLevel());
    }
}
