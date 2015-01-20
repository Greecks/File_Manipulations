/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.exceptions;

import java.io.File;
import java.io.FilenameFilter;
import objects.CustomFileFilter;

/**
 *
 * @author Dmitri
 */
public class Home4_FilesWithExtensions {
    public static void main(String[] args) {
     
        File f = new File("D:\\file");
        FilenameFilter filter = new CustomFileFilter("doc");
        System.out.println(".....DOC.....");
        for (String files : f.list(filter)) {
            System.out.println(files);
        }
        
    }
  
}
