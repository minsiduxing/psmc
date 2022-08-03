package priv.guochun.psmc.system.framework.upload.model;

import java.io.File;

public class UploadFileModel
{
    public File file;
    //临时文件地址（psmc传统上传使用，后续废弃）
    public String temp_file_path;
    //真实文件地址(如果是fastdfs 就是上传返回的id，oss类似）
    public String file_upload_real_path;
    //文件完整url
    public String fileCompleteUrl;

    //文件真实名称
    public String fileRealName;
    //文件系统名称
    public String fileSystemName;
    //文件后缀
    public String suffix;
    //文件大小
    public String fileSize;
    //临时文件地址（psmc传统上传使用，后续废弃）
    public String custom_file_path;
    
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

	public String getCustom_file_path() {
		return custom_file_path;
	}

	public void setCustom_file_path(String custom_file_path) {
		this.custom_file_path = custom_file_path;
	}

    public String getFileCompleteUrl() {
        return fileCompleteUrl;
    }

    public void setFileCompleteUrl(String fileCompleteUrl) {
        this.fileCompleteUrl = fileCompleteUrl;
    }
}
