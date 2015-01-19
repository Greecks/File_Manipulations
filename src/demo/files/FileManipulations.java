/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.files;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.TmpManipulation;

/**
 *
 * @author velenteenko
 */
public class FileManipulations {

    private static final String PATH_FILE_LINUX = "/home/velenteenko/file.txt";
    private static final String PATH_FILE_WINDOWS = "D:\\file.txt";
    
    public static void main(String[] args) {
        try {
            writeTextToFile(PATH_FILE_WINDOWS);
            
            System.out.println("File was writen!!!");
            
            readTextFromfile(PATH_FILE_WINDOWS);
            readFileOverBuffer(PATH_FILE_WINDOWS,10);
            workWithFileSystem_File(PATH_FILE_WINDOWS);
            int res=generateMyselfException();
            //callThrowFileException();
        } catch (Exception ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
        private static void workWithFileSystem_File(String filename)
        {
        try {
            File f = new File(filename);
            f.createNewFile();
            System.out.println("Create file: "+f.getName());
            System.out.println("Its file: "+f.isFile());
            System.out.println("Its dir or folder: "+f.isDirectory());
        } catch (IOException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File dir = new File(TmpManipulation.stripExtensions(filename));
            if ( ! dir.exists()) {
                dir.mkdirs();
            } else
            {
                for (String file : dir.list()) {
                    System.out.println("Files in dir: "+file);
                }
            }
            
            System.out.println("Path to new dir: "+dir.getPath());  
        }
        
        private static int generateMyselfException() throws Exception
        {
            int a,b,c;
            a=1;
            b=2;
            c=a+b;
            throw new Exception("Have exception!!!!");
        }
        
        private static void callThrowFileException() throws IOException
        {
            File f = new File("D:\\ww\\file.txt");
            f.createNewFile();
        }
}
