package com.example.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callGenerateUsers",
	query = "CALL GENERATE_USERS(:quantity)"
	)
})
@Entity
@Table(name = "USERS")
public class User {
		
	@Id
	private Long id;

	@Column(name= "name", length = 10, nullable = false)
	private String name;
	@Column(name = "surname", length = 10, nullable = false)
	private String surname;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
