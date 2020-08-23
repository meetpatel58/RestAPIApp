package com.stardust.spring.services;

import com.stardust.spring.api.v1.mapper.CatagoryMapper;
import com.stardust.spring.api.v1.model.CatagoryDTO;
import com.stardust.spring.model.Catagory;
import com.stardust.spring.repositories.CatagoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
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

    @Override
    public CatagoryDTO saveCatagoryByDTO(Long id, CatagoryDTO catagoryDTO) {

        Catagory catagory = catagoryMapper.catagoryDTOToCatagory(catagoryDTO);
        catagory.setId(id);

        Catagory savedcatagory = catagoryRepository.save(catagory);

        CatagoryDTO returnDTO = catagoryMapper.catagoryToCatagoryDTO(savedcatagory);

        return returnDTO;
    }

    @Override
    public CatagoryDTO patchCatagory(Long id, CatagoryDTO catagoryDTO) {

        return catagoryRepository.findById(id).map(catagory -> {

            if(catagoryDTO.getName() != null){
                catagory.setName(catagoryDTO.getName());
            }

            Catagory savedCatagory = catagoryRepository.save(catagory);

            CatagoryDTO returnDTO = catagoryMapper.catagoryToCatagoryDTO(savedCatagory);

            return returnDTO;
        }).orElseThrow(RuntimeException::new);
    }
}
