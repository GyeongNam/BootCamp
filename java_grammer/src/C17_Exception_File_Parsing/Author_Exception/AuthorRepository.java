package C17_Exception_File_Parsing.Author_Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AuthorRepository {
    List<Author> authors;
    AuthorRepository(){
        authors = new ArrayList<>();
    }
    public void register(Author author) {
        authors.add(author);
    }

    Optional<Author> getAuthorByEmail(String email){
        for(Author author:this.authors){
            if(author.getEmail().equals(email)){
                return Optional.of(author);
            }
        }
        return Optional.empty();
    }
}
