package lk.ijse.apparelHub.dto.tm;

import javafx.scene.control.DatePicker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderTm {
private String orderId;
private String B_id;
private String pay_id;
private double price;
private String description;
private  int qyt;
private String date;

}
