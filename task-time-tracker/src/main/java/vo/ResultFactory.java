package vo;

public class ResultFactory {

    public static <T> Result<T> getSuccessResult(T data) {

        return new Result<T>(true, data);
    }

    public static <T> Result<T> getSuccessResult(T data, String msg) {

        return new Result<T>(true, msg);
    }

    public static <T> Result<T> getSuccessResultMsg(String msg) {

        return new Result<T>(true, msg);
    }

    public static <T> Result<T> getFailResult(String msg) {

        return new Result<T>(false, msg);
    }
}
