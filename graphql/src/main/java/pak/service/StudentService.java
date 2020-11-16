package pak.service;

import pak.entity.Student;

public interface StudentService {

    Iterable<Student> findStudents();
    Student findStudent(Long id);
    long countStudents();

    Student saveStudent(Student student);
    void deleteStudent(Long id);

}
