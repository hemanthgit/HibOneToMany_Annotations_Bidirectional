package com.mhk.poc.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mhk.poc.model.Cart;
import com.mhk.poc.model.Item;
import com.mhk.poc.util.HibernateUtil;

public class Test {

		public static void main(String[] args) {

			Cart ebayCart = new Cart();
			ebayCart.setName("Ebay");
			
			Item item1 = new Item();
			item1.setName("Television");
			item1.setQuantity(4);
			item1.setItemCart(ebayCart); // Need to set Cart in OneToMany Bi-Directional mappings.

			Item item2 = new Item();
			item2.setName("Toy");
			item2.setQuantity(2);
			item2.setItemCart(ebayCart); // Need to set Cart in OneToMany Bi-Directional mappings.
			
			Set<Item> items = new HashSet<Item>();
			items.add(item1);
			items.add(item2);

			ebayCart.setItems(items);
			
			SessionFactory sessionFactory = null;
			Session session = null;
			Transaction tx = null;
			try{
			//Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("Session created");
			//start transaction
			tx = session.beginTransaction();
			//Save the Model object
			session.save(ebayCart);
			// As we are using OneToMany "Bidirectional" mapping, we should save ITEM(child) objects exclusively
			session.save(item1);
			session.save(item2);
			//Commit transaction
			tx.commit();

			System.out.println("Cart ID="+ebayCart.getId());
			System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getItemCart().getId());
			System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getItemCart().getId());
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}finally{
				if(!sessionFactory.isClosed()){
					System.out.println("Closing SessionFactory");
					sessionFactory.close();
				}
			}
		}
}
