package com.learn.quiz;

import java.util.ArrayList;

public class Question {
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;

    public Question(String question, String answer, String option1, String option2, String option3) {
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<>();
        options.add(option1);
        options.add(option2);
        options.add(option3);

        return options;
    }

    public ArrayList<String> shuffleOptions(){
        ArrayList<String> options = getOptions();
        ArrayList<String> temp = new ArrayList<>();
        int index;
        while (!options.isEmpty()){
            index = (int) (Math.random() * options.size());
            temp.add(options.get(index));
            options.remove(index);
        }
        return temp;
    }

    public String getAnwser(){
        return answer;
    }

}
