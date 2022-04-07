package com.haagahelia.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*issues faced:

CrudRepository could not be imported. Had to manually add things into pom.xml to get it to work
Had to add 
 <dependency>  
	<groupId>org.springframework.data</groupId>  
	<artifactId>spring-data-jpa</artifactId>  
	<version>2.2.3.RELEASE</version>  
</dependency>  

AND

<dependency>  
	<groupId>org.springframework.boot</groupId>  
	<artifactId>spring-boot-starter-data-jpa</artifactId>  
	<version>2.2.2.RELEASE</version>  
</dependency>

  From https://www.javatpoint.com/spring-boot-starter-data-jpa

 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByTitleIgnoreCase(String title);

	List<Book> findByAuthorIgnoreCase(String author);

	List<Book> findByYear(int year);

	List<Book> findByIsbnOrderByTitle(String isbn);

	List<Book> findByPriceOrderByTitle(double price);
}
