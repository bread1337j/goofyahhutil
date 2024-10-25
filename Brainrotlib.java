package Util;

import java.util.Random;

public class Brainrotlib {
    public static void print(Object obj){ //
        System.out.println(obj);
    }
    public static int randint(int min, int max){ return(new Random().nextInt(max-min) + min); }
}
