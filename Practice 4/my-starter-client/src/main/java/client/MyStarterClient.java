package client;
import library.MyLibraryClass;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyStarterClient {
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(MyStarterClient.class,args);
        MyLibraryClass myLibraryByClass = applicationContext.getBean(MyLibraryClass.class);
        myLibraryByClass.printInfo();
        try{
            System.out.println(applicationContext.getBean(String.class));
        }catch (NoSuchBeanDefinitionException e){
            System.out.println("missing secret in application.properties or it is not set to true");
        }
    }
}
