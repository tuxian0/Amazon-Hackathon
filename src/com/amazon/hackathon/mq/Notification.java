package com.amazon.hackathon.mq;



public class Notification {
		
		private int userID;
		private String notificationStr;
		
		public int getUserID()
		{
			return userID;
		}

		public String getNotificationStr()
		{
			return notificationStr;
		}
		
		public void setUserID(int uID)
		{
			userID=uID;
		}
		
		public void setNotificationStr(String notif)
		{
			notificationStr=notif;
		}
}