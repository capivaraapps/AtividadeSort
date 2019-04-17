/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import Model.Periodico;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author 144162026
 */
public class PeriodicoProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Periodico[] array = readCsv();
        
        Sort.selectionSort(array);
        array = null;
        array = readCsv();
        Sort.insertionSort(array);
        array = null;
        array = readCsv();
        Sort.shellSort(array);
        
    }
 
    
    public static Periodico[] readCsv(){
        
        ClassLoader classLoader = new PeriodicoProject().getClass().getClassLoader();
        
        File file = new File(classLoader.getResource("resources/QualisCapes.csv").getFile());
        
        int cont = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if(first){
                    first = false;
                }
                else{
                    cont++;
                }
            }
        }catch(IOException e){
            System.err.println("O arquivo não pode ser lido.");
        }
        Periodico[] result = new Periodico[cont];
        cont = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if(first){
                    first = false;
                }
                else{
                    String[] values = line.split(";");
                    result[cont] = new Periodico(values[0],values[1],values[2],values[3]);
                    cont++;
                }
            }
        }catch(IOException e){
            System.err.println("O arquivo não pode ser lido.");
        }
        return result;
    }

}