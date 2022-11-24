

package com.example.invoice.commons;

import com.example.invoice.dao.companies.IcompaniesDoa;
import com.example.invoice.dao.individual.IindividualDoa;
import com.example.invoice.dao.invoices.IinvoicesDoa;
import com.example.invoice.dao.references.IreferencesDoa;
import com.example.invoice.dto.ReferenceRequestUpdate;
import com.example.invoice.exceptions.GlobalException;
import com.example.invoice.models.Company;
import com.example.invoice.models.Individual;
import com.example.invoice.models.Invoice;
import com.example.invoice.models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {
    private final IcompaniesDoa companiesDoa;
    private final IindividualDoa individualDoa;
    private final IreferencesDoa referencesDoa;
    private final IinvoicesDoa invoicesDoa;

    @Autowired
    public Validator(IcompaniesDoa companiesDoa, IindividualDoa individualDoa, IreferencesDoa referencesDoa, IinvoicesDoa invoicesDoa) {
        this.companiesDoa = companiesDoa;
        this.individualDoa = individualDoa;
        this.referencesDoa = referencesDoa;
        this.invoicesDoa = invoicesDoa;
    }

    public static void notValidJSONObject(Company companies) {
        if (companies.getName() == null) {
            throw new GlobalException(ER.MESSAGE_COMP_JSON);
        }
    }

    public Company isValid(Company company) {
        notValidJSONObject(company);
        return company;
    }

    public Company isValid(String id, Company company) {
        notValidJSONObject(company);
        company.setCompanyId(this.notValidCompanyId(id));
        return company;
    }

    public Individual isValid(Individual individual) {

        this.notValidJSONObject(individual);
        this.notValidName(individual.getName());
        this.notValidType(individual.getType());
        this.notValidCompanyId(individual.getCompanyId().toString());
        return individual;
    }

    public Individual isValid(String id, Individual individual) {
        this.notValidJSONObject(individual);
        this.notValidCompanyId(individual.getCompanyId().toString());
        individual.setIndividId(this.notValidIndividId(id));
        this.notValidName(individual.getName());
        return individual;
    }

    public long notValidIndividId(String id) {
        if (this.notValidReqId(id)) {
            throw new GlobalException(ER.MESSAGE_INDIVID_ID_1);
        } else {
            long idDAO = Long.parseLong(id);
            if (!this.individualDoa.isValidIndividId(idDAO)) {
                throw new GlobalException(String.format(ER.MESSAGE_INDIVID_ID_2, idDAO));
            } else {
                return idDAO;
            }
        }
    }

    public long notValidCompanyId(String id) {
        if (this.notValidReqId(id)) {
            throw new GlobalException(ER.MESSAGE_COMP_ID_1);
        } else {
            long idDAO = Long.parseLong(id);
            if (!this.companiesDoa.isValidCompanyId(idDAO)) {
                throw new GlobalException(String.format(ER.MESSAGE_COMP_ID_2, idDAO));
            } else {
                return idDAO;
            }
        }
    }

    public void notValidJSONObject(Individual individual) {
        if (individual.getName() == null || individual.getType() == null || individual.getCompanyId() == null) {
            throw new GlobalException(ER.MESSAGE_INDIVID_JSON);
        }
    }

    private void notValidName(String name) {

        Pattern pattern = Pattern.compile(PATTERN.NAME, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) {
            throw new GlobalException(ER.MESSAGE_VALID_NAME);
        }
    }

    private void notValidType(String type) {

        Pattern pattern = Pattern.compile(PATTERN.TYPE, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(type);
        if (!matcher.find()) {
            throw new GlobalException(ER.MESSAGE_PERSON_TYPE);
        }
    }

    public Invoice isValid(Invoice invoice) {
        this.notValidJSONObject(invoice);
        this.notValidIndividId(invoice.getIndividId().toString());
        this.notValidReqSum(invoice.getAmount().toString());
        this.notValidDate(invoice.getDate());
        return invoice;
    }

    public Invoice isValid(String id, Invoice invoice) {
        this.notValidJSONObject(invoice);
        invoice.setInvoiceId(this.notValidInvoiceId(id));
        this.notValidIndividId(invoice.getIndividId().toString());
        this.notValidReqSum(invoice.getAmount().toString());
        this.notValidDate(invoice.getDate());
        return invoice;
    }

    private boolean notValidReqId(String id) {

        Pattern pattern = Pattern.compile(PATTERN.ID, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(id);
        return !matcher.find();
    }

    public long notValidInvoiceId(String id) {
        if (this.notValidReqId(id)) {
            throw new GlobalException(ER.MESSAGE_INVOICE_ID_1);
        } else {
            long idDAO = Long.parseLong(id);
            if (!this.invoicesDoa.isValidInvoiceId(idDAO)) {
                throw new GlobalException(String.format(ER.MESSAGE_INVOICE_ID_2, idDAO));
            } else {
                return idDAO;
            }
        }
    }

    public void notValidJSONObject(Invoice invoice) {
        if (invoice.getIndividId() == null || invoice.getDate() == null || invoice.getAmount() == null) {
            throw new GlobalException(ER.MESSAGE_INVOICE_JSON);
        }
    }

    public void notValidReqSum(String id) {

        Pattern pattern = Pattern.compile(PATTERN.SUM, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(id);
        if (!matcher.find()) {
            throw new GlobalException(ER.MESSAGE_VALID_SUM);
        }
    }

    private void notValidDate(String date) {

        Pattern pattern = Pattern.compile(PATTERN.DATE, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(date);
        if (!matcher.find()) {
            throw new GlobalException(ER.MESSAGE_VALID_DATE);
        }
    }

    public long notValidRefId(String id) {
        if (this.notValidReqId(id)) {
            throw new GlobalException(ER.MESSAGE_VALID_REF_ID_1);
        } else {
            long idDAO = Long.parseLong(id);
            if (!this.referencesDoa.isValidRefId(idDAO)) {
                throw new GlobalException(String.format(ER.MESSAGE_VALID_REF_ID_2, idDAO));
            } else {
                return idDAO;
            }
        }
    }

    private void notValidRefIdCreate(String id) {
        if (this.notValidReqId(id)) {
            throw new GlobalException(ER.MESSAGE_VALID_REF_ID_1);
        } else {
            long idDAO = Long.parseLong(id);
            if (this.referencesDoa.isValidRefId(idDAO)) {
                throw new GlobalException(String.format(ER.MESSAGE_VALID_REF_ID_3, idDAO));
            }
        }
    }

    public void notValidJSONObject(Reference reference) {
        if (reference.getRef() == null || reference.getIndividId() == null) {
            throw new GlobalException(ER.MESSAGE_REF_JSON);
        }
    }

    public void notValidJSONObject(ReferenceRequestUpdate referenceRequest) {
        if (referenceRequest.getIndividId() == null) {
            throw new GlobalException(ER.MESSAGE_REF_REQ_JSON);
        }
    }

    public Reference isValid(Reference reference) {
        this.notValidJSONObject(reference);
        this.notValidRefIdCreate(reference.getRef().toString());
        this.notValidIndividId(reference.getIndividId().toString());
        return reference;
    }

    public Reference isValid(String id, ReferenceRequestUpdate reference) {
        Reference ref = new Reference();
        this.notValidJSONObject(reference);
        ref.setRef(this.notValidRefId(id));
        ref.setIndividId(this.notValidIndividId(reference.getIndividId()));
        return ref;
    }

    public String val(String param, String val) {
        switch (param) {
            case "ref":
                this.notValidRefId(val);
                break;
            case "date":
                val = String.format("TO_DATE('%s','YYYY-MM-DD')", val);
                break;
            case "type":
                this.notValidType(val);
                val = String.format("'%s'", val);
                break;
            default:
                if (!param.equals("amount")) {
                    throw new GlobalException(ER.MESSAGE_VALID_PARAM_1);
                }

                this.notValidReqSum(val);
                break;
        }

        return val;
    }

    public String notValidParam(String param) {
        if (!TableColumns.getValues().contains(param)) {
            throw new GlobalException(String.format(ER.MESSAGE_VALID_PARAM_2, param));
        } else {
            return param;
        }
    }
}
