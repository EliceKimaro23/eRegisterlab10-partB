package edu.mum.cs245.eregistrar.service.imp;

import edu.mum.cs245.eregistrar.model.Student;
import edu.mum.cs245.eregistrar.repository.StudentRepository;
import edu.mum.cs245.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
     @Autowired
    public StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        studentRepository.findById(student.getStudentId()).orElse(null);
        return  studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            return studentRepository.save(student);
        }
        return student;
    }
}
