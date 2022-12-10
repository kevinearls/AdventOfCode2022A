import dev.kearls.ReceiptReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestReceiptReader {
    private static final String TEST_INPUT="src/main/resources/receipt.txt";
    ReceiptReader receiptReader = new ReceiptReader();
    @Test
    public void testReceiptReader() throws IOException {
        receiptReader.getCategoryTotals(TEST_INPUT);
    }

}
