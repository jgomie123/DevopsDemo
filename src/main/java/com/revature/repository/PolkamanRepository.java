package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Polkaman;

/*Usually when you build a spring boot project, you use a module called Spring Data JPA. This is a module that can 
 * abstract away the repository implementations 
 * 
 * SPring data jpa is able to provide these implementations at runtime - All I have to do is provide interfaces that
 * extend either JpaRepository or the CrudRepository
 * JPA: Java Persistence API - what we used yesterday that allowed us to map our model to our table
 * */

//@Repository
public interface PolkamanRepository extends JpaRepository<Polkaman, Integer> {
	//when extending JpaRepository, you must pass in generics: the first is your entity type, and the next is 
	//the type of the entity's unique identifier (primary key)
	List<Polkaman> findAll();
	<S extends Polkaman> S save(Polkaman polkaman);
	//The return type of the save method is a child type of your entity - the reason being that the entity manager
	//creates a subtype of your entity (in this case, Polkaman), and uses that subtype as a proxy
	void deleteById(int id);
	Polkaman findById(int id);
}

