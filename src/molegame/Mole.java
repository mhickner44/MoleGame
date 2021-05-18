/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molegame;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author mhick
 */
public class Mole extends Group {

    private Ellipse Head;
    private Rectangle Body;
    private Circle LeftEye, RightEye;
    private Ellipse Mouth;
    private Ellipse Nose;
    int moleX = 0;
    int moleY = 0;

    public Mole() {
        //Mole
        Head = new Ellipse(moleX + 530, moleY+100, 40, 50);
        Body = new Rectangle(moleX + 490, moleY + 110, 80, 40);
        Mouth = new Ellipse(moleX + 530, moleY +95, 20, 10);
        LeftEye = new Circle(moleX + 515, moleY +75, 5);
        RightEye = new Circle(moleX + 545, moleY +75, 5);
        Nose = new Ellipse(moleX + 530, moleY +93, 5, 3);
        //colors for body parts
        Head.setFill(Color.GREY);
        Mouth.setFill(Color.ANTIQUEWHITE);
        Body.setFill(Color.BLACK);

        getChildren().add(Head);
        getChildren().add(Body);
        getChildren().add(Mouth);
        getChildren().add(LeftEye);
        getChildren().add(RightEye);
        getChildren().add(Nose);

//adding mole to the screen
    }
//try using mole as a object with changable x and y , change the variables to x and y somehow PROBABLY NOT

    public int getMoleX() {
        return moleX;
    }

    public void setMoleX(int moleX) {
        this.moleX = moleX;
    }

    public int getMoleY() {
        return moleY;
    }

    public void setMoleY(int moleY) {
        this.moleY = moleY;
    }

    public void processMouseClick(MouseEvent e) {

    }

}
