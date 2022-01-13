package pak.interceptors.hibernate;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class MyHibernatePropertiesCustomizer implements HibernatePropertiesCustomizer {

    private final MyHibernateInterceptor myHibernateInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", myHibernateInterceptor);
    }
}
