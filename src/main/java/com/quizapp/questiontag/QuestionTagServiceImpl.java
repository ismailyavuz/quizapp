package com.quizapp.questiontag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class   QuestionTagServiceImpl implements QuestionTagService {

    private final QuestionTagRepository questionTagRepository;

    @Override
    public List<QuestionTagDto> getQuestionTags() {
        List<QuestionTag> questionTags = questionTagRepository.findAll();
        return questionTags.stream().map(qt -> new QuestionTagDto(qt.getId(), qt.getName())).collect(Collectors.toList());
    }

    @Override
    public QuestionTagDto createQuestionTag(CreateQuestionTagRequest request) {
        QuestionTag questionTag = new QuestionTag();
        questionTag.setName(request.getName());
        questionTag = questionTagRepository.save(questionTag);
        return new QuestionTagDto(questionTag.getId(), questionTag.getName());
    }
}
