package com.amazon.hackathon.mq;


import java.util.ArrayList;

public class MessageQueue {
	ArrayList<Notification> alist= new ArrayList<Notification>();
	public void dequeue()
	{
		alist.remove(0);
		
	}
	public void enqueue(Notification qOP)
	{
	   
		alist.add(qOP);
		for(Notification n:alist) {
			System.out.println(n.getUserID());
		}
	}
	public ArrayList<Notification> getAlist() {
		return alist;
	}
	public void setAlist(ArrayList<Notification> alist) {
		this.alist = alist;
	}
	
	

}
