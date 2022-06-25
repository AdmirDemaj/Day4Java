package com.web.springboot.demo.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name ="users")
public class User extends Base{
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;


}


