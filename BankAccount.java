package project;

import java.util.Scanner;


public class BankAccount {
	int balance;
	int TransactionHistory;
	String customerName;
	String customerId;
	
	BankAccount(String cname,String cid){
		customerName=cname;
		customerId=cid;
	}
	
	/*void login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your id: ");
		String login = input.nextLine();
		showMenu();
	}*/
	
	void deposit(int amount) {
		
		if(amount>0) {
			
			balance=balance+amount;
			TransactionHistory=amount;
		}
		
	} 
	
	void withdraw(int amount) {
		if(amount>0) {
			if(amount<balance) {
			balance=balance-amount;
			TransactionHistory= -amount;
			}
			else
				System.out.println("insufficient balance!!!");
		}
	}
	
	void getPreviousTransaction() {
		if(TransactionHistory>0) {
			System.out.println("Deposited: "+TransactionHistory);
		}
		else if(TransactionHistory<0) {
			System.out.println("Withdrawn: "+Math.abs(TransactionHistory));
		}
		else {
			System.out.println("No transaction occured");
		}
		
	}
	
	void showMenu() {
		//char option='\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome: "+customerName);
		System.out.println("Your id is: "+customerId);
		System.out.println("\n");
				
		while(true) {
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Previous Transaction");
			System.out.println("5. Exit");

			System.out.println("=============================");
			System.out.println("Enter an option");
			System.out.println("=============================");
			
			int option = scanner.nextInt();
			
			System.out.println("\n");
			
			switch(option) {
			
			case 1:
				System.out.println("-------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("-------------------------");
				System.out.println("\n");
				break;
				
			case 2:
				System.out.println("-----------------------------");
				System.out.println("Enter an amount to deposit:");
				System.out.println("-----------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 3:
				System.out.println("------------------------------");
				System.out.println("Enter an amount to withdraw:");
				System.out.println("------------------------------");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("------------------------------");
				getPreviousTransaction();
				System.out.println("------------------------------");
				System.out.println("\n");
				break;
			
			case 5:
				System.out.println("thankyou");
				System.exit(0);;
			default:
				System.out.println("Invalid option! please enter again");
				break;
			}
			
			
		}
		
	}

}
