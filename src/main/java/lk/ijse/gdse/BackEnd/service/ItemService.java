package lk.ijse.gdse.BackEnd.service;

import lk.ijse.gdse.BackEnd.dto.ItemDTO;
import lk.ijse.gdse.BackEnd.entity.Item;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface ItemService {
    Item saveItem(ItemDTO itemDTO);
    Item getItemById(Long id);
    List<Item> getAllItems();
}
