package util;


import com.httpapi.bmy.model.ResultModel;

public class ResultUtil {
    public static ResultModel Success(Object par){
        ResultModel resultModel=new ResultModel();
        resultModel.setStatus(200);
        resultModel.setMessage("null");
        resultModel.setData(par);
        return resultModel;

    }
    public static ResultModel Error(String message){
        ResultModel resultModel=new ResultModel();
        resultModel.setStatus(404);
        resultModel.setMessage(message);
        resultModel.setData(null);
        return resultModel;

    }


}
