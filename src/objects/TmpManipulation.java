/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Dmitri
 */
public class TmpManipulation {
    
    public static String stripExtensions(String filename)
    {
        if (filename== null) 
            return null;
        int posDelimeter = filename.lastIndexOf(".");
        if (posDelimeter == -1)
            return filename;
        return filename.substring(0, posDelimeter);
    }
}
