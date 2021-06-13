package com.userservice.Service;

import com.userservice.Entity.User;
import com.userservice.Repository.UserRepo;
import com.userservice.UserApplication;
import com.userservice.ValueObject.Department;
import com.userservice.ValueObject.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserApplication userApplication;

    @Autowired
    private ResponseTemplateVo responseTemplateVo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public ResponseTemplateVo findByuserId(Long id) {

        User user = userRepo.findByuserId(id);
        Department department = userApplication.restTemplate().getForObject("http://localhost:8001/departments/" + user.getUserId(), Department.class);

        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;
    }
}
