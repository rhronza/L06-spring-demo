package cz.expertkom.ju.springdemo.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import cz.expertkom.ju.interfaces.entity.Item;

@XmlRootElement
public class Items {

	List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
