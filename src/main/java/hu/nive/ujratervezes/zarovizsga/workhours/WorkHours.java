package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkHours {

    public String minWork(String file){
        List<RecordWork> records = readFile(Path.of(file));
        Map<String, RecordWork> minWorks = reportMap(records);
        return buildString(minWorks);
    }

    private List<RecordWork> readFile(Path path){
        List<RecordWork> records = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line=reader.readLine()) != null){
                String[] data = line.split(",");
                addToRecords(records, data);
            }
            return records;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    private void addToRecords(List<RecordWork> records, String[] data){
        records.add(new RecordWork(data[0], Integer.parseInt(data[1]), LocalDate.parse(data[2])));
    }

    private Map<String, RecordWork> reportMap(List<RecordWork> records){
        Map<String, RecordWork> result = new HashMap<>();
        for(RecordWork record : records){
            if(result.containsKey(record.getName())){
                if(result.get(record.getName()).getHoursWork() > record.getHoursWork()){
                    result.put(record.getName(),record);
                }
            }
            else{
                result.put(record.getName(), record);
            }
        }
        return result;
    }

    private String buildString(Map<String, RecordWork> toConvert){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, RecordWork> entry : toConvert.entrySet()){
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue().getDate().toString());
            sb.append('\n');
        }
        return sb.toString();
    }


}
