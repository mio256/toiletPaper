import javax.swing.*;

class Main {
    // 生徒用ソフトウェア

    public static final String[] toiletComboData =
            {"toilet1", "toilet2", "toilet3", "toilet4", "toilet5"};

    public static final String topLabelStr = "トイレットペーパーを大切に使いましょう。";

    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 閉じるボタンで終了
        frame.setBounds(600, 100, 1080 / 3, 1920 / 3); // X位置 Y位置 X幅 Y幅
        frame.setTitle("toiletPaper"); // タイトル
        frame.setVisible(true); // 可視化
    }
}
