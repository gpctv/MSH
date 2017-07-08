package com.dao;
/**
 * 商品銷售量查詢 BEAN
 * @author Stan
 *
 */
public class SalesItemCount {
private String idSales;
private String num;
private String NameItem;
private String row;
public String getIdSales() {
	return idSales;
}
public void setIdSales(String idSales) {
	this.idSales = idSales;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getNameItem() {
	return NameItem;
}
public void setNameItem(String nameItem) {
	NameItem = nameItem;
}
public String getRow() {
	return row;
}
public void setRow(String row) {
	this.row = row;
}

}
