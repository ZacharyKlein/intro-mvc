package mvc.demo

class HomeController {

    Map model = [message: "Hello from the model!"]

    def index() {
        return model
    }
}
