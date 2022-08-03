package priv.guochun.psmc.system.framework.upload.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import org.apache.log4j.Logger;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastdfsUtils {

	private static final Logger logger = Logger.getLogger(FastdfsUtils.class);

	static {
		try {
			String filePath = FastdfsUtils.class.getClassLoader().getResource("fdfs_client.properties").getPath();
			ClientGlobal.init(filePath);
		} catch (Exception e) {
			logger.error("FastDFS Client Init Fail!", e);
		}
	}

	/**
	 * 获取访问服务器的token，拼接到地址后面
	 *
	 * @param filepath
	 *            文件路径 group1/M00/00/00/wKgzgFnkTPyAIAUGAAEoRmXZPp876.jpeg
	 * @param httpSecretKey
	 *            密钥
	 * @return 返回token，如： token=078d370098b03e9020b82c829c205e1f&ts=1508141521
	 * @throws MyException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static void getToken(String filepath, String httpSecretKey)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, MyException {
		int ts = (int) Instant.now().getEpochSecond();
		// token
		String token = "null";
		token = ProtoCommon.getToken(filepath, ts, httpSecretKey);

		StringBuilder sb = new StringBuilder();
		sb.append("token=").append(token);
		sb.append("&ts=").append(ts);

	}
	/**
	 * 文件缓冲区，web上没啥用
	 * @param inStream
	 * @param fileLength
	 * @return
	 * @throws IOException
	 */
	private static byte[] getFileBuffer(InputStream inStream, long fileLength) throws IOException {

		byte[] buffer = new byte[256 * 1024];
		byte[] fileBuffer = new byte[(int) fileLength];

		int count = 0;
		int length = 0;

		while ((length = inStream.read(buffer)) != -1) {
			for (int i = 0; i < length; ++i) {
				fileBuffer[count + i] = buffer[i];
			}
			count += length;
		}
		return fileBuffer;
	}
	/**
	 * 文件上传
	 * @param fileBuff
	 * @param uploadFileName
	 * @param fileLength
	 * @return
	 * @throws IOException
	 */
	public static String[] uploadFile(byte[] fileBuff, String uploadFileName, long fileLength) throws IOException {
		logger.debug("上传文件=======================");
		String[] files = null;
		String fileExtName = "";
		if (uploadFileName.contains(".")) {
			fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
		} else {
			throw new RuntimeException("非法文件");
		}

		// 建立连接
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageServer storageServer = null;
		StorageClient client = new StorageClient(trackerServer, storageServer);

		NameValuePair[] metaList = new NameValuePair[3];
		metaList[0] = new NameValuePair("fileName", uploadFileName);
		metaList[1] = new NameValuePair("fileExtName", fileExtName);
		metaList[2] = new NameValuePair("fileLength", String.valueOf(fileLength));

		// 上传文件
		try {
			files = client.upload_file(fileBuff, fileExtName, metaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		trackerServer.close();
		return files;
	}

	// 下载文件
	public static byte[]  downloadFile(String groupName, String filepath) throws Exception {
		logger.debug("下载文件=======================");
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageServer storageServer = null;

		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		byte[] bytes = storageClient.download_file(groupName, filepath);
		return bytes;
	}

	// 查看文件信息
	public static FileInfo getFileInfo(String groupName, String filepath) throws Exception {
		logger.debug("获取文件信息=======================");
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageServer storageServer = null;

		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		FileInfo fi = storageClient.get_file_info(groupName, filepath);
		return fi;
	}

	public static NameValuePair [] getFileMate(String groupName, String filepath) throws Exception {
		logger.debug("获取文件Mate=======================");
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageServer storageServer = null;

		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		NameValuePair nvps[] = storageClient.get_metadata(groupName, filepath);
		return nvps;
	}
	/**
	 * 删除文件
	 * @param groupName
	 * @param filepath
	 * @throws Exception
	 */
	public static Boolean deleteFile(String groupName, String filepath){
		logger.debug("删除文件=======================");
		try{
			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			int i = storageClient.delete_file(groupName, filepath);
			return i == 0 ? true : false;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("文件删除失败");
		}
	}
}
