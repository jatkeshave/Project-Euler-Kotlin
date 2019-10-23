package project_euler.controllers

import javafx.fxml.Initializable
import java.net.URL
import java.util.*

class MainController() : BaseController(), Initializable {

  override fun initialize(location: URL?, resources: ResourceBundle?) {
    println(this.rootScene)
  }

  class Factory : BaseController.Factory<MainController> {
    override fun create(): MainController {
      return MainController()
    }
  }
}

