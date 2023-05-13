package com.admoney.admoneyadmanagementservice.DTOS;

import com.admoney.admoneyadmanagementservice.Models.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionnaireResponceDTO {
    private List<Question> questionnaire;
    private ResponseDTO responseDTO;
}
