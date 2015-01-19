/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Dmitri
 */
public class Home3WriteOverBuffer {
    
    private static final String STR = "Write to file";
    
    public static void main(String[] args) {
        try
        {
            File f = new File("D:\\FileBuff.txt");
            if (!f.exists())
                f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(STR);
                bw.flush();
            }
            System.out.println("Data writen!!!");
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
