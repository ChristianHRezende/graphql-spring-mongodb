package br.com.chrezende.graphqlex.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.chrezende.graphqlex.domain.Author;
import br.com.chrezende.graphqlex.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>{
}
