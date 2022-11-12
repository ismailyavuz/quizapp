package com.quizapp.question.repository;

import com.quizapp.userquestion.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionRepository extends JpaRepository<UserQuestion, Long> {
}
