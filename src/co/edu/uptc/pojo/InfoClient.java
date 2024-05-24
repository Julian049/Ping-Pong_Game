package co.edu.uptc.pojo;

import java.io.Serializable;

public class InfoClient implements Serializable {
    private char code;

    public InfoClient(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }
}
