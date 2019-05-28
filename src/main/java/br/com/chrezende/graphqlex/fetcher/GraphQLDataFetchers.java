package br.com.chrezende.graphqlex.fetcher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import br.com.chrezende.graphqlex.domain.Author;
import br.com.chrezende.graphqlex.domain.Book;
import br.com.chrezende.graphqlex.repository.AuthorRepository;
import br.com.chrezende.graphqlex.repository.BookRepository;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

		    
	    @Autowired
	    private BookRepository bookRepository;
	    
	    @Autowired
	    private AuthorRepository authorRepository;
	    
	    @PostConstruct
	    private void generateData() {

	    	List<Author> authorList = Arrays.asList(new Author("Zé", "Dos Anel"),new Author("Tiririca", "Da Tijuca"),new Author("Maria", "Cornélia"));
	    	authorList.forEach(c -> c = authorRepository.save(c));
	    			bookRepository.saveAll(Arrays.asList(
	    					new Book("Lord of rings", 400, authorList.get(0)),
	    					new Book("How to do Jokes", 400, authorList.get(1)),
	    					new Book("How to shot at alien", 400, authorList.get(2))
	    					));
	    }
	    
	    public DataFetcher getBookByIdDataFetcher() {
	        return dataFetchingEnvironment -> {
	            String bookId = dataFetchingEnvironment.getArgument("id");
	            return bookRepository.findById(bookId);
	        };
	    }
	    
    public DataFetcher getAllBooks() {
        return dataFetchingEnvironment -> {
        		return bookRepository.findAll();
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String,String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authorRepository.findById(authorId);
        };
    }
    
    public DataFetcher getPageCountDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String,String> book = dataFetchingEnvironment.getSource();
            return book.get("totalPages");
        };
    }
}