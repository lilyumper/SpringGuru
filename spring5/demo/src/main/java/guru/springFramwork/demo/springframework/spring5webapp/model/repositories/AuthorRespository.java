package guru.springFramwork.demo.springframework.spring5webapp.model.repositories;

import guru.springFramwork.demo.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long> {

}
