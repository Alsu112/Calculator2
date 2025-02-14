package sample;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorView extends VBox {
    private CalculatorViewModel viewModel;
    private Stage stage;
    private HBox zeroLine;
    private HBox firstLine;
    private HBox secondLine;
    private HBox thirdLine;
    private HBox fourthLine;
    private TextArea textArea;
    private boolean hasPoint;
    public CalculatorView(CalculatorViewModel viewModel, Stage stage) {
        this.viewModel = viewModel;
        this.stage = stage;
        hasPoint = false;
        textArea = new TextArea();
        textArea.setText("0");
        textArea.setEditable(false);;
        textArea.setStyle("-fx-font-size: 30px;");
        zeroLine = new HBox();
        firstLine = new HBox();
        secondLine = new HBox();
        thirdLine = new HBox();
        fourthLine = new HBox();
        initFourthLine();
        initZeroLine();
        initFirstLine();
        initSecondLine();
        initThirdLine();
        getChildren().addAll(fourthLine, thirdLine, secondLine, firstLine, zeroLine);
    }
    private void initFourthLine() {
        Button deleteBtn = new Button("<-");
        deleteBtn.setMinSize(100, 100);
        deleteBtn.setStyle("-fx-font-size: 30px;");
        deleteBtn.setOnAction(event -> {
            if(textArea.getText(textArea.getLength() - 1, textArea.getLength()).equals(".")){
                hasPoint = false;
            }
            if(textArea.getLength() > 1) {
                textArea.deleteText(textArea.getLength() - 1, textArea.getLength());
            }
            if(textArea.getLength() == 1 ){
                textArea.setText("0");
            }
        });
        fourthLine.getChildren().addAll(textArea,deleteBtn);
    }
    private void initBtn(Button btn, int i, HBox hbox){
        btn.setMinSize(100, 100);
        btn.setStyle("-fx-font-size: 30px;");
        btn.setOnAction(event -> {
            if(textArea.getText().equals("0")){
                textArea.setText(Integer.toString(i));
            }
            else{
                textArea.appendText(Integer.toString(i));
            }
        });
        hbox.getChildren().addAll(btn);
    }
    private void initFirstLine() {
        for(int i = 1; i < 4 ; i++)
        {
            initBtn(new Button(Integer.toString(i)), i, firstLine);
        }
        Button divideBtn = new Button("/");
        divideBtn.setStyle("-fx-font-size: 30px;");
        divideBtn.setMinSize(100, 100);
        divideBtn.setOnAction(event -> {
            viewModel.calculation(textArea.getText(), "/");
            textArea.clear();

        });
        Button rootBtn = new Button("√x");
        rootBtn.setMinSize(100, 100);
        rootBtn.setStyle("-fx-font-size: 30px;");
        rootBtn.setOnAction(event -> {
            double a = 0;
            a = Double.parseDouble(textArea.getText());
            textArea.clear();
            textArea.setText(Double.toString(Math.sqrt(a)));
            hasPoint = false;
        });
        firstLine.getChildren().addAll(divideBtn, rootBtn);
    }

    private void initSecondLine() {
        for(int i = 1; i < 4 ; i++)
        {
            initBtn(new Button(Integer.toString(i + 3)), i + 3 , secondLine);
        }
        Button minusBtn = new Button("-");
        minusBtn.setMinSize(100, 100);
        minusBtn.setStyle("-fx-font-size: 30px;");
        minusBtn.setOnAction(event -> {
            viewModel.calculation(textArea.getText(),"-");
            textArea.clear();
        });
        Button ceBtn = new Button("+/-");
        ceBtn.setMinSize(100, 100);
        ceBtn.setStyle("-fx-font-size: 30px;");
        ceBtn.setOnAction(event -> {
            textArea.clear();
        });
        secondLine.getChildren().addAll(minusBtn, ceBtn);
    }
    private void initThirdLine(){
        for(int i = 1; i < 4 ; i++)
        {
            initBtn(new Button(Integer.toString(i + 6)), i + 6, thirdLine);
        }
        Button plusBtn = new Button("+");
        plusBtn.setMinSize(100, 100);
        plusBtn.setStyle("-fx-font-size: 30px;");
        plusBtn.setOnAction(event -> {
            viewModel.calculation(textArea.getText(),"+");
            textArea.clear();
        });
        Button cBtn = new Button("C");
        cBtn.setMinSize(100, 100);
        cBtn.setStyle("-fx-font-size: 30px;");
        cBtn.setOnAction(event -> {
            textArea.clear();
            textArea.setText("0");
            hasPoint = false;
        });
        thirdLine.getChildren().addAll(plusBtn, cBtn);
    }
    private void initZeroLine(){
        Button zeroBtn = new Button("0");
        zeroBtn.setMinSize(100,100);
        zeroBtn.setStyle("-fx-font-size: 30px;");
        zeroBtn.setOnAction(event->{
            if (textArea.getLength() >= 2 ){
                textArea.appendText("0");
            }
        });
        Button zapBtn = new Button(".");
        zapBtn.setMinSize(100,100);
        zapBtn.setStyle("-fx-font-size: 30px;");
        zapBtn.setOnAction(event->{
            if (hasPoint == false) {
                textArea.appendText(".");
            }
            hasPoint = true;
        });
        Button resultBtn = new Button("=");
        resultBtn.setMinSize(100,100);
        resultBtn.setStyle("-fx-font-size: 30px;");
        resultBtn.setOnAction(event->{
            viewModel.calculation(textArea.getText(), "=");
            textArea.setText(viewModel.getSavedValue());
            viewModel.setSavedValue("0");
        });
        Button multiplyBtn = new Button("*");
        multiplyBtn.setMinSize(100, 100);
        multiplyBtn.setStyle("-fx-font-size: 30px;");
        multiplyBtn.setOnAction(event -> {
            viewModel.calculation(textArea.getText(),"*");
            textArea.clear();
        });
        Button squareBtn = new Button("x²");
        squareBtn.setMinSize(100, 100);
        squareBtn.setStyle("-fx-font-size: 30px;");
        squareBtn.setOnAction(event -> {
            double a = 0;
            a = Double.parseDouble(textArea.getText());
            textArea.clear();
            textArea.setText( Double.toString(a * a));
            hasPoint = false ;
        });
        zeroLine.getChildren().addAll(zeroBtn,zapBtn,resultBtn, multiplyBtn, squareBtn);
    }
}

