import java.io.File;

public class SearchDir {
    public static void main(String[] args) {
        String path1 = "/home/skyadmin/toiletPaper/data"; // ver Linux
        // String path1 = "C:\\toiletPaper\\data\\"; // ver Win

        File file1 = new File(path1);
        File fileArray1[] = file1.listFiles();

        String[] toiletComboData = {"toilet1", "toilet2", "toilet3", "toilet4", "toilet5"};
        int[] sum = new int[toiletComboData.length];

        // ファイルの一覧
        for (File f : fileArray1) {
            if (f.isFile()) {
                Seri search = new Seri();
                for (int i = 0; i < toiletComboData.length; i++) {
                    search.read(f.toString());
                    if (search.readText().equals(toiletComboData[i])) {
                        sum[i] += search.readNum();
                    }
                }
            }
        }

        // 総数計算・表示
        int sums = 0;
        for (int i = 0; i < toiletComboData.length; i++) {
            System.out.println(toiletComboData[i] + "の消費数:" + sum[i]);
            sums += sum[i];
        }
        System.out.println("全体の消費数:" + sums);
    }
}
