package bstrom.akimts.demoRestSpring;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoRestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestSpringApplication.class, args);
	}

}
