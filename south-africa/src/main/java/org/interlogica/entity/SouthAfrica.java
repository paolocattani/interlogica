package org.interlogica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SOUTH_AFRICA")
public class SouthAfrica {

	/**
	 * Table id
	 */
	private Integer id;

	/**
	 * File Content
	 */
	private byte[] fileContent;
	/**
	 * File Content type ( csv, pdf, .. )
	 */
	private String fileContentType;
	/**
	 * File name
	 */
	private String fileName;
	/**
	 * Column separator : ';' ',' ' '
	 */
	private String columnSeparator;
	/**
	 * Indicates if file has header or not
	 */
	private Boolean hasHeader;
	/**
	 * Column index ( zero-based ) where to find the key ( the phone number )
	 */
	private Integer keyColumnNumber;
	/**
	 * API result
	 */
	private String result;

	public SouthAfrica() {
	}

	public SouthAfrica(Integer id, byte[] fileContent, String fileContentType, String fileName, String columnSeparator,
			Boolean hasHeader, Integer keyColumnNumber, String result) {
		super();
		this.id = id;
		this.fileContent = fileContent;
		this.fileContentType = fileContentType;
		this.fileName = fileName;
		this.columnSeparator = columnSeparator;
		this.hasHeader = hasHeader;
		this.keyColumnNumber = keyColumnNumber;
		this.result = result;
	}

	@Id
	@SequenceGenerator(name = "sequence_generator", sequenceName = "sa_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "sequence_generator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Lob
	@Column(name = "FILE_CONTENT")
	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	@Column(name = "FILE_CONTENT_TYPE", length = 200)
	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	@Column(name = "FILE_NAME", length = 200)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "COLUMN_SEPARATOR", length = 200)
	public String getColumnSeparator() {
		return columnSeparator;
	}

	public void setColumnSeparator(String columnSeparator) {
		this.columnSeparator = columnSeparator;
	}

	@Column(name = "HAS_HEADER", precision = 1, scale = 0)
	public Boolean getHasHeader() {
		return hasHeader;
	}

	public void setHasHeader(Boolean hasHeader) {
		this.hasHeader = hasHeader;
	}

	@Column(name = "KEY_COLUMN_NUMBER", precision = 3, scale = 0)
	public Integer getKeyColumnNumber() {
		return keyColumnNumber;
	}

	public void setKeyColumnNumber(Integer keyColumnNumber) {
		this.keyColumnNumber = keyColumnNumber;
	}

	@Lob
	@Column(name = "RESULT_JSON")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
