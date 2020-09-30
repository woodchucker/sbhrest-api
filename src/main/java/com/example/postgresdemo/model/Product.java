package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product extends AuditModel {
    private Long product_id;
    @Id
    @Column(name="product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getproduct_id() {
        return this.product_id;
    }

    public void setproduct_id(Long product_id) {
        this.product_id = product_id;
    }
    private String product_name;
    public String getproduct_name()
    {
            return this.product_name;
    }
    public void setproduct_name(String value)
    {
            this.product_name = value;
    }

    private String description;
    public String getdescription()
    {
            return this.description;
    }
    public void setdescription(String value)
    {
            this.description = value;
    }

    private java.math.BigDecimal price;
    public java.math.BigDecimal getprice()
    {
            return this.price;
    }
    public void setprice(java.math.BigDecimal value)
    {
            this.price = value;
    }

    private int duration_days;
    public int getduration_days()
    {
            return this.duration_days;
    }
    public void setduration_days(int value)
    {
            this.duration_days = value;
    }

    private java.sql.Date locked_at;
    public java.sql.Date getlocked_at()
    {
            return this.locked_at;
    }
    public void setlocked_at(java.sql.Date value)
    {
            this.locked_at = value;
    }
    private java.sql.Date unlocked_at;
    public java.sql.Date getunlocked_at()
    {
            return this.unlocked_at;
    }
    public void setunlocked_at(java.sql.Date value)
    {
            this.unlocked_at = value;
    }
}