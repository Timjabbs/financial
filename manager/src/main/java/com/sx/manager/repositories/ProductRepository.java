package com.sx.manager.repositories;

import com.sx.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author : Anui
 * @date : 2020/2/26
 * @time : 14:50
 * @Description :
 */
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
