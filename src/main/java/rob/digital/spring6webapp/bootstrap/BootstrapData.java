package rob.digital.spring6webapp.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rob.digital.spring6webapp.domain.Author;
import rob.digital.spring6webapp.domain.Book;
import rob.digital.spring6webapp.domain.Publisher;
import rob.digital.spring6webapp.repositories.AuthorRepository;
import rob.digital.spring6webapp.repositories.BookRepository;
import rob.digital.spring6webapp.repositories.PublisherRepository;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        var danAuthor = Author.builder().firstName("Dan").lastName("Simons").build();
        var stephenAuthor = Author.builder().firstName("Stephen").lastName("King").build();

        var bookHyperion = Book.builder().title("Hyperion").isbn("234234").build();
        var bookInstitute = Book.builder().title("Institute").isbn("65643344").build();

        var publisher = Publisher.builder().name("Super Publisher").build();

//        danAuthor.getBooks().add(bookHyperion);
//        stephenAuthor.getBooks().add(bookInstitute);
//        bookHyperion.getAuthors().add(danAuthor);
//        bookInstitute.getAuthors().add(stephenAuthor);


        var savedDanAuthor = authorRepository.save(danAuthor);
        var savedStephenAuthor = authorRepository.save(stephenAuthor);

        var savedBookHyperion = bookRepository.save(bookHyperion);
        var savedBookInstitute = bookRepository.save(bookInstitute);

        var savedPublisher = publisherRepository.save(publisher);

        savedBookHyperion.setPublisher(savedPublisher);
        savedBookInstitute.setPublisher(savedPublisher);

        // !!! this builds association between entities, between Author and Books
        // add @Builder.Default to the property of the class (domain or model) that is using Set => "Set<Book> books = new HashSet<>()"
        // if you're using builder
        savedDanAuthor.getBooks().add(savedBookHyperion);
        savedStephenAuthor.getBooks().add(savedBookInstitute);
        savedBookHyperion.getAuthors().add(savedDanAuthor);
        savedBookInstitute.getAuthors().add(savedStephenAuthor);

//        savedPublisher.getBooks().add(savedBookInstitute);
//        savedPublisher.getBooks().add(savedBookHyperion);

        authorRepository.save(savedDanAuthor);
        authorRepository.save(savedStephenAuthor);
        bookRepository.save(savedBookHyperion);
        bookRepository.save(savedBookInstitute);


        System.out.println("===== Inside of Bootstrap =======");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher has published => " + bookRepository.count() + " books");


//        System.out.println(savedDanAuthor.toString());
        System.out.println("Publisher name is -> " + savedPublisher);


    }
}
