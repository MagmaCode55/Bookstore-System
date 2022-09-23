package Pack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;


/**
 *
 * @author visha
 */
public class MemberOptions implements Condition {
    
    
    Scanner kbd = new Scanner(System.in);
    //Makes an arraylist to store members
    public static ArrayList<Membership> memberList = new ArrayList();
    public static ArrayList<Inventory> dvd = new ArrayList();
    public static ArrayList<Inventory> cd = new ArrayList();
    public static ArrayList<Inventory> book = new ArrayList();

    private static int newMem = 0;

    

    /**
     *
     * @return the member number
     */
    private static int getNewMem() {
        return newMem;
    }

    /**
     * adds a new member every time it's called
     */
    private static void addnewMem() {
        newMem++;
    }
    
    /**
     * Constructor that add two members to memberList arraylist
     */
    
    public MemberOptions() {
        //memberList.add(new PremiumMembership("John", "Premium", false, 3, 4, 5, getNewMem()));
        //addnewMem();
        memberList.add(new FreeMembership("Elly", "Free", 4, 4, 5, getNewMem()));
        addnewMem();
        
    }
    
    /**
     * adds two members already to the list
     */
    /**
     * This method adds the functionality to add a new member
     *
     * @param name name of member adding
     * @param memberType what type of membership the new member has
     * @param pay Does the member need to pay a fee
     * @param cd How many cds does the member has
     * @param dvd how many dvds the member has
     * @param books How many books the member has
     * @return returns the member number
     */
    public int addMember(String name, String memberType, boolean pay, int cd, int dvd, int books) {

        if (memberType.equals("F") || memberType.equals("f")) {
            memberType = "Free";
            FreeMembership Member = new FreeMembership(name, memberType, cd, dvd, books, getNewMem());
            memberList.add(Member);
            addnewMem();
        } else if (memberType.equals("P") || memberType.equals("p")) {
            memberType = "Premium";
            PremiumMembership Member = new PremiumMembership(name, memberType, pay, cd, dvd, books, getNewMem());
            memberList.add(Member);
            addnewMem();
        }

        return getNewMem();

    }

    /**
     * Prints the member's information from his number
     *
     * @param num member number from user input
     * @return if true
     */
    public boolean printMemberInfo(int num) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getmemNum() == num) {

                memberList.get(i).display();

                if (memberList.get(i).getType().equals("Premium")) {

                    if (memberList.get(i).getPay() == false) {
                        System.out.println("You have to pay for your membership.");

                    } else {
                        System.out.println("You are all up to date.");

                    }
                } else {
                    System.out.println("You have a free membership. No need to Pay.");

                }
                return true;
            }

        }
        return false;

    }

    /**
     * this method is used to pay the monthly membership fee
     *
     * @param num gives the account number
     */
    public void payMonFee(int num) {
        double cost = 0.0;
        double payment = 0.0;
        
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getmemNum() == num) {
                if (memberList.get(i).getType().equals("Premium")) {
                    if (memberList.get(i).getPay() == false) {
                        System.out.println("You need to pay for your fee of $3.25.");
                        while (cost < 3.25) {
                            payment = kbd.nextDouble();
                            cost += payment;
                            if (cost < 3.25) {
                                System.out.println("Please deposit more money. You still have to pay $" + (3.25 - payment));

                            } else {
                                System.out.println("You have paid the fee. Thank you!");
                                memberList.get(i).setPay(true);

                                System.out.println("Your change is $" + (cost - 3.25) + ".");
                            }
                        }
                    } else {
                        System.out.println("You have already paid the fee.");
                    }
                } else {
                    System.out.println("You don't need to pay. You are a free member.");
                }
            }

        }

    }
    
    
    /**
     * This method gives the ability to buy items from the bookstore stock
     *
     * @param num is the account id
     */
    public void makePayment(int num) {
        boolean done = false;
        int numBooks = 0;
        int numCD = 0;
        int numDVD = 0;
        double cost = 0.0;
        double payment = 0.0;
        int fNumBook = 0;
        int fNumCD = 0;
        int fNumDVD = 0;
        double price1 = 0;
        double price2 = 0;
        double price3 = 0;
        try{
            while (!done) {
                System.out.print("What Book would you like to buy? Enter the name of the book or none buy no books: ");
                String name = kbd.nextLine();
                
                for (int i = 0; i < book.size(); i++) {
                    if (book.get(i).getName().equals(name)) {
                        kbd.nextLine();
                        System.out.println("How many copies would you like to buy?");
                        numBooks = kbd.nextInt();
                        while (numBooks > book.get(i).getAmount()) {
                                System.out.println("You have requested more than the inventory. Please enter a different number.");
                                numBooks = kbd.nextInt();
                            
                            
                        }
                        book.get(i).setAmount(book.get(i).getAmount() - numBooks);

                        fNumBook = numBooks;
                        price1 = book.get(i).getPrice() * fNumBook;

                    }
                    else if(name.equals("none")){
                        break;
                    }
                }
                kbd.nextLine();
                System.out.print("What CDs would you like to buy? Enter the name of the CD or none buy no CD's: ");
                String name1 = kbd.nextLine();
                
                for (int i = 0; i < cd.size(); i++) {
                    if (cd.get(i).getName().equals(name1)) {
                        kbd.nextLine();
                        System.out.println("How many copies would you like to buy?");
                        numCD = kbd.nextInt();
                        while (numCD > cd.get(i).getAmount()) {
                            System.out.println("You have requested more than the inventory. Please enter a different number.");
                            numCD = kbd.nextInt();
                        }
                        cd.get(i).setAmount(cd.get(i).getAmount() - numCD);

                        fNumCD = numCD;
                        price2 = fNumCD * cd.get(i).getPrice();
                    } else if (name1.equals("none")) {
                        break;
                    }
                }
                kbd.nextLine();
                System.out.println("What DVDs would you like to buy? Enter the name of the DVD or none buy no DVDs: ");
                String name2 = kbd.nextLine();
                
                for (int i = 0; i < dvd.size(); i++) {
                    if (dvd.get(i).getName().equals(name2)) {
                        kbd.nextLine();
                        System.out.println("How many copies would you like to buy?");
                        numDVD = kbd.nextInt();
                        while (numDVD > dvd.get(i).getAmount()) {
                            System.out.println("You have requested more than the inventory. Please enter a different number.");
                            numDVD = kbd.nextInt();
                        }

                        dvd.get(i).setAmount(dvd.get(i).getAmount() - numDVD);

                        fNumDVD = numDVD;
                        price3 = fNumDVD * dvd.get(i).getPrice();
                    }
                    else if(name2.equals("none")){
                        break;
                    }
                }
                 
                done = true;
            
                
            }
            


        }
        catch (InputMismatchException e) {
                System.err.println("Invalid input");
                kbd.nextLine();
        }
        
        double total = price1 + price2 + price3;
        System.out.println("The total cost of your purchase is: $" + total);
        System.out.print("Deposit money: ");

        while (cost <= total) {
            payment = kbd.nextDouble();
            cost += payment;
            if (cost <= total) {
                System.out.println("Please deposit more money. You still have to pay $" + (total - payment));

            } else {
                System.out.println("You have paid for your items. Thank you!");

                System.out.println("Your change is $" + (cost - total) + ".");
            }
        }
        
        for(int i = 0; i < memberList.size();i++){
            if(memberList.get(i).getmemNum() == num){
                memberList.get(i).setBook(fNumBook);
                memberList.get(i).setCD(fNumCD);
                memberList.get(i).setDVD(fNumDVD);
            }
        }
        

    }
    /**
     * A method that prints out a greeting
     */
    @Override
    public void greet() {
        System.out.println("Hi, welcome to the bookstore!");
    }
    
    
    public static void main(String[] args){
        MemberOptions obj = new MemberOptions();
        System.out.println(memberList.size());
        obj.addMember("Name", "Premium", true, 3, 3, 3);
        if(memberList.size() >  1){
            System.out.println(true);
        }
        if(memberList.get(1).getmemNum() == 1){
            System.out.println(true);
        }
        if (memberList.get(0).getType().equals("Premium")) {
            System.out.println(true);
        }
        if(memberList.get(0).getPay() == false){
            System.out.println(true);
        }
        memberList.get(0).setPay(true);
        if(memberList.get(1).getPay() == false){
            System.out.println(true);
        }

    }
    

}
