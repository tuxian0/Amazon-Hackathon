package com.amazon.hackathon.csv.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.amazon.hackathon.data.ItemVO;
import com.amazon.hackathon.file.listener.FileAlterationListenerImpl;

public class CSVFileReader {
	
	private String sharedFolderLink;
	
	protected void fileChange() throws Exception {
		// Change this to match the environment you want to watch.
        final File directory = new File(sharedFolderLink);
        FileAlterationObserver fao = new FileAlterationObserver(directory);
        fao.addListener(new FileAlterationListenerImpl());
        final FileAlterationMonitor monitor = new FileAlterationMonitor();
        monitor.addObserver(fao);
        System.out.println("Starting monitor. CTRL+C to stop.");
        monitor.start();
 
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
 
            @Override
            public void run() {
                try {
                    System.out.println("Stopping monitor.");
                    monitor.stop();
                } catch (Exception ignored) {
                }
            }
        }));
	}
	
	public static List<ItemVO> readCSVFile(String csvFile) {
		List<ItemVO> list = new ArrayList<ItemVO>();
		BufferedReader br = null;
		String line = "", cvsSplitBy = ",";
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				ItemVO itemData = new ItemVO();
				// use comma as separator
				String[] country = line.split(cvsSplitBy);
				itemData.setItem(Integer.parseInt(country[0]));
				itemData.addAttribute_name(country[1]);
				itemData.addAttribute_value(country[2]);
				
				list.add(itemData);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

}
