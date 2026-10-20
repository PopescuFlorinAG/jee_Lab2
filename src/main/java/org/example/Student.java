package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGr() {
        return grupa;
    }

    public void adaugaNota(int nota) {
        this.note.add(nota);
    }

    public boolean esteIntegralist() {
        for (int nota : note) {
            if (nota < 5) {
                return false;
            }
        }
        return true;
    }

    public int getNrRestante() {
        int rest = 0;
        for (int nota : note) {
            if (nota < 5) {
                rest++;
            }
        }
        return rest;
    }

    public double medie() {
        if (note.isEmpty()) return 0.0;
        int suma = 0;
        for (int nota : note) {
            suma += nota;
        }
        return (double) suma / note.size();
    }

    @Override
    public String toString() {
        return "Grupa: " + grupa +
                ", Nume: " + nume + " " + prenume +
                ", Note= " + note +
                ", Medie= " + medie() +
                ", Restante= " + getNrRestante();
    }
}