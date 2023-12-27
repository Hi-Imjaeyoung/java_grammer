package C18Thread;

public class C18RunnableImplementsClass implements Runnable{

    @Override
    public void run() {
        System.out.println("C18RunnableImplementsClass : "+Thread.currentThread().getName());
    }
}
