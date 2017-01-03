/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.app.gigj.mvp.views.core;

public interface View {
    void showLoadingView();
    void hideLoadingView();
    void onError(String errorCode, String errorMsg);
}
