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
package models;

import java.util.ArrayList;

public class Seller extends User implements IAuctionInterface {

    private ArrayList<Auction> auctions;
    
    public void createAuction() {
        // TODO
    }

    public boolean deleteAuction(int id) {
        try{
            Auction auction = auctions.stream().filter(a -> a.getId() == id).findFirst().get();
            Model.delete(Auction.class, auction.getId());
            auctions.remove(auction);
            return true;
        }catch(Exception e)
        {
            
        }
        return false;
    }

    public void updateAuction() {
        // TODO
    }

    public void addItemToInventory() {
        // TODO
    }

    public void deleteItemFromInventory() {
        // TODO
    }

    public void updateItemInInventory() {
        // TODO
    }

    public int getFollowersNumber() {
        return Model.count(SubscribeSeller.class, "SelleID = ?", this.getId());
    }
 
    public static Seller getSellerData(int sellerId) {
        return Model.find(Seller.class, sellerId);
    }

    @Override
    public ArrayList<Auction> search(String query) {
        // TODO
        return null;
    }

    @Override
    public ArrayList<Auction> getAuction() {
        if (auctions == null) {
            auctions = new ArrayList<>(Model.find(Auction.class, "UserID = ?", this.getId()));
        }
        return auctions;
    }

}