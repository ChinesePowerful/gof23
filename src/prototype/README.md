6.原型模式（Prototype）
=====

简介
----

### 意图
- 使用原型实例（被克隆的对象）指定待创建对象的类型，并通过复制这个原型来创建新的对象

### 主要解决
- 需要重新创建一个已经实例的对象时，实例对象内部的属性过于复杂

### 何时使用
- 当需要根据一个内部复杂的实例对象创建出一个新的对象时

### 注意
- 浅拷贝时，【被拷贝对象】和【拷贝出的新对象】内部的属性引用的是同一个地址，当一个被拷贝对象修改属性指向地址内的数值时，另一个拷贝出来的实例的属性会受到影响而改变

实现
----

### 实例
- 使用 GitHub 管理项目时会有很多的分枝，假设这些分枝刚刚创建时需要用到的数据是和主分枝相同的，如果要重新创建然后再把主分枝的数据填充进去就太繁琐了，所以使用主分枝作为原型克隆一份作为其他分枝即可
- 但是，你在编辑其他分枝的时候是不能影响到主分枝的，所以需要使用到深拷贝

### 文件类
```java
public class File {

    private String fileName;
    private String fileType;
    private String description;
    private String content;
    private String pushTime;

    // 隐藏了 get,set,toString,constructor 方法

    /**
     * 使用深拷贝，确保克隆的 file 对象内的属性不是指向同一个地址
     * @return clone object
     */
    public File clone() {
        return new File(
                new String(this.fileName),
                new String(this.fileType),
                new String(this.description),
                new String(this.content),
                new String(this.pushTime)
        );
    }
}
```

### 分枝类
```java
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * 使用深拷贝
     * @param branchName 分枝名称
     * @return clone object
     */
    public Branch clone(String branchName) {
        Branch branch = new Branch(branchName);
        for (File file :
                this.fileList) {
            branch.addFile(file.clone());
        }
        return branch;
    }

}
```

### 调用类
```java
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
        for (File f: dev.getFileList()) {
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
```