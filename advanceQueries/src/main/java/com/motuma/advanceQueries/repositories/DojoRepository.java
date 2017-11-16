package com.motuma.advanceQueries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motuma.advanceQueries.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
	
	//get all dojos
	@Query("SELECT d FROM Dojo d")
	List<Dojo> findAllDojo();
	
	//get all the name of the dojos
	@Query("SELECT d.name From Dojo d")
	List<Dojo> getAllDojoNames();
	
	//passing params and filter (still retrieves a list)
	@Query("SELECT d FROM Dojo d WHERE id=!1")
	Dojo getDojoWhereId(Long id);
	
	//passing params and filtering
	@Query("SELECT d FROM Dojo d WHERE id= ?1")
	Dojo getSingleDojoWhereId(Long id);
	
	@Modifying
	@Query("update Dojo d set d.name = ?1")
	int setNameFromAll(String name);
	
	
	@Modifying
	@Query("update Dojo d set d.name = ?1")
	int setNameForAll(String name);
	
	@Modifying
	@Query("update Dojo d set d.name = ?1")
	int deteteOneDojo(Long id);
	
	// inner join retrieving only the dojos
    @Query("SELECT d FROM Dojo d JOIN d.ninjas n")
    List<Dojo> joinDojosAndNinjas();
    
    // inner join retrieving dojos and ninjas
    @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
    List<Object[]> joinDojosAndNinjas2();
}
