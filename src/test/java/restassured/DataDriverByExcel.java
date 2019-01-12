package restassured;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DataDriverByExcel {

    @Parameterized.Parameters
    public static List<DataClass> data() throws IOException {
        ArrayList<DataClass> data = new ArrayList<DataClass>();

        CsvMapper mapper = new CsvMapper();
//        CsvSchema schema = mapper.schemaFor(DataClass.class);
//        System.out.println("111111111===="+DataDriverByExcel.class.getResource("/data/input.csv").getFile());
//        System.out.println("222222222===="+DataDriverByExcel.class.getResource("../data/input.csv").getFile());
        File csvFile = new File(DataDriverByExcel.class.getResource("/data/input.csv").getFile());
        MappingIterator<DataClass> it = mapper.readerWithSchemaFor(DataClass.class).readValues(csvFile);
        while (it.hasNext()){
            DataClass row = it.next();
            data.add(row);
        }

        return data;

    }
    @Parameterized.Parameter
    public DataClass data;

    @Test
    public void dataTest(){
        assertThat(data.getCount(),equalTo(Integer.parseInt(data.getKey())));
    }

}
