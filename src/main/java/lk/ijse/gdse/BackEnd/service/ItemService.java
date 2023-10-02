package lk.ijse.gdse.BackEnd.service;

import lk.ijse.gdse.BackEnd.dto.ItemDTO;
import lk.ijse.gdse.BackEnd.entity.Item;

import java.io.IOException;
import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface ItemService {
    void saveItem(ItemDTO itemDTO) throws IOException;
    void updateItem(ItemDTO itemDTO);
    void deleteItem(String id);
    void uploadItemImage(String image, String itemId);
}
