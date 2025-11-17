import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter amount to withdraw: ");
        double withdraw = sc.nextDouble();

        if (withdraw <= balance) {
            balance -= withdraw;
            System.out.println("Withdrawal Successful!");
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance! Withdrawal not possible.");
        }
    }
}
