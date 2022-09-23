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
public class Membership {

    private String memberType = "";
    private String name = "";
    private int books = 0;
    private int cd = 0;
    private int dvd = 0;

    private boolean pay = false;
    public int memberNum = 0;

    /**
     *
     * @param name gets name from main class
     * @param type gets type of membership from main class
     * @param cd gets number of cd's from the main class
     * @param dvd gets number of dvd's from main class
     * @param books gets number of books from main class
     * @param memNum gets the member number
     */
    public Membership(String name, String type, int cd, int dvd, int books, int memNum) {
        memberType = type;
        this.name = name;
        this.books = books;
        this.cd = cd;
        this.dvd = dvd;
        memberNum = memNum;
    }

    /**
     * return method
     *
     * @return returns member type
     */
    public String getType() {
        return memberType;
    }

    /**
     *
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return returns number of books
     */
    public int getBooks() {
        return books;
    }

    /**
     *
     * @return returns number of CDs
     */
    public int getCD() {
        return cd;
    }

    /**
     *
     * @return returns number of DVDs
     */
    public int getDVD() {
        return dvd;
    }

    /**
     *
     * @return returns member account number
     */
    public int getmemNum() {
        return memberNum;
    }

    /**
     *
     * @param value gets a boolean value
     */
    public void setPay(boolean value) {
        this.pay = value;
    }

    /**
     * changes the amount of books in the account to the value 'count'
     *
     * @param count gets integer value
     */
    public void setBook(int count) {
        this.books = count;
    }

    /**
     * changes the amount of CD's in the account to the value 'count'
     *
     * @param count gets integer value
     */
    public void setCD(int count) {
        this.cd = count;
    }

    /**
     * changes the amount of DVD's in the account to the value 'count'
     *
     * @param count gets integer value
     */
    public void setDVD(int count) {
        this.dvd = count;
    }

    /**
     *
     * @return returns if paid or not
     */
    public boolean getPay() {
        return pay;
    }

    /**
     * Displays information about the user
     */
    public void display() {
        System.out.println("Your name is " + name);
        System.out.println("Your member number is " + (memberNum + 1));
        System.out.println("You have currently bought " + books + " books, " + cd + " CDs, and " + dvd + " DVDs.");

    }
    
    public static void main(String[] args){
        
        Membership one = new Membership("lol", "Free", 2,2,2,2);
        
        one.display();
        one.setBook(0);
        if(one.books == 0){
            System.out.println(true);
        }
        one.setDVD(0);
        if(one.dvd == 0){
            System.out.println(true);
        }
        one.setCD(0);
        if(one.cd == 0){
            System.out.println(true);
        }
        
        
    }

}
