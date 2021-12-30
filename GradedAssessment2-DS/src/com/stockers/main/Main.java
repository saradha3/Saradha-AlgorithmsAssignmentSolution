package com.stockers.main;

import java.util.Scanner;

import com.stockers.service.StockerService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StockerService stockerService = new StockerService();
		double key = 0.0;
		
		System.out.println("Enter the no of companies");
		int no_of_companies = sc.nextInt();
		
		double stock_price[] = new double[no_of_companies];
		boolean compare_stock[] = new boolean[no_of_companies];
		
		for(int i=0;i<no_of_companies;i++) {
			System.out.println("Enter current stock price of the company "+(i+1));
			 stock_price[i] = sc.nextDouble();
			
			System.out.println("Whether company's stock price rose today compared to yesterday?");
			 compare_stock[i] = sc.nextBoolean();
		}
			while(true) {
				System.out.println("\n***********************************************************");
				System.out.println("Enter the operation that you want to perform");
				System.out.println("1. Display the companies stock prices in ascending order");
				System.out.println("2. Display the companies stock prices in descending order");
				System.out.println("3. Display the total no of companies for which stock prices rose today");
				System.out.println("4. Display the total no of companies for which stock prices declined today");
				System.out.println("5. Search a specific stock price");
				System.out.println("6. Press 0 to exit");
				System.out.println("***********************************************************");
				
				int choice = sc.nextInt();
				switch(choice) {
					case 1:
						stock_price=stockerService.displayAscending(stock_price, 0, stock_price.length-1);
						System.out.println("Stock prices is ascending order are:");
						for(int i=0;i<stock_price.length;i++) {
							System.out.print(stock_price[i]+ " ");
						}
						break;
					case 2:
						stock_price=stockerService.displayDescending(stock_price, 0, stock_price.length-1);
						System.out.println("Stock prices is descending order are:");
						for(int i=0;i<stock_price.length;i++) {
							System.out.print(stock_price[i]+ " ");
						}
						break;
					case 3:
						stockerService.stockRise(compare_stock);
						break;
					case 4:
						stockerService.stockDecline(compare_stock);
						break;
					case 5:
						System.out.println("Enter the key value");
						key = sc.nextDouble();
						stockerService.searchStock(stock_price, key);
						break;
					case 0: 
						System.out.println("Exited successfully");
						System.exit(0);
					default:
						System.out.println("Enter a valid choice");
						break;
				}
			}
			
			
		

	}

}
