package com.worthto.ecps.dao;

public interface IUploadDao {
	/**
	 * 	上传图片到图片服务器
	 * @param fileBytes 文件的字节码
	 * @param realPath	图片存放的真实路径
	 */
	void saveBrandPic(byte[] fileBytes, String realPath);

	/**
	 * 删除图片服务器的图片
	 * @param realPath 图片存放的真是路径
	 */
	void deleteBrandPic(String realPath);
}
