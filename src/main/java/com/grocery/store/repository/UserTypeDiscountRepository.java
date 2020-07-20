/**
 * 
 */
package com.grocery.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grocery.store.entity.UserType;

/**
 * @author Mumtaz
 *
 */
@Repository
public interface UserTypeDiscountRepository extends CrudRepository<UserType, Long> {

	public UserType findByUserType(String userType);
}
