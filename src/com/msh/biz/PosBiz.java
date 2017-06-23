package com.msh.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dao.DiscountDAO;
import com.dao.Item;
import com.dao.ItemDAO;

public class PosBiz {
	
	ItemDAO itemDAO;
	DiscountDAO discountDAO;
	
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public DiscountDAO getDiscountDAO() {
		return discountDAO;
	}

	public void setDiscountDAO(DiscountDAO discountDAO) {
		this.discountDAO = discountDAO;
	}

	public ArrayList<Item> getItemKey(){
		Item item=new Item();
		item.setEnableItem(new BigDecimal("1"));
		@SuppressWarnings("unchecked")
		ArrayList<Item> itemList= (ArrayList<Item>) itemDAO.findByExample(item);
		  
	return itemList;
	}
}
