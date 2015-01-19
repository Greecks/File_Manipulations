/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dmitri
 */
public class Home1 {
    public static void main(String[] args) {
        try
        {
            System.out.println(1 / 0);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(RuntimeException.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(Exception | Error ex)
        {
            Logger.getLogger(RuntimeException.class.getName()).log(Level.SEVERE,null,ex);
        }
//        try
//        {
//            System.out.println(1 / 0);
//        }catch(Throwable exth)
//        {
//        Logger.getLogger(RuntimeException.class.getName()).log(Level.SEVERE,null,exth);
//        }
        
        
//        try
//        {
//            System.out.println(1 / 0);  
//        }catch(Throwable exth)
//        {
//        Logger.getLogger(RuntimeException.class.getName()).log(Level.SEVERE,null,exth);
//        }
    }
}
