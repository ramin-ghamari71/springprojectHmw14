package com.ramin.model.student.service;

import com.ramin.model.exception.AuthException;
import com.ramin.model.student.Student;
import com.ramin.model.student.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) throws Exception {
        checkForDuplicateCode(student);
        validation(student);
        this.studentRepository.save(student);
    }

    public List<Student> readAllStudents() {
        return this.studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return this.studentRepository.findById(id);
    }

    public Long checkIfExist(Student student) {
        return this.studentRepository.ifExistWithCode(student.getStudentId());
    }

    public void update(Student student) throws Exception {
//        checkForDuplicateCode(student);
        validation(student);
        this.studentRepository.save(student);
    }

    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }

    private void checkForDuplicateCode(Student student) throws Exception {
        Long count = checkIfExist(student);
        if (count != 0) throw new Exception("this Student ID is taken, try another");
    }

    private void validation(Student student) throws Exception {
        if (student.equals(null)) throw new Exception("Fill the fields");
        if (student.getName().length() < 3 || student.getName().length() > 50
                || student.getLastName().length()
                < 3 || student.getLastName().length() > 50)
            throw new Exception(" Name and Last Name should be between 3-50 characters ");
        checkName(student);

    }

    private void checkName(Student student) throws Exception {
        char[] nameChar = student.getName().toCharArray();
        char[] lastNameChar = student.getLastName().toCharArray();
        for (char c : nameChar) {
            if(!Character.isLetter(c)) {
                throw new Exception(" Name should be A-Z and a-z");
            }
        }
        for (char c : lastNameChar) {
            if(!Character.isLetter(c)) {
                throw new Exception(" Last Name should be A-Z and a-z");
            }
        }

    }
}
