package co.edu.umanizales.myfirstapi.controller.dto;

import co.edu.umanizales.myfirstapi.model.Location;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class StoreDTO {
    private String code;
    private String name;
    private String address;
    private String locationId;
    private String description;

}