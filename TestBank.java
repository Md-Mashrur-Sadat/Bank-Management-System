package project;

import java.util.*;
import java.io.*;

public class TestBank {

		public static void main(String[] args) {

			Scanner scanS = new Scanner(System.in);
			Scanner scanN = new Scanner(System.in);
			
			ArrayList<String> clientNames = new ArrayList<>() ;
			ArrayList<String> clientID = new ArrayList<>() ;
			
			File f = new File("info.txt") ;
			
			try {
				
				Scanner scanf = new Scanner(f) ;
				
				while(scanf.hasNextLine()) {
					
					clientNames.add(scanf.nextLine());
					clientID.add(scanf.nextLine()) ;
				}
			
			}
			catch(Exception e) {
				
				
			}

			
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			
			int n = scanN.nextInt() ;
			
			if(n == 1) {
				
				System.out.println("Enter name: ");
				
				String name = scanS.nextLine() ;
				
				clientNames.add(name) ;
				
				int id = (int)((Math.random() * 9000)+1000); 
				
				String idToString = id+ "" ;
				
				clientID.add(idToString) ;
				
				System.out.println("auto generated id: "+id);
				
				try {
					
					PrintWriter pw = new PrintWriter( new FileWriter(f)) ;
	
					for(int i = 0 ; i < clientID.size(); i++) {
						
						pw.println(clientNames.get(i));
						pw.println(clientID.get(i));
					}
					
					pw.close();
				}
				catch(Exception e) {
					
					System.out.println("info file error!!!");
				}
				
			}
			else if(n == 2) {
				
				System.out.println("Enter name: ");
				
				String name = scanS.nextLine();
				
				System.out.println("Enter id : ") ;
				
				String id = scanS.nextLine() ;
				
				boolean condition = false ;
				
				
				for(int i = 0 ; i < clientID.size(); i++) {
					
					if(name.equals(clientNames.get(i)) && id.equals(clientID.get(i))) {
						
						condition = true ;
						break ;
					}
				}
				
				if(condition) {
				
					BankAccount obj1 = new BankAccount(name,id);
					
					System.out.println();
					
					obj1.showMenu(); 
				}
				else {
					System.out.println("User not found");
					
				}

			}
			else {
				
				System.out.println("Wrong input!!!");
			}
		
			scanS.close();
			scanN.close();
	
		}
		
		
	}

	


