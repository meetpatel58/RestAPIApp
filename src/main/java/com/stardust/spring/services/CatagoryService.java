package com.stardust.spring.services;

import com.stardust.spring.api.v1.model.CatagoryDTO;

import java.util.List;

public interface CatagoryService {

    List<CatagoryDTO> getAllCategories();

    CatagoryDTO getCategoryByName(String name);

    CatagoryDTO createNewCatagory(CatagoryDTO catagoryDTO);

    CatagoryDTO saveCatagoryByDTO(Long id, CatagoryDTO catagoryDTO);

    CatagoryDTO patchCatagory(Long id, CatagoryDTO catagoryDTO);
}
