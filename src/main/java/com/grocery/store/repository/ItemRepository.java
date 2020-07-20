/**
 * 
 */
package com.grocery.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grocery.store.entity.Item;

/**
 * @author Mumtaz
 *
 */

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

	
}
