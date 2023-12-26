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
}
