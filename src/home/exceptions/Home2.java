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
public class Home2 {
    public static void main(String[] args) {
     
        try {  
            System.out.println(divide(6, 0));
        } catch (TrainingEcxeptions ex) {
            Logger.getLogger(Home2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static double divide(int a, int b) throws TrainingEcxeptions
    {
        try
        {
            if (b==0) {
                throw new TrainingEcxeptions("Argument cannot be 0!!!");
            }
            
                    return a / b;
        }
        catch(ArithmeticException ex)
        {
            throw new TrainingEcxeptions(ex.getMessage());
        }
        catch (Exception ex)
        {
            Logger.getLogger(RuntimeException.class.getName()).log(Level.SEVERE,null,ex);
        } 
        return 0;
    }
}

class TrainingEcxeptions extends Exception
{

    public TrainingEcxeptions() {
    super();
    }

    public TrainingEcxeptions(String message) {
        super(message);
    }
    
    
}
