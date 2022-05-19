package project.example;

import com.opensymphony.xwork2.ActionSupport;

public class About extends ActionSupport {
    public String execute() {

        String[] sentences = {
            "This is about me text 1.",
            "This is about me text 2.",
            "This is about me text 3.",
            "This is about me text 4.",
            "This is about me text 5."
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
