package com.stardust.spring.bootstrap;

import com.stardust.spring.model.Catagory;
import com.stardust.spring.repositories.CatagoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CatagoryRepository catagoryRepository;

    public Bootstrap(CatagoryRepository catagoryRepository) {
        this.catagoryRepository = catagoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Catagory monitors = new Catagory();
        monitors.setName("Monitors");
        catagoryRepository.save(monitors);

        Catagory ram = new Catagory();
        ram.setName("RAM");
        catagoryRepository.save(ram);

        Catagory cpu = new Catagory();
        ram.setName("CPU");
        catagoryRepository.save(cpu);

        Catagory gpu = new Catagory();
        ram.setName("GPU");
        catagoryRepository.save(gpu);

        Catagory psu = new Catagory();
        ram.setName("PSU");
        catagoryRepository.save(psu);

        System.out.println("Data Loaded = " + catagoryRepository.count());
    }
}
