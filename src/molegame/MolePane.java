/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molegame;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author mhick
 */
public class MolePane extends Pane {

    private Mole mole, moleTwo, moleThree, moleFour, moleFive, moleSix, moleSeven, moleEight, moleNine, moleTen, moleEleven, moleTwelve;
    int countDown = 30;
    private int Score;
    private String scoreLabel = "Score:";
    private Label gameTime, Final, ScoreBoard, gameOver;
    private int time;
    private Timer timer;
    private int secondsPassed;
    private Rectangle rect;
    private Rectangle topBar;
    private int timeShown = 2;
    private Button playAgain;
    private Timeline timeline, timelineT;

    public MolePane() {
        setStyle("-fx-background-color: #336600");
        rect = new Rectangle(0, 40, 1000, 1000);
        topBar = new Rectangle(0, 0, 1000, 40);
        rect.setFill(Color.ALICEBLUE);
        topBar.setFill(Color.ALICEBLUE);
        playAgain = new Button("Play Again");

//GAME OVER 
        gameOver = new Label("Game Over");
        Final = new Label("Final");
//SCOREBOARD
        ScoreBoard = new Label();
        ScoreBoard.setText(scoreLabel + String.valueOf(Score));
        ScoreBoard.setScaleX(2);
        ScoreBoard.setScaleY(2);
        gameTime = new Label();
        gameTime.setText("Time left: " + String.valueOf(countDown));
        gameTime.setScaleX(2);
        gameTime.setScaleY(2);
//MOLES
        mole = new Mole();
        moleTwo = new Mole();
        moleThree = new Mole();
        moleFour = new Mole();
        moleFive = new Mole();
        moleSix = new Mole();
        moleSeven = new Mole();
        moleEight = new Mole();
        moleNine = new Mole();
        moleTen = new Mole();
        moleEleven = new Mole();
        moleTwelve = new Mole();
//SET POSITION
        //MOLES
        //TOP LEFT
        mole.setLayoutX(-480);
        mole.setLayoutY(-50);
        moleTwo.setLayoutX(-300);
        moleTwo.setLayoutY(0);
        moleNine.setLayoutX(-200);
        moleNine.setLayoutY(360);
        //TOP RIGHT
        moleThree.setLayoutX(400);
        moleThree.setLayoutY(0);
        moleFour.setLayoutX(50);
        moleFour.setLayoutY(0);
        moleTen.setLayoutX(250);
        moleTen.setLayoutY(300);
        //BOTTOM LEFT
        moleFive.setLayoutX(-400);
        moleFive.setLayoutY(600);
        moleSix.setLayoutX(-200);
        moleSix.setLayoutY(700);
        moleEleven.setLayoutX(-100);
        moleEleven.setLayoutY(650);
        //BOTTOM RIGHT
        moleSeven.setLayoutX(20);
        moleSeven.setLayoutY(400);
        moleEight.setLayoutX(280);
        moleEight.setLayoutY(600);
        moleTwelve.setLayoutX(300);
        moleTwelve.setLayoutY(750);

//OTHER
        ScoreBoard.setLayoutX(880);
        ScoreBoard.setLayoutY(10);
        gameTime.setLayoutX(50);
        gameTime.setLayoutY(10);

//EVENTS
        setOnMousePressed(this::processMousePressed);
        playAgain.setOnAction(this::processAction);
//ADD MOLES
        getChildren().add(mole);
        getChildren().add(moleTwo);
        getChildren().add(moleThree);
        getChildren().add(moleFour);
        getChildren().add(moleFive);
        getChildren().add(moleSix);
        getChildren().add(moleSeven);
        getChildren().add(moleEight);
        getChildren().add(moleNine);
        getChildren().add(moleTen);
        getChildren().add(moleEleven);
        getChildren().add(moleTwelve);

//ADD GAME INFORMATION
        getChildren().add(topBar);
        getChildren().add(gameTime);
        getChildren().add(ScoreBoard);

        //timer for how long it appears
        //        TimerTask task = new TimerTask() {
        //            public void run() {
        //                secondsPassed++;
        //                System.out.println(secondsPassed);
        //                
        //            }
        //        };
        //        timer.schedule(task, 1000, 1000);
        //        new Thread(new Task<Void>() {
        //            @Override
        //            protected Void call() throws Exception {
        //                Thread.sleep(3 * 1000);
        //
        //                secondsPassed++;
        //                System.out.println(secondsPassed);
        //                return null;
        //
        //            }
        //
        //        }).start();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ae -> {
            countDown--;
            gameTime.setText("Time left: " + countDown);
        }));
        timeline.setCycleCount(10000);
        timeline.play();
        timelineT = new Timeline(new KeyFrame(Duration.seconds(30), ae -> {
            getChildren().add(rect);
            getChildren().add(gameOver);
            getChildren().add(Final);
            getChildren().add(playAgain);
            getChildren().remove(gameTime);
            playAgain.setLayoutX(450);
            playAgain.setLayoutY(500);
            gameOver.setLayoutX(450);
            gameOver.setLayoutY(450);
            gameOver.setScaleX(5);
            gameOver.setScaleY(5);
            Final.setLayoutX(800);
            Final.setLayoutY(10);
            Final.setScaleX(2);
            Final.setScaleY(2);

        }));
        timelineT.setCycleCount(1);
        timelineT.play();

    }

    public void processMousePressed(MouseEvent e) {
        Random rand = new Random();
//TOP LEFT X AND Y
        int highXtl = -50;
        int lowXtl = -480;
        int highYtl = 360;
        int lowYtl = -50;
        int newXtl = rand.nextInt(highXtl - lowXtl + 1) + lowXtl;
        int newYtl = rand.nextInt(highYtl - lowYtl + 1) + lowYtl;

//TOP RIGHT X AND Y
        int highXtr = 400;
        int lowXtr = -20;
        int highYtr = 380;
        int lowYtr = -50;
        int newXtr = rand.nextInt(highXtr - lowXtr + 1) + lowXtr;
        int newYtr = rand.nextInt(highYtr - lowYtr + 1) + lowYtr;
//BOTTOM LEFT X AND Y
        int highXbl = -20;
        int lowXbl = -480;
        int highYbl = 800;
        int lowYbl = 380;
        int newXbl = rand.nextInt(highXbl - lowXbl + 1) + lowXbl;
        int newYbl = rand.nextInt(highYbl - lowYbl + 1) + lowYbl;
//BOTTOM RIGHT X AND Y
        int highXbr = 400;
        int lowXbr = -20;
        int highYbr = 800;
        int lowYbr = 380;
        int newXbr = rand.nextInt(highXbr - lowXbr + 1) + lowXbr;
        int newYbr = rand.nextInt(highYbr - lowYbr + 1) + lowYbr;
//TOP LEFT MOLES
        if (mole.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    mole.setLayoutX(-1000);
                    mole.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    mole.setLayoutX(newXtl);
                    mole.setLayoutY(newYtl);
                    return null;
                }
            }).start();
        }
        if (moleTwo.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleTwo.setLayoutX(-1000);
                    moleTwo.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleTwo.setLayoutX(newXtl);
                    moleTwo.setLayoutY(newYtl);

                    return null;
                }
            }).start();

        }
        if (moleNine.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleNine.setLayoutX(-1000);
                    moleNine.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleNine.setLayoutX(newXtl);
                    moleNine.setLayoutY(newYtl);

                    return null;
                }
            }).start();

        }
//TOP RIGHT MOLES
        if (moleThree.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleThree.setLayoutX(-1000);
                    moleThree.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleThree.setLayoutX(newXtr);
                    moleThree.setLayoutY(newYtr);

                    return null;
                }
            }).start();
        }
        if (moleFour.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleFour.setLayoutX(-1000);
                    moleFour.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleFour.setLayoutX(newXtr);
                    moleFour.setLayoutY(newYtr);

                    return null;
                }
            }).start();
        }
        if (moleTen.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleTen.setLayoutX(-1000);
                    moleTen.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleTen.setLayoutX(newXtr);
                    moleTen.setLayoutY(newYtr);

                    return null;
                }
            }).start();
        }
        //BOTTOM LEFT MOLES
        if (moleFive.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleFive.setLayoutX(-1000);
                    moleFive.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleFive.setLayoutX(newXbl);
                    moleFive.setLayoutY(newYbl);

                    return null;
                }
            }).start();
        }
        if (moleSix.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleSix.setLayoutX(-1000);
                    moleSix.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleSix.setLayoutX(newXbl);
                    moleSix.setLayoutY(newYbl);

                    return null;
                }
            }).start();

        }
        if (moleEleven.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleEleven.setLayoutX(-1000);
                    moleEleven.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleEleven.setLayoutX(newXbl);
                    moleEleven.setLayoutY(newYbl);

                    return null;
                }
            }).start();

        }
        //BOTTOM RIGHT
        if (moleSeven.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleSeven.setLayoutX(-1000);
                    moleSeven.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleSeven.setLayoutX(newXbr);
                    moleSeven.setLayoutY(newYbr);

                    return null;
                }
            }).start();
        }
        if (moleEight.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleEight.setLayoutX(-1000);
                    moleEight.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleEight.setLayoutX(newXbr);
                    moleEight.setLayoutY(newYbr);
                    return null;
                }
            }).start();
        }
        if (moleTwelve.isPressed()) {
            Score = Score + 10;
            ScoreBoard.setText(scoreLabel + String.valueOf(Score));
            new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    moleTwelve.setLayoutX(-1000);
                    moleTwelve.setLayoutY(-1000);
                    Thread.sleep(timeShown * 1000);
                    moleTwelve.setLayoutX(newXbr);
                    moleTwelve.setLayoutY(newYbr);
                    return null;
                }
            }).start();
        }
    }
//PlayAgain button

    public void processAction(ActionEvent e) {
        Score = Score - Score;
        ScoreBoard.setText(scoreLabel + Score);
        countDown = 30;
        timelineT.playFromStart();
        getChildren().remove(rect);
        getChildren().remove(playAgain);
        getChildren().remove(gameOver);
        getChildren().remove(Final);
        getChildren().add(gameTime);
    }
}
