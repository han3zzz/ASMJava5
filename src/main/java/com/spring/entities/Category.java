package com.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idCategory")
	private Integer id ;
	@Column(name = "ten" , length = 100 , nullable = false)
	private String ten ;
	@Column(name = "trangthai")
	private Integer trangThai ;
	
	@OneToMany(mappedBy = "category" , fetch = FetchType.LAZY)
	private List<Product> product;

	
	
	
	

}
