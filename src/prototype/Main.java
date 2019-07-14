package prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Branch master = new Branch("master");
        for (int i = 0; i < 10; i++) {
            String str = i + "";
            master.addFile(new File(str, str, str, str, str));
        }
//        拷贝一个 dev 分枝
        Branch dev = master.clone("dev");
//        测试深拷贝是否成功
        int i = 0;
        List<File> fileList = master.getFileList();
        for (File f : dev.getFileList()) {
            File file = fileList.get(i);
            System.out.println("file is equal: " + (file == f));
            System.out.println("index equal: " + (file.getFileName() == f.getFileName()));
            System.out.println("index equal: " + (file.getFileType() == f.getFileType()));
            System.out.println("index equal: " + (file.getDescription() == f.getDescription()));
            System.out.println("index equal: " + (file.getContent() == f.getContent()));
            System.out.println("index equal: " + (file.getPushTime() == f.getPushTime()));
        }
    }
}
