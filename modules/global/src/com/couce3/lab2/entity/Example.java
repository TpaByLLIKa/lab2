package com.couce3.lab2.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "LAB2_EXAMPLE")
@Entity(name = "lab2_Example")
@NamePattern("%s %s|strProp,bigDecProp")
public class Example extends StandardEntity {
    private static final long serialVersionUID = 1738268403088105310L;

    @Column(name = "str_prop")
    public String strProp;

    @Column(name = "big_dec_prop")
    public BigDecimal bigDecProp;

    public String getStrProp() {
        return strProp;
    }

    public void setStrProp(String strProp) {
        this.strProp = strProp;
    }

    public BigDecimal getBigDecProp() {
        return bigDecProp;
    }

    public void setBigDecProp(BigDecimal bigDecProp) {
        this.bigDecProp = bigDecProp;
    }
}