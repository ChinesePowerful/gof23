package chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class Handler {

    private int position = 0;
    private int filterNumber = 0;

//    用于存放所有过滤器
    private List<Filter> filterList = new ArrayList<>();
//    添加过滤器
    public void addFilter(Filter filter) {
        this.filterList.add(filter);
        this.filterNumber++;
    }

    /**
     * 处理请求
     * @param webName 网址
     */
    public void handlerRequest(String webName) {
        if (this.position < this.filterNumber) {
            if (this.filterList.get(this.position++).doFilter(webName)) {
                System.out.println("神秘 404 代码");
                this.position = 0;
                return;
            }
            this.handlerRequest(webName);
        } else {
            System.out.println(webName + " 可以访问");
            this.position = 0;
        }
    }

}