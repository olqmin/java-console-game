package com.pure.academy.util;

import com.pure.academy.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionGeneratorHelper {

    private static List<QuestionModel> questionsList = new ArrayList();

    public static QuestionModel getRandomQuestion() {
           prepareData();
           return questionsList.get(0);
    }

    static void prepareData() {
        QuestionModel firstQ = new QuestionModel();
        firstQ.setActualQuestion(
                "\n1. What doest the strings[1] contain after executing the following code?\n"
                        + "char[] chars = { 'H', 'Y', 'P', 'E', 'R','-','S','K','I','L','L'};\n"
                        + "String stringFromChars  = String.valueOf(chars);\n"
                        + "String[] strings = stringFromChars.split(\"-\")"
        );
        firstQ.addAnswer("SKILL", true);
        firstQ.addAnswer("H", false);
        firstQ.addAnswer("HYPER", false);
        firstQ.addAnswer("-", false);
        questionsList.add(firstQ);

    }


}
