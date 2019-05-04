package guru.springFramwork.demo.springframework.spring5webapp.model.DevBootstrap;

import guru.springFramwork.demo.springframework.spring5webapp.model.Author;
import guru.springFramwork.demo.springframework.spring5webapp.model.Book;
import guru.springFramwork.demo.springframework.spring5webapp.model.Publisher;
import guru.springFramwork.demo.springframework.spring5webapp.model.repositories.AuthorRespository;
import guru.springFramwork.demo.springframework.spring5webapp.model.repositories.BookRepository;
import guru.springFramwork.demo.springframework.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRespository authorRespository;
    private BookRepository  bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRespository authorRespository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRespository = authorRespository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);


        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRespository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJ8", "23444", publisher);
        rod.getBooks().add(noEjb);

        authorRespository.save(rod);
        bookRepository.save(noEjb);

    }
}
