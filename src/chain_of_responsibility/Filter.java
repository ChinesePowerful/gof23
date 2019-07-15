package chain_of_responsibility;

/**
 * 过滤器
 * filterWebName 会被拦截的网址
 */
public class Filter {
    private String filterWebName;

    public Filter(String filterWebName) {
        this.filterWebName = filterWebName;
    }

    /**
     * 过滤方法，如果网址会被拦截则返回 true
     * @param webName 网址
     * @return true or false
     */
    public boolean doFilter(String webName) {
        if (webName.equalsIgnoreCase(this.filterWebName)) {
            return true;
        } else {
            return false;
        }
    }
}
