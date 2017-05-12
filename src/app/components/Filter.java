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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static app.Partials.*;

public class Filter {

    private static Filter instance;

    private GridPane filterContainer;
    private Label headline;
    private InputField priceField;
    private DropdownField auctionStatusField;
    private InputField numberOfBidsField;

    private Filter() {
        this.render();
    }

    private void render() {
        //Filter headline
        headline = new Label("Filter:");
        headline.getStyleClass().add("headline--category");

        //Filter fields
        priceField = new InputField("Maximum price", TEXT, SHORT, HIDE_ERROR_MESSAGE);
        //auctionStatusField = new DropdownField("Auction Status", SHORT, HIDE_ERROR_MESSAGE, "All", "Active", "Not started");
        auctionStatusField.setDefaultSelect();
        numberOfBidsField = new InputField("Number of bidders", NUMBER, SHORT, HIDE_ERROR_MESSAGE);

        //Filter container
        filterContainer = new GridPane();
        filterContainer.setHgap(30);
        filterContainer.setAlignment(Pos.CENTER);
        filterContainer.setPadding(new Insets(10));
        filterContainer.getStyleClass().add("filter");

        GridPane.setConstraints(headline, 0, 0);
        GridPane.setConstraints(priceField.getInputField(), 1, 0);
        GridPane.setConstraints(auctionStatusField.getDropdownField(), 2, 0);
        GridPane.setConstraints(numberOfBidsField.getInputField(), 3, 0);

        filterContainer.getChildren().addAll(headline,
                                             priceField.getInputField(),
                                             auctionStatusField.getDropdownField(),
                                             numberOfBidsField.getInputField());
    }

    public GridPane getFilter() {
        return filterContainer;
    }

    public static Filter getInstance() {
        if (instance == null) {
            instance = new Filter();
        }
        return instance;
    }
    
}
