package com.MediaController;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class MediaControl implements Initializable  {

   
    @FXML
    private Button play;

    @FXML
    private Button fast;

    @FXML
    private Button slow;

    @FXML
    private Button stop;

    @FXML
    private Button openfile;

    @FXML
    private MediaView mediaview;

    @FXML
    private Button pause;
    
    private String filePath;
    
    private MediaPlayer mediaplayer;
    
    @FXML
    private Slider slider;
    

    @FXML
    private Slider seekslider;
    
    
    @FXML
    private Label currenttime;
    
    
    
    
    
    @FXML
    void clickonopenfile(ActionEvent event) {
    	
    	
    	 FileChooser fileChooser = new FileChooser();
         FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File (*.mp4)", "*.mp4");
              fileChooser.getExtensionFilters().add(filter);
              File file = fileChooser.showOpenDialog(null);
              filePath = file.toURI().toString();
              
              if(filePath != null){
                  Media media = new Media(filePath);
                  mediaplayer = new MediaPlayer(media);
                  mediaview.setMediaPlayer(mediaplayer);
                      DoubleProperty width = mediaview.fitWidthProperty();
                      DoubleProperty hight = mediaview.fitHeightProperty();
                      
                      width.bind(Bindings.selectDouble(mediaview.sceneProperty(), "width"));
                      hight.bind(Bindings.selectDouble(mediaview.sceneProperty(), "hight"));
    	             mediaplayer.setAutoPlay(true);
    	             
    	             
    	             slider.setValue(mediaplayer.getVolume()*100);
    	             slider.valueProperty().addListener(new InvalidationListener() {
						
						@Override
						public void invalidated(javafx.beans.Observable observable) {
							// TODO Auto-generated method stub
							mediaplayer.setVolume(slider.getValue()/100);
						}
					});
          mediaplayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

			@Override
			public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
				// TODO Auto-generated method stub
				seekslider.setValue(newValue.toMinutes());
			}
		});
          seekslider.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent dc) {
				// TODO Auto-generated method stub
               mediaplayer.seek(Duration.minutes(seekslider.getValue()));				
			}
              });

    }}
   

    @FXML
    void clcikonpause(ActionEvent event) {
   mediaplayer.pause(); 
    }

    @FXML
    void clcikonplay(ActionEvent event) {
mediaplayer.play();
mediaplayer.setRate(1);
    }

    @FXML
    void clickonslow(ActionEvent event) {
mediaplayer.setRate(0.7);
    }

    @FXML
    void clickonfast(ActionEvent event) {
mediaplayer.setRate(4);
    }

    @FXML
    void clickonstop(ActionEvent event) {
mediaplayer.stop();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
	}
	

}
