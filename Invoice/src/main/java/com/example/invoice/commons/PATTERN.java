package com.example.invoice.commons;

public class PATTERN {
    public final static String NAME="^[A-Z][a-z]{2,} [A-Z][a-z]{2,}$";
    public final static String TYPE="^legal$|^natural$";
    public final static String ID="^[1-9]([0-9]+)?$";
    public final static String SUM="(^[1-9][0-9]+([.][0-9]{2}))|(^[0]([.][0-9][1-9]))$";
    public final static String DATE="^(((\\d\\d)(([02468][048])|([13579][26]))-02-29)|(((\\d\\d)(\\d\\d)))-((((0\\d)|(1[0-2]))-((0\\d)|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))\\s(([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d))$";

}
