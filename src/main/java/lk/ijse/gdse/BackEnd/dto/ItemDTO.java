package lk.ijse.gdse.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String itemId;

    private String brand;
    private String description;
    private int qty;
    private double price;
    private String warranty;

    private String image;
}
