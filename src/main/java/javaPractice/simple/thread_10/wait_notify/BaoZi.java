package javaPractice.simple.thread_10.wait_notify;

import lombok.Data;

@Data
public class BaoZi {
    private String  pier;
    private String xianer;
    // 为false的时候是占用，true是空闲
    private boolean flag = false;

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public String getXianer() {
        return xianer;
    }

    public void setXianer(String xianer) {
        this.xianer = xianer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
