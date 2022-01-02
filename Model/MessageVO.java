package Model;

public class MessageVO {

	private int bnum; 
	private String send_name;
	private String receive_email;
	private String content;
	private String dates;
	
	
	public MessageVO(int bnum, String send_name, String receive_email, String content, String dates) {
		super();
		this.bnum = bnum;
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
		this.dates = dates;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getReceive_email() {
		return receive_email;
	}

	public void setReceive_email(String receive_email) {
		this.receive_email = receive_email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}
	
	
}
