package C12ClassLecture;

import java.util.function.Predicate;

public class C1203ClassLecture {
    public static void main(String[] args) {
        Person p1 = new Person();
//        변수 값에 직접 접근하여 값을 할당하는 방식
//        p1.passwd = 123;
//        p1.name ="재영";
//        p1.email ="imjy@naver.com";
//        p1.age = 300;
//        Person.personCount++;
//        p1.whoIs();
        p1.setAge(1);
        p1.setEmail("hi");
        p1.setName("김수한무거북이와두루미삼천갑자동방삭어쩌구");

        Person p2 = new Person();
//        변수 값에 직접 접근하여 값을 할당하는 방식
//        p2.passwd = 123;
//        p2.name ="투재영";
//        p2.email ="imjy@naver.com";
//        p2.age = 2300;
//        Person.personCount++;
//        p2.whoIs();

    }
}
//Person 클래스를 만들고
//매개 변수 : name email passwd age
//객체 매서드 : whoIs name email passwd age 입니다 출력
//객체 생성후 whoIs 메서드 호출
class Person{
    //private은 같은 클래스 내에서 접근이 가능게 함.
    private String name , email;
    private int passwd, age;
    public  void whoIs(){
        System.out.println("이름 :" +this.name +" email : "+this.email +" passwd : "+ this.passwd +" age : "+this.age);
    }
    // setter getter pattern

    // @가 없으면 안됌
    public void setEmail(String email) {
        if(!email.contains("@")) {
            System.out.println("이메일 형식이 틀렸습니다");
        }else{
            this.email = email;
        }
    }

    public void setPasswd(int passwd) {
        this.passwd = passwd;
    }
    // 나이는 20세 이상
    public void setAge(int age) {
        if(age<=20) {
            System.out.println("잼민이는 안됩니다");
        }else{
            this.age = age;
        }
    }

    // 이름은 10글자 이하만 가능
    public void setName(String name){
        if(name.length()>10){
            System.out.println("이름이 너무 길어요");
        }else{
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPasswd() {
        return passwd;
    }

    public int getAge() {
        return age;
    }
}
