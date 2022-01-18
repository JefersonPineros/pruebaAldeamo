package com.mainsoft.prueba.aldeamo.aldeamoProyect.services.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainsoft.prueba.aldeamo.aldeamoProyect.dao.IArraysRepository;
import com.mainsoft.prueba.aldeamo.aldeamoProyect.entity.ArraysEntity;
import com.mainsoft.prueba.aldeamo.aldeamoProyect.services.IArraysService;

@Service
public class ArraysServiceImpl implements IArraysService {
	
	@Autowired
	private IArraysRepository arraysRepository;

	@Override
	public String valideArray(Integer q, Integer id) {
		ArraysEntity arrayObject = this.arraysRepository.findById(id).orElse(null);
		
		String[] arrayInitial;
		
		String response = ""; 
		
		
		List<String> listInitial = new ArrayList<String>();
		List<String> finalArray = new ArrayList<String>();
		List<String> listNew = new ArrayList<String>();
		List<String> listNew2 = new ArrayList<String>();
		boolean allPrimos = false; 
		if (arrayObject != null) {
			arrayInitial = arrayObject.getInputArray().split(",");
			listInitial = Arrays.asList(arrayInitial);
			
			for (Integer i = 0; i < q; i++ ) {
				Integer newlength  = listNew.size();
				Integer lastLength = newlength;
				if ( !allPrimos ) {
					Integer initialLength = listInitial.size();
					while ( initialLength > 0 ) {
						if ( !this.esPrimo( Integer.parseInt( listInitial.get( initialLength ) ) ) ) {
							finalArray.add( listInitial.get( initialLength ) );
						} else {
							listNew.add( listInitial.get( initialLength ) );
						}
						initialLength = initialLength - 1;
					}
					allPrimos = true;
				} else {
					while ( newlength > 0 ) {
						if ( newlength == lastLength) {
							finalArray.add( listNew.get( newlength ));
						} else {
							listNew2.add( listNew.get( newlength ) );
						}
						newlength = newlength - 1;
					}
					listNew = listNew2;
				}
				
			}
		}
		for ( int i = 0; i < finalArray.size(); i++ ) {
			if ( ( i + 1 ) < finalArray.size() ) {
				response = response + finalArray.get( i + 1 ) + ","; 
			} else {
				response = response.concat( finalArray.get( i + 1 ) );
			}
		}
		return response;
	}

	public boolean esPrimo(Integer  num) {
		Integer contador = 0;
		 
        for( Integer I = 1; I <= num; I++)
        {
            if((num % I) == 0)
            {
                contador++;
            }
        }
        
        if (contador <= 2) {
        	return true;
        } else {
        	return false;
        }
	}

}
