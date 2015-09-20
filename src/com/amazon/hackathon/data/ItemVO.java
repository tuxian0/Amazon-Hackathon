package com.amazon.hackathon.data;

import java.util.ArrayList;
import java.util.List;
import com.amazon.hackathon.constants.SubsriptionSystemConstants;

public class ItemVO {

	private int item;
	
	private List<String> attribute_name = new ArrayList<String>();
	
	private List<String> attribute_value = new ArrayList<String>();
	
	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public List<String> getAttribute_name() {
		return attribute_name;
	}

	public void addAttribute_name(String attr_name) {
		attribute_name.add(attr_name);
	}

	public List<String> getAttribute_value() {
		return attribute_value;
	}

	public void addAttribute_value(String attr_value) {
		attribute_value.add(attr_value);
	}

	public String getItemValues() {
		StringBuffer sb = new StringBuffer();
		for(int cnt=0; cnt<getAttribute_name().size(); cnt++) {
			sb.append(getAttribute_name().get(cnt));
			sb.append(SubsriptionSystemConstants.DELIMITER);
			sb.append(getAttribute_value().get(cnt));
			sb.append(SubsriptionSystemConstants.DELIMITER);
		}
		return sb.toString();
	}
}
