package com.cisco.CollEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Collection2
{
	public static void main(String args1[])
	{
		//String args1[]={"Hello","World"};
		int len=args1.length;
		System.out.println(len);
		
		StringBuffer result = new StringBuffer(); 
		
		for (int i = 0; i < len; i++)
		{ 
		   result.append( args1[i] );  
		} 
		
		String mynewstring = result.toString(); 

		char[] c=mynewstring.toCharArray();
		
		int len_new=c.length;
		System.out.println(len_new);

		HashMap<Character,ArrayList<Integer>> charac=new HashMap<Character,ArrayList<Integer>>();
		
		for(char c1:c)
		{
			
			if(charac.containsKey(c1))
			{
				ArrayList<Integer> temp=charac.get(c1);
				temp.add(i);
			}
			else
			{
				ArrayList<Integer> pos=new ArrayList<Integer>();
				pos.add(i);
				charac.put(c1, pos);
			}
		}
		
		Set set = charac.entrySet();
	      
	    Iterator i = set.iterator();
	     
	    while(i.hasNext()) 
	    {
	    	Map.Entry me = (Map.Entry)i.next();
	        System.out.print(me.getKey() + ": ");
	        System.out.println(me.getValue());
	    }

		//System.out.println("Character: "+charactr+" and its position: "+position);
	}
}