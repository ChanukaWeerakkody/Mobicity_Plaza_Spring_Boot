package lk.ijse.gdse.BackEnd.dao;

import lk.ijse.gdse.BackEnd.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface CustomerDAO extends JpaRepository<Customer,String> {
    Customer findByEmail(String email);
}
