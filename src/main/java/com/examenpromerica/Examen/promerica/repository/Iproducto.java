package com.examenpromerica.Examen.promerica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenpromerica.Examen.promerica.entity.Producto;
@Repository
public interface Iproducto extends JpaRepository<Producto,Integer>{

}
