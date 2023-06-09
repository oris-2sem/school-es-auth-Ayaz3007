package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.SignUpDto;
import com.example.mydiary.models.Parent;
import com.example.mydiary.models.Student;
import com.example.mydiary.models.Teacher;
import com.example.mydiary.models.User;
import com.example.mydiary.repositiries.ParentRepository;
import com.example.mydiary.repositiries.StudentRepository;
import com.example.mydiary.repositiries.TeacherRepository;
import com.example.mydiary.repositiries.UsersRepository;
import com.example.mydiary.sevices.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;

    private final ParentRepository parentRepository;

    @Override
    public void signUp(SignUpDto signUpDto) {
        if(usersRepository.findByEmail(signUpDto.getEmail()).isPresent()) {
            throw new RuntimeException("Account with " + signUpDto.getEmail() + " email is present");
        }
        if(signUpDto.getIsTeacher() == null) {
            parentRepository.save(Parent.builder()
                    .firstName(signUpDto.getFirstName())
                    .lastName(signUpDto.getLastName())
                    .build());
        } else if(signUpDto.getIsTeacher()) {
            teacherRepository.save(Teacher.builder()
                            .firstName(signUpDto.getFirstName())
                            .lastName(signUpDto.getLastName())
                    .build());
        } else {
            studentRepository.save(Student.builder()
                            .firstName(signUpDto.getFirstName())
                            .lastName(signUpDto.getLastName())
                    .build());
        }
        User user = User.builder()
                .firstName(signUpDto.getFirstName())
                .lastName(signUpDto.getLastName())
                .email(signUpDto.getEmail())
                .role(signUpDto.getIsTeacher() == null ? User.Role.PARENT :
                        signUpDto.getIsTeacher() ? User.Role.TEACHER : User.Role.STUDENT)
                .hashPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .build();
        usersRepository.save(user);
    }
}
