package com.cisco.CollEx;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection1
{
	static ArrayList<Character> input=new ArrayList<Character>();
	static HashMap<String, Integer> cache=new HashMap<String, Integer>();
	
	public static void main(String args[])
	{
		String ip1="Input1";
		String ip2="OtherInput";
		func(ip1);
		func(ip2);
		func(ip1);
	}
	
	static void func(String ip)
	{
		int i=0;
		int len=ip.length();
		
		if(cache.containsKey(ip))
		{
			Integer i1=cache.get(ip);
			System.out.println("No. of characters in "+ip+": "+i1+" thru the HashMap");
		}
		else
		{
			for(i=0;i<len;i++)
			{
				if(!(input.contains(ip.charAt(i))))
						{
							input.add(ip.charAt(i));
						}
			}
			cache.put(ip, input.size());
			System.out.println("No. of characters in "+ip+": "+input.size()+" thru the ArrayList");
			//System.out.println(ip+" "+input.size());
		}
	}
}