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

import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.ItemInventory;
import com.xsis.batch137.model.Province;
import com.xsis.batch137.model.SalesOrder;
import com.xsis.batch137.service.CustomerService;
import com.xsis.batch137.service.ItemInventoryService;
import com.xsis.batch137.service.ProvinceService;
import com.xsis.batch137.service.SalesOrderService;

//import com.bootcamp.miniproject.model.Customer;
//import com.bootcamp.miniproject.model.ItemInventory;
/*import com.bootcamp.miniproject.model.Province;
import com.bootcamp.miniproject.model.SalesOrder;
import com.bootcamp.miniproject.service.CustomerService;
import com.bootcamp.miniproject.service.ItemInventoryService;
import com.bootcamp.miniproject.service.ProvinceService;
import com.bootcamp.miniproject.service.SalesOrderService;*/

@Controller
@RequestMapping("/transaction/sales-order")
public class SalesOrderController {
	@Autowired
	SalesOrderService salesOrderService;
	
	@Autowired
	ItemInventoryService itemInventoryService;
	
	@Autowired
	ProvinceService provinceService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping
	public String index(Model model) {
		List<SalesOrder> salesOrders = salesOrderService.selectAll();
		List<Province> provinces = provinceService.selectAll();
		model.addAttribute("salesOrders", salesOrders);
		model.addAttribute("provinces", provinces);
		return "sales-order";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveSalesOrder(@RequestBody SalesOrder salesOrder) {
		salesOrderService.save(salesOrder);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateSalesOrder(@RequestBody SalesOrder salesOrder) {
		salesOrderService.update(salesOrder);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSalesOrder(@PathVariable Long id) {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setId(id);
		salesOrderService.delete(salesOrder);
	}
	
	@RequestMapping(value = "/get-one/{id}", method = RequestMethod.GET)
	@ResponseBody
	public SalesOrder getOneSalesOrder(@PathVariable Long id) {
		SalesOrder salesOrder = salesOrderService.getOne(id);
		return salesOrder;
	}
	
	@RequestMapping(value = "/get-one-item/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ItemInventory getOneItem(@PathVariable Long id) {
		ItemInventory itemInventory = itemInventoryService.getOne(id);
		return itemInventory;
	}
	
	@RequestMapping(value = "/search-item", method = RequestMethod.GET)
	@ResponseBody
	public List<ItemInventory> searchItem(@RequestParam(value="search", defaultValue="") String search) {
		List<ItemInventory> itemsInventory = itemInventoryService.searchItemInventoryByItemName(search);
		return itemsInventory;
	}
	
	@RequestMapping(value = "/search-customer", method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> searchCustomer(@RequestParam(value="search", defaultValue="") String search) {
		List<Customer> customers = customerService.getCustomerBySearchName(search);
		return customers;
	}
}
