package vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	final private boolean success;
	final private T data;
	final private String msg;

	Result(boolean success, T data) {
		this.success = success;
		this.data = data;
		this.msg = null;
	}

	Result(boolean success, String msg) {
		this.success = success;
		this.data = null;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public T getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder("\"Result{\"");
		sb.append("success=").append(success);
		sb.append(", msg=").append(msg);

		sb.append(", data=");

		if (data == null) {

			sb.append("null");

		} else if (data instanceof List) {

			List<?> castList = (List<?>) data;
			if (castList.isEmpty()) {

				sb.append("empty list");

			} else {
				Object firstItem = castList.get(0);

				sb.append("List of ").append(firstItem.getClass());
			}

		} else {
			sb.append(data.toString());
		}

		sb.append("}");

		return sb.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (success ? 1231 : 1237);
		return result;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Result<?> other = (Result<?>) obj;
		if (this.success != other.success) {
			return false;
		}
		return Objects.deepEquals(this.data, other.data);
	}
	
}
