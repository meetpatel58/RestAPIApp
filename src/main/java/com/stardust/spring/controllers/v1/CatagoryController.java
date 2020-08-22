package com.stardust.spring.controllers.v1;

import com.stardust.spring.api.v1.model.CatagoryDTO;
import com.stardust.spring.api.v1.model.CatagoryListDTO;
import com.stardust.spring.services.CatagoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/catagories")
public class CatagoryController {

    private final CatagoryService catagoryService;

    public CatagoryController(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CatagoryListDTO getAllCatagories(){

        return new CatagoryListDTO(catagoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CatagoryDTO getCatagoryByName( @PathVariable String name){
        return catagoryService.getCategoryByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatagoryDTO createNewCatagory(@RequestBody CatagoryDTO catagoryDTO){
        return catagoryService.createNewCatagory(catagoryDTO);
    }
}
