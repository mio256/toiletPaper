import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Seri {
    public void write(String str, Integer num, Date date) {
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
        try {
            if (!str.contains(".")) {
                str = str + ".bin";
            }

            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(str));

            Data data = (Data) objInStream.readObject();
            objInStream.close();

            System.out.println(data.getText());
            System.out.println(data.getNum());
            System.out.println(data.getDate());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readText(String str) {
        try {
            if (!str.contains(".")) {
                str = str + ".bin";
            }

            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(str));

            Data data = (Data) objInStream.readObject();
            objInStream.close();

            return data.getText();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer readNum(String str) {
        try {
            if (!str.contains(".")) {
                str = str + ".bin";
            }

            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(str));

            Data data = (Data) objInStream.readObject();
            objInStream.close();

            return data.getNum();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date readDate(String str) {
        try {
            if (!str.contains(".")) {
                str = str + ".bin";
            }

            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(str));

            Data data = (Data) objInStream.readObject();
            objInStream.close();

            return data.getDate();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
