package lk.ijse.gdse.BackEnd.dao;

import lk.ijse.gdse.BackEnd.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface AdminDAO extends JpaRepository<Admin,String> {
    Object searchAdminByUserName(String userName);
}
