package mn.mvc.demo.controller;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import mn.mvc.demo.model.UserInfo;
import mn.mvc.demo.model.UserInfoRepository;

import java.util.Map;

@Controller("/views")
class HomeController {

    private final UserInfoRepository repository;

    public HomeController(UserInfoRepository repository) {
        this.repository = repository;
    }

    @Get
    @View("home")
    public HttpResponse<?> home() {
        return HttpResponse.ok(CollectionUtils.mapOf("message", "Welcome to our View!"));
    }

    @Get("/secure")
    @View("loggedIn")
    public HttpResponse<UserInfo> loggedIn() {
        UserInfo userInfo = repository.findById(1).orElse(null);

        return HttpResponse.ok(userInfo);
    }

}