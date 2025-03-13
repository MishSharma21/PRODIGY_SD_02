import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Task1 extends Application {

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Temperature Converter");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(40, 40, 40, 40));

        grid.setStyle("-fx-background-color:linear-gradient(to bottom,skyblue,pink);");

        Label tempLabel = new Label("Enter temperature:");
        tempLabel.setStyle("-fx-font-weight: bold;");
        grid.add(tempLabel, 0, 0);

        TextField tempInput = new TextField();
        tempInput.setPromptText("Temperature");
        grid.add(tempInput, 1, 0);

        Label unitLabel = new Label("Select unit (K, C, F):");
        unitLabel.setStyle("-fx-font-weight: bold;");
        grid.add(unitLabel, 0, 1);

        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("K", "C", "F");
        unitComboBox.setValue("K"); 
        grid.add(unitComboBox, 1, 1);

        Button convertButton = new Button("Convert");
        convertButton.setStyle("-fx-font-weight: bold;");
        grid.add(convertButton, 1, 2);

        Label resultLabel = new Label();
        grid.add(resultLabel, 0, 3, 2, 1);

        convertButton.setOnAction(e -> {
            try {
                double temp = Double.parseDouble(tempInput.getText());
                String unit = unitComboBox.getValue();
                String result = "";

                if (unit.equals("K")) 
                {
                    double celsius = temp - 273.15;
                    double fahrenheit = (celsius * 9.0 / 5.0) + 32;
                    result = String.format("The Temperature from :\nKelvin to Celsius: %.2f\nKelvin to Fahrenheit: %.2f", celsius, fahrenheit);
                } 
                else if (unit.equals("C")) 
                {
                    double kelvin = temp + 273.15;
                    double fahrenheit = (temp * 9.0 / 5.0) + 32;
                    result = String.format("The Temperature from :\nCelsius to Kelvin: %.2f\nCelsius to Fahrenheit: %.2f", kelvin, fahrenheit);
                } 
                else if (unit.equals("F")) 
                {
                    double celsius = (temp - 32) * 5.0 / 9.0;
                    double kelvin = celsius + 273.15;
                    result = String.format("The Temperature from :\nFahrenheit to Celsius: %.2f\nFahrenheit to Kelvin: %.2f", celsius, kelvin);
                }

                resultLabel.setText(result);
            } 
            catch (NumberFormatException ex) 
            {
                resultLabel.setText("Invalid temperature input. Please enter a valid number.");
            }
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}

