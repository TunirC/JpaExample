package com.incb.store_content_manager.repository.mysql;

import com.incb.store_content_manager.model.mysql.ProductTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mySqlProductRepository")
public interface SqlProductRepository extends JpaRepository<ProductTableEntity, Integer> {
}
