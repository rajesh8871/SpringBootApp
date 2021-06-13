package com.userservice.ValueObject;

import com.userservice.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ResponseTemplateVo {

    private User user;
    private Department department;
}
