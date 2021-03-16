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
        return buildString(records);
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


    private String buildString(List<RecordWork> records){
        int minHours = Integer.MAX_VALUE;
        RecordWork minWork = new RecordWork(null, Integer.MAX_VALUE, null);
        for(RecordWork record : records){
            if(record.getHoursWork() < minHours) {
                minHours = record.getHoursWork();
                minWork = record;
            }
        }
        return minWork.getName() + ": " + minWork.getDate().toString();
    }


}
