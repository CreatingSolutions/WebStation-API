package webstationapi.DTO;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class APIErrorDTO {
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String msg;
    private HttpStatus status;
    private String details;
    
	public LocalDateTime getTimestamp() { return timestamp; }
	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
	public String getMsg() { return msg; }
	public void setMsg(String msg) { this.msg = msg; }
	public HttpStatus getStatus() { return status; }
	public void setStatus(HttpStatus status) { this.status = status; }
	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
    
    
    
}
