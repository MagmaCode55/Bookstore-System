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
public class PremiumMembership extends Membership {

    private boolean pay = false;

    /**
     * A constructor to make a Premium membership object
     *
     * @param name name of account
     * @param type type of account
     * @param pay gives false or true based on whether they have paid the
     * monthly fee
     * @param cd number of CD's
     * @param dvd number of DVD's
     * @param books number of books
     * @param memNum the account number
     */
    public PremiumMembership(String name, String type, boolean pay, int cd, int dvd, int books, int memNum) {
        super(name, type, cd, dvd, books, memNum);
        this.pay = pay;
    }

    /**
     * A method to change the payment value from false to true
     *
     * @param value gets a boolean value
     */
    @Override
    public void setPay(boolean value) {
        this.pay = value;
    }

    /**
     * A method to check if the person has paid their monthly fee
     *
     * @return returns if paid or not
     */
    @Override
    public boolean getPay() {
        return pay;
    }

    /**
     * Displays information about the account
     */
    @Override
    public void display() {
        super.display();

    }
    
    public static void main(String[] args){
        PremiumMembership one = new PremiumMembership("LOL", "Premium",false, 3,3,3,2);
        
        one.display();
        
        if(one.getPay() == false){
            System.out.println(true);
        }
        one.setPay(true);
        if(one.getPay() == true){
            System.out.println(true);
        }
        
    }

}
