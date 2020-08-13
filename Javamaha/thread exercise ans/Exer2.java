package com.cisco.ThreadEx;

class Storage1
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

class Counter1 extends Thread
{
	Storage1 st;
	
	public Counter1(Storage1 st)
	{
		this.st=st;
	}
	
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			synchronized(st)
			{
				st.setI(i);
			}
				
			try
			{
				Thread.currentThread();
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			new Printer1(st);
		}
	}
}

class Printer1 extends Thread
{
	Storage1 st;
	
	public Printer1(Storage1 st)
	{
		this.st=st;
		new Thread(this,"Printer").start();
	}
	
	public void run()
	{
		synchronized(st)
		{
			System.out.println("Value: "+st.getI());
		}
		
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

public class Exer2
{
	public static void main(String args[])
	{
		Storage1 st=new Storage1();
		Counter1 c=new Counter1(st);
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