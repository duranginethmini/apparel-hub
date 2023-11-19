package lk.ijse.apparelHub.dto;

import javafx.scene.control.DatePicker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String orderId;
    private String B_id;
    private String Pay_id;
    private double price;
    private String description;
    private int qty;
    private String date;

}
