package cz.expertkom.ju.springdemo.api.impl;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import cz.expertkom.ju.interfaces.ItemRepository;
import cz.expertkom.ju.interfaces.UserService;
import cz.expertkom.ju.interfaces.entity.Item;
import cz.expertkom.ju.interfaces.entity.User;
import cz.expertkom.ju.springdemo.api.TestApi;
import cz.expertkom.ju.springdemo.dto.ItemDto;
import cz.expertkom.ju.springdemo.dto.Items;
import cz.expertkom.ju.springdemo.service.ItemService;

public class TestApiImpl implements TestApi {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Response test(String param) {
		 User user = userService.getUser(param);
		 return Response.ok(user).build();
		 
	}

	@Override
	public Response item(String param) {
		Item item = new Item();
		item.setText("test");
		itemService.create(item);
		return Response.ok(param+","+param).build();
	}

	@Override
	public Response itemsList() {
		List<Item> result = itemService.findAll();
		Items items = new Items();
		items.setItems(result);
		System.out.println(itemRepository.getItemById((long)1));
		return Response.ok(items).build();
	}
	
	public Response itemsInsert(ItemDto itemDto) {
		Item item = new Item();
		item.setText(itemDto.getText());
		itemService.create(item);
		return Response.ok().build();	
	}
	
	public Response deleteRecord(Long id) {
			itemService.deleteRecord(id);
		return Response.ok().build();
	}
	
	public Response updateRecord(Long id, ItemDto itemDto) {
			System.out.println("Změna záznamu");
			Item item = itemService.getItem(id);
			item.setText(itemDto.getText());
			System.out.println(item);
			itemService.updateRecord(item);
		return Response.ok().build();
	}

}
