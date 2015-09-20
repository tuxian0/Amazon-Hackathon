package com.amazon.hackathon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.amazon.hackathon.data.ItemVO;
import com.amazon.hackathon.db.provider.SQLConnectionProvider;
import com.thoughtworks.xstream.XStream;

public class SubscriptionSystemDAO {

	public void insertContents(Map<Integer, String> map) {
		if (map != null && map.size() > 0) {
			Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, String> pair = (Map.Entry<Integer, String>) it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				ItemVO item = checkIfExistInDB(pair.getKey().intValue());
				if(item != null) {
					try {
						SQLConnectionProvider
							.executeUpdateQuery(generateUpdateQuery(item, pair.getValue()));
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					try {
						SQLConnectionProvider
							.executeInsertQuery(generateInsertQuery(pair.getKey().intValue(), pair.getValue()));
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private ItemVO checkIfExistInDB(int intValue) {
		String query = "SELECT * FROM item WHERE item=" + intValue;
		try {
			Connection conn = SQLConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
//			ResultSet rs = SQLConnectionProvider.executeSelectQuery(query);
//			if(rs != null && !rs.isClosed()) {
//				System.err.println("Value exist, so you should update not insert");
				while(rs.next()) {
					ItemVO item = new ItemVO();
					
					item.setItem(rs.getInt("item"));
					String itemValue = rs.getString("item_details");
					
					String attr[] = itemValue.split("/");
					for(int cnt=0; cnt<attr.length; cnt = cnt+2) {
						item.addAttribute_name(attr[cnt]);
						item.addAttribute_value(attr[cnt+1]);
					}
					System.err.println("item>>"+new XStream().toXML(item));
					return item;
				}
//			}
//			else
//				System.err.println("rs is null for the select query");
				conn.close();
				stmt.close();
				rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String generateUpdateQuery(ItemVO item, String value) {
		String attr[] = value.split("/");
		for(int cnt=0; cnt<attr.length; cnt = cnt+2) {
			System.err.println(item.getItemValues() + " contains " + attr[cnt].trim());
			if(item.getItemValues().contains(attr[cnt].trim())) {
				for(int index=0; index<item.getAttribute_name().size(); index++) {
					String str1 = item.getAttribute_name().get(index), str2 = attr[cnt].trim();
					if(str1.equals(str2)) {
						item.getAttribute_value().set(index, attr[cnt+1]);
						System.err.println(attr[cnt].trim() + " = '"+ attr[cnt+1] +"'");
					}
				}
			}
		}
		return "UPDATE item SET item_details='"+ item.getItemValues() +"' WHERE item="+ item.getItem();
	}

	private String generateInsertQuery(int item, String itemValue) {

		return "INSERT INTO item(item, item_details) VALUES (" + item + ", '" + itemValue + "');";

	}

	public List<ItemVO> retrieveListOfItems() {
		String query = "SELECT * FROM item";
		List<ItemVO> list = new ArrayList<ItemVO>();
		try {
			Connection conn = SQLConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setItem(rs.getInt("item"));
				String itemValue = rs.getString("item_details");
				
				String attr[] = itemValue.split("/");
				for(int cnt=0; cnt<attr.length; cnt = cnt+2) {
					item.addAttribute_name(attr[cnt]);
					item.addAttribute_value(attr[cnt+1]);
				}
				System.err.println("item>>"+new XStream().toXML(item));
				list.add(item);
			}
			conn.close();
			stmt.close();
			rs.close();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
