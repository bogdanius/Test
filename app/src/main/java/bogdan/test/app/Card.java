package bogdan.test.app;

import java.io.Serializable;

/**
 * Created by Bogdan on 16.07.2015.
 */
public class Card implements Serializable{
    private static final long serialVersionUID = -7060210544600464481L;
    private String value;
    private int number;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
