package pak.interceptors.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionSynchronization;

@Slf4j
public class MyTransactionSynchronization implements TransactionSynchronization {

    @Override
    public void afterCompletion(int status) {
        if (status == STATUS_COMMITTED) {
            log.info("MyTransactionSynchronization afterCompletion");
        }
    }

}
