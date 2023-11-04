package com.api.rest.marvel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.marvel.entity.Bitacora;

@Repository
public interface RepositorioBitacora extends JpaRepository<Bitacora, Long>{

}
