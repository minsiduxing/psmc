package priv.guochun.psmc.system.enums;

public enum FileEnum {
	//远程新文件上传成功
	REMOTE_NEW_UPLOAD_SUCCESS("REMOTE_NEW_UPLOAD_SUCCESS",1),
	//远程新文件上传失败
	REMOTE_NEW_UPLOAD_FAILE("REMOTE_NEW_UPLOAD_FAILE",2),
	//远程断点上传成功
	REMOTE_BREAK_UPLOAD_SUCCESS("REMOTE_BREAK_UPLOAD_SUCCESS",3),
	//远程断点上传失败
	REMOTE_BREAK_UPLOAD_BREAK_FAILE("REMOTE_UPLOAD_BREAK_FAILE",4);
	private String name;
	private Integer value;
	private FileEnum(String name,Integer value){
		this.name=name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
