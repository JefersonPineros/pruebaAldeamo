package com.mainsoft.prueba.aldeamo.aldeamoProyect.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ADMIN
 *
 */
@Entity
@Table(name = "arrays")
public class ArraysEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;
	
	@Column( name = "input_array" )
	private String InputArray;
	
	

	public ArraysEntity() {
		super();
	}

	public ArraysEntity(Integer id, String inputArray) {
		super();
		this.id = id;
		InputArray = inputArray;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInputArray() {
		return InputArray;
	}

	public void setInputArray(String inputArray) {
		InputArray = inputArray;
	}

	
}
