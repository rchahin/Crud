package com.examenpromerica.Examen.promerica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examenpromerica.Examen.promerica.entity.Producto;
import com.examenpromerica.Examen.promerica.repository.Iproducto;

@RestController
@RequestMapping("/api")

public class ProductoController {

	@Autowired
	Iproducto productoRepo;
	
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getAllProducto(@RequestParam(required = false) String title) {
		try {
			List<Producto> producto = new ArrayList<Producto>();

			if (title == null)
				productoRepo.findAll().forEach(producto::add);
			else
				//alumnosRepository.findByTitleContaining(title).forEach(tutorials::add);

			if (producto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(producto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/producto")
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		try {
			Producto productos = productoRepo
					.save(new Producto(producto.getId(), producto.getNombres(),producto.getDescripcion(), producto.getPrecio(), producto.getEstado()));
			return new ResponseEntity<>(producto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/producto/{id}")
	public ResponseEntity<Producto> updateProductos(@PathVariable("id") Integer id, @RequestBody Producto productos) {
		Optional<Producto> productosData = productoRepo.findById(id);

		if (productosData.isPresent()) {
			Producto _productos = productosData.get();
			_productos.setNombres(productos.getNombres());
			_productos.setDescripcion(productos.getDescripcion());
			_productos.setPrecio(productos.getPrecio());
			_productos.setEstado(productos.getEstado());
			return new ResponseEntity<>(productoRepo.save(_productos), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/producto/{id}")
	public ResponseEntity<HttpStatus> deleteProductos(@PathVariable("id") Integer id) {
		try {
			productoRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

 }