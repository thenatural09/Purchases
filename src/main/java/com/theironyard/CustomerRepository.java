package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Troy on 10/25/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
