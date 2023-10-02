package lk.ijse.gdse.BackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Item implements SuperEntity {
    @Id
    private String itemId;

    private String brand;
    private String description;
    private int qty;
    private double price;
    private String warranty;

    @Lob
    private byte[] image;
}
