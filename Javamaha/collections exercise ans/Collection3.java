package com.cisco.CollEx;

import java.util.ArrayList;
import java.util.HashMap;

class Account
{
	static int accNo=1;
	int bal;
	String name;
	char type;
	
	ArrayList<Account> accList=new ArrayList<Account>();
	HashMap<Integer,Integer> acc=new HashMap<Integer,Integer>();
	
	Account()
	{
		
	}
	
	Account(String name,char type)
	{
		this.name=name;
		this.type=type;
		bal=0;
		this.accNo=accNo;
	}
	
	int openAcc(String name, char type)
	{
		Account a1=new Account(name,type);
		accList.add(a1);
		int index=accList.indexOf(a1);
		acc.put(accNo, index);
		accNo++;
		System.out.println("Account successfully opened. Your acc num is: "+(accNo-1));
		return (accNo-1);
	}
	
	void deposit(int accNo, int amt) 
	{
		int index=acc.get(accNo);
		Account temp=accList.get(index);
		temp.bal=temp.bal+amt;
		System.out.println("Amount successfully deposited.");
	}
	
	void withDraw(int accNo,int amt)
	{
		int index=acc.get(accNo);
		Account temp=accList.get(index);
		temp.bal=temp.bal-amt;
		System.out.println("Amount withdrawn successfully.");
	}
	
	void closeAcc(int accNo)
	{
		int index=acc.get(accNo);
		Account temp=accList.get(index);
		temp.bal=0;
		acc.remove(accNo);
		accList.remove(temp);
		System.out.println("Account closed.");
	}
	
	int checkBal(int accNo)
	{
		int index=acc.get(accNo);
		Account temp=accList.get(index);
		return temp.bal;
	}
}

public class Collection3
{
	public static void main(String args[])
	{
		Account a=new Account();
		int num=a.openAcc("abc",'S');
		a.deposit(num, 500);
		a.withDraw(num,200);
		System.out.println("Account balance for acc: "+num+" is: "+a.checkBal(num));
		a.closeAcc(num);
		
		int num1=a.openAcc("xyz",'C');
		a.deposit(num1, 5000);
		a.withDraw(num1,700);
		System.out.println("Account balance for acc: "+num1+" is: "+a.checkBal(num1));
		a.closeAcc(num1);
	}
}