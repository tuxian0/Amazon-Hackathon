package com.amazon.hackathon.file.listener;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.amazon.hackathon.Service.SubscriptionSystemImpl;
import com.amazon.hackathon.csv.reader.CSVFileReader;

public class FileAlterationListenerImpl implements FileAlterationListener {

	/**
     * {@inheritDoc}
     */
    @Override
    public void onStart(final FileAlterationObserver observer) {
        System.out.println("The WindowsFileListener has started on " + observer.getDirectory().getAbsolutePath());
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onDirectoryCreate(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was created.");
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onDirectoryChange(final File directory) {
        System.out.println(directory.getAbsolutePath() + " wa modified");
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onDirectoryDelete(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was deleted.");
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onFileCreate(final File file) {
        System.out.println(file.getAbsoluteFile() + " was created.");
        System.out.println("----------> length: " + file.length());
        System.out.println("----------> last modified: " + new Date(file.lastModified()));
        System.out.println("----------> readable: " + file.canRead());
        System.out.println("----------> writable: " + file.canWrite());
        System.out.println("----------> executable: " + file.canExecute());
        
        if(file.getName().endsWith(".csv")) {
        	SubscriptionSystemImpl impl = new SubscriptionSystemImpl();
        	impl.storeContents(CSVFileReader.readCSVFile(file.getName()));
        }
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onFileChange(final File file) {
        System.out.println(file.getAbsoluteFile() + " was modified.");
        System.out.println("----------> length: " + file.length());
        System.out.println("----------> last modified: " + new Date(file.lastModified()));
        System.out.println("----------> readable: " + file.canRead());
        System.out.println("----------> writable: " + file.canWrite());
        System.out.println("----------> executable: " + file.canExecute());
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onFileDelete(final File file) {
        System.out.println(file.getAbsoluteFile() + " was deleted.");
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop(final FileAlterationObserver observer) {
        System.out.println("The WindowsFileListener has stopped on " + observer.getDirectory().getAbsolutePath());
    }

}
