package C17ExceptionFileParseing.AuthorException;

class Author{

    private static long staticId=0L;
    private long id;
    private String name, email,passwd;

    Author(String name,String email,String passwd){
        staticId++;
        id = staticId;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
    }

    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPasswd() {
        return passwd;
    }
}
