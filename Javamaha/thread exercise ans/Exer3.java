package com.cisco.ThreadEx;

class ConProd
{
	int value;
	boolean available = false;

	public synchronized int get()
	{
		while (available == false) 
		{
			try 
			{
				wait();
			} 
			catch (Exception e)
			{
				
			}
		}
		available = false;
		notifyAll();
		return value;
	}

	public synchronized void put(int value)
	{
		while (available == true) 
		{
			try
			{
				wait();
			} 
			catch (Exception e) 
			{
			}
		}
		this.value = value;
		available = true;
		notifyAll();
	}
}

class Consumer extends Thread 
{
	ConProd cp;
	int num;

	public Consumer(ConProd c, int num)
	{
		cp = c;
		this.num = num;
	}

	public void run()
	{
		int value = 0;
		for (int i = 0; i < 10; i++) 
		{
			value = cp.get();
			System.out.println("Consumer #" + this.num + " got: " + value);
		}
	}
}

class Producer extends Thread 
{
	ConProd cp;
	int num;

	public Producer(ConProd c, int num)
	{
		cp = c;
		this.num = num;
	}

	public void run() 
	{
		for (int i = 0; i < 10; i++)
		{
			cp.put(i);
			System.out.println("Producer #" + this.num + " put: " + i);
			try
			{
				sleep(500);
			} 
			catch (InterruptedException e)
			{
			}
		}
	}
}

public class Exer3 
{
	public static void main(String[] args)
	{
		ConProd c = new ConProd();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		p1.start();
		c1.start();
	}
}
