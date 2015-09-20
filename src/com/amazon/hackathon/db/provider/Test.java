package com.amazon.hackathon.db.provider;

import com.amazon.hackathon.Service.SubscriptionSystemImpl;
import com.amazon.hackathon.csv.reader.CSVFileReader;

public class Test {

	public static void main(String[] args) {

		SubscriptionSystemImpl impl = new SubscriptionSystemImpl();
		impl.storeContents(CSVFileReader.readCSVFile("/home/tuxian/Documents/Amazon/file_2.csv"));
	}

}
