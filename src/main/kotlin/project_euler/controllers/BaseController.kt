package project_euler.controllers

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.stage.Stage

abstract class BaseController {
  protected var rootScene: Scene = Scene(Pane(Label("Default Root Scene")))
    private set

  interface Factory<T : BaseController> {
    fun create(): T
  }

  companion object {
    fun <T : BaseController, U : Parent> createScene(
      controllerFactory: Factory<T>,
      fxmlLoader: FXMLLoader
    ): Scene {
      val controller = controllerFactory.create()
      fxmlLoader.setController(controller)
      val scene = Scene(fxmlLoader.load<U>())
      controller.rootScene = scene
      return scene
    }

    fun <T : BaseController> Stage.createAndAttachController(
      factory: Factory<T>,
      fxmlLoader: FXMLLoader
    ) {
      this.scene = createScene<T, Parent>(factory, fxmlLoader)
    }
  }
}
