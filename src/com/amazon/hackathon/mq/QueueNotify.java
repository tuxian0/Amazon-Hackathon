package com.amazon.hackathon.mq;

import java.io.IOException;
import java.util.Scanner;

public class QueueNotify {
	public static void main(String args[]) throws IOException {
		MessageQueue mq = new MessageQueue();
		// QueueNotify qNotify= new QueueNotify();
		// QueueOperations qOper=new QueueOperations();
		Scanner sc = new Scanner(System.in);
		String notification;
		int userID, option;

		do {
			System.out.println("Enter the option( 1. to enqueue 2. to dequeue)");
			option = sc.nextInt();
			if (option == 1) {
				Notification qOP = new Notification();
				System.out.println("Enter the User ID:");
				userID = sc.nextInt();
				System.out.println("Enter the notification");
				notification = sc.next();
				qOP.setNotificationStr(notification);
				qOP.setUserID(userID);
				mq.enqueue(qOP);
			}

			if (option == 2) {
				mq.dequeue();
			}

		} while (option != 3);
		sc.close();
	}

}
