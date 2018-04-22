package testSerialize;
/*
 *   Created by zview@qq.com on 18-4-15.
 */

import java.io.Serializable;

public class Address implements Serializable {

    String city;

    public Address(String city) {
        this.city = city;
    }
}
