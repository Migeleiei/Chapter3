package se233.chapter3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Region;

import java.io.File;

public class MainViewController {
    @FXML
    private Region dropRegion;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ListView listView;
    @FXML
    public void initialize(){
        dropRegion.setOnDragOver(dragEvent -> {
            Dragboard db = dragEvent.getDragboard();
            final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".pdf");
            if(db.hasFiles() && isAccepted){
                dragEvent.acceptTransferModes(TransferMode.COPY);
            }else {
                dragEvent.consume();
            }
        });
    dropRegion.setOnDragDropped(dragEvent -> {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if(db.hasFiles()){
            success = true;
            String filePath;
            int total_files = db.getFiles().size();
            for(int i = 0; i < total_files; i++){
                File file = db.getFiles().get(i);
                filePath = file.getAbsolutePath();
                System.out.println(filePath);
            }
            progressBar.setProgress(100);
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    });
    }
}
