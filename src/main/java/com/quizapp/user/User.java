package com.quizapp.user;

import com.quizapp.shared.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    private String identifier;
}
