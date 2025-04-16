package com.AnshSpringBootProjects.JournalApplication.Entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserUpdateDTO {

    @Indexed(unique = true)
    private String username;

    private String password;

}
