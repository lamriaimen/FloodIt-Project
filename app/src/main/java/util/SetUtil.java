package util;

import java.util.NoSuchElementException;
import java.util.Set;

public class SetUtil {
    public static <T> T anyElement(Set<T> elements){
        return elements.stream().findAny().orElseThrow(NoSuchElementException::new);
    }
}
