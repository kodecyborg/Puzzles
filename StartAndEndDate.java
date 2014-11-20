package com.example.data.algorithms;

import java.util.Date;



public class StartAndEndDate {

	private Node head;
	private Node tail;
	private int N;
	
	private class Node{
		Date start;
		Date end;
		Node next;
		
	}
	
	private void add(Date start,Date end){
		Node oldLast=tail;
		tail=new Node();
		tail.start=start;
		tail.end=end;
		tail.next=null;
		if(isEmpty())head=tail;
		else oldLast.next=tail;
		N++;
	}
	
	public void addAll(Date[] dates)
	{
		if(dates.length%2!=0)throw new IllegalArgumentException("Array length must be even");
		
		for(int i=0;i<dates.length-1;i++)
		{
			add(dates[i],dates[i+1]);
			
		}
	}
	
	private boolean contains(Node x,Date date)
	{
		if(x==null)return false;
		if(x.start.before(date) && x.end.after(date))return true;
		else
		return contains(x.next,date);
	
	}
	
	public boolean contains(Date date)
	{
		return contains(head,date);
	}
	
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return N==0;
	}


	
	
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		Date dateArray[]=new Date[12];
		
		dateArray[0]=new Date("06/24/1980");
		dateArray[1]=new Date("06/24/1981");
		
		dateArray[2]=new Date("06/24/1982");
		dateArray[3]=new Date("06/24/1983");
		
		dateArray[4]=new Date("06/24/1984");
		dateArray[5]=new Date("06/24/1985");
		
		dateArray[6]=new Date("06/24/1986");
		dateArray[7]=new Date("06/24/1987");
		
		dateArray[8]=new Date("06/24/1988");
		dateArray[9]=new Date("06/24/1989");
		
		dateArray[10]=new Date("06/24/1990");
		dateArray[11]=new Date("06/24/1991");
		

		Date testDate=new Date("06/20/1990");//Into pair of dates
		Date testDate2=new Date("06/26/1991");//Not in any pair of dates
		StartAndEndDate st=new StartAndEndDate();
		st.addAll(dateArray);
		
		System.out.println(st.contains(testDate));
		System.out.println(st.contains(testDate2));

	}


}
