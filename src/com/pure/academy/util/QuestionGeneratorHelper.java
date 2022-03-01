package com.pure.academy.util;

import com.pure.academy.model.QuestionModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class QuestionGeneratorHelper {

    private static List<QuestionModel> questionsList = new ArrayList();

    public static List<QuestionModel> getThreeRandomQuestions() {
           prepareData();
           
           List<QuestionModel> shuffeledList = ShuffelHelper.newShuffledList(questionsList);
           
           
           return shuffeledList.subList(0, 2);
    }

    static void prepareData() {
        QuestionModel firstQ = new QuestionModel();
        firstQ.setActualQuestion(
                "\n1. What does the strings[1] contain after executing the following code?\n"
                        + "char[] chars = { 'H', 'Y', 'P', 'E', 'R','-','S','K','I','L','L' };\n"
                        + "String stringFromChars  = String.valueOf(chars);\n"
                        + "String[] strings = stringFromChars.split(\"-\")"
        );
        firstQ.addAnswer("SKILL", true);
        firstQ.addAnswer("H", false);
        firstQ.addAnswer("HYPER", false);
        firstQ.addAnswer("-", false);
        questionsList.add(firstQ);

        QuestionModel secondQ = new QuestionModel();
        secondQ.setActualQuestion(
                "\n2. Which method must be invoked to get the actual number of characters of a string?\n"
        );
        secondQ.addAnswer("capacity", false);
        secondQ.addAnswer("size", false);
        secondQ.addAnswer("charAt", false);
        secondQ.addAnswer("length", true);
        questionsList.add(secondQ);
        
    }


}
