/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

/**
 *
 * @author visha
 */
public class InvalidValueException extends Exception{
    /**
     * Method to return a specific error type
     */
    public InvalidValueException(){
        super("This is not the right value");
    }
}
