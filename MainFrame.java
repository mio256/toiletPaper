import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    JLabel endlabel;
    JComboBox combo;
    SpinnerNumberModel model;

    MainFrame() {
        // アイコン設定
        ImageIcon icon = new ImageIcon("./icon.png");
        setIconImage(icon.getImage());

        // PAGE_
        // ラベル
        JLabel startlabel = new JLabel();
        JPanel startPanel = new JPanel();
        startPanel.add(startlabel);

        // CENTER
        JPanel centerPanel = new JPanel();
        // コンボボックス
        String[] combodata = { "toilet1", "toilet2", "toilet3", "toilet4", "toilet5" };
        combo = new JComboBox(combodata);
        combo.setPreferredSize(new Dimension(200, 50));
        combo.setMaximumRowCount(5);
        centerPanel.add(combo);
        // スピナー
        model = new SpinnerNumberModel(1, null, null, 1);
        JSpinner spinner = new JSpinner(model);
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, "#,##0");
        spinner.setEditor(editor);
        spinner.setPreferredSize(new Dimension(150, 25));
        centerPanel.add(spinner);

        // EAST
        // ボタン
        JPanel eastPanel = new JPanel();
        JButton enterbutton = new JButton("OK");
        enterbutton.addActionListener(this);
        eastPanel.add(enterbutton);

        // PAGE_END
        // ラベル
        endlabel = new JLabel();
        JPanel endPanel = new JPanel();
        endPanel.add(endlabel);

        // ペイン
        setLayout(new FlowLayout());
        Container contentPane = getContentPane();
        contentPane.add(startPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(eastPanel, BorderLayout.EAST);
        contentPane.add(endPanel, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent e) {
        String comboText = "null";
        Integer spinnerText = -1;
        comboText = (String) combo.getSelectedItem();
        spinnerText = (Integer) model.getValue();
        endlabel.setText(comboText + " " + spinnerText);
    }
}