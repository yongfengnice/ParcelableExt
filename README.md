# ParcelableExt
ParcelableExt is to make Parcelable be use easily as like as use Serializable.

usage: just implements ParcelableExt instead of implements Parcelable,and needn't to do any more!
~~~
//just implements ParcelableExt:
public class TestParam implements ParcelableExt {
    private static String TAG = "TAG";
    private int age;
    public transient String name;
    public String address = "address";
}
~~~
