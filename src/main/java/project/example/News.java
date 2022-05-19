package project.example;

import com.opensymphony.xwork2.ActionSupport;

public class News extends ActionSupport {
    public String execute() {

        String[] sentences = {
            "This is update text 1.",
            "This is update text 2.",
            "This is update text 3.",
            "This is update text 4.",
            "This is update text 5."
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
