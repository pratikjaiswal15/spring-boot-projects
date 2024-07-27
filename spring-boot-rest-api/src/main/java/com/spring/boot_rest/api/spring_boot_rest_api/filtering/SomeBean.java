package com.spring.boot_rest.api.spring_boot_rest_api.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties({"value1", "value3"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;

//    @JsonIgnore
    private String field2;
    private String field3;
    private String field4;


    public SomeBean(String value1, String value2, String value3, String value4) {
        this.field1 = value1;
        this.field2 = value2;
        this.field3 = value3;
        this.field4 = value4;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public String getField4() {
        return field4;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "value1='" + field1 + '\'' +
                ", value2='" + field2 + '\'' +
                ", value3='" + field3 + '\'' +
                ", value4='" + field4 + '\'' +
                '}';
    }
}
