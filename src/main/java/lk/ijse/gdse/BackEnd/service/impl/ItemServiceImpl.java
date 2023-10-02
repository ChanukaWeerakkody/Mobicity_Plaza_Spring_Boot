package lk.ijse.gdse.BackEnd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.BackEnd.dao.ItemDAO;
import lk.ijse.gdse.BackEnd.dto.ItemDTO;
import lk.ijse.gdse.BackEnd.entity.Item;
import lk.ijse.gdse.BackEnd.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    ItemDAO itemDAO;

    @Override
    public Item saveItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemid(itemDTO.getItemid());
        item.setBrand(itemDTO.getBrand());
        item.setDescription(itemDTO.getDescription());
        item.setQty(itemDTO.getQty());
        item.setPrice(itemDTO.getPrice());
        item.setWarranty(itemDTO.getWarranty());
        item.setImage(Base64.getDecoder().decode(itemDTO.getImageBase64()));

        return itemDAO.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemDAO.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDAO.findAll();
    }
}
