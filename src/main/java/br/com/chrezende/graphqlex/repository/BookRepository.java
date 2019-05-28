package br.com.chrezende.graphqlex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.chrezende.graphqlex.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}
