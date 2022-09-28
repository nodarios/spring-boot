package pak.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.entities.MyEntity;
import pak.enums.ErrorType;
import pak.exception.AppException;
import pak.repositories.MyRepo;

import java.time.Instant;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class MyService {

    private final MyRepo myRepo;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyEntity save(MyEntity app) {
        return myRepo.save(app);
    }

    @Transactional
    public void deleteById(Long id) {
        myRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MyEntity> findAll() {
        return myRepo.findAll();
    }

    @Transactional(readOnly = true)
    public MyEntity findById(long id) {
        return myRepo.findById(id)
                .orElseThrow(() -> new AppException(ErrorType.ENTITY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public MyEntity findByName(String name) {
        return myRepo.findByName(name)
                .orElseThrow(() -> new AppException(ErrorType.ENTITY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<MyEntity> searchByInfo(String info) {
        return myRepo.searchByInfo(info);
    }

    @Transactional(readOnly = true)
    public Instant getDatabaseTime() {
        return myRepo.getDatabaseTime();
    }

}
