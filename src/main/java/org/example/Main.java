package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.*;

class ByAlphComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int compGr = s1.getGr().compareTo(s2.getGr());
        if (compGr != 0) return compGr;
        int compNume = s1.getNume().compareTo(s2.getNume());
        if (compNume != 0) return compNume;
        return s1.getPrenume().compareTo(s2.getPrenume());
    }
}

class ByGradesComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.medie() == o2.medie()) return 0;
        return o1.medie() < o2.medie() ? 1 : -1;
    }
}

class ByFailComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getNrRestante(), s2.getNrRestante());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student("Popescu", "Marian", "225_3"));
        studenti.add(new Student("Popescu", "Maria", "225_3"));
        studenti.add(new Student("Popa", "Marian", "225_3"));
        studenti.add(new Student("Bica", "Irina", "225_3"));
        studenti.add(new Student("Badea", "Ion", "225_1"));
        studenti.add(new Student("Cacoveanu", "Andreea", "225_1"));
        studenti.add(new Student("Onofrei", "Mircea", "225_1"));

        // a)
        Random rand = new Random();
        for (Student st : studenti) {
            for (int i = 0; i < 5; i++) {
                int nota = rand.nextInt(7) + 4;
                st.adaugaNota(nota);
            }
        }

        System.out.println("a) ");
        for (Student st : studenti) {
            System.out.println(st);
        }

        // b1)
        System.out.println("\nb1) ");
        Collections.sort(studenti, new ByAlphComparator());
        for (Student st : studenti) {
            System.out.println(st);
        }

        List<Student> integralisti = new ArrayList<>();
        List<Student> restantieri = new ArrayList<>();

        for (Student st : studenti) {
            if (st.esteIntegralist()) {
                integralisti.add(st);
            } else {
                restantieri.add(st);
            }
        }

        // b2)
        System.out.println("\nb2)");
        Collections.sort(integralisti, new ByGradesComparator());
        if (integralisti.isEmpty()) {
            System.out.println("Nu exista.");
        } else {
            for (Student st : integralisti) {
                System.out.println(st);
            }
        }

        // b3)
        System.out.println("\nb3)");
        Collections.sort(restantieri, new ByFailComparator());
        if (restantieri.isEmpty()) {
            System.out.println("Nu exista.");
        } else {
            for (Student st : restantieri) {
                System.out.println(st);
            }
        }
    }
}