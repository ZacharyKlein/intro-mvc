package mn.mvc.demo.model;

import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

@Singleton
public class Bootstrap {
    private final UserInfoRepository repository;

    public Bootstrap(UserInfoRepository repository) {
        this.repository = repository;
    }

    @EventListener
    @Transactional
    public void onStartup(ServerStartupEvent event) {
        repository.save(new UserInfo(1, true, "kleinz"));
    }

}
