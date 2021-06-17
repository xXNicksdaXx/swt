package inloop;

import java.util.*;
import inloop.renovation_project.*;
import inloop.enterprise_node.*;

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
        System.out.println("Done 1.");

        StaffMember nick = new StaffMember("Nick", "Informatik");

        Holding h1 = new Holding("1");
        Holding h2 = new Holding("2");
        Company c1 = new Company("1.1");
        Company c2 = new Company("1.2");
        Company c3 = new Company("2.1");
        Division d1 = new Division("1.2.1");
        Division d2 = new Division("2.1.1");
        Team t1 = new Team("1.2.1.1", nick);

        System.out.println(h1.add(c1));
        System.out.println(h1.add(c1));
        h1.add(c2);
        h2.add(c3);
        c2.add(d1);

        Set<AbstractEnterpriseUnit> set = h1.getChildNodes();
        System.out.println(set);

        System.out.println("Done 2.");

    }

}