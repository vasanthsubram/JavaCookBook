package core.enums;

public enum MimeType {

    JPEG("image/jpeg", "jpg"),
    PDF("application/pdf", "pdf"),
    BINARY("application/octet-stream", "bin"),
    TEXT("text/plain", "txt");
    
    private String type;
    private String extension;

    private MimeType(String type, String extension) {
        this.type = type;
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public String getExtension() {
        return extension;
    }
    
    public boolean isJpeg(){
    	return this==JPEG;
    }
    
    public static void main(String[] args){
		for(MimeType e: MimeType.values()){
			System.out.println(e + " -> " + e.ordinal()+ " " + e.getType() + " " + e.getExtension());
			System.out.println(e.isJpeg());
		}
	}
    
    public String toString(){
		return name().toLowerCase();
	}
	
   
}
