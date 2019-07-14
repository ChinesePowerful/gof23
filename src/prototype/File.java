package prototype;

public class File {

    private String fileName;
    private String fileType;
    private String description;
    private String content;
    private String pushTime;

    public File(String fileName, String fileType, String description, String content, String pushTime) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.description = description;
        this.content = content;
        this.pushTime = pushTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", pushTime='" + pushTime + '\'' +
                '}';
    }

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
