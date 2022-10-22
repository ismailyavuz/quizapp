package com.quizapp.questiontag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionTagServiceImpl implements QuestionTagService {

    private final QuestionTagRepository questionTagRepository;

    @Override
    public List<QuestionTagResponse> getQuestionTags() {
        List<QuestionTag> questionTag = questionTagRepository.findAll();
        return questionTag.stream().map(qt -> new QuestionTagResponse(qt.getId(), qt.getName())).collect(Collectors.toList());
    }
}
