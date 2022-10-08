package com.quizapp.user;

import com.quizapp.shared.entities.BaseEntity;
import com.quizapp.userquestion.UserQuestion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
