package com.exam.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.config.StocksMapper;
import com.exam.dto.InventoryDTO;
import com.exam.dto.ProductsDTO;
import com.exam.entity.Inventory;
import com.exam.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	StocksMapper stocksMapper;

	public InventoryServiceImpl(StocksMapper stocksMapper) {
		this.stocksMapper = stocksMapper;
	}

	@Override
	public void upsertInventory(Inventory inventory) {
		Optional<Inventory> existingInventoryOpt = inventoryRepository.findFirstByProductId(inventory.getProductId());

		// if 기존 재고관리 데이터 있으면 get 해서 새로운 재고관리 데이터와 비교하고 같지 않으면 update
		// else 기존 재고관리 데이터 없으면 새로운 재고관리 데이터 insert
		if (existingInventoryOpt.isPresent()) {
			Inventory existingInventory = existingInventoryOpt.get();
			if (!existingInventory.getStockQuantity().equals(inventory.getStockQuantity())) {
				existingInventory.setStockQuantity(inventory.getStockQuantity());
				existingInventory.setLastUpdated(LocalDateTime.now());
				inventoryRepository.save(existingInventory);
			}
		} else {
			inventory.setLastUpdated(LocalDateTime.now());
			inventoryRepository.save(inventory);
		}
	}

	@Override
	public List<InventoryDTO> findAllStocks() {
		List<InventoryDTO> result = stocksMapper.findAllStocks();
		return result;
	}

	@Override
	public List<ProductsDTO> findAllProducts() {
		List<ProductsDTO> result = stocksMapper.findAllProducts();
		return result;
	}

	@Override
	public List<InventoryDTO> findAllProductsStock() {
		List<InventoryDTO> result = stocksMapper.findAllProductsStock();
		return result;
	}

}
