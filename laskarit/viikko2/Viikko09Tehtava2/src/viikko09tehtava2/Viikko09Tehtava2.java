
package viikko09tehtava2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author miljaniemi
 */
public class Viikko09Tehtava2 {

    public static void main(String[] args) {
        // TODO code application logic here
        int[] t = {6,2,3,5,2,4,1,8};
        int[] tulos = laske(t);
        System.out.println(Arrays.toString(tulos));
    }
    
    public static int[] laske(int[] t) {
        int n = t.length;
        int[] pisin = new int[n];
        int[] aiempi = new int[n];

        for (int k = 0; k < n; k++) {
            pisin[k] = 1;
            aiempi[k] = -1;
            for (int x = 0; x < k; x++) {
                if (Math.abs(t[k]- t[x])==1) {
                    if (pisin[x] + 1 > pisin[k] && pisin[x] +1 > pisin[k]) {
                        pisin[k] = pisin[x] + 1;
                        aiempi[k] = x;
                    }
                }
            }
        }
        
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (pisin[i] > k) {
                k = pisin[i];
            }
        }
        int[] tulos = new int[pisin[k]];
        
        int a = 0;
        while (k!=-1) {
            tulos[a] = t[k];
            k = aiempi[k];
            a++;
        }
        
        return tulos;

    }

}
