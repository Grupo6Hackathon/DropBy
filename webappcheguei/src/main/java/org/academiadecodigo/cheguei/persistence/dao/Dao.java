package org.academiadecodigo.cheguei.persistence.dao;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.persistence.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

}
