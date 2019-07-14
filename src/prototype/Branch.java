package prototype;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String branchName;

    private List<File> fileList = new ArrayList<>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public void addFile(File file) {
        this.fileList.add(file);
    }

    public List<File> getFileList() {
        return this.fileList;
    }

    /**
     * 使用深拷贝
     * @param branchName 分枝名称
     * @return clone object
     */
    public Branch clone(String branchName) {
        Branch branch = new Branch(branchName);
        for (File file : this.fileList) {
            branch.addFile(file.clone());
        }
        return branch;
    }

}
