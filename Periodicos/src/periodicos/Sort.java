/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author 144162026
 */
public class Sort {
    
    public static void selectionSort (Comparable[] vet) throws IOException{
        long cont = 0;
        long millisInicio = System.currentTimeMillis();
        for(int i=0 ; i<vet.length-1 ; i++){
            int min = i;
            for(int j=i+1 ; j<vet.length ; j++){
                if(vet[j].compareTo(vet[min]) < 0) min = j;
                cont++;
            }
            if(min != i) {
                Comparable tmp = vet[min];
                vet[min] = vet[i];
                vet[i] = tmp;
            }
        }
        long millisFim = System.currentTimeMillis();
        System.out.println("Selection Sort fez " + cont + " comparações.");
        System.out.println("Selection Sort demorou " + ((millisFim-millisInicio) /1000)/60 + " minutos e " + ((millisFim-millisInicio) /1000)%60 + " segundos.");
        writeFile(vet, "selection");
    }
    public static void insertionSort (Comparable[] vet) throws IOException{
        int j;
        long cont = 0;
        long millisInicio = System.currentTimeMillis();
        for(int i=1 ; i<vet.length ; i++){
            Comparable ref = vet[i];
            for(j=i ; j>0 && ref.compareTo(vet[j-1])<0 ; j--){
                vet[j] = vet[j-1];
                cont++;
            }
            vet[j] = ref;
        }
        long millisFim = System.currentTimeMillis();
        System.out.println("Insertion Sort fez " + cont + " comparações.");
        System.out.println("Insertion Sort demorou " + ((millisFim-millisInicio) /1000)/60 + " minutos e " + ((millisFim-millisInicio) /1000)%60 + " segundos.");
        writeFile(vet, "insertion");
    }
    public static void shellSort (Comparable[] vet) throws IOException{
        long cont = 0;
        long millisInicio = System.currentTimeMillis();
        for (int gap = vet.length/2; gap > 0; gap /= 2){ 
            for (int i = gap; i < vet.length; i += 1){
                Comparable temp = vet[i]; 
                int j;             
                for (j = i; j >= gap && vet[j - gap].compareTo(temp) < 0; j -= gap){
                    vet[j] = vet[j - gap]; 
                    cont++;
                }
                vet[j] = temp; 
            } 
        } 
        long millisFim = System.currentTimeMillis();
        System.out.println("Shell Sort fez " + cont + " comparações.");
        System.out.println("Shell Sort demorou " + ((millisFim-millisInicio) /1000)/60 + " minutos e " + ((millisFim-millisInicio) /1000)%60 + " segundos.");
        writeFile(vet, "shell");
    }
    public static void writeFile(Comparable[] vet, String algorithm) throws IOException {
	FileWriter fw = new FileWriter("src/resources/" + algorithm + ".csv");
        for (int i = 0; i < vet.length; i++) {
                fw.write(vet[i].toString()+"\n");
        }
	fw.close();
    }
}
