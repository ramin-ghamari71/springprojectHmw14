package com.ramin.controller.student;

import com.ramin.model.exception.AuthException;
import com.ramin.model.student.Student;
import com.ramin.model.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "/show-form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form-student";
    }

    @RequestMapping(path = "/add-student")
    public String addNewStudent(@ModelAttribute("student") Student std) {
        try {
            studentService.save(std);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthException(new Date(), e.getMessage());
        }
        return "redirect:/app/student/show-form";
    }

    @RequestMapping(path = "/list")
    public String list(Model model) {
        model.addAttribute("studentList", studentService.readAllStudents());
        return "list-student";
    }

    @RequestMapping(path = "/delete-student/{id}")
    public String DeleteById(@PathVariable Long id) {
        studentService.deleteById( id);
        return "redirect:/app/student/list";
    }

    @RequestMapping(value = "/edit-student/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Student> std = studentService.findById(id);
        return new ModelAndView("edit-student", "EditStudent", std);
    }

    @RequestMapping(value = "/edit-save", method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("emp") Student student) {
        try {
            studentService.update(student);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthException(new Date(), e.getMessage());
        }
        return new ModelAndView("redirect:/app/student/list");
    }

}


//https://www.javatpoint.com/spring-mvc-crud-example