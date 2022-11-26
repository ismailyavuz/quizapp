package com.quizapp.user;

import com.quizapp.shared.entities.BaseEntity;
import com.quizapp.userquestion.UserQuestion;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    private String identifier;

    @OneToMany(mappedBy = "user")
    List<UserQuestion> questions;
}
