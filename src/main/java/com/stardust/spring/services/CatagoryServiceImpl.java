package com.stardust.spring.services;

import com.stardust.spring.api.v1.mapper.CatagoryMapper;
import com.stardust.spring.api.v1.model.CatagoryDTO;
import com.stardust.spring.repositories.CatagoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CatagoryServiceImpl implements CatagoryService {

    private final CatagoryMapper catagoryMapper;
    private final CatagoryRepository catagoryRepository;

    public CatagoryServiceImpl(CatagoryMapper catagoryMapper, CatagoryRepository catagoryRepository) {
        this.catagoryMapper = catagoryMapper;
        this.catagoryRepository = catagoryRepository;
    }

    @Override
    public List<CatagoryDTO> getAllCategories() {
        return catagoryRepository.findAll()
                .stream()
                .map(catagoryMapper::catagorytoCatagoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CatagoryDTO getCategoryByName(String name) {
        return catagoryMapper.catagorytoCatagoryDTO(catagoryRepository.findByName(name));
    }
}
