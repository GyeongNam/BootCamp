package C17_Exception_File_Parsing.Author_Exception;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

class AuthorService {
    AuthorRepository authorRepository;

    AuthorService(){
        authorRepository = new AuthorRepository();
    }
    void register(Author author) throws IllegalArgumentException{
        // 만약에 password 5자리 이하이면 예외발생 (IllegalArgu)
        Optional <Author> authors = authorRepository.getAuthorByEmail(author.getEmail());
        if (author.getPassword().length()>=5) {
            if(authors.isPresent()){
                throw new IllegalArgumentException("이미 같은 회원이 존재합니다.");
            }else{
                authorRepository.register(author);
            }
        }else{
            throw new IllegalArgumentException("비밀번호 길이가 짧습니다.");
        }

    }
    Optional<Author> login(String email, String pwd ) throws IllegalArgumentException, NoSuchElementException {
        Optional <Author> author = authorRepository.getAuthorByEmail(email);
        if(author.isPresent()){
           if(author.get().getPassword().equals(pwd)){
               return author;
           }else{
               throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
           }
        }else{
            throw new NoSuchElementException(email+" : 이메일을 찾을 수 없습니다.");
        }
    }

}
