package br.com.leandrorezende.marvel.web.model.comic;

public class ComicDataWrapper {

	private int code;

	private String status;

	private String copyright;

	private String attributionText;

	private String attributionHTML;

	private ComicDataContainer data;

	private String eTag;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	public ComicDataContainer getData() {
		return data;
	}

	public void setData(ComicDataContainer data) {
		this.data = data;
	}

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}

}
