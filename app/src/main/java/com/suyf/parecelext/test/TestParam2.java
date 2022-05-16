package com.suyf.parecelext.test;

import com.suyf.parecelext.core.ParcelableExt;

public class TestParam2 implements ParcelableExt {

    private String name;

    private TestParam testParam;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestParam getTestParam() {
        return testParam;
    }

    public void setTestParam(TestParam testParam) {
        this.testParam = testParam;
    }
}
