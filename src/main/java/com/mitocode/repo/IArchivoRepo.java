package com.mitocode.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.mitocode.model.Archivo;

public interface IArchivoRepo extends IGenericRepo<Archivo, Integer>{

    @Query(value = "select * from archivo where id_archivo = (select max(id_archivo) from archivo)", nativeQuery = true)
    Optional<Archivo> findLast();

}
