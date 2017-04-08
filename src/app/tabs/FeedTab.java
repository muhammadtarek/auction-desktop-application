/*
 * The MIT License
 *
 * Copyright 2017 Muhammad.
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

package app.tabs;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class FeedTab extends  GridView {

    private static FeedTab instance;

    private BorderPane feedPageContainer;

    private FeedTab() {
        super();
        this.render();
    }

    private void render() {
        //Explore tab container
        feedPageContainer = new BorderPane();
        feedPageContainer.setTop(tabScrollbar);
        feedPageContainer.setMargin(tabScrollbar, new Insets(20,0,20,0));
    }

    public BorderPane getFeedTab() {
        return feedPageContainer;
    }

    public static FeedTab getInstance() {
        if (instance == null) {
            instance = new FeedTab();
        }
        return instance;
    }
}
