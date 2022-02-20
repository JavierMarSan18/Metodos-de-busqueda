package busqueda;

import main.Main;

import java.util.Collections;
import java.util.List;

public class Busqueda {

    public static int lineal(int elemento, List<Integer> list){
        for (int i=0; i< list.size()-1;i++){
            if(elemento == list.get(i)){
                return i;
            }
        }
        return -1;
    }

    public static int binaria(int elemento, List<Integer> list){
        int lo, mid, hi;
        lo = 0;
        hi = list.size()-1;

        while (lo<=hi){
            mid = lo + (hi-lo)/2;
            if(elemento==list.get(mid)){
                return  mid;
            }else if(elemento<list.get(mid)){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }

    public static void all(int elemento, List<Integer> list){
        long timeStart = System.nanoTime();
        int indValue = lineal(elemento,list); //Metodo Lineal
        long time = System.nanoTime() - timeStart;
        Main.estado(list,indValue,time, "Lineal");

        Collections.sort(list);//Ordenando la lista
        timeStart = System.nanoTime();
        indValue = binaria(elemento,list); //Metodo Binario
        time = System.nanoTime() - timeStart;
        Main.estado(list,indValue,time, "Binaria");
    }
}
