package com.example.bootdata.dao.impl;

import com.example.bootdata.dao.PetDao;
import com.example.bootdata.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * user: ken
 * data: 2021/5/18 16:00
 */
//@Repository
public class PetDaoImpl implements PetDao {
    @Autowired
    JdbcTemplate template;

    @Override
    public int save(Pet pet) {
        String sql = "insert into  t_pet(name,health,love,strain,birthday) values (?,?,?,?,?);";
        return template.update(sql, pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain(),pet.getBirthday());
    }

    @Override
    public int update(Pet pet) {
        String sql = "update  t_pet set name=?,health=?,love=?,strain=? where id=?;";
        return template.update(sql, pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain(),pet.getId());
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from t_pet where id=?;";
        return template.update(sql,id);
    }

    @Override
    public List<Pet> getAllPet() {
        String sql = "select id,name,health,love,strain,birthday from  t_pet";
        return  template.query(sql,new BeanPropertyRowMapper<>(Pet.class));
    }

    @Override
    public Pet getPetById(int id) {
        String sql = "select id,name,health,love,strain,birthday from  t_pet where id = ?";
        return  template.queryForObject(sql,new BeanPropertyRowMapper<>(Pet.class),id);
    }
    @Override
    public List<Map<String,Object>> getAllList(){
        String sql = "select id,name,health,love,strain,birthday from  t_pet";
        return  template.queryForList(sql);
    };

    @Override
    public Map<String,Object> getMapById(int id){
        String sql = "select id,name,health,love,strain,birthday from  t_pet where id = ?";
        return  template.queryForMap(sql, id);
    };
}
