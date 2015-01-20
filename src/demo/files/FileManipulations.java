/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.files;

import java.io.*;
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
//import objects.TmpManipulation;

/**
 *
 * @author velenteenko
 */
public class FileManipulations {

    private static final String PATH_FILE = "/home/velenteenko/file.txt";
    private static final String PATH_NEW_FILE = "/home/velenteenko/file2.txt";
    private static final String PATH_NEW_DIR = "/home/velenteenko/work/dirs1";
    private static final String USERNAMES = System.getProperty("user.name");
    private static final String HOMEDIR = "/home/"+USERNAMES+"/";
    private static final String PATH_FILE_LINUX = "/home/velenteenko/file.txt";
    private static final String PATH_FILE_WINDOWS = "D:\\file.txt";
    
    public static void main(String[] args) {
            String toMethod;
         // String inp;
//           System.out.println("Input the path to the file for writing: ");
//           inp = sc.nextLine();
//           if (inp.contains(HOMEDIR)) {
//           toMethod = inp;
//           } else toMethod = HOMEDIR+inp;
//               try (Scanner sc = new Scanner(System.in)) {
//            
//            toMethod = sc.nextLine();
//            writeTextToFile(inputScanner("Input the path to the file for writing: ", toMethod));
            
            // System.out.println("Input the path to the file for reading: ");
            //   inp = sc.nextLine();
            // System.out.println("File was writen!!!");
       // try {
            //            toMethod = sc.nextLine();
//            readTextFromfile(inputScanner("Input the path to the file for reading: ",toMethod));
//
//            
//            toMethod = sc.nextLine();
//            readFileOverBuffer(inputScanner("Input the path to the file for reading over buffer: ",toMethod),10);
//            
//            System.out.println("New file-->");
//            
//            toMethod = sc.nextLine();
//            workWithFileSystem_File(inputScanner("Input the path to the create new file: ",toMethod));
//            System.out.println("New dir-->");
//            
//            toMethod = sc.nextLine();
//            workWithFileSystem_Dir(inputScanner("Input the path to the create new dir: ",toMethod));
           // generateMyselfException();
           // callThrowFileException();
        
       // } catch (Exception ex) {
        //    Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }
    
    private static String inputScanner(String message, String path)
    {
//        Scanner sc = new Scanner(System.in);
//        String inp = "";
           // String toMethod;
            System.out.println(message);
//            if (sc.hasNext()) {
//         inp = sc.next();   
//        }
            if (path.contains(HOMEDIR)) 
            {
                //return inp; 
                return path;
            } else //return HOMEDIR+inp;
            {
               return HOMEDIR + path;
            }
    }
//            sc.close();
//        try {
//            writeTextToFile(PATH_FILE_WINDOWS);
//            
//            System.out.println("File was writen!!!");
//            
//            readTextFromfile(PATH_FILE_WINDOWS);
//            readFileOverBuffer(PATH_FILE_WINDOWS,10);
//            workWithFileSystem_File(PATH_FILE_WINDOWS);
//            int res=generateMyselfException();
//            //callThrowFileException();
//        } catch (Exception ex) {
//            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
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
   
    
    
    private static void readFileOverBuffer(String filename, int countBytes)
    {
        System.out.println("Read data from textfile bytes...");
        BufferedInputStream bufferedInputStream = null;
        byte[] buffer = new byte[countBytes];
        String resString = "";
        
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filename));
                    int readbytes = 0;
                    while ((readbytes = bufferedInputStream.read(buffer)) != -1)
                    {
                        String str = new String(buffer);
                        resString += new String(buffer);
                        System.out.println(str);
                    }
                    System.out.println("------------------");
                    System.out.println(resString);                    
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
    
        private static void workWithFileSystem_File(String createFileFileName)
        {
        System.out.println("Work with filesystem...");
        try {
            File f = new File(createFileFileName);
            f.createNewFile();
            System.out.println("created a file: "+f.getName());
            System.out.println("it`s file: "+f.isFile());
            System.out.println("it`s directory: "+f.isDirectory()); 
        } catch (IOException ex) {
            Logger.getLogger(FileManipulations.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
            
        private static void workWithFileSystem_Dir(String createDireFileName)
        {
        System.out.println("Work with filesystem...");
        File f = new File(createDireFileName);
            if (!f.exists()) {
             f.mkdirs();
            } else
            {
                System.out.println("Canceled! Directory exist!");
                return;
            }
        System.out.println("created a file: "+f.getName());
        System.out.println("it`s file: "+f.isFile());
        System.out.println("it`s directory: "+f.isDirectory());
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
            File f = new File("/home/wqwqw/file.txt");
            f.createNewFile();
        }
}
