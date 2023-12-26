package C16EtcClass;

public class C1605EnumMain {
    public static void main(String[] args) {
        EnumStudent student1 = new EnumStudent();
        student1.setName("재영");
        // 그 의미를 하나의 표현식으로 통일 하고 싶은 경우
        // student1.setClassGrade("first");
        // student1.setClassGrade("1");
        // student1.setClassGrade("First_grade");
        student1.setClassGrade("First_Grade");

        // 방법 1. class내 static 변수를 사용
        student1.setClassGrade(classGrade.class1);
            // 문제점 : 코드가 복잡해지면 까먹고 클래스 변수를 사용하지 않을 수도 있다. (컴파일이 가능하기 때문)
        EnumStudent student2 = new EnumStudent();
        // 타입 까지 체크, String으로 세팅이 불가함
        // enum타입 사용 시 static final 변수와 동일한 방법으로 사용
        student2.setRole(Role.GENERAL_USER);
        System.out.println(student2.getRole());
        System.out.println(student2.getRole().getClass());
        // enum값 내부에는 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(student2.getRole().ordinal()); // 0 출력
    }
}
class classGrade{
    static final String class1 = "First_Grade";
    static final String class2 = "Second_Grade";
    static final String class3 = "Third_Grade";
}

enum Role{
    // 각 열거형 변수(상수) , 로 구분하고 상수목록 끝에는 ;으로 마무리

    GENERAL_USER,ADMIN_USER,SUPER_USER;
}

class EnumStudent{
    private String name;
    // 소속 반
    private String classGrade;
    // String 타입 x Role 타입
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}