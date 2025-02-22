package com.exam.service;

import java.util.List;

import com.exam.dto.OrderDetailsDTO;
import com.exam.dto.OrdersAccountDTO;
import com.exam.entity.OrderDetails;
import com.exam.entity.Orders;
import com.exam.entity.Sales;

public interface OrderDetailsService {

	public Orders findOrder(int cartId);
	public List<OrderDetailsDTO> findOrderDetails(int cartId);
	public List<OrderDetails> saveAllOrderDetails(Orders savedOrder, List<OrderDetailsDTO> list);
	public List<OrderDetailsDTO> findOrderDetailsProducts(int orderId);
	
	OrderDetails findByOrderDetailId(int orderDetailId);
	public Orders getOrdersByOrderDetailId(int orderDetailId);
	
	public List<OrdersAccountDTO> FindOrdersAndDetails(int userId);
	public Sales saveSales(Sales sales);
}
