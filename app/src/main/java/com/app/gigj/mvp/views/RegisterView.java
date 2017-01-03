package com.app.gigj.mvp.views;

import com.app.gigj.domin.entities.Address;
import com.app.gigj.domin.entities.Company;
import com.app.gigj.mvp.views.core.View;

import java.util.ArrayList;

/**
 * Created by duanlei on 16/12/31.
 */

public interface RegisterView extends View {
    void onProvinceSuccess(ArrayList<Address> addresses);

    void onCitySuccess(ArrayList<Address> addresses);

    void onCompanySuccess(ArrayList<Company> companies);
}
