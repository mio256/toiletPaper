import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Seri {

    String text;
    Integer num;
    Date date;

    public void write(String str, Integer num, Date date) {
        // yyyyMMddHHmmss.binを名前にしてデータを保存

        SimpleDateFormat saveDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String saveString = saveDateFormat.format(date);

        try {
            ObjectOutputStream objOutStream =
                    new ObjectOutputStream(new FileOutputStream("data/" + saveString + ".bin"));

            Data data = new Data(str, num, date);

            objOutStream.writeObject(data);
            objOutStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(String str) {
        // 引数(ファイルのパス)からファイルを読み取り、変数に格納

        try {

            // 拡張子の指定がなければ.binに指定
            if (!str.contains(".")) {
                str = str + ".bin";
            }

            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(str));

            Data data = (Data) objInStream.readObject();
            objInStream.close();

            text = data.getText();
            num = data.getNum();
            date = data.getDate();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readText() {
        return text;
    }

    public Integer readNum() {
        return num;
    }

    public Date readDate() {
        return date;
    }
}
