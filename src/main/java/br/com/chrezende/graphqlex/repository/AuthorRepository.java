package br.com.chrezende.graphqlex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.chrezende.graphqlex.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
