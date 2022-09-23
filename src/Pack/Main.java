package Pack;


import static Pack.MemberOptions.memberList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author visha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int bookCount = 500;
        //int cdCount = 35;
        //int dvdCount = 456;

        //Creating a new object called store
        MemberOptions store = new MemberOptions();
        
        Inventory store2 = new Inventory();
        
        //Making a new scanner object
        Scanner kbd = new Scanner(System.in);
        int num = 0;
        
        while (num != 8) {
            //options for the store to do
            store.greet();
            System.out.println("\t 1. Register new member");
            System.out.println("\t 2. Check your information");
            System.out.println("\t 3. Pay your fee");
            System.out.println("\t 4. Check library inventory");
            
            System.out.println("\t 5. Purchase items from our store");
            System.out.println("\t 6. Add books to the store");
            System.out.println("\t 7. Check members");
            System.out.println("\t 8. Exit");

            num = kbd.nextInt();
            kbd.nextLine();

            switch (num) {
                case 1:
                    System.out.println("enter your first and last name: ");
                    String name1 = kbd.nextLine();
                    System.out.println("What type of membership do you want? Enter Premium or Free[F/P]: ");
                    String vtype = kbd.nextLine();

                    while (!vtype.contains("F") && !vtype.contains("f") && !vtype.contains("P") && !vtype.contains("p")) {
                        System.out.println("Please enter a valid type of membership [P/F]: ");
                        vtype = kbd.nextLine();
                    }

                    boolean paid = false;
                    int booksOwned = 0;
                    int cdsOwned = 0;
                    int dvdsOwned = 0;
                    int memberNum = store.addMember(name1, vtype, paid, cdsOwned, dvdsOwned, booksOwned);
                    System.out.println("You have successfully registered your account! Your member number is " + memberNum);

                    if (vtype.equals("p") || vtype.equals("P")) {
                        System.out.println("Since you have made a new account, you need to pay your fee of $3.25 at 3rd option in the main menu. Thank you!");
                    }
                    break;
                case 2:
                    System.out.println("enter your member number: ");
                    int num2 = kbd.nextInt();
                    boolean ans = store.printMemberInfo(num2);

                    if (ans != true) {
                        System.out.println("Your account does not exist.");
                    }
                    break;
                case 3:

                    System.out.println("Enter your member number: ");
                    int num3 = kbd.nextInt();
                    store.payMonFee(num3);
                    break;
                case 4:
                    store2.printInventory();
                    break;
                case 5:
                    System.out.println("Enter your member number: ");
                    int num4 = kbd.nextInt();
                    store2.printInventory();
                    store.makePayment(num4);

                    break;
                case 6:
                    System.out.println("Enter the name of the file(hi.txt): ");
                    String fileName = kbd.nextLine();
                    store2.storeData(fileName);
                    break;
                case 7: 
                    System.out.println(memberList.size());
                    
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, 7, or 8");

            }
        }

    }

}
