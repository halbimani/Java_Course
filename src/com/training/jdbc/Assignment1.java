package com.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/testdb";
		String username = "postgres";
		String password = "pass123";
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while (true) {
			System.out.println("Press the number corresponding to your option:\n"
					+ "1. Create an Account\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. Transfer\n"
					+ "5. Balance\n"
					+ "6. Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					Scanner s1 = new Scanner(System.in);
					System.out.println("Enter Account ID: ");
					String account1 = s1.nextLine();
					System.out.println("Enter Your Name: ");
					String name1 = s1.nextLine();
					System.out.println("Enter The Balance: ");
					Double value1 = s1.nextDouble();
					try {
						Class.forName("org.postgresql.Driver");
						Connection connection = DriverManager.getConnection(url, username, password);
						// Check if the account id is existing
						PreparedStatement pstmt11 = connection.prepareStatement("Select count(*) from bank_account where account_id = ?");
						pstmt11.setString(1, account1);
						ResultSet rs11 = pstmt11.executeQuery();
						
						rs11.next();
						int count = rs11.getInt(1);
						
						if (count > 0) {
							System.out.println("Account ID already exists! Please choose a different ID.");
							break;
						}
						
						// Add the new account to the table
						PreparedStatement pstmt12 = connection.prepareStatement("Insert into bank_account (account_id, account_holder_name, balance) values(?, ?, ?)");
						pstmt12.setString(1, account1);
						pstmt12.setString(2, name1);
						pstmt12.setDouble(3, value1);
						
						int rowsInserted = pstmt12.executeUpdate();
						
						if (rowsInserted > 0) {
							System.out.println("Account Created Successfully!");
						}
						break;
						
					} catch(Exception e) {
						System.out.println(e);
					}
					
					break;
				case 2:
					Scanner s2 = new Scanner(System.in);
					System.out.println("Enter Account ID: ");
					String account2 = s2.nextLine();
					System.out.println("Enter Deposit Amount: ");
					double value2 = s2.nextDouble();
					try {
						Class.forName("org.postgresql.Driver");
						Connection connection = DriverManager.getConnection(url, username, password);
						// Get the current balance
						PreparedStatement pstmt21 = connection.prepareStatement("Select balance from bank_account where account_id= ?");
						pstmt21.setString(1, account2);
						ResultSet rs2 = pstmt21.executeQuery();
						
						double currentBalance2 = 0;
						
						if(rs2.next()) {
							currentBalance2 = rs2.getDouble("balance");
						}
						
						double newBalance2 = currentBalance2 + value2;
						// Update with the new balance
						PreparedStatement pstmt22 = connection.prepareStatement("UPDATE bank_account SET balance = ? WHERE account_id = ?");
						pstmt22.setDouble(1, newBalance2);
						pstmt22.setString(2, account2);
						int rowsUpdated2 = pstmt22.executeUpdate();
						
						if (rowsUpdated2 > 0) {
			                System.out.println("Deposit successful! New balance: " + newBalance2);
			            } else {
			                System.out.println("Failed to update the balance.");
			            }
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 3:
					Scanner s3 = new Scanner(System.in);
					System.out.println("Enter Account ID: ");
					String account3 = s3.nextLine();
					System.out.println("Enter Withdraw Amount: ");
					double value3 = s3.nextDouble();
					try {
						Class.forName("org.postgresql.Driver");
						Connection connection = DriverManager.getConnection(url, username, password);
						//Get the current Balance
						PreparedStatement pstmt31 = connection.prepareStatement("Select balance from bank_account where account_id= ?");
						pstmt31.setString(1, account3);
						ResultSet rs3 = pstmt31.executeQuery();
						
						double currentBalance3 = 0;
						
						if(rs3.next()) {
							currentBalance3 = rs3.getDouble("balance");
						}
						
						if(value3 > currentBalance3) {
							System.out.println("Unavailable Funds!");
							break;
						}
						
						double newBalance3 = currentBalance3 - value3;
						// Update with the new balance
						PreparedStatement pstmt32 = connection.prepareStatement("UPDATE bank_account SET balance = ? WHERE account_id = ?");
						pstmt32.setDouble(1, newBalance3);
						pstmt32.setString(2, account3);
						int rowsUpdated3 = pstmt32.executeUpdate();
						
						if (rowsUpdated3 > 0) {
			                System.out.println("Deposit successful! New balance: " + newBalance3);
			            } else {
			                System.out.println("Failed to update the balance.");
			            }
						
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 4:
					Scanner s4 = new Scanner(System.in);
					System.out.println("Enter the sending Account ID: ");
					String account41 = s4.nextLine();
					System.out.println("Enter the recieving Account ID: ");
					String account42 = s4.nextLine();
					if (account41.equals(account42)) {
						System.out.println("Invalid Accounts");
						break;
					}
					System.out.println("Enter Transform Amount: ");
					double value4 = s4.nextDouble();
					try {
						Class.forName("org.postgresql.Driver");
						Connection connection = DriverManager.getConnection(url, username, password);
						//Get the current Balance for transferring account 
						PreparedStatement pstmt41 = connection.prepareStatement("Select balance from bank_account where account_id = ?");
						pstmt41.setString(1, account41);
						ResultSet rs41 = pstmt41.executeQuery();
						
						double currentBalance41 = 0;
						
						if (rs41.next()) {
							currentBalance41 = rs41.getDouble("balance");
						}
						
						if(value4 > currentBalance41) {
							System.out.println("Unavailable Funds!");
							break;
						}
						
						double newBalance41 = currentBalance41 - value4;
						// Update the transferring account with the new balance
						PreparedStatement pstmt42 = connection.prepareStatement("UPDATE bank_account SET balance = ? WHERE account_id = ?");
						pstmt42.setDouble(1, newBalance41);
						pstmt42.setString(2, account41);
						int rowsUpdated41 = pstmt42.executeUpdate();
						
						if (rowsUpdated41 > 0) {
			                System.out.println("Deposit successful! New balance: " + newBalance41);
			            } else {
			                System.out.println("Failed to update the balance.");
			            }
						
						//Get the current Balance for receiving account
						PreparedStatement pstmt43 = connection.prepareStatement("Select balance from bank_account where account_id = ?");
						pstmt43.setString(1, account42);
						ResultSet rs42 = pstmt43.executeQuery();
						
						double currentBalance42 = 0;
						
						if (rs42.next()) {
							currentBalance42 = rs42.getDouble("balance");
						}
						
						double newBalance42 = currentBalance42 + value4;
						// Update the receiving account with the new balance
						PreparedStatement pstmt44 = connection.prepareStatement("UPDATE bank_account SET balance = ? WHERE account_id = ?");
						pstmt44.setDouble(1, newBalance42);
						pstmt44.setString(2, account42);	
						pstmt44.executeUpdate();
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 5:
					Scanner s5 = new Scanner(System.in);
					System.out.println("Enter Account ID: ");
					String account5 = s5.nextLine();
					try {
						Class.forName("org.postgresql.Driver");
						Connection connection = DriverManager.getConnection(url, username, password);
						PreparedStatement pstmt5 = connection.prepareStatement("Select balance from bank_account where account_id = ?");
						pstmt5.setString(1, account5);
						ResultSet rs5 = pstmt5.executeQuery();
						
						double balance5 = 0;
						
						if(rs5.next()) {
							balance5 = rs5.getDouble("balance");
						}
						
						System.out.println("Account ID: " + account5 + " Balance: " + balance5);
						
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 6:
					System.out.println("Exiting Program. Thank You!");
					System.exit(0);
					break;
			}
		}
		
		
		
		
		
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection connection = DriverManager.getConnection(url, username, password);
//			
//			
//			PreparedStatement pstmt = connection.prepareStatement("Select * from bank_account");
////			pstmt.setString(1,  "Said Al-Hinai");
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				System.out.print("ID: " + rs.getString(1) + ", Name: " + rs.getString(2) + ", Balance: " + rs.getString(3) + "\n");
//			}
//		} catch(Exception e) {
//			System.out.println(e);
//		}
	}

}
