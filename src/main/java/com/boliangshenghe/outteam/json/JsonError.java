/**
  * Copyright 2017 bejson.com 
  */
package com.boliangshenghe.outteam.json;

/**
 * Auto-generated: 2017-10-23 21:46:2
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonError {

    private String topic;
    private String message;
    private Fault fault;
    public void setTopic(String topic) {
         this.topic = topic;
     }
     public String getTopic() {
         return topic;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setFault(Fault fault) {
         this.fault = fault;
     }
     public Fault getFault() {
         return fault;
     }

}