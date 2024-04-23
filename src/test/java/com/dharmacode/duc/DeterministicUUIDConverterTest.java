package com.dharmacode.duc;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeterministicUUIDConverterTest {

    private static final Long TEST_ID = 1L;
    private static final String TEST_SEED = "lXpiPA3sZ3HMTo4o";
    private static final int SEQUENCE_LENGTH = 10;

    @Test
    public void testIsDeterministicWithoutSeed() {
        DeterministicUUIDConverter converter = new DeterministicUUIDConverter();
        UUID uuid1 = converter.convert(TEST_ID);
        UUID uuid2 = converter.convert(TEST_ID);
        assertEquals(uuid1, uuid2);
        System.out.println(uuid1);
    }

    @Test
    public void testIsDeterministicWithSeed() {
        DeterministicUUIDConverter converter = new DeterministicUUIDConverter(TEST_SEED);
        UUID uuid1 = converter.convert(TEST_ID);
        UUID uuid2 = converter.convert(TEST_ID);
        assertEquals(uuid1, uuid2);
        System.out.println(uuid1);
    }

    @Test
    public void testSequenceWithSeed() {
        DeterministicUUIDConverter converter = new DeterministicUUIDConverter(TEST_SEED);
        for (long l = 1; l <= SEQUENCE_LENGTH; l++) {
            UUID uuid1 = converter.convert(l);
            System.out.printf("%dL => %s%n", l, uuid1);
        }
    }

}