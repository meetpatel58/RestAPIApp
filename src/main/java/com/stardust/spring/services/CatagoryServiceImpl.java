package com.stardust.spring.services;

import com.stardust.spring.api.v1.mapper.CatagoryMapper;
import com.stardust.spring.api.v1.model.CatagoryDTO;
import com.stardust.spring.model.Catagory;
import com.stardust.spring.repositories.CatagoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
                .map(catagoryMapper::catagoryToCatagoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CatagoryDTO getCategoryByName(String name) {
        return catagoryMapper.catagoryToCatagoryDTO(catagoryRepository.findByName(name));
    }

    @Override
    public CatagoryDTO createNewCatagory(CatagoryDTO catagoryDTO) {

        Catagory catagory = catagoryMapper.catagoryDTOToCatagory(catagoryDTO);

        Catagory savedcatagory = catagoryRepository.save(catagory);

        CatagoryDTO returnDTO = catagoryMapper.catagoryToCatagoryDTO(savedcatagory);

        return returnDTO;
    }
}
