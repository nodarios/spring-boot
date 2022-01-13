package pak.interceptors.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MyHibernateInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(
            Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        log.info("MyHibernateInterceptor onSave");
        resisterMyTransactionSynchronization();
        return false;
    }

    private MyTransactionSynchronization resisterMyTransactionSynchronization() {
        Set<MyTransactionSynchronization> set = TransactionSynchronizationManager.getSynchronizations().stream()
                .filter(s -> s instanceof MyTransactionSynchronization)
                .map(s -> (MyTransactionSynchronization) s)
                .collect(Collectors.toSet());
        if (set.size() > 1) {
            throw new RuntimeException("There is more than one instance of MyTransactionSynchronization");
        } else if (set.size() == 1) {
            return set.iterator().next();
        }
        MyTransactionSynchronization myTransactionSynchronization = new MyTransactionSynchronization();
        TransactionSynchronizationManager.registerSynchronization(myTransactionSynchronization);
        return myTransactionSynchronization;
    }

}
