package pak.jmx;

import org.springframework.stereotype.Component;

@Component
public class MyFlag implements MyFlagMBean {

    private boolean status = true;

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
}
