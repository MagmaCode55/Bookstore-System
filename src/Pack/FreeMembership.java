package Pack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author visha
 */
public class FreeMembership extends Membership {

    /**
     * A constructor to make a free membership object
     *
     * @param name gets name from main class
     * @param type gets type of membership from main class
     * @param cd gets number of CD's from the main class
     * @param dvd gets number of DVD's from main class
     * @param books gets number of books from main class
     * @param memNum gets the member number
     */
    public FreeMembership(String name, String type, int cd, int dvd, int books, int memNum) {
        super(name, type, cd, dvd, books, memNum);

    }

    /**
     * A method to print out free membership details
     */
    @Override
    public void display() {
        super.display();
        System.out.println("You are a free member. You do not need to pay a membership fee.");
    }
    
    
    public static void main(String[] args){
        FreeMembership one = new FreeMembership("LOL", "Free", 3,3,3,2);
        
        one.display();
    }
    

}
