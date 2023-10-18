import org.junit.Assert;
import org.junit.Test;

public class UnitTestingExamplesTest {

    /*
     * stringSplosion("Code") → "CCoCodCode"
     * stringSplosion("abc") → "aababc"
     * stringSplosion("ab") → "aab"
     *
     * empty string
     * stringSplosion("") → ""
     *
     * one character
     * stringSplosion(".") → "."
     *
     * all caps string, checking for all caps specifically
     * stringSplosion("CODE") → "CCOCODCODE"
     *
     * repeated characters
     * stringSplosion("----") → "----------"
     *
     * all punctuation string
     * stringSplosion("+-/*") → "++-+-/+-/*"
     */
    @Test
    public void stringSplosion_empty_string() {

        // Arrange
        String expectedString = "";
        UnitTestingExamples sut = new UnitTestingExamples();

        // Act
        String actualString = sut.stringSplosion("");

        // Assert
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void stringSplosion_single_character() {

        // Arrange
        String expectedString = ".";
        UnitTestingExamples sut = new UnitTestingExamples();

        // Act
        String actualString = sut.stringSplosion(".");

        // Assert
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void stringSplosion_all_caps() {

        // Arrange
        String expectedString = "CCOCODCODE";
        UnitTestingExamples sut = new UnitTestingExamples();

        // Act
        String actualString = sut.stringSplosion("CODE");

        // Assert
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void stringSplosion_repeated_characters() {

        // Arrange
        String expectedString = "----------";
        UnitTestingExamples sut = new UnitTestingExamples();

        // Act
        String actualString = sut.stringSplosion("----");

        // Assert
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void stringSplosion_all_punctuation() {

        // Arrange
        String expectedString = "++-+-/+-/*";
        UnitTestingExamples sut = new UnitTestingExamples();

        // Act
        String actualString = sut.stringSplosion("+-/*");

        // Assert
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void isEven() {
        // Arrange
        int[] testInputs = {0, 2, 4};

        // Act

        // Assert

    }
}