package guru.springFramwork.demo.springframework.spring5webapp.model.repositories;

import guru.springFramwork.demo.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
