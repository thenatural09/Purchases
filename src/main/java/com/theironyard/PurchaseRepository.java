package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Troy on 10/25/16.
 */
public interface PurchaseRepository extends CrudRepository<Purchase,Integer> {
    List<Purchase> findByCategory(String category);
}
