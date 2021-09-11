import javax.swing.*;

class Main {
    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 閉じるボタンで終了
        frame.setBounds(600, 100, 1080 / 3, 1920 / 3);// X位置 Y位置 X幅 Y幅
        frame.setTitle("toiletPaper");
        frame.setVisible(true);
    }
}