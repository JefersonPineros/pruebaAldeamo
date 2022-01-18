package com.mainsoft.prueba.aldeamo.aldeamoProyect.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.prueba.aldeamo.aldeamoProyect.services.IArraysService;

@RestController
@RequestMapping("/api/prueba")
public class BartendingController {
	
	@Autowired
	private IArraysService arrayService;
	
	@GetMapping( "/{iterations}/{id}" )
	public ResponseEntity<?> arrayValide(@PathVariable Integer iterations, @PathVariable Integer id) {
		Map<String, Object> result = new HashMap<>();
		String arrayResponse;
		if ( id > 5 || id < 1 ) {
			result.put("message", "El id ingresado es superior o inferior al entre 1 o 5");
			result.put("error", "Id incorrecto");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.ACCEPTED);
		} else {
			try {
				arrayResponse = this.arrayService.valideArray(iterations, id);
			} catch (Exception e) {
				result.put("message", e.getMessage());
				result.put("error", "Se ha presentado un error");
				return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
			}
		}
		
		if (arrayResponse != "" ) {			
			result.put("response" , arrayResponse );
			result.put("state", HttpStatus.OK.value());
		} else {
			result.put("message", "se ha presentado un error al generar la respuesta");
			result.put("error", "Se ha presentado un error");
		}
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

}
