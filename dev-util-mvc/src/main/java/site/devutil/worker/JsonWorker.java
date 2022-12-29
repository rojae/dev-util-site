package site.devutil.worker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonWorker {

    // lombok's toString to Json
    public String toStringToJson(String str) {
        StringBuilder result = new StringBuilder();

        str = str.replace("(", "");
        str = str.replace(")", "");

        List<String> res = new ArrayList<>();
        List<String> arr = new ArrayList<>(Arrays.asList(str.split(",")));

        // 01. Add "
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).trim());
        }

        // 02. Add Last "" (If value is Empty Space)
        for (int i = 0; i < arr.size(); i++) {
            String[] item = arr.get(i).split("=");
            res.add("\"" + item[0] + "\"");
            if (item.length != 2)
                res.add("\"\"");
            else
                res.add("\"" + item[1] + "\"");
        }

        result.append("{");
        for (int i = 0; i < res.size(); i++) {
            if (i != 0 && i % 2 == 0)
                result.append(",\n\t");
            else if (i % 2 == 0)
                result.append("\n\t");
            else
                result.append(":");
            result.append(res.get(i));
        }
        result.append("\n}");

        return result.toString();
    }

    // Pojo to Json

    // Xml to Json

    //

}
