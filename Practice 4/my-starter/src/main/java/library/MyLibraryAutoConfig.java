package library;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyLibraryAutoConfig {
    @Bean
    public MyLibraryClass myLibraryClass(){
        return new MyLibraryClass();
    }
    @Bean
    @ConditionalOnProperty(name="secret", havingValue = "true")
    public String secret(){
        return "super secret";
    }
}
