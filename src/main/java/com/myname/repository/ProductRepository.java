package com.myname.repository;

import com.myname.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    @Query("select p from Product p where p.productSort = :sort and p.quantityOnStock>0")
    List<Product> findProductsBySort(@Param("sort")String sort);
}
