package com.ifpb.bestplaces01.interfaces;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

public interface IUploadFile {

    public default String uploadFile(String pathName, Part part) throws IOException {
       File folder = new File(pathName);
       if (!folder.exists()) folder.mkdirs();
       String sep = File.separator;
       part.write(pathName + sep + part.getSubmittedFileName());
       return pathName + sep + part.getSubmittedFileName();
    }
}
