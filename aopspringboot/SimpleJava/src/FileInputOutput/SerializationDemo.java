package FileInputOutput;

import java.io.Serializable;

public class SerializationDemo implements Serializable {
    int i;
    transient int j;
}
