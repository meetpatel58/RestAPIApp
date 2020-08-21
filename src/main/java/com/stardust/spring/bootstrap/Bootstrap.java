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

        Catagory ram = new Catagory();
        ram.setName("RAM");

        Catagory cpu = new Catagory();
        ram.setName("CPU");

        Catagory gpu = new Catagory();
        ram.setName("GPU");

        Catagory psu = new Catagory();
        ram.setName("PSU");

        catagoryRepository.save(monitors);
        catagoryRepository.save(ram);
        catagoryRepository.save(cpu);
        catagoryRepository.save(gpu);
        catagoryRepository.save(psu);

        System.out.println("Data Loaded = " + catagoryRepository.count());
    }
}
