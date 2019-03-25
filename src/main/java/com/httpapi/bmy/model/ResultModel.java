package com.httpapi.bmy.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultModel{
   private int status;
   private String message;
   private Object data;


}
