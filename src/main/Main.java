package main;

import busqueda.Busqueda;

import java.util.*;

public class Main {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        try
        {
            menuStart();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    private static void menuStart() {
        System.out.println("Métodos de Búsqueda");
        System.out.println("1.-Iniciar\n2.-Salir");
        int opc = leer.nextInt();
        if(opc==1){
            System.out.println("Ingresa el tamaño de la lista");
            int tam = leer.nextInt();
            List<Integer> list = genList(tam);
            System.out.println("Lista creada: " + list);

            System.out.println("Ingresa el elemento a buscar <<Un entero>>.");
            int elemento = leer.nextInt();
            menuBusqueda(elemento,list);
        }
    }

    private static void menuBusqueda(int elemento, List<Integer> list){
        System.out.println("Método de Búsqueda");
        System.out.println("1.-Lineal\n2.-Binaria\n3.-Todos\n4.-Atrás\n0.-Salir");
        int opc = leer.nextInt();

        switch (opc){
            case 1: //Método Lineal
                long timeStart = System.nanoTime();
                int indValue = Busqueda.lineal(elemento, list);
                long time = System.nanoTime() - timeStart;
                estado(list,indValue,time);
                menuBusqueda(elemento,list);
                break;
            case 2: //Método Binario
                Collections.sort(list); //Se ordena la lista con api Collections
                System.out.println("Ordenando lista..." + list);
                timeStart = System.nanoTime();
                indValue = Busqueda.binaria(elemento, list);
                time = System.nanoTime() - timeStart;
                estado(list,indValue,time);
                menuBusqueda(elemento,list);
                break;
            case 3: //Todos
                Busqueda.all(elemento, list);
                menuBusqueda(elemento, list);
                break;
            case 4:
                menuStart();
                break;
            default:
                break;
        }
    }

    private static List<Integer> genList(int tam){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int value;

        for(int i=0; i<tam;i++){
            value = random.nextInt(tam*5);
            if(exist(value,list,i)) {
                i--;
            }else{
                list.add(value);
            }
        }
        return list;
    }

    private static boolean exist(int value, List<Integer> list, int indMax){
        for(int i=0;i<indMax;i++){
            if(list.get(i)==value){
                return true;
            }
        }
        return false;
    }

    public static void estado(List<Integer> list,int index, long time){
        if(index!=-1){
            System.out.println("\n------------BUSQUEDA--------------");
            System.out.println("Estado: Encontrado");
            System.out.println("Valor: " + list.get(index));
            System.out.println("Posición: list[" +index+"]");
            System.out.println("Duración: "+time+" Nanoseg...");
        }else{
            System.out.println("\n------------BUSQUEDA--------------");
            System.out.println("Estado: No Encontrado");
            System.out.println("Duración: "+time+" Nanoseg...");
        }
    }
}
