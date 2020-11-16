package pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.entity.Student;
import pak.exception.EntityNotFoundException;
import pak.repository.StudentRepo;

import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Iterable<Student> findStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student findStudent(Long id) {
        Optional<Student> studentOpt = studentRepo.findById(id);
        if (studentOpt.isPresent()) {
            return studentOpt.get();
        } else {
            throw new EntityNotFoundException("student not found", id);
        }
    }

    @Override
    public long countStudents() {
        return studentRepo.count();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

}
