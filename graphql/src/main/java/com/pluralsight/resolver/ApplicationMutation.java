package com.pluralsight.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.entity.Application;
import com.pluralsight.exception.ApplicationNotFoundException;
import com.pluralsight.repository.ApplicationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApplicationMutation implements GraphQLMutationResolver {

    private ApplicationRepository applicationRepository;

    public ApplicationMutation(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application newApplication(String name, String owner, String description) {
        Application app = new Application(name, owner, description);
        return applicationRepository.save(app);
    }

    public boolean deleteApplication(Long id) {
        applicationRepository.deleteById(id);
        return true;
    }

    public Application updateApplicationOwner(String newOwner, Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if(optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setOwner(newOwner);
            return applicationRepository.save(application);
        } else {
            throw new ApplicationNotFoundException("Application Not Found", id);
        }
    }

}
