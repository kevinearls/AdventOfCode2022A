package dev.kearls;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dev.kearls.Common.getInput;


public class ReceiptReader {

    public Map<String, Double> getCategoryTotals(String receiptFileName) throws IOException {
        Map<String, Double> spentPerCategory = new HashMap<>();
        List<String> input = getInput(receiptFileName);

        int index = 0;
        while (index < input.size()) {
            String line = input.get(index).trim();
            // If a line starts with >> it's a category...
            if (line.startsWith(">>")) {
                System.out.println("Category: " + line.substring(3));
            } else if (line.length() == 40) {
                System.out.println("Normal line: " + line);   // TODO can we split by multiple whitespaces to get price?  Or name, quantity, price?
            } else {
                // should just be a multiple?
                System.out.println(">>>>>> Other [" + line + "]");
            }
            //System.out.println("[" + line + "] length? " + line.length());
            index++;
        }

        return spentPerCategory;
    }
}
