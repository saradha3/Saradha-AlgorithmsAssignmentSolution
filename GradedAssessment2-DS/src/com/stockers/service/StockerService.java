package com.stockers.service;

public class StockerService {
	
	public double[] displayAscending(double[] stock_price,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			
			displayAscending(stock_price,left,mid);
			displayAscending(stock_price,mid+1,right);
			
			mergeAscending(stock_price,left,mid,right);
					
		}
		return stock_price;
		
	}
	
	public double[] displayDescending(double[] stock_price,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			
			displayDescending(stock_price,left,mid);
			displayDescending(stock_price,mid+1,right);
			
			mergeDescending(stock_price,left,mid,right);
					
		}
		return stock_price;
		
	}
	
	public void stockRise(boolean[] compare_stock) {
		int count=0;
		for(int i=0;i<compare_stock.length;i++) {
			if(compare_stock[i])
				count++;
		}
		System.out.println("Total no of companies whose stock price rose today: "+count);
	}
	
	public void stockDecline(boolean[] compare_stock) {
		int count=0;
		for(int i=0;i<compare_stock.length;i++) {
			if(!compare_stock[i])
				count++;
		}
		System.out.println("Total no of companies whose stock price declined today: "+count);
	}
	
	public void searchStock(double[] stock_price,double key) {
		stock_price=displayAscending(stock_price, 0, stock_price.length-1);
		int l=0,r=stock_price.length-1,flag=-1;
		while(l<=r) {
			int m=(l+r)/2;
			if (stock_price[m]==key) {
				System.out.println("Stock of value "+key+ " is present");
				flag=0;
				break;
			}
			if (stock_price[m] < key)
                l = m + 1;
			
			else
                r = m - 1;
		}
		if(flag==-1)
			System.out.println("Value not found");
	}
	
	
	public void mergeAscending(double[] stock_price, int left, int mid, int right) {
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		double leftArr[] =new double[n1];
		double rightArr[] = new double[n2];
		
		for(int i=0;i<n1;i++) {
			leftArr[i]= stock_price[left+i];
		}
		for(int j=0;j<n2;j++) {
			rightArr[j]=stock_price[mid+1+j];
		}
		
		int i=0,j=0,k=left;
		
		while(i<n1 && j<n2) {
			if(leftArr[i]<=rightArr[j]) {
				stock_price[k]=leftArr[i];
				i++;
			}
			else {
				stock_price[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			stock_price[k]=leftArr[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			stock_price[k]=rightArr[j];
			j++;
			k++;
		}
		
		}
	
	public void mergeDescending(double[] stock_price, int left, int mid, int right) {
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		double leftArr[] =new double[n1];
		double rightArr[] = new double[n2];
		
		for(int i=0;i<n1;i++) {
			leftArr[i]= stock_price[left+i];
		}
		for(int j=0;j<n2;j++) {
			rightArr[j]=stock_price[mid+1+j];
		}
		
		int i=0,j=0,k=left;
		
		while(i<n1 && j<n2) {
			if(leftArr[i]>=rightArr[j]) {
				stock_price[k]=leftArr[i];
				i++;
			}
			else {
				stock_price[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			stock_price[k]=leftArr[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			stock_price[k]=rightArr[j];
			j++;
			k++;
		}
		
		}

}
