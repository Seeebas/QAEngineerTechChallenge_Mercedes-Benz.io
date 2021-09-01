package com.helpers.constants;

public final class ConstantsUIElements {

    //VALUES
    public static final String TOPMENU_OURCARS_VALUE ="Our Cars";
    public static final String HATCHBACKS = "Hatchbacks";

    //IFRAMES
    public static final String MAIN_FRAME_ID = "vmos-cont";

    //SHADOWROOT
    public static final String SHADOWROOT_TAGNAME_ACCEPTCOOKIES = "cmm-cookie-banner";
    public static final String QUERY_CSSSELECTOR_FOR_ACCEPTALLCOOKIES = "return document.querySelector('cmm-cookie-banner').shadowRoot.querySelector('div.button-wrapper:nth-child(1) > button:nth-child(2)')";

    //SPAN
    public static final String SPAN_TEXT_EQUAL_TO = "//span[text()='{value}']";
    public static final String MOUSE_HOVER_CARTYPE_BY_SPAN = "//span[contains(text(),'{value}')]";
    public static final String SPAN_LEFT_CAR_TYPES = "//span[@class='vmos_1nZ_z' and text()='{value}']";

    //CONTAINS
    public static final String CONTAINS_A_VALUE = "//a[contains(text(),'{value}')]";
    public static final String CONTAINS_LEGEND_VALUE = "//legend[contains(text(),'{value}')]";

    //INPUT
    public static final String LABEL_CONTAINS_AND_INPUT = "//label[contains(text(),' {value} ')]//input";

    //Static values
    public static final String DIV_TOTAL_CAR_STATIC = "//div[@class='cc-motorization-comparsion-status__info-text']";
    public static final String TOTAL_CAR_PAGINATION_STATIC = "//div[@class='cc-motorization-header__price cc-text ng-star-inserted']";

    public static final String INNER_TEXT = "innerText";
    public static final String POUNDS_SIGN = "£";

}
