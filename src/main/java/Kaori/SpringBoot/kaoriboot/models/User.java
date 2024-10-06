package Kaori.SpringBoot.kaoriboot.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotEmpty(message = "Username should not be empty")
    private String username;
    @Column
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @Column
    @Min(value = 0, message = "Age should be greater than 0")
    private Integer age;
}




