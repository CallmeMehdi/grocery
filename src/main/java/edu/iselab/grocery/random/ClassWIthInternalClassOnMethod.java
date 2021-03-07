package edu.iselab.grocery.random;

import java.util.HashMap;
import java.util.Map;

public class ClassWIthInternalClassOnMethod<K> {

    public Map<K, K> getNewInstance() {

        class ValuesImpl extends HashMap<K, K> {

            private static final long serialVersionUID = -6699582558783270354L;

            public int getMax() {
                return 10;
            }
        }

        return new ValuesImpl();
    }
}
