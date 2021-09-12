import java.io.File;

public class SearchDir {
    public static void main(String[] args) {

        String path1 = "/home/skyadmin/toiletPaper/data";

        File file1 = new File(path1);
        File fileArray1[] = file1.listFiles();

        Integer sum = 0;
        // ファイルの一覧
        for (File f : fileArray1) {
            if (f.isFile()) {
                System.out.println(f.toString());// ファイルを表示
                Seri search = new Seri();
                sum += search.readNum(f.toString());
            }
        }
        System.out.println("合計数:" + sum);// 合計表示
    }
}
