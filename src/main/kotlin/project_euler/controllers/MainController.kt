package project_euler.controllers

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ListView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import project_euler.internal.StubProblemViewGenerator
import java.net.URL
import java.util.*

class MainController() : BaseController(), Initializable {

  @FXML
  private lateinit var rootContainer: AnchorPane

  @FXML
  private lateinit var problemViewList: ListView<GridPane>

  override fun initialize(location: URL?, resources: ResourceBundle?) {
    println(this.rootScene)
    problemViewList.items = FXCollections.observableList(StubProblemViewGenerator.generate(10))
  }

  class Factory : BaseController.Factory<MainController> {
    override fun create(): MainController {
      return MainController()
    }
  }
}

