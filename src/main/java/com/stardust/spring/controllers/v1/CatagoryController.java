package com.stardust.spring.controllers.v1;

import com.stardust.spring.api.v1.model.CatagoryDTO;
import com.stardust.spring.api.v1.model.CatagoryListDTO;
import com.stardust.spring.services.CatagoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/catagories")
public class CatagoryController {

    private final CatagoryService catagoryService;

    public CatagoryController(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }

    @GetMapping
    public ResponseEntity<CatagoryListDTO> getAllCatagories(){

        return new ResponseEntity<CatagoryListDTO>(
                new CatagoryListDTO(catagoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CatagoryDTO> getCatagoryByName( @PathVariable String name){
        return new ResponseEntity<CatagoryDTO>(
                catagoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
