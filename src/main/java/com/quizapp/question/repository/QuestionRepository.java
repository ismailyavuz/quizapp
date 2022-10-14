package com.quizapp.question.repository;

import com.quizapp.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "select q from question q " +
            "inner join question_tag qt on q.question_tag_id = qt.id " +
            "left join user_question us on us.question_id = q.id " +
            "where q.enabled = true " +
            "and us.user_id = :userId " +
            "and (us.createdAt <= current_date - '7 day'::interval and us.correct = false) " +
            "and qt.id = questionTagId ", nativeQuery = true)
    Question getQuestionByQuestionTag(@Param("userId") Long userId,
                                      @Param("questionTagId") Long questionTagId);

}
