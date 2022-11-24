package com.example.invoice.commons;

public class ER {
    public static final String MESSAGE_COMP_JSON="Wrong json fields or null values!The count of fields must be exactly one and the name of the fields must be 'name',with value of any string characters and must be not null!";
    public static final String MESSAGE_INDIVID_ID_1="The format of  id is not valid, it must be positive number bigger then zero!";
    public static final String MESSAGE_INDIVID_ID_2="Individual with id=%d does not exist";
    public static final String MESSAGE_COMP_ID_1="The format of reference id is not valid, it must be positive number bigger then zero!";
    public static final String MESSAGE_COMP_ID_2="Company with id=%d does not exist";
    public static final String MESSAGE_INDIVID_JSON="Wrong json fields or null values!The count of fields must be exactly three and the name of the fields must be 'name','type','companyId with value of any string characters and must be not null!";
    public static final String MESSAGE_VALID_NAME="The name must consist first and last name each more then two characters long!";
    public static final String MESSAGE_PERSON_TYPE="Type of person must be legal or natural!";
    public static final String MESSAGE_INVOICE_ID_1="The format of reference id is not valid, it must be positive number bigger then zero!";
    public static final String MESSAGE_INVOICE_ID_2="Invoice with id=%d does not exist";
    public static final String MESSAGE_INVOICE_JSON="Wrong json fields or null values!The count of fields must be exactly three and the name of the fields must be 'individId','amount','date'with value of any string characters and must be not null!";
    public static final String MESSAGE_VALID_SUM="The format of sum is not valid, it must be positive number with two decimal places precision bigger then zero!";
    public static final String MESSAGE_VALID_DATE="The format of the date is not valid,it must be MM/DD/YYYY.According to Gregorian calendar!";
    public static final String MESSAGE_VALID_REF_ID_1="The format of reference id is not valid, it must be positive number bigger then zero!";
    public static final String MESSAGE_VALID_REF_ID_2="Reference with id=%d does not exist";
    public static final String MESSAGE_VALID_REF_ID_3="Reference with id=%d already exist,you can do update";
    public static final String MESSAGE_REF_JSON="Wrong json fields or null values!The count of fields must be exactly two and the name of the field must be 'ref','individId'with value of any string characters and must be not null!";
    public static final String MESSAGE_REF_REQ_JSON="Wrong json fields or null values!The count of fields must be exactly one and the name of the field must be 'individId'with value of any string characters and must be not null!";
    public static final String MESSAGE_VALID_PARAM_1="Not valid param!";
    public static final String MESSAGE_VALID_PARAM_2="Param with value=%s does not exist!Available params-ref,amount,date";

}
