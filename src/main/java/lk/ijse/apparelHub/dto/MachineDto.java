package lk.ijse.apparelHub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MachineDto {
    private String M_id;
    private String type;
    private double cost;
}
