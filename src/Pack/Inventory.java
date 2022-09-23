package Pack;


import java.util.*;
import java.io.*;
import Pack.InvalidValueException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author visha
 */
public class Inventory extends MemberOptions {
    private String type1;
    private String type;
    private String name;
    private double price;
    private int amount;
     
    /**
     * Constructor for inventory class
     * @param type the type of the product
     * @param name the name of the product
     * @param price the price of the product
     * @param amount the amount of the product
     */
    public Inventory(String type, String name, double price, int amount){
        this.type = type;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    /**
     * 
     * @param amount gets amount from user
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * Returns name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * returns price
     * @return price
     */
    public double getPrice() {
        return price;
    }
    /**
     * returns amount
     * @return amount
     */
    public int getAmount() {
        return amount;
    }
    /**
     * a small constructor to add products
     */
    public Inventory(){
        dvd.add(new Inventory("DvD","Stuart Little", 6.99, 10));
        cd.add(new Inventory("CD" ,"Brownie", 7.99, 20));
        book.add(new Inventory("book" ,"The Hate you Give", 9.99, 3));
    }
    /**
     * Description of products
     * @return a string
     */
    @Override
    public String toString() {
        return "Type: " + type + " Name: " + name + " Price: " + price + " Number of copies: " + amount;
    }
    /**
     * Prints the details of the products
     * 
     */
    public void printInventory(){
        System.out.println("DVDs ----------------------------------------------");
        for(int i = 0; i < dvd.size();i++){
            System.out.println(dvd.get(i).toString());
            
        }
        System.out.println("CDs ---------------------------------------------");
        for(int i = 0; i < cd.size();i++){
            System.out.println(cd.get(i).toString());
            
        }
        System.out.println("Books --------------------------------------------");
        for(int i = 0; i < book.size();i++){
            System.out.println(book.get(i).toString());
            
        }
    }
    
    /**
     * Takes data from a file and inputs it into each arraylist
     * @param fileName get a String name of file
     */
    public void storeData(String fileName){
        
        try {
             
            File inpFile = new File(fileName);
            Scanner fileScan = new Scanner(inpFile);
            
            //num1 = fileScan.nextDouble();
            //System.out.println(num1);
            fileScan.nextLine();
            //num2 = fileScan.nextDouble();
            //System.out.println(num2);
            try {
                while (fileScan.hasNext()) {
                    String line = fileScan.nextLine();
                    String line2 = line.replace("[", "").replace("]", "");
                    String type1 = "";
                    String type2 = "";
                    String name = "";
                    String price = "";
                    String amount = "";
                    String id = "";
                    String paid = "";

                    
                    String[] lineArr = line2.split(",");
                    type1 = lineArr[0];

                    if (type1.equals("Item")) {
                        type2 = lineArr[1];
                        name = lineArr[2];
                        price = lineArr[3];
                        amount = lineArr[4];
                        double newPrice = 0.0;
                        int newAmount = 0;
                        newPrice = Double.parseDouble(price);
                        newAmount = Integer.parseInt(amount);
                        
                        
                        if (type2.equals("book")) {
                            Inventory temp = new Inventory(type2,name, newPrice, newAmount);
                            book.add(temp);
                        } else if (type2.equals("CD")) {
                            Inventory temp = new Inventory(type2,name, newPrice, newAmount);
                            cd.add(temp);
                        } else if (type2.equals("DvD")) {
                            Inventory temp = new Inventory(type2,name, newPrice, newAmount);
                            dvd.add(temp);
                        }

                    } else if (type1.equals("Member")) {
                        type2 = lineArr[1];
                        id = lineArr[2];
                        boolean hasPaid = false;
                        
                        int newID = Integer.parseInt(id);
                        if (type2.equals("free")) {
                            if(lineArr.length == 4){
                                throw new InvalidValueException();
                            }
                            type2 = "Free";
                            FreeMembership freeMember = new FreeMembership(name, type2, 0, 0, 0, newID);
                            memberList.add(freeMember);
                        } else if (type2.equals("premium")) {
                            type2 = "Premium";
                            if (lineArr.length == 4) {
                                paid = lineArr[3];
                                hasPaid = Boolean.parseBoolean(paid);
                                PremiumMembership preMember = new PremiumMembership(name, type2, hasPaid, 0, 0, 0, newID);
                                memberList.add(preMember);
                            } else {
                                PremiumMembership preMember = new PremiumMembership(name, type2, false, 0, 0, 0, newID);
                                memberList.add(preMember);
                            }
                        }

                    }
                    else{
                        throw new InvalidValueException();
                    }

                }
            } catch (InvalidValueException e) {
                System.err.println(e);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;

        }

    }
}
