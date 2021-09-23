import javax.swing.*;

class Student {
    // 生徒用ソフトウェア

    public static final String[] toiletComboData =
            {"111男", "121男", "131男", "141女",
             "211男","221女","231男","241男","242女","251男",
             "311来客男","312女","312職女","321男","322職男","331男","332女",
             "411男","412女","421男","422男","女子更衣室","431男","432男","441男","442男",
             "体育館男","体育館女","部室横男","部室横女","第2グ男","第2グ女"};

    public static final String topLabelStr = "トイレットペーパーを大切に使いましょう。";

    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 閉じるボタンで終了
        frame.setBounds(600, 100, 1080 / 3, 1920 / 3); // X位置 Y位置 X幅 Y幅
        frame.setTitle("toiletPaper"); // タイトル
        frame.setVisible(true); // 可視化
    }
}
