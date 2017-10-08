package info.trongdat.practice2;

/**
 * Created by Alone on 10/28/2016.
 */

public class Question {
    String question;
    String[] answer;
    String result;

    public Question(String question, String[] answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
