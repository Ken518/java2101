package com.example.bootdata.controller;

import com.example.bootdata.entity.Pet;
import com.example.bootdata.entity.R;
import com.example.bootdata.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * user: ken
 * data: 2021/5/18 16:11
 */
@Controller
@RequestMapping("abc")
@Slf4j
public class PetController {

    @Autowired
    PetService service;


    @GetMapping ("/pets")
    public String getPets(Model model){

        log.info("pets----------------------------->");

        log.info("pets----------------------------->");

        log.info("pets----------------------------->");

        List<Pet> allPet = service.getAllPet();

        model.addAttribute("pets",allPet);

        return "pet";
    }

    @PostMapping("/pet/add")
    public R addPet(Pet pet){

        try {
            int result = service.save(pet);
            if(result>0){
                return R.ok(pet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return R.error(588,"新增失败");
    }


}
