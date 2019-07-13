package singleton;

public enum  EnumImplSingleton {

    INSTANCE;

    private Object attributeName;

    public Object getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(Object attributeName) {
        this.attributeName = attributeName;
    }
}
