package inloop.leet;

public abstract class Leet {
    public static String toLeet(String normal){
        normal = normal.replace("elite", "1337");
        normal = normal.replace("cool", "k3wl");
        normal = normal.replace("!", "!!!11");
        normal = normal.replace("ck", "xx");
        normal = normal.replace("ers", "0rz");
        normal = normal.replace("er", "0rz");
        normal = normal.replace("en", "n");
        normal = normal.replace("e", "3");
        normal = normal.replace("t", "7");
        normal = normal.replace("o", "0");
        normal = normal.replace("a", "@");
        return normal;
    }

    public static String[] allToLeet(String[] normals){
        int i = 0;
        int l = normals.length;
        String[] modified = new String[l];
        for (String n : normals){
            modified[i] = toLeet(n);
            i++;
        }
        return modified;
    }
}
