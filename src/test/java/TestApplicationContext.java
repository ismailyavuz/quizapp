import com.quizapp.Main;
import com.quizapp.question.Question;
import com.quizapp.question.model.enums.LangCodeEnum;
import com.quizapp.question.repository.QuestionRepository;
import com.quizapp.question.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Main.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class TestApplicationContext {

    @SpyBean
    QuestionRepository questionRepository;

    @Autowired
    QuestionServiceImpl questionService;

    @BeforeEach
    void arrangeDB() {
        questionRepository.deleteAll();
    }

    @Test
    void isApplicationContextLoading() {
        Assertions.assertTrue(true);
    }

    @Test
    void success_get_question_by_id() {
        Question question = new Question();
        question.setId(1L);
        question.setQuestionText("Some question");
        question.setLangCode(LangCodeEnum.EN);
        Mockito.when(questionRepository.findById(5L))
                .thenReturn(
                        java.util.Optional.of(question));

        Question question1 = questionService.findById(5L);

        Mockito.verify(questionRepository).findById(5L);

        Assertions.assertEquals(question1.getQuestionText(), "Some question");
        Assertions.assertEquals(question1.getLangCode(), LangCodeEnum.EN);

//        Question question =
//                questionRepository
//                        .getNextQuestion("İsmail Yavuz", 1l,
//                                new Date());
//        Assertions.assertNotNull(question);
    }

    @Test
    void fail_question_not_found() {
        Mockito.when(questionRepository.findById(6L))
                .thenReturn(
                        Optional.empty());

        Question question1 = questionService.findById(6L);

        Assertions.assertNull(question1);

    }

    @Test
    void createQuestion() {
        Question question = new Question();
        questionRepository
                .save(question);
        Assertions.assertNotNull(question.getId());
    }

}
