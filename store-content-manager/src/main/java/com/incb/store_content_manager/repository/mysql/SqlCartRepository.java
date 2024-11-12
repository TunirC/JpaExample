package com.incb.store_content_manager.repository.mysql;

import com.incb.store_content_manager.model.CartEntity;
import com.incb.store_content_manager.model.mysql.CartTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mySqlCartRepository")
public interface SqlCartRepository extends JpaRepository<CartTableEntity, Integer> {
}
