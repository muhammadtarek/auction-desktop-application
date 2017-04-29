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

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Card {

    BorderPane cardContainer;
    private Label pictureView;
    private Rectangle pictureClipper;

    GridPane cardDetails;

    Card() {
        this.render();
    }

    private void render() {
        //Item picture
        pictureClipper = new Rectangle(250, 175);
        pictureClipper.setArcWidth(5);
        pictureClipper.setArcHeight(5);

        pictureView = new Label();
        pictureView.getStyleClass().add("item-image");
        pictureView.setClip(pictureClipper);

        //Card container
        cardContainer = new BorderPane();
        cardContainer.getStyleClass().addAll("card", "small-card");
        cardContainer.setTop(pictureView);
    }

    protected void setPictureView() {
        // TODO
    }
}
