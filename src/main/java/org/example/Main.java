package org.example;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class Main {
    void main() {

        //pb1
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d


        //
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {x.add(rand.nextInt(11));}
        Collections.sort(x);
        System.out.println("x= " + x);

        Random rand2 = new Random();
        for (int i = 0; i < 7; i++)
        {y.add(rand2.nextInt(11));}
        Collections.sort(y);
        System.out.println("y= " + y);

        //punct a
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println("xPlusY= " + xPlusY);
        Collections.sort(xPlusY);
        //b
        List<Integer> newS =x.stream().filter(y::contains).toList();
        zSet.addAll(newS);
        System.out.println("zSet= " + zSet);
        //c
        xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);
        System.out.println("xMinusY= " + xMinusY);

        //d
        xPlusYLimitedByP.addAll(xPlusY);

        Iterator<Integer> it = xPlusYLimitedByP.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            if (val > p) { //
                it.remove();
            }
        }
        System.out.println("xPlusYLimitedByP= " + xPlusYLimitedByP);


    }}
