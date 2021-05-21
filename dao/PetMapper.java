package com.example.bootdata.dao;

import com.example.bootdata.entity.Pet;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user: ken
 * data: 2021/5/19 10:19
 */
//@Mapper
@Repository
public interface PetMapper {

    /**
     *新增
     */
//    @Insert("insert into t_pet(name,health,love,birthday)value(#{name},#{health},#{love},#{birthday})")
    public int save(Pet pet);

    /**
     * 查询
     */
//    @Select("select * from t_pet where name like '%${name}%'")
//    @ResultType(Pet.class)
    public List<Pet> getAllPet(@Param("name") String name);
}
