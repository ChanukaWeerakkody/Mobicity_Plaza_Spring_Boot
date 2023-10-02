package lk.ijse.gdse.BackEnd.api;

import lk.ijse.gdse.BackEnd.dao.ItemDAO;
import lk.ijse.gdse.BackEnd.dto.ItemDTO;
import lk.ijse.gdse.BackEnd.entity.Item;
import lk.ijse.gdse.BackEnd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin("*")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemDAO itemDAO;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadItem(@RequestBody ItemDTO itemDTO) {
        Item savedItem = itemService.saveItem(itemDTO);
        return ResponseEntity.ok("Item uploaded successfully with ID: " + savedItem.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}
