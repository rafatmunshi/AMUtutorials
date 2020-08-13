package com.cisco.ThreadEx;

class Storage
{
	int i;
	
	void setI(int i)
	{
		this.i=i;
	}
	
	int getI()
	{
		return i;
	}
}

class Counter extends Thread
{
	Storage st;
	
	public Counter(Storage st)
	{
		this.st=st;
	}
	
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			
			st.setI(i);
				
			try
			{
				Thread.currentThread();
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			new Printer(st);
		}
	}
}

class Printer extends Thread
{
	Storage st;
	
	public Printer(Storage st)
	{
		this.st=st;
		new Thread(this,"Printer").start();
	}
	
	public void run()
	{
		
		System.out.println("Value: "+st.getI());
		
		try
		{
			Thread.currentThread();
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
}

public class Exer1
{
	public static void main(String args[])
	{
		Storage st=new Storage();
		Counter c=new Counter(st);
		new Thread(c,"Counter").start();
		
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}