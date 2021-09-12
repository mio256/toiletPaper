import java.io.File;

public class SearchDir {
    // 教師用ソフトウェア

    public static void main(String[] args) {

        String path1 = "/home/skyadmin/toiletPaper/data"; // ver Linux
        // String path1 = "C:\\toiletPaper\\data\\"; // ver Win

        File file1 = new File(path1);
        File fileArray1[] = file1.listFiles();
        int[] sum = new int[Main.toiletComboData.length];

        // ファイルの一覧
        for (File f : fileArray1) {
            if (f.isFile()) {
                Seri search = new Seri();
                search.read(f.toString());
                for (int i = 0; i < Main.toiletComboData.length; i++) {
                    if (search.readText().equals(Main.toiletComboData[i])) {
                        sum[i] += search.readNum();
                    }
                }
            }
        }

        // 総数計算・表示
        int sums = 0;
        for (int i = 0; i < Main.toiletComboData.length; i++) {
            System.out.println(Main.toiletComboData[i] + "の消費数:" + sum[i]);
            sums += sum[i];
        }
        System.out.println("全体の消費数:" + sums);
    }
}
