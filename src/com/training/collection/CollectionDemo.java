package com.training.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionDemo {
	
	public static void main(String[] args) {
		
//		List<String> names = new ArrayList<>();
//		names.add("Ahmed");
//		names.add("Hassan");
//		names.add("Ali");
//		names.add("Fatima");
//		names.add("Ali");
//		
//		for(String name:names) {
//			System.out.println(name);
//		}
//		
//		Set<Employee> empSet = new HashSet<>();
//		empSet.add(new Employee(101, "Harith", "IT", 6000));
//		
//		System.out.println(empSet);
		
		Map<Integer, String> empMap = new HashMap<>();
		empMap.put(102,  "Mohammed");
		empMap.put(102,"Suleiman");
		empMap.put(103, "Farah");
		empMap.put(101, "Noorie");
		
		
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(101, "Harith", 6000));
		customers.add(new Customer(102, "Lamki", 7000));
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		// add
		// update
		// search 
		// delete
		while(true) {
			
			System.out.println("Choice your option: \n"
					+ "1. Add a customer\n"
					+ "2. Update an existing customer\n"
					+ "3. Search for a customer\n"
					+ "4. Detele a customer\n"
					+ "5. Display all customers\n"
					+ "6. Exit\n"
					+ "Enter your option: ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					Scanner s1 = new Scanner(System.in);
					System.out.println("Enter Customer Number: ");
					int customerNumber = s1.nextInt();
					s1.nextLine();
					System.out.println("Enter Customer Name: ");
					String customerName = s1.nextLine();
					System.out.println("Enter Customer Salary: ");
					double salary = s1.nextDouble();
					customers.add(new Customer(customerNumber, customerName, salary));
					break;
				case 2:
					Scanner s2 = new Scanner(System.in);
					System.out.println("Enter Customer Number: ");
					int customer2 = s2.nextInt();
					for (int i = 0; i < customers.size(); i++) {
						if(customers.get(i).getCustomerNumber() == customer2) {
							Scanner s22 = new Scanner(System.in);
							System.out.println("Enter the updated Customer Number: ");
							customers.get(i).setCustomerNumber(s22.nextInt());
							s22.nextLine();
							System.out.println("Enter the updated Customer Name: ");
							customers.get(i).setCustomerName(s22.nextLine());
							System.out.println("Enter the updated Customer Salary: ");
							customers.get(i).setSalary(s22.nextInt());
						}
					}
					break;
				case 3:
					Scanner s3 = new Scanner(System.in);
					System.out.println("Enter Customer Number: ");
					int customer3 = s3.nextInt();
					for (int i = 0; i < customers.size(); i++) {
						if(customers.get(i).getCustomerNumber() == customer3) {
							System.out.println(customers.get(i).display());
						}
					}
					break;
				case 4:
					Scanner s4 = new Scanner(System.in);
					System.out.println("Enter Customer Number: ");
					int customer4 = s4.nextInt();
					for (int i = 0; i < customers.size(); i++) {
						if (customers.get(i).getCustomerNumber() == customer4) {
							customers.remove(i);
						}
					}
					break;
				case 5:
					for (int i = 0; i < customers.size(); i++) {
						System.out.println(customers.get(i).display());
					}
					break;
				case 6:
					System.out.println("Exiting Program. Thank You!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input! Please Enter a Valid Option.");
			}
		}
		
		
	}
}
