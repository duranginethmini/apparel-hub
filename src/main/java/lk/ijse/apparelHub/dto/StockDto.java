package lk.ijse.apparelHub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockDto {
    private String stockId;
    private String type;
    private  int amount;
    private String description;

}
