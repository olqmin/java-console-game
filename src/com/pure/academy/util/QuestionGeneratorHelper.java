package com.pure.academy.util;

import model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionGeneratorHelper {

    private static List<QuestionModel> questionsList = new ArrayList();

    public static List<QuestionModel> getThreeRandomQuestions() {
        if(questionsList.isEmpty()) {
            prepareData();
        }
           
           List<QuestionModel> shuffeledList = ShuffelHelper.newShuffledList(questionsList);
           
           
           return shuffeledList.subList(0, 8);
    }

    static void prepareData() {
        QuestionModel firstQ = new QuestionModel();
        firstQ.setActualQuestion(
                "What does the strings[1] contain after executing the following code?\n"
                        + "char[] chars = { 'H', 'Y', 'P', 'E', 'R','-','S','K','I','L','L' };\n"
                        + "String stringFromChars  = String.valueOf(chars);\n"
                        + "String[] strings = stringFromChars.split(\"-\")\n");

        firstQ.addAnswer("SKILL", true);
        firstQ.addAnswer("H", false);
        firstQ.addAnswer("HYPER", false);
        firstQ.addAnswer("-", false);
        questionsList.add(firstQ);

        QuestionModel secondQ = new QuestionModel();
        secondQ.setActualQuestion(
                "Which method must be invoked to get the actual number of characters of a string?\n");

        secondQ.addAnswer("capacity", false);
        secondQ.addAnswer("size", false);
        secondQ.addAnswer("charAt", false);
        secondQ.addAnswer("length", true);
        questionsList.add(secondQ);

        QuestionModel thirdQ = new QuestionModel();
        thirdQ.setActualQuestion(
                "What exception does the following code throw?\n"
                + "String s = null;\n"
                + "s.replace(\"a\", “b\");\n");

        thirdQ.addAnswer("NumberFormatException", false);
        thirdQ.addAnswer("NullPointerException", true);
        thirdQ.addAnswer("StringFormatException", false);
        thirdQ.addAnswer("NullReferenceException", false);
        questionsList.add(thirdQ);

        QuestionModel fourthQ = new QuestionModel();
        fourthQ.setActualQuestion(
                "What is the return type of a method that does not return a value?\n"
                      );

        fourthQ.addAnswer("null", false);
        fourthQ.addAnswer("none", false);
        fourthQ.addAnswer("void", true);
        fourthQ.addAnswer("nothing", false);
        questionsList.add(fourthQ);

        QuestionModel fifthQ = new QuestionModel();
        fifthQ.setActualQuestion(
                "You're given a method with the following declaration: public int getAddress().\n"
                        + "There is also an already created instance john of the same class where this method is located.\n"
                        + "How can you call this method?\n"
        );

        fifthQ.addAnswer("getAddress(john)", false);
        fifthQ.addAnswer("john.getAddress()", true);
        fifthQ.addAnswer("return john.getAddress()", false);
        fifthQ.addAnswer("john.valueOf(getAddress()", false);
        questionsList.add(fifthQ);

        QuestionModel sixthQ = new QuestionModel();
        sixthQ.setActualQuestion(
                "There is an array of ints named numbers.\n"
                        + "How to get the last element of this array?\n"
        );

        sixthQ.addAnswer("numbers[100_000_000]", false);
        sixthQ.addAnswer("numbers[numbers.lenght + 1]", false);
        sixthQ.addAnswer("numbers[numbers.lenght - 1]", true);
        sixthQ.addAnswer("numbers[numbers.lenght] ", false);
        questionsList.add(sixthQ);

        QuestionModel seventhQ = new QuestionModel();
        seventhQ.setActualQuestion(
                "Here's an ArrayList called list with the following elements:\n"
                        + "[ArrayList,is,a,resized,array]\n"
                        + "Select the contents of the resulting list after executing the following code:\n"
                        + "list.remove(1);\n"
                        + "list.remove(\"a\");\n"
                        + "list.remove(2);\n"
        );

        seventhQ.addAnswer("[is, resized]", false);
        seventhQ.addAnswer("[ArrayList, resized]", true);
        seventhQ.addAnswer("[is, array]", false);
        seventhQ.addAnswer("[is, a, array] ", false);
        questionsList.add(seventhQ);

        QuestionModel eightQ = new QuestionModel();
        eightQ.setActualQuestion(
                "What does this code print?\n"
                        + "int[][] c = {\n"
                        + "   { 40, 30, 25, 30, 15 },\n"
                        + "   { 13, 12, 16 },\n"
                        + "   { 101, 125, 114, 131 }\n"
                        + "}\n"
                        + "System.out.print(c.length + \" \");\n"
                        + "for (int[] nestedArray : c) {\n"
                        + "   System.out.print(nestedArray.length + \" \");\n"
                        + "}\n"
        );

        eightQ.addAnswer("3 3 5 4", false);
        eightQ.addAnswer("5 3 4 3", false);
        eightQ.addAnswer("3 5 4 3", false);
        eightQ.addAnswer("3 5 3 4", true);
        questionsList.add(eightQ);

    }

}
