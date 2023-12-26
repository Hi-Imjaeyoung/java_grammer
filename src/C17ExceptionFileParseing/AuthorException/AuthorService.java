package C17ExceptionFileParseing.AuthorException;

import java.util.*;

class AuthorService {
    AuthorRepo authorRepo;
    AuthorService(){
        authorRepo = new AuthorRepo();
    }

    void register(Author author) throws IllegalArgumentException{
        // 이름과 email이 null이면 예외를 던지자
        if(author.getName().isEmpty()){
            throw new NoSuchElementException("이름이 없다고요??");
        }
        if(author.getEmail().isEmpty()){
            throw new NoSuchElementException("이메일이 없다고요??");
        }
        // 만약에 passwd가 5자리 이하이면 예외 발생(illegalArgument)
        if(author.getPasswd().length()<=5){
            throw new IllegalArgumentException("비밀번호를 6자리 이상으로 설정해주세요");
        }
        try {
            DuplicationCheck(author.getEmail(), author.getName());
        }catch (IllegalArgumentException e){
            throw e;
        }
        authorRepo.register(author);
    }

    Optional<Author> logIn(String email, String passWd) throws IllegalArgumentException, NoSuchElementException{
        List<Author> authorList = authorRepo.getAuthors(); // -> 하나의 author 객체만 return 하는 메서드로
        Optional<Author> author1 = Optional.empty();
        for(Author author : authorList){
            if(author.getEmail().equals(email)){
                if(author.getPasswd().equals(passWd)){
                    author1 = Optional.ofNullable(author);
                }else{
                    // passWd가 틀리면 예외 발생(illegalArgument)
                    throw new IllegalArgumentException("비밀번호가 틀립니다");
                }
            }
        }
        // 이메일이 존재하지 않으면 예외 발생(NosuchElement)
        if(!author1.isPresent()){
            throw new NoSuchElementException("해당 이메일은 존재하지 않습니다");
        }
        return author1;
    }
    void DuplicationCheck(String name, String email) throws IllegalArgumentException{
        for(Author author : authorRepo.getAuthors()){
            if(author.getEmail().equals(email)){
                throw new IllegalArgumentException("이미 가입된 이메일입니다");
            }
            if (author.getName().equals(name)){
                throw new IllegalArgumentException("이미 가입된 이름입니다");
            }
        }
    }
    Optional<Author> findPassWd(String name){
        Optional<Author> targetAuthor = Optional.empty();
        for(Author author:authorRepo.authors){
            if(author.getName().equals(name)){
                targetAuthor = Optional.ofNullable(author);
            }
        }
        if(!targetAuthor.isPresent()){
            throw new NoSuchElementException("해당 이름으로 가입된 정보를 찾을 수없습니다.");
        }
        return targetAuthor;
    }
    public void upgrade(Author author){

    }
}
