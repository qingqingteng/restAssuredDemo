package restassured;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DataDriverByYaml {

    @Parameterized.Parameters
    public static List<DataClass> data() throws IOException {
        ArrayList<DataClass> data = new ArrayList<DataClass>();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File yamlFile = new File(DataDriverByYaml.class.getResource("/data/input.yaml").getFile());
        TypeReference<List<DataClass>> typeReference = new TypeReference<List<DataClass>>() {
        };
        data = mapper.readValue(yamlFile,typeReference);
        return data;

    }
    @Parameterized.Parameter
    public DataClass data;

    @Test
    public void dataTest(){
        assertThat(data.getCount(),equalTo(Integer.parseInt(data.getKey())));
    }

}
