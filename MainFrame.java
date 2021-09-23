import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class MainFrame extends JFrame implements ActionListener {

    JLabel endLabel;
    JComboBox<String> toiletCombo;
    SpinnerNumberModel numSpinner;

    MainFrame() {
        // アイコン設定
        ImageIcon icon = new ImageIcon("./icon.png");
        setIconImage(icon.getImage());

        // トップ ラベル
        JPanel topLabelPanel = new JPanel();
        JLabel topLabel = new JLabel(Student.topLabelStr);
        topLabelPanel.add(topLabel);

        // トイレの場所 コンボ
        JPanel toiletComboPanel = new JPanel();
        toiletCombo = new JComboBox<>(Student.toiletComboData);
        toiletCombo.setPreferredSize(new Dimension(200, 50));
        toiletCombo.setMaximumRowCount(15);
        toiletComboPanel.add(toiletCombo);

        // トイレットペーパー数 スピナー
        JPanel numSpinnerPanel = new JPanel();
        numSpinner = new SpinnerNumberModel(1, 1, 255, 1); // 初期値,最小値,最大値,増分
        JSpinner numJSpinner = new JSpinner(numSpinner);
        JSpinner.NumberEditor numberEditor = new JSpinner.NumberEditor(numJSpinner, "#,##0");
        numJSpinner.setEditor(numberEditor);
        numJSpinner.setPreferredSize(new Dimension(150, 25));
        numSpinnerPanel.add(numJSpinner);

        // 決定 ボタン
        JPanel enterButtonPanel = new JPanel();
        JButton enterButton = new JButton("OK");
        enterButton.addActionListener(this); // Action
        enterButtonPanel.add(enterButton);

        // 記録確認 ラベル
        JPanel endLabelPanel = new JPanel();
        endLabel = new JLabel();
        endLabelPanel.add(endLabel);

        // ペイン
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));// 縦一列に並べる
        Container contentPane = getContentPane();
        contentPane.add(topLabelPanel, BorderLayout.CENTER);
        contentPane.add(toiletComboPanel, BorderLayout.CENTER);
        contentPane.add(numSpinnerPanel, BorderLayout.CENTER);
        contentPane.add(enterButtonPanel, BorderLayout.CENTER);
        contentPane.add(endLabelPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) { // Action
        String cmd = e.getActionCommand();
        System.out.println(cmd);

        if (cmd.equals("OK")) { // enterButton			         
            cmdEnterButton();
        }
    }

    public void cmdEnterButton() {
        String comboText = (String) toiletCombo.getSelectedItem();
        Integer spinnerNum = (Integer) numSpinner.getValue();
        Date nowDate = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String showDate = DateFormat.format(nowDate);

        // 記録確認表示
        endLabel.setText(comboText + "/" + spinnerNum + "/" + showDate);

        // データ記録
        Seri save = new Seri();
        save.write(comboText, spinnerNum, nowDate);
    }
}
