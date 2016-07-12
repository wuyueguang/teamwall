package rocky.teamwall.dto;

import java.util.List;

import rocky.teamwall.entity.Tag;

public class TagDTO {

	private boolean success;
	private List<Tag> data;
	private Integer count;
	private String error;
	
	public TagDTO() {}
	
	public TagDTO(boolean success, List<Tag> data) {
		this.success = success;
		this.data = data;
	}
	
	public TagDTO(boolean success, Integer count) {
		this.success = success;
		this.count = count;
	}

	public TagDTO(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Tag> getData() {
		return data;
	}

	public void setData(List<Tag> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
