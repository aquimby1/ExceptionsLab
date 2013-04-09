package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_FIRST = 0;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        
        try{
           String lastName = app.extractLastName(fullName); 
           String msg = "Your last name is: " + lastName;
           JOptionPane.showMessageDialog(null, msg);
        }
        catch(IllegalArgumentException iae){
            JOptionPane.showMessageDialog( null,"Data Entry Error");
        }
        
        
        
        
    }
    /**
     * check for comma for last name first
     * split entry and take last piece
     * if there's a suffix takes piece before that
     * @param fullName
     * @return 
     */
    public String extractLastName(String fullName) throws IllegalArgumentException{
        if(fullName == null || fullName.length()==0){
            throw new IllegalArgumentException("Entry Required");
        }
        if(fullName.contains(",")){
            String[] nameParts = fullName.split(",");
            return nameParts[LAST_NAME_FIRST];
        }
        
        String[] nameParts = fullName.split(" ");
        if(nameParts[nameParts.length-1].length() <3){
            return nameParts[nameParts.length-2];
        }
        return nameParts[nameParts.length-1];
    }

}
