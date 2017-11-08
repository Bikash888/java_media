package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../com/mediafx/videoplayer.fxml"));
	        primaryStage.setTitle("Extra Creative Media Player");
	        
	        Scene scene = new Scene(root, 700, 500);
            
	       
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getClickCount()==2){
					primaryStage.setFullScreen(true);
			}}
		});	       
	        primaryStage.setScene(scene);
	        primaryStage.sizeToScene();
	        primaryStage.show();
	        
		
			 
			//primaryStage.initStyle(StageStyle.UNDECORATED);


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
