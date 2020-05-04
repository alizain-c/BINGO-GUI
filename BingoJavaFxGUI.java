/* 
Ali Zain Charolia

Description: 
This User-Friendly program is for a BINGO game between two players made with Java and the implementation of GUI using JavaFX. 
It asks the user/player to enter a number in the input Textfield and fills in the bingo card for each of the players respectively,
checks for no repitition and then generates random numbers and colors up the number matching with it on the bingo card and checks the winner. 
Runs smoothly with restrictions and instructions on the application window itself (All GUI; Java, JavaFX and JOptionPane)
*/

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import java.awt.Component;

public class BingoJavaFxGUI extends Application {
    int index1 = 0;
    int index2 = 0;
    int index3 = 0;
    int[] random;
    static Label[] lbs1;
    static Label[] lbs2;
    TextField getNumberTextField = new TextField("");
    
    Label textLabel = new Label("");
    int count = 0;

    public boolean Repeat(Label[] arr, int size, int num) {
        for(int i = 0; i < size; ++i) {
            if (num == Integer.parseInt(arr[i].getText())) {
                return true;
            }
        }
        return false;
    }

    static void randomize(int[] arr, int size) {
        Random r = new Random();

        for(int i = size - 1; i > 0; --i) {
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    public int checkWinner() {
        if (this.index1 >= 24 && this.index2 >= 24) {
            if (this.checkArray(lbs1) && this.checkArray(lbs2)) {
                return 0;
            } else if (this.checkArray(lbs1)) {
                return 1;
            } else {
                return this.checkArray(lbs2) ? 2 : -1;
            }
        } else {
            return -2;
        }
    }

    public boolean checkArray(Label[] arr) {
        if (arr[0].getText() == "00" && arr[1].getText() == "00" && arr[2].getText() == "00" && arr[3].getText() == "00" && arr[4].getText() == "00") {
            return true;
        } else if (arr[5].getText() == "00" && arr[6].getText() == "00" && arr[7].getText() == "00" && arr[8].getText() == "00" && arr[9].getText() == "00") {
            return true;
        } else if (arr[10].getText() == "00" && arr[11].getText() == "00" && arr[12].getText() == "00" && arr[13].getText() == "00" && arr[14].getText() == "00") {
            return true;
        } else if (arr[15].getText() == "00" && arr[16].getText() == "00" && arr[17].getText() == "00" && arr[18].getText() == "00" && arr[19].getText() == "00") {
            return true;
        } else if (arr[20].getText() == "00" && arr[21].getText() == "00" && arr[22].getText() == "00" && arr[23].getText() == "00" && arr[24].getText() == "00") {
            return true;
        } else if (arr[0].getText() == "00" && arr[6].getText() == "00" && arr[12].getText() == "00" && arr[18].getText() == "00" && arr[24].getText() == "00") {
            return true;
        } else if (arr[4].getText() == "00" && arr[8].getText() == "00" && arr[12].getText() == "00" && arr[16].getText() == "00" && arr[20].getText() == "00") {
            return true;
        } else if (arr[0].getText() == "00" && arr[4].getText() == "00" && arr[20].getText() == "00" && arr[24].getText() == "00") {
            return true;
        } else if (arr[0].getText() == "00" && arr[5].getText() == "00" && arr[10].getText() == "00" && arr[15].getText() == "00" && arr[20].getText() == "00") {
            return true;
        } else if (arr[1].getText() == "00" && arr[6].getText() == "00" && arr[11].getText() == "00" && arr[16].getText() == "00" && arr[21].getText() == "00") {
            return true;
        } else if (arr[2].getText() == "00" && arr[7].getText() == "00" && arr[12].getText() == "00" && arr[17].getText() == "00" && arr[22].getText() == "00") {
            return true;
        } else if (arr[3].getText() == "00" && arr[8].getText() == "00" && arr[13].getText() == "00" && arr[18].getText() == "00" && arr[23].getText() == "00") {
            return true;
        } else {
            return arr[4].getText() == "00" && arr[9].getText() == "00" && arr[14].getText() == "00" && arr[19].getText() == "00" && arr[24].getText() == "00";
        }
    }

    public void start(Stage primaryStage) {
        
        Label lbsup[] = new Label[10];
        Label lbsdown[] = new Label[10];
        Label lbsdown2[] = new Label[10];
	    Label lbsdown3[] = new Label[10];
        GridPane gridpane = new GridPane();
        Button myButton = new Button(" Random # ");
        myButton.setOnAction(new BingoJavaFxGUI.ButtonClickHandlerRamdom());
        Button Buttonfill1 = new Button("  Fill User 1  ");
        Buttonfill1.setOnAction(new BingoJavaFxGUI.ButtonClickHandlerfill1());
        Button Buttonfill2 = new Button("  Fill User 2  ");
        Buttonfill2.setOnAction(new BingoJavaFxGUI.ButtonClickHandlerfill2());
        Button exitButton = new Button("       Exit       ");
        exitButton.setOnAction(new BingoJavaFxGUI.ExitButtonListener());
        this.textLabel.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;");
        this.random = new int[40];
        
        for(int i = 0; i < 40; ++i) {
            this.random[i] = i + 10;
        }

        randomize(this.random, 40);

        for(int i = 0; i < 10; ++i) {
            lbsup[i] = new Label("---");
            lbsup[i].setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
            lbsdown[i] = new Label(" | ");
            lbsdown[i].setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
            lbsdown2[i]=new Label(" | ");
		    lbsdown2[i].setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
		    lbsdown3[i]=new Label(" | ");
		    lbsdown3[i].setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
        }

        Label label1 = new Label(" B ");
        label1.setStyle("-fx-font-size: 20px;-fx-border-color: black; -fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label2 = new Label(" I  ");
        label2.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label3 = new Label(" N ");
        label3.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label4 = new Label(" G ");
        label4.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label5 = new Label(" O ");
        label5.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label6 = new Label("INPUT:");
	    label6.setStyle("-fx-font-size: 19px;-fx-font-weight: bold;-fx-text-fill: #00008B;");
	    Label label7 = new Label("  GAME INSTRUCTIONS:");
	    label7.setStyle("-fx-font-size: 19px;-fx-font-weight: bold;-fx-text-fill: #00008B;");
	    Label label8 = new Label ("<-- Click to exit the application.");
	    Label label9 = new Label ("<-- Enter your desired number here.");
	    Label label10 = new Label ("<-- Click this button to fill in User 1's card");
	    Label label12 = new Label ("<-- Click this button to fill in User 2's card");
	    Label label13 = new Label ("<-- Random Number generated.");
	    Label label14 = new Label ("<-- Click this button to generate a random #.");

        
        for(int i = 0; i < 5; ++i) {
            gridpane.add(lbsup[i], i + 1, 1);			   
        }

        gridpane.add(label1, 1, 0);
        gridpane.add(label2, 2, 0);
        gridpane.add(label3, 3, 0);
        gridpane.add(label4, 4, 0);
        gridpane.add(label5, 5, 0);
        gridpane.add(label6, 20, 0);
	    gridpane.add(label7, 23, 0);
	    gridpane.add(label8, 23, 6);
	    gridpane.add(label9, 23, 1);
	    gridpane.add(label10, 23, 2);
	    gridpane.add(label12, 23, 3);
	    gridpane.add(label13, 23, 4);
	    gridpane.add(label14, 23, 5);

        lbs1 = new Label[25];
        int count = 0;

        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                lbs1[count] = new Label("00");
                lbs1[count].setStyle("-fx-font-size: 20px;-fx-border-color: black;-fx-text-fill: red;");
                gridpane.add(lbs1[count], j + 1, i + 2);
                ++count;
            }
            gridpane.add(lbsdown[i], 7, i + 2);   
        }

        lbs1[12].setStyle("-fx-font-size: 20px;-fx-border-color: black;-fx-text-fill: green;");
        Label label11 = new Label(" B ");
        label11.setStyle("-fx-font-size: 20px;-fx-border-color: black; -fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label21 = new Label("  I ");
        label21.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label31 = new Label(" N ");
        label31.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label41 = new Label(" G ");
        label41.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        Label label51 = new Label(" O ");
        label51.setStyle("-fx-font-size: 20px; -fx-border-color: black;-fx-font-weight: bold;-fx-text-fill: #00008B;");
        
        gridpane.add(label11, 9, 0);
        gridpane.add(label21, 10, 0);
        gridpane.add(label31, 11, 0);
        gridpane.add(label41, 12, 0);
        gridpane.add(label51, 13, 0);
        
        for(int i = 5; i < 10; ++i) {
            gridpane.add(lbsup[i], i + 4, 1);
        }

        lbs2 = new Label[25];
        count = 0;

        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                lbs2[count] = new Label("00");
                lbs2[count].setStyle("-fx-font-size: 20px;-fx-border-color: black;-fx-text-fill: red;");
                gridpane.add(lbs2[count], j + 9, i + 2);
                ++count;
            }
        }

        lbs2[12].setStyle("-fx-font-size: 20px;-fx-border-color: black;-fx-text-fill: green;");
        this.getNumberTextField.setPrefWidth(10);
        gridpane.add(this.getNumberTextField, 20, 1);
        gridpane.add(Buttonfill1, 20, 2);
        gridpane.add(Buttonfill2, 20, 3);
        this.textLabel.setPrefWidth(80);
        this.textLabel.setAlignment(Pos.CENTER);
        gridpane.add(this.textLabel, 20, 4);
        gridpane.add(myButton, 20, 5);
        gridpane.add(exitButton, 20, 6);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Scene scene = new Scene(gridpane, 851, 300);
        primaryStage.setTitle("Bingo by Ali Zain Charolia.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class ButtonClickHandlerRamdom implements EventHandler<ActionEvent> {
        

        public void handle(ActionEvent event) {
            
            for(int i = 0; i < 25; ++i) {
                if (Integer.parseInt(BingoJavaFxGUI.lbs1[i].getText()) == BingoJavaFxGUI.this.random[BingoJavaFxGUI.this.index3]) {
                    BingoJavaFxGUI.lbs1[i].setText("00");
                    BingoJavaFxGUI.lbs1[i].setStyle("-fx-font-size: 20px;-fx-border-color: black;-fx-text-fill: red;");
                }
            }

            for(int i = 0; i < 25; ++i) {
                if (Integer.parseInt(BingoJavaFxGUI.lbs2[i].getText()) == BingoJavaFxGUI.this.random[BingoJavaFxGUI.this.index3]) {
                    BingoJavaFxGUI.lbs2[i].setText("00");
                    BingoJavaFxGUI.lbs2[i].setStyle("-fx-font-size: 20px;-fx-border-color: black;-fx-text-fill: red;");
                }
            }

            if (BingoJavaFxGUI.this.checkWinner() == 0) {
                JOptionPane.showMessageDialog(null, "Both the users (User 1 and 2) won");
            } else if (BingoJavaFxGUI.this.checkWinner() == 1) {
                JOptionPane.showMessageDialog(null, "USER 1 WINS");
            } else if (BingoJavaFxGUI.this.checkWinner() == 2) {
                JOptionPane.showMessageDialog(null, "USER 2 WINS");
            } else if (BingoJavaFxGUI.this.index3 == 30) {
                JOptionPane.showMessageDialog(null, "RANDOM NUMBERS DONE");
            } else if (BingoJavaFxGUI.this.checkWinner() == -2) {
                JOptionPane.showMessageDialog(null, "NEED MORE NUMBERS TO FILL IN THE Bingo CARD");
            } else {
                BingoJavaFxGUI.this.textLabel.setText(Integer.toString(BingoJavaFxGUI.this.random[BingoJavaFxGUI.this.index3]));
                ++BingoJavaFxGUI.this.index3;
            }

        }
    }

    class ButtonClickHandlerfill1 implements EventHandler<ActionEvent> {
        

        public void handle(ActionEvent event) {
            if (BingoJavaFxGUI.this.getNumberTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "INPUT IS EMPTY");
            } else if (BingoJavaFxGUI.this.index1 > 24) {
                JOptionPane.showMessageDialog(null, "INPUT LIMIT REACHED. | BINGO CARD FULL.");
            } else if (Integer.parseInt(BingoJavaFxGUI.this.getNumberTextField.getText()) >= 10 && Integer.parseInt(BingoJavaFxGUI.this.getNumberTextField.getText()) <= 50) {
                if (BingoJavaFxGUI.this.Repeat(BingoJavaFxGUI.lbs1, BingoJavaFxGUI.this.index1, Integer.parseInt(BingoJavaFxGUI.this.getNumberTextField.getText()))) {
                    JOptionPane.showMessageDialog(null, "DO NOT REPEAT A NUMBER WHICH IS ALREADY IN THE CARD.");
                } else if (BingoJavaFxGUI.this.index1 == 12) {
                    ++BingoJavaFxGUI.this.index1;
                } else {
                    BingoJavaFxGUI.this.textLabel.setText(BingoJavaFxGUI.this.getNumberTextField.getText());
                    BingoJavaFxGUI.lbs1[BingoJavaFxGUI.this.index1].setText(BingoJavaFxGUI.this.getNumberTextField.getText());
                    BingoJavaFxGUI.this.getNumberTextField.setText("");
                    ++BingoJavaFxGUI.this.index1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "YOUR INPUT NUMBER SHOULD BE BETWEEN 10-50 ONLY.");
            }

        }
    }

    class ButtonClickHandlerfill2 implements EventHandler<ActionEvent> {
        

        public void handle(ActionEvent event) {
            if (BingoJavaFxGUI.this.getNumberTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "INPUT IS EMPTY");
            } else if (BingoJavaFxGUI.this.index2 > 24) {
                JOptionPane.showMessageDialog(null, "INPUT LIMIT REACHED. | BINGO CARD FULL. ");
            } else if (Integer.parseInt(BingoJavaFxGUI.this.getNumberTextField.getText()) >= 10 && Integer.parseInt(BingoJavaFxGUI.this.getNumberTextField.getText()) <= 50) {
                if (BingoJavaFxGUI.this.Repeat(BingoJavaFxGUI.lbs2, BingoJavaFxGUI.this.index2, Integer.parseInt(BingoJavaFxGUI.this.getNumberTextField.getText()))) {
                    JOptionPane.showMessageDialog(null, "DO NOT REPEAT A NUMBER WHICH IS ALREADY IN THE CARD.");
                } else if (BingoJavaFxGUI.this.index2 == 12) {
                    ++BingoJavaFxGUI.this.index2;
                } else {
                    BingoJavaFxGUI.this.textLabel.setText(BingoJavaFxGUI.this.getNumberTextField.getText());
                    BingoJavaFxGUI.lbs2[BingoJavaFxGUI.this.index2].setText(BingoJavaFxGUI.this.getNumberTextField.getText());
                    BingoJavaFxGUI.this.getNumberTextField.setText("");
                    ++BingoJavaFxGUI.this.index2;
                }
            } else {
                JOptionPane.showMessageDialog(null, "YOUR INPUT NUMBER SHOULD BE BETWEEN 10-50 ONLY.");
            }

        }
    }

    public class ExitButtonListener implements EventHandler<ActionEvent> {
        
        public void handle(ActionEvent arg0) {
            System.exit(0);
        }
    }
}
