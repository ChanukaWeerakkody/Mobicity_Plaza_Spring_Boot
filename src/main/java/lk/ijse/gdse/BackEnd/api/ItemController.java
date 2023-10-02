package lk.ijse.gdse.BackEnd.api;

import jakarta.servlet.annotation.MultipartConfig;
import lk.ijse.gdse.BackEnd.dao.ItemDAO;
import lk.ijse.gdse.BackEnd.dto.ItemDTO;
import lk.ijse.gdse.BackEnd.entity.Item;
import lk.ijse.gdse.BackEnd.service.ItemService;
import lk.ijse.gdse.BackEnd.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@RestController
@RequestMapping("/api/v1/item/")
@MultipartConfig(location = "")
//@CrossOrigin("*")
public class ItemController {


    @Autowired
    ItemService itemService;

    @Autowired
    ItemDAO itemDAO;


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE} )
    public void saveItem(@RequestPart String itemId,@RequestPart String brand, @RequestPart String description,@RequestPart int qty,@RequestPart double price,@RequestPart String warranty, @RequestPart byte[] image){

        System.out.println("hit");
        String s = Base64.getEncoder().encodeToString(image);

//        ItemDTO itemDTO = new ItemDTO();
//        itemDTO.setItemId(itemId);
//        itemDTO.setBrand(brand);
//        itemDTO.setDescription(description);
//        itemDTO.setQty(qty);
//        itemDTO.setPrice(price);
//        itemDTO.setWarranty(warranty);
//        itemDTO.setImage(s);
//        itemService.saveItem(itemDTO);
        System.out.println(s);

//        System.out.println(itemId+" "+brand+" "+description+" "+qty+" "+price+" "+warranty+" "+s);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@ModelAttribute ItemDTO imageDTO) {
        try {
            itemService.saveItem(imageDTO);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading the image");
        }
    }

}
