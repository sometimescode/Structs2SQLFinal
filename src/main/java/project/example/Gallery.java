package project.example;

import com.opensymphony.xwork2.ActionSupport;

public class Gallery extends ActionSupport {
    public String execute() {

        String[] sentences = {
            "This is gallery text 1.",
            "This is gallery text 2.",
            "This is gallery text 3.",
            "This is gallery text 4.",
            "This is gallery text 5."
        };
        int randomNum = (int) (Math.random() * 5);

        setSentence(sentences[randomNum]);

        return SUCCESS;
    }

    private String sentence;

    public String getSentence() {
        return sentence;
    }
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
