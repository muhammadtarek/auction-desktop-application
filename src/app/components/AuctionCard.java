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

import app.Navigator;
import app.views.AuctionView;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import models.*;

import static app.Partials.*;
import java.text.DecimalFormat;

import java.util.Objects;

import models.Buyer;

public class AuctionCard extends Card {

    private final int viewType;
    private Auction auction;

    private GridPane itemNameAndButtonContainer;
    private Label itemName;
    private SubscribeButton subscribeButton;
    private Label currentBid;
    private Label auctionStatus;

    private UserDetails userDetails;

    private Boolean userSubscribed;
    private DecimalFormat decimalFormat;

    public AuctionCard(int viewType, Auction auction) {
        super();
        this.viewType = viewType;
        this.auction = auction;
        this.render();
    }

    private void render() {
        //Item photo
        photo = ImageUtils.cropAndConvertImage(auction.getItem().getItemPhotos().get(0).getImage(), 250, 175);
        photoViewer.setFill(new ImagePattern(photo));

        //Item name
        itemName = new Label(auction.getItem().getName());
        itemName.getStyleClass().add("item-name");

        itemName.setOnMouseClicked(e -> {
            Navigator.viewPage(AUCTION_VIEW, auction.getItem().getName());
            AuctionView.getInstance().fillAuctionData(Auction.getAuction(auction.getId()));
        });

        //Subscribe button
        if (viewType == BUYER) {
            subscribeButton = new SubscribeButton(auction.getId());

            if (auction.getFollowers() != null) {
                for (Buyer buyer : auction.getFollowers()) {
                    if (Objects.equals(buyer.getId(), currentBuyer.getId())) {
                        subscribeButton.markAsSubscribed();
                    }
                }
            }
        }

        //Item and button container
        itemNameAndButtonContainer = new GridPane();
        itemNameAndButtonContainer.setMaxWidth(220);

        ColumnConstraints itemColumn = new ColumnConstraints();
        itemColumn.setPercentWidth(85);

        ColumnConstraints buttonColumn = new ColumnConstraints();
        buttonColumn.setPercentWidth(15);
        buttonColumn.setHalignment(HPos.RIGHT);

        itemNameAndButtonContainer.getColumnConstraints().addAll(itemColumn, buttonColumn);

        GridPane.setConstraints(itemName, 0, 0);
        itemNameAndButtonContainer.getChildren().add(itemName);

        if (viewType == BUYER) {
            GridPane.setConstraints(subscribeButton.getSubscribeButton(), 1, 0);
            itemNameAndButtonContainer.getChildren().add(subscribeButton.getSubscribeButton());
        }

        //Current bid
        decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(2);
        currentBid = new Label(decimalFormat.format(auction.getHighestPrice()) + "$");
        currentBid.getStyleClass().add("item-bid");

        //Auction status
        auctionStatus = new Label(auction.getAuctionStatus().toUpperCase());
        auctionStatus.getStyleClass().add("auction-status");

        //If is the card for the buyer show seller info
        if (viewType == BUYER) {
            userDetails = new UserDetails(FIT_CONTAINER, auction.getSeller().getName(),
                    auction.getSeller().getPhoto(),
                    auction.getUserID());
        }

        //Auction details container
        cardDetails = new GridPane();
        cardDetails.setPadding(new Insets(10, 0, 0, 0));

        GridPane.setConstraints(itemNameAndButtonContainer, 0, 0);
        GridPane.setMargin(itemNameAndButtonContainer, new Insets(0, 15, 2, 15));

        GridPane.setConstraints(currentBid, 0, 1);
        GridPane.setMargin(currentBid, new Insets(1, 15, 4, 15));

        GridPane.setConstraints(auctionStatus, 0, 2);
        GridPane.setMargin(auctionStatus, new Insets(1, 15, ((viewType == BUYER) ? 4 : 10), 15));

        cardDetails.getChildren().addAll(itemNameAndButtonContainer, currentBid, auctionStatus);

        if (viewType == BUYER) {
            GridPane.setConstraints(userDetails.getUserDetails(), 0, 3);
            cardDetails.getChildren().add(userDetails.getUserDetails());
        }

        //Auction card container
        cardContainer.setBottom(cardDetails);
    }

    public BorderPane getCard() {
        return cardContainer;
    }
}
