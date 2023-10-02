package lk.ijse.gdse.BackEnd.dao;

import lk.ijse.gdse.BackEnd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface ItemDAO extends JpaRepository<Item,Long > {
}
