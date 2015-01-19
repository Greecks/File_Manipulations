/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.files;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author velenteenko
 */
public class FileManipulations {

    private static final String PATH_FILE = "/home/velenteenko/file.txt";
    
    public static void main(String[] args) {
        writeTextToFile(PATH_FILE);
        
        System.out.println("File was writen!!!");
        
        readTextFromfile(PATH_FILE);
        readFileOverBuffer(PATH_FILE,10);
        
    }
    
    private static void writeTextToFile(String filename)
    {
        try { 
            try (Writer wr = new FileWriter(filename)) {
                wr.write("String1 + String (over)"+"\n");
                wr.write("String2 + 2");
                wr.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void readTextFromfile(String filename)
    {
        System.out.println("Read a text file: "+filename);
        try {
           try (BufferedReader br = new BufferedReader(new FileReader(filename)))
           {
              String st;
               while ( (st = br.readLine()) !=null ) {
                   System.out.println(st);
               }
           }
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    
    private static void readFileOverBuffer(String filename, int countOfBytes)
    {
        System.out.println("Read data from textfile bytes...");
        BufferedInputStream bufferedInputStream = null;
        byte[] buffer = new byte[countOfBytes];
        
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filename));
                    int readbytes = 0;
                    while ((readbytes = bufferedInputStream.read(buffer)) != -1)
                    {
                        String str = new String(buffer);
                        System.out.println(str);
                    }
                    
                    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
           try
           {
               if (bufferedInputStream != null) {
                   bufferedInputStream.close();
               }
           }
           catch (IOException ex)
        {
         Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);   
        }
        }
        
    }
}
