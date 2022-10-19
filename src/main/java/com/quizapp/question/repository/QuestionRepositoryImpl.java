package com.quizapp.question.repository;

import com.quizapp.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {

    private final EntityManager em;

    @Override
    public Question getNextQuestion(String identifier, Long questionTagId, Date askAgainBeforeThisDate) {
        final String query = "select q from Question q " +
                "join q.questionTags qt " +
                "where q.enabled = true " +
                "and qt.id = :questionTagId " +
                "and q.id not in (select uq.questionId from UserQuestion uq " +
                "and uq.user.identifier = :identifier " +
                "and (uq.createdAt <= :askAgainBeforeThisDate or uq.correct = false)) ";
        return em.createQuery(query, Question.class)
                .setParameter("identifier", identifier)
                .setParameter("askAgainBeforeThisDate", askAgainBeforeThisDate)
                .setParameter("questionTagId", questionTagId)
                .setMaxResults(1)
                .getSingleResult();
    }
}
