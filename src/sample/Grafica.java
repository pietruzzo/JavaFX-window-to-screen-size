package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;

/**
 * Created by pietro on 01/06/17.
 */
public class Grafica {
    @FXML
    AnchorPane pannello;
    @FXML
    public Pane vedononvedo;

    @FXML
    private void initialize(){
        //Setta le dimensioni della pannello principale 'vedononvedo'
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setPannelloDim(vedononvedo, width, height);

        //riscala il campo per adattarsi al pannello principale
        double pannellow = pannello.getPrefWidth();
        double pannelloh= pannello.getPrefHeight();
        double fattoreScala = width/pannellow;
        if (fattoreScala> (height/pannelloh)) fattoreScala = height/pannelloh;

        riscala(pannello, fattoreScala);



    }
    @FXML
    private void riscala(){}


    private void riscala(Pane pannello, double coeff){
        pannello.setScaleX(coeff);
        pannello.setScaleY(coeff);
        pannello.setTranslateX(- pannello.getPrefWidth()*((1-coeff)/2));
        pannello.setTranslateY(- pannello.getPrefHeight()*((1-coeff)/2));
        pannello.maxWidth(pannello.getWidth()*coeff);
        pannello.maxHeight(pannello.getHeight()*coeff);
        pannello.minWidth(pannello.getWidth()*coeff);
        pannello.minHeight(pannello.getHeight()*coeff);
        pannello.setPrefWidth(pannello.getWidth()*coeff);
        pannello.setPrefHeight(pannello.getHeight()*coeff);
    }

    private void setPannelloDim(Pane pannello, double w, double h){
        pannello.maxWidth(w);
        pannello.maxHeight(h);
        pannello.minWidth(w);
        pannello.minHeight(h);
        pannello.setPrefHeight(h);
        pannello.setPrefWidth(w);
    }
}
