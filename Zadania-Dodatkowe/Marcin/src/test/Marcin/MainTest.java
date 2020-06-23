package Marcin;

import org.junit.jupiter.api.*;  //don't work if static :|
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @ValueSource(ints = { 2, 5, 19, 97, 59})
    void isPrimeTrue(int value) {
        assertTrue(Main.isPrime(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 42, 20, 88, 100})
    void isPrimeFalse(int value) {
        assertFalse(Main.isPrime(value));
    }

    @Test
    void isPeselValidTest() {
        Pattern peselPattern = Pattern.compile(".*0$");
        //given int
        String peselTrue = "44051401458";
        String peselFalse = "12345678901";
        String myPesel = "89042809033";
        String randomPesel = "20061113045";

        assertFalse(Main.isPeselValid(peselFalse));
        assertFalse(Main.isPeselValid(randomPesel));
        assertTrue(Main.isPeselValid(peselTrue));
        assertTrue(Main.isPeselValid(myPesel));
    }

    @Test
    @DisplayName("Is werbal representation working?")
    void wordRepresentationTest(int ints){
        assertEquals("one", Main.wordRepresentationTo999(1));
        assertEquals("onehundred", Main.wordRepresentationTo999(100));
        assertEquals("eleven", Main.wordRepresentationTo999(11));
        assertEquals("twenty", Main.wordRepresentationTo999(20));
        assertEquals("sixtyfive", Main.wordRepresentationTo999(65));
        assertEquals("onehundredeleven", Main.wordRepresentationTo999(111));
    }

}