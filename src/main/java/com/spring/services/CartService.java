package com.spring.services;

import java.util.List;

import com.spring.entities.Cart;

public interface CartService {
	public Cart add(Cart cart);
	public Cart update(Cart cart);
	public void delete(Cart cart);
	public List<Cart> getCartbyUser(String username);
	public Cart getById(String username , Integer id, String kt);
	public void deleteCartByUsername(String username);
}
