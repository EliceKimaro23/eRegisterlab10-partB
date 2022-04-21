package edu.mum.cs245.eregistrar.service;

import edu.mum.cs245.eregistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    public abstract Student saveStudent(Student student);
    public abstract List<Student> getAllStudents();
    public abstract Student getStudentById(Integer studentId);
    public abstract void deleteStudent(Integer studentId);
    public abstract Student updateStudent(Integer studentId, Student student);
}
