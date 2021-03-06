package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Category;
import com.xsis.batch137.model.Item;
import com.xsis.batch137.model.ItemInventory;
import com.xsis.batch137.model.ItemVariant;
import com.xsis.batch137.model.Outlet;
import com.xsis.batch137.service.CategoryService;
import com.xsis.batch137.service.ItemInventoryService;
import com.xsis.batch137.service.ItemService;
import com.xsis.batch137.service.ItemVariantService;
import com.xsis.batch137.service.OutletService;


@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemInventoryService itemInventoryService;
	
	@Autowired
	ItemVariantService itemVariantService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	OutletService outletService;
	
	@RequestMapping
	public String index(Model model) {
		List<Item> items=itemService.selectAll();
		List<ItemInventory> itemInventories=itemInventoryService.selectAll();
		List<ItemVariant> itemVariants=itemVariantService.selectAll();
		List<Category> categories=categoryService.selectAll();
		List<Outlet> outlets=outletService.selectAll();
		model.addAttribute("outlets", outlets);
		model.addAttribute("items", items);
		model.addAttribute("categories", categories);
		model.addAttribute("itemInventories", itemInventories);
		model.addAttribute("itemVariants", itemVariants);
		return "/item/item";
	}
		
/*==================================CRUD FOR ITEM============================*/
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Item item) {
		itemService.save(item);
	}
	
	@RequestMapping(value="/get-all", method=RequestMethod.GET)
	@ResponseBody
	public List<Item> getAll(){
		return itemService.selectAll();
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public List<ItemInventory> getOne (@PathVariable Long id,Model model) {
		Item item=itemService.getOne(id);
		//List<ItemVariant> dataVariant=itemVariantService.searchVariantByItem(item);
		List<ItemInventory> dataInventory=itemInventoryService.searchInventoryByItem(item);
		model.addAttribute("dataInventory",dataInventory);
		//model.addAttribute("dataVariant",dataVariant);
		model.addAttribute("item",item);
		return dataInventory;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Item item) {
		itemService.update(item);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		Item item=new Item();
		item.setId(id);
		itemService.delete(item);
	}
	
	@RequestMapping(value="/search-item",method=RequestMethod.GET)
	@ResponseBody
	public List<ItemInventory> searchItem(@RequestParam(value="search", defaultValue="") String search){
		List<ItemInventory > itemInventories = itemInventoryService.searchItemInventoryByItemName(search);
		return itemInventories;
	}
	
/*==================================CRUD FOR ITEMVARIANT============================*/
	@RequestMapping(value="/save-variant",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveVariant(@RequestBody ItemVariant itemVariant) {
		itemVariantService.save(itemVariant);
	}
	
	@RequestMapping(value="/get-all-variant", method=RequestMethod.GET)
	@ResponseBody
	public List<ItemVariant> getAllVariant(){
		return itemVariantService.selectAll();
	}
	
	@RequestMapping(value="/get-one-variant/{id}")
	@ResponseBody
	public ItemVariant getOneVariant(@PathVariable Long id) {
		ItemVariant itemVariant=itemVariantService.getOne(id);
		return itemVariant;
	}
	//s
	@RequestMapping(value="/update-variant",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateVariant(@RequestBody ItemVariant itemVariant) {
		itemVariantService.update(itemVariant);
	}
	
	@RequestMapping(value="/delete-variant/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteVariant(@PathVariable Long id) {
		ItemVariant itemVariant=new ItemVariant();
		itemVariant.setId(id);
		itemVariantService.delete(itemVariant);
	}
/*==================================CRUD FOR ITEMINVENTORY============================*/
	@RequestMapping(value="/save-inventory",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveInventory(@RequestBody ItemInventory itemInventory) {
		itemInventoryService.save(itemInventory);
	}
	
	@RequestMapping(value="/get-one-inventory/{id}")
	@ResponseBody
	public ItemInventory getOneInventory(@PathVariable Long id) {
		ItemInventory itemInventory=itemInventoryService.getOne(id);
		return itemInventory;
	}
	
	@RequestMapping(value="/update-inventory",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateInventory(@RequestBody ItemInventory itemInventory) {
		itemInventoryService.update(itemInventory);
	}
	
	@RequestMapping(value="/delete-inventory/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteInventory(@PathVariable Long id) {
		ItemInventory itemInventory=new ItemInventory();
		itemInventory.setId(id);
		itemInventoryService.delete(itemInventory);
	}
	
	@RequestMapping("/get-inventory")
	@ResponseBody
	public List<ItemInventory> getAllInventory(){
		return itemInventoryService.selectAll();
	}
}
