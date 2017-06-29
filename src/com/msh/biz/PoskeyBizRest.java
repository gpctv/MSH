package com.msh.biz;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

import com.dao.Discount;
import com.dao.DiscountDAO;
import com.dao.Item;
import com.dao.ItemDAO;
import com.dao.PoskeyDAO;
import com.msh.api.TimeStamp;
import com.msh.model.PoskeyBean;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
/**
 * PoskeyBiz
 * @author Stan
 *
 */
public class PoskeyBizRest {
	private final String poskey="poskey";
	private PoskeyDAO poskeyDAO;
	private ItemDAO itemDAO;
	private DiscountDAO discountDAO;
	private static Logger log=LoggerFactory.getLogger(PoskeyBizRest.class); 
	public void setPoskeyDAO(PoskeyDAO poskeyDAO){
		this.poskeyDAO=poskeyDAO;
	}
    public void setItemDAO(ItemDAO itemDAO){
    	this.itemDAO=itemDAO;
    }
    public void setDiscountDAO(DiscountDAO discountDAO){
    	this.discountDAO=discountDAO;
    }
    /**
     * get all poskey
     * @return
     */
	public  HashMap<String,PoskeyBean> getPoskeyList(){
	 
		 return poskeyDAO.getAll();
	}
	/**
	 * 設定儲存 POSKEY
	 * @param poskeyBean
	 */
	public PoskeyBean setPoskey(PoskeyBean poskeyBean){
		Item item=new Item();
		Discount discount=new Discount();
		if(poskey.equals(poskeyBean.getType())){
			item.setNameItem(poskeyBean.getTitle());
			item.setIdItem(poskeyDAO.getMax(poskeyBean));
			item.setAmountItem(poskeyBean.getSales().longValue());
		    item.setCreatedateItem(TimeStamp.getNowTimeStamp());
		    item.setEnableItem(poskeyBean.getIsEnable()?new BigDecimal(1):new BigDecimal(0));
		    itemDAO.save(item);
		    poskeyBean.setSelfId(item.getIdItem());
		    return poskeyBean;
		}else{
			discount.setAmountDiscount(poskeyBean.getDiscount().doubleValue());
			discount.setEnableDiscount(poskeyBean.getIsEnable()?new BigDecimal(1):new BigDecimal(0));
			discount.setIdDiscount(poskeyDAO.getMax(poskeyBean));
			discount.setNameDiscount(poskeyBean.getTitle());
			discount.setTypeDiscount("");
			discount.setCreatedateDiscount(TimeStamp.getNowTimeStamp());
			discountDAO.save(discount);
			poskeyBean.setSelfId(discount.getIdDiscount());
			return poskeyBean;
			}
	}
	/**
	 * 刪除 POSKEY
	 * @param poskeyBean
	 */
	public void deletePoskey(PoskeyBean poskeyBean){
		Item item=new Item();
		Discount discount=new Discount();
		if(poskey.equals(poskeyBean.getType())){
			item.setNameItem(poskeyBean.getTitle());
			item.setIdItem(poskeyBean.getSelfId());
			item.setAmountItem(poskeyBean.getSales().longValue());
		    item.setCreatedateItem(TimeStamp.getNowTimeStamp());
		    item.setEnableItem(poskeyBean.getIsEnable()?new BigDecimal(1):new BigDecimal(0));
		    itemDAO.delete(item);
		}else{
			discount.setAmountDiscount(poskeyBean.getDiscount().doubleValue());
			discount.setEnableDiscount(poskeyBean.getIsEnable()?new BigDecimal(1):new BigDecimal(0));
			discount.setIdDiscount(poskeyBean.getSelfId());
			discount.setNameDiscount(poskeyBean.getTitle());
			discount.setTypeDiscount("");
			discount.setCreatedateDiscount(TimeStamp.getNowTimeStamp());
			discountDAO.delete(discount);
		}
	}
	
	public void updatePoskey(PoskeyBean poskeyBean){
		Item item=new Item();
		Discount discount=new Discount();
		if(poskey.equals(poskeyBean.getType())){
			item.setNameItem(poskeyBean.getTitle());
			item.setIdItem(poskeyBean.getSelfId());
			item.setAmountItem(poskeyBean.getSales().longValue());
		    item.setCreatedateItem(TimeStamp.getNowTimeStamp());
		    item.setEnableItem(poskeyBean.getIsEnable()?new BigDecimal(1):new BigDecimal(0));
		    itemDAO.attachDirty(item);
		}else{
			discount.setAmountDiscount(poskeyBean.getDiscount().doubleValue());
			discount.setEnableDiscount(poskeyBean.getIsEnable()?new BigDecimal(1):new BigDecimal(0));
			discount.setIdDiscount(poskeyBean.getSelfId());
			discount.setNameDiscount(poskeyBean.getTitle());
			discount.setTypeDiscount("");
			discount.setCreatedateDiscount(TimeStamp.getNowTimeStamp());
			discountDAO.attachDirty(discount);
		}
	}

}
