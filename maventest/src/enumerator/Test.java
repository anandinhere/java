package enumerator;

public class Test {
	
	public enum WhoisRIR {
		AU_TEMP("AT,OT,MR,FS,RHTT"),
		NZ_TEMP("AT,OT,MR,FS,RHTT"),
		CN_TEMP(""),
		HK_TEMP(""),
		JP_TEMP(""),
		SG_TEMP(""),
		
		AU_PERM("ENG,RFS,RH,RHAO,RHES,RHT"),
		NZ_PERM("ENG,RFS,RH,RHAO,RHES,RHT"),
		CN_PERM(""),
		HK_PERM(""),
		JP_PERM(""),
		SG_PERM("");
	    
	    

	    private String lobs;

	    WhoisRIR(String lobs) {
	        this.lobs = lobs;
	    }

	    public String lobs() {
	        return lobs;
	    }
	}

    public static void main(String[] args) {

		//whois.arin.net
    	
    	System.out.println(WhoisRIR.valueOf("AU_TEMP").lobs());
    	


    }

}
