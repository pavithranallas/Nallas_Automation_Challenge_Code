package json_comparison;

public class StateCode {
	private Integer id;
	   private String value;
	   private String statecode;
	   private String menu;
	  
	   public void setId(int id) {
		      this.id = id;
		   }
	   public int getId() {
	      return id;
	   }

	   public String getvalue() {
	      return value;
	   }
	   public void setvalue(String value) {
	      this.value = value;
	   }
	   public String getstatecode() {
		      return statecode;
		   }
		   public void setstatecode(String statecode) {
		      this.statecode = statecode;
		   }
		
				 public String toString()
				 { 
					 return "menu [ id: "+id+", value: "+value+", statecode: "+ statecode+ "]"; }
				 
}
