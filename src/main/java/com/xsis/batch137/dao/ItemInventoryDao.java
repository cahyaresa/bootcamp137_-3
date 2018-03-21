package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.ItemInventory;

public interface ItemInventoryDao {
	public void save(ItemInventory itemInventory);
	public List<ItemInventory> selectAll();
	public ItemInventory getOne(ItemInventory itemInventory);
	public void delete(ItemInventory itemInventory);
	public void update(ItemInventory itemInventory);
	public void saveAtauUpdate(ItemInventory itemInventory);
}