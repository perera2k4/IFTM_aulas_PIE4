import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JanelaJavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Label label = new Label("Olá JavaFX");
		StackPane raiz = new StackPane(label);
		Scene scene = new Scene(raiz, 300, 250);
		
		stage.setTitle("Exemplo JavaFX");
		stage.setScene(scene);
		stage.show();
		// stage.setFullScreen(true);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}