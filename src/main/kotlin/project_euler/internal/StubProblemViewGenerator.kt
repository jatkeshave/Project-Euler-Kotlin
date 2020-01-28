package project_euler.internal

import javafx.fxml.FXMLLoader
import javafx.scene.control.Label
import javafx.scene.layout.GridPane

object StubProblemViewGenerator {
  fun generate(count: Int): List<GridPane> {
    val retList = mutableListOf<GridPane>()
    repeat(count) { counter ->
      val fl = FXMLLoader(ClassLoader.getSystemResource("views/item-problem.fxml"))
      val item = fl.load<GridPane>()
      (item.lookup("#id") as Label).text = counter.toString()
      (item.lookup("#title") as Label).text = "Title $counter"
      (item.lookup("#description") as Label).text = "Test Description for this test $counter"
      (item.lookup("#description") as Label).text = "Test Description for this test $counter"
      (item.lookup("#status") as Label).text = "Status $counter"
      retList += item
    }
    return retList
  }
}
