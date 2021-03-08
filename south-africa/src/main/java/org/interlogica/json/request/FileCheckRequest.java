package org.interlogica.json.request;

import java.io.Serializable;

public class FileCheckRequest implements Serializable {

	private static final long serialVersionUID = -196101855665846537L;

	private String fileContent;
	private String fileContentType;
	private String fileName;
	private String columnSeparator;
	private Boolean hasHeader;
	private Integer keyColumnNumber;

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getColumnSeparator() {
		return columnSeparator;
	}

	public void setColumnSeparator(String columnSeparator) {
		this.columnSeparator = columnSeparator;
	}

	public Boolean getHasHeader() {
		return hasHeader;
	}

	public void setHasHeader(Boolean hasHeader) {
		this.hasHeader = hasHeader;
	}

	public Integer getKeyColumnNumber() {
		return keyColumnNumber;
	}

	public void setKeyColumnNumber(Integer keyColumnNumber) {
		this.keyColumnNumber = keyColumnNumber;
	}

	@Override
	public String toString() {
		return "FileCheckRequest [fileContent=" + fileContent + ", fileContentType=" + fileContentType + ", fileName="
				+ fileName + ", columnSeparator=" + columnSeparator + ", hasHeader=" + hasHeader + ", keyColumnNumber="
				+ keyColumnNumber + "]";
	}

}
