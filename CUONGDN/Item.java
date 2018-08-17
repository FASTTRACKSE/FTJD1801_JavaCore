package object;

import java.util.List;

public class Item {

	private int itemID;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	private String itemValue;

	public Item(int itemID, String itemValue) {
		this.itemID = itemID;
		this.itemValue = itemValue;
	}

	

	public String toString() {
		return  itemValue;
	}
}
