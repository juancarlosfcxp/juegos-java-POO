/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;

/**
 *
 * @author pere
 */
public class Utils {
    private static final Random random = new Random();

    /**
     *
     * @return un color a l'atzar entre 0 i 255
     */
    public static int randomSimpleColor() {
        return random.nextInt(256);
    }

    /**
     *
     * @param MIN_VELOCITAT
     * @param MAX_VELOCITAT
     * @return
     */
    public static float velocitatAtzar(int MIN_VELOCITAT, int MAX_VELOCITAT) {
        int vX = Utils.randomValue(MIN_VELOCITAT, MAX_VELOCITAT);
        if (Utils.randomValue(0, 1)==0){
            vX = -vX;
        }
        return vX;

    }

    private Utils() {
    }
    
//    /**
//     * 
//     * @return color RGB a l'atzar codificat com a int.
//     */
//    public static int randomColor(){
//        return 256*256*random.nextInt(256) + //Red
//                256 * random.nextInt(256) + //Green
//                random.nextInt(256); //Blue
//    }
    
    /**
     *
     * @param min
     * @param max
     * @return valor entre min i max, inclosos.
     */
    public static int randomValue(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }
    
    
}
