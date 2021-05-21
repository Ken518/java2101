package com.example.bootdata.dao;

import com.example.bootdata.entity.Pet;

import java.util.List;
import java.util.Map;

/**
 * user: ken
 * data: 2021/5/18 15:59
 */
public interface PetDao {

        public int save(Pet pet);

        public int update(Pet pet);

        public int deleteById(int id);

        public List<Pet> getAllPet();

        public Pet getPetById(int id);
        
        public List<Map<String,Object>> getAllList();

        public Map<String,Object> getMapById(int id);
    
    
}
