package ch.heig.dai.lab.fileio.romainfleury;

import java.io.File;
import java.util.HashSet;
import java.io.*;

public class FileExplorer {
    private final File folder;
    private HashSet<File> knownFiles;

    /**
     * Constructor
     * Memorize the folder to explore and initialize the set of known files.
     * @param folder
     */
    public FileExplorer(String folder) {
        this.folder = new File(folder);
        this.knownFiles = new HashSet<File>();
    }

    /**
     * Get a single new file from the folder.
     * The file must not have been returned before.
     * Use the java.io.file API to get the list of files in the folder.
     * Use the HashSet knownFiles to keep track of the files that have already been returned.
     * @return a new file, or null if there is no new file
     */
    public File getNewFile() {
        // TODO: implement the method body here

        File[] files  = folder.listFiles();
        for(File file: files){
            // regarder si file est présent dans knownfile
            int flag = 0;
            for(File f: knownFiles){
                if(file.getName().equals(f.getName())){
                    flag = 1;
                    break;
                }
            }

            // si pas présent push dans knownfile, ajouter
            if(flag == 0){
                knownFiles.add(file);
                return file;
            }
        }

        return null;
    }
}