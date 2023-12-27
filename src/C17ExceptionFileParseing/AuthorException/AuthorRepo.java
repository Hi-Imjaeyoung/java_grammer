package C17ExceptionFileParseing.AuthorException;

import java.util.*;

class AuthorRepo {
    List<Author> authors;
    AuthorRepo(){
        authors = new LinkedList<>();
    }
    void register(Author author){
        authors.add(author);
    }
    List<Author> getAuthors(){
        return authors;
    }
    //TODO 여기서는 Optional 객체 사용이 적절함
    Optional<Author> getAuthorByEmail(String email){
        for(Author a : authors){
            if(a.getEmail().equals(email)){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}
