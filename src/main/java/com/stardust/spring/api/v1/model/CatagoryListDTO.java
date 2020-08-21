package com.stardust.spring.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CatagoryListDTO {

    List<CatagoryDTO> catagories;
}
