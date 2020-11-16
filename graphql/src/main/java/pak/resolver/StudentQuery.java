package pak.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pak.entity.Person;
import pak.entity.Student;
import pak.service.PersonService;
import pak.service.StudentService;

import java.util.Date;

@Component
public class StudentQuery implements GraphQLQueryResolver {

    private StudentService studentService;

    @Autowired
    public StudentQuery(StudentService studentService) {
        this.studentService = studentService;
    }

    public Iterable<Student> findStudents() {
        return studentService.findStudents();
    }

}
