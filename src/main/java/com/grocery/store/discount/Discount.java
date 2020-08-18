package com.grocery.store.discount;

import com.grocery.store.entity.SiteUser;
import com.grocery.store.enums.UserTypeEnum;

public abstract class Discount {

    SiteUser userType;

    //Discount(UserTypeEnum )

    public abstract double getDiscount();
}

class StaffDiscount extends Discount {

    @Override
    public double getDiscount() {
        return 0;
    }
}

class AffiliateDiscount extends Discount {

    @Override
    public double getDiscount() {
        return 0;
    }
}

class LoyalCustomerDiscount extends Discount {

    @Override
    public double getDiscount() {
        return 0;
    }
}
