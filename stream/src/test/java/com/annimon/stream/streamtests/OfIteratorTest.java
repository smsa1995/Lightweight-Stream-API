package com.annimon.stream.streamtests;

import com.annimon.stream.Functions;
import com.annimon.stream.Stream;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.Test;
import static com.annimon.stream.test.hamcrest.StreamMatcher.assertElements;
import static org.hamcrest.Matchers.is;

public final class OfIteratorTest {

    @Test
    public void testStreamOfIterator() {
        Stream.of(Functions.counterIterator())
                .limit(5)
                .custom(assertElements(is(Arrays.asList(
                      0, 1, 2, 3, 4
                ))));
    }

    @Test(expected = NullPointerException.class)
    public void testStreamOfIteratorNull() {
        Stream.of((Iterator<?>)null);
    }
}
