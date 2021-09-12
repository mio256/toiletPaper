import java.io.Serializable;
import java.util.Date;

public class Data implements Serializable {
    String comboText;
    Integer spinnerNum;
    Date nowDate;

    Data(String str, Integer num, Date date) {
        comboText = str;
        spinnerNum = num;
        nowDate = date;
    }

    public String getText() {
        return comboText;
    }

    public Integer getNum() {
        return spinnerNum;
    }

    public Date getDate() {
        return nowDate;
    }
}
