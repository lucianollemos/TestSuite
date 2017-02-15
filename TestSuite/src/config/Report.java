package config;

import com.itextpdf.text.Document;

public class Report {
	
	Document document;
	
	
	public Report() {
		document = new Document();
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
}
