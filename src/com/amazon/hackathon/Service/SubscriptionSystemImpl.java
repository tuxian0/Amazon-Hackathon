package com.amazon.hackathon.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.amazon.hackathon.dao.SubscriptionSystemDAO;
import com.amazon.hackathon.data.ItemVO;
import com.thoughtworks.xstream.XStream;

public class SubscriptionSystemImpl {
	
	public void storeContents(List<ItemVO> list) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(ItemVO item:list) {
			if( !isExists(map, item) ) {
				map.put(item.getItem(), item.getItemValues());
			}
			else {
				map.put(item.getItem(), map.get(item.getItem()) + item.getItemValues());
			}
		}
		
		SubscriptionSystemDAO dao = new SubscriptionSystemDAO();
		System.out.println("SubscriptionSystemImpl.storeContents>>map>>"+new XStream().toXML(map));
		dao.insertContents(map);
		
	}

	private boolean isExists(Map<Integer, String> map, ItemVO item) {
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer, String> pair = (Map.Entry<Integer, String>)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        if(pair.getKey().equals(item.getItem())) {
	        	return true;
	        }
	    }
		return false;
	}
	
	public List<ItemVO> getItems() {
		SubscriptionSystemDAO dao = new SubscriptionSystemDAO();
		return dao.retrieveListOfItems();
		
	}

}
