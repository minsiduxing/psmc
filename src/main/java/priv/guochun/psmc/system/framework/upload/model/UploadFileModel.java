package priv.guochun.psmc.system.framework.upload.model;

import java.io.File;

public class UploadFileModel
{
    public File file;
    
    public String temp_file_path;
    
    public String file_upload_real_path;
    
    public String fileRealName;
    
    public String fileSystemName;
    
    public String suffix;
    public String fileSize;
    
    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getTemp_file_path()
    {
        return temp_file_path;
    }

    public void setTemp_file_path(String temp_file_path)
    {
        this.temp_file_path = temp_file_path;
    }

    public String getFile_upload_real_path()
    {
        return file_upload_real_path;
    }

    public void setFile_upload_real_path(String file_upload_real_path)
    {
        this.file_upload_real_path = file_upload_real_path;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public String getFileRealName()
    {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName)
    {
        this.fileRealName = fileRealName;
    }

    public String getFileSystemName()
    {
        return fileSystemName;
    }

    public void setFileSystemName(String fileSystemName)
    {
        this.fileSystemName = fileSystemName;
    }

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
    
    
}
