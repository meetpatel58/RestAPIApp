package com.stardust.spring.api.v1.mapper;

import com.stardust.spring.api.v1.model.CatagoryDTO;
import com.stardust.spring.model.Catagory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatagoryMapper {

    CatagoryMapper INSTANCE = Mappers.getMapper(CatagoryMapper.class);

    CatagoryDTO catagorytoCatagoryDTO(Catagory catagory);
}
