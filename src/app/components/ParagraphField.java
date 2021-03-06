/*
 * The MIT License
 *
 * Copyright 2017 Contributors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package app.components;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import static app.Partials.NORMAL;

public class ParagraphField extends Input {

    private int inputSize = NORMAL;

    private TextArea input;

    public ParagraphField(String inputName) {
        super(inputName, NORMAL);
        this.render();
    }

    public ParagraphField(String inputName, int inputSize) {
        super(inputName, inputSize);
        this.inputSize = inputSize;
        this.render();
    }

    private void render() {
        //Input field
        input = new TextArea();
        input.getStyleClass().add("input");
        input.setMinWidth(inputSize);
        input.setMaxWidth(inputSize);
        input.setMinHeight(250);
        input.setMaxHeight(250);
        input.setWrapText(true);

        input.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                    if (!newValue)
                        onBlur();
                });

        //Adding to the grid pane
        GridPane.setConstraints(input, 0, 1);
        GridPane.setMargin(input, new Insets(0, 0, 3, 0));
        inputFieldContainer.getChildren().add(input);
    }

    /*
 Returns the input's value
 */
    public String getValue() {
        return input.getText();
    }

    public void setValue(String value) {
        input.setText(value);
    }

    public void clear() {
        input.setText("");
    }

    /*
     When the user lose focus on an input it will validate the value
     */
    private void onBlur() {
        //TODO

        String message; //Call the validation message validate(getValue(), text)

        /*
         If there is an error message the input field will be highlighted
         else it will set it to normal
         */
        /*
        if (message != "true") {
            markAsDanger(message);
        } else {
            markAsNormal();
        }*/
    }

    public GridPane getParagraphField() {
        return inputFieldContainer;
    }
}
