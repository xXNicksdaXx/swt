package inloop;

import java.util.*;
import inloop.renovation_project.*;
import inloop.mymatrix.*;

import static java.lang.String.valueOf;

public class Inloop {
    public static void main(String[] args) {
        Surface s1 = new Surface(50, 30);
        Flooring f1 = new Flooring("oak", 20, 5.3);
        s1.setMaterial(f1);

        StructuredObject s2 = new StructuredObject();
        Surface u1 = new Surface(100, 30.6);
        Flooring f2 = new Flooring("spruce", 10, 3.6);
        u1.setMaterial(f2);
        Surface u2 = new Surface(20.7, 54.3);
        Paint p1 = new Paint("orange", 10, 3, 22.4);
        u2.setMaterial(p1);
        s2.add(u1);
        s2.add(u2);

        Surface s3 = new Surface(71, 22);
        Paint p2 = new Paint("red", 10, 2, 20);
        s3.setMaterial(p2);

        StructuredObject s = new StructuredObject();
        s.add(s1);
        s.add(s2);
        s.add(s3);

        Map<String, Integer> map = new HashMap<>();
        map.put("birch", 130);
        map.put("orange", 9);
        map = s.addMaterialRequirements(map);

        double price = s.getPrice();

        System.out.println(map);
        System.out.println(price);
        System.out.println("Done.");

        Matrix<Integer> matrix = new MyMatrix<>();
        matrix.put(1,0,3);

    }

}