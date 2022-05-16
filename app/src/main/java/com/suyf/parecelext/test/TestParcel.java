package com.suyf.parecelext.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;

public class TestParcel implements Parcelable {

    private static String TAG1 = "TAG1";
    private static final String TAG2 = "TAG2";

    private int age;
    public int age33 = 10;
    public int age3 = 10;
    public int a2ge = 10;
    public int ag4e = 10;
    public int agrfe = 10;

    public transient String name;
    public String naeme1 = "name";
    public String nawme1 = "name";
    public String naesme1 = "name";
    public String nadme1 = "name";
    public String nafme1 = "name";
    public String na5me1 = "name";
    public String nam4e1 = "name";
    public static String nam2e1 = "name";
    public String nam3e1 = "name";
    public String na4me1 = "name";
    public String nam3fe1 = "nanxbcnme";
    public static final String nam2ge1 = "naterwtme";
    public String na2me1 = "nadfsgme";
    public String nam2se1 = "navzcvgme";
    public String name31 = "nanbnme";
    public String name21 = "nagasgme";
    public String naffme1 = "nbxbvxcame";
    public String na5sme1 = "nacbbxcbme";
    public String naem4e1 = "nadfgbxvme";
    public String namf2e1 = "na43gme";
    public String nawqm3e1 = "na34535me";
    public String naw4me1 = "namreqwrwe";
    public String narrwm3fe1 = "nagfgfdsgrme";
    public String najttm2ge1 = "naeterme";
    public String nah2me1 = "navgfggsgme";
    public String nahgm2se1 = "name";
    public String nagme31 = "name";
    public transient String namdfe21 = "name";

    protected String address;

    public TestParcel() {
    }

    protected TestParcel(Parcel in) {
        age = in.readInt();
        age33 = in.readInt();
        age3 = in.readInt();
        a2ge = in.readInt();
        ag4e = in.readInt();
        agrfe = in.readInt();
        naeme1 = in.readString();
        nawme1 = in.readString();
        naesme1 = in.readString();
        nadme1 = in.readString();
        nafme1 = in.readString();
        na5me1 = in.readString();
        nam4e1 = in.readString();
        nam3e1 = in.readString();
        na4me1 = in.readString();
        nam3fe1 = in.readString();
        na2me1 = in.readString();
        nam2se1 = in.readString();
        name31 = in.readString();
        name21 = in.readString();
        naffme1 = in.readString();
        na5sme1 = in.readString();
        naem4e1 = in.readString();
        namf2e1 = in.readString();
        nawqm3e1 = in.readString();
        naw4me1 = in.readString();
        narrwm3fe1 = in.readString();
        najttm2ge1 = in.readString();
        nah2me1 = in.readString();
        nahgm2se1 = in.readString();
        nagme31 = in.readString();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        long currentTimeMillis = System.nanoTime();
        dest.writeInt(age);
        dest.writeInt(age33);
        dest.writeInt(age3);
        dest.writeInt(a2ge);
        dest.writeInt(ag4e);
        dest.writeInt(agrfe);
        dest.writeString(naeme1);
        dest.writeString(nawme1);
        dest.writeString(naesme1);
        dest.writeString(nadme1);
        dest.writeString(nafme1);
        dest.writeString(na5me1);
        dest.writeString(nam4e1);
        dest.writeString(nam3e1);
        dest.writeString(na4me1);
        dest.writeString(nam3fe1);
        dest.writeString(na2me1);
        dest.writeString(nam2se1);
        dest.writeString(name31);
        dest.writeString(name21);
        dest.writeString(naffme1);
        dest.writeString(na5sme1);
        dest.writeString(naem4e1);
        dest.writeString(namf2e1);
        dest.writeString(nawqm3e1);
        dest.writeString(naw4me1);
        dest.writeString(narrwm3fe1);
        dest.writeString(najttm2ge1);
        dest.writeString(nah2me1);
        dest.writeString(nahgm2se1);
        dest.writeString(nagme31);
        dest.writeString(address);
        Log.d("Suyf", "writeToParcel耗时ns: " + (System.nanoTime() - currentTimeMillis));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestParcel> CREATOR = new Creator<TestParcel>() {
        @Override
        public TestParcel createFromParcel(Parcel in) {
            long currentTimeMillis = System.nanoTime();
            TestParcel testParcel = new TestParcel(in);
            Log.d("Suyf", "readParcel耗时ns: " + (System.nanoTime() - currentTimeMillis));
            return testParcel;
        }

        @Override
        public TestParcel[] newArray(int size) {
            return new TestParcel[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
