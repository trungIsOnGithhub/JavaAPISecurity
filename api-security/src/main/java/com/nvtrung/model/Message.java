package com.nvtrung.model;

import java.time.Instant;
import org.json.JSONObject;

public class Message {
    public String spaceName;
    public long msgId;
    public String author;
    public Instant time;
    public String message;

    public Message(String spaceName, long msgId, String author,
        Instant time, String message) {
      this.spaceName = spaceName;
      this.msgId = msgId;
      this.author = author;
      this.time = time;
      this.message = message;
    }
    @Override
    public String toString() {
      JSONObject msg = new JSONObject();
      msg.put("uri",
          "/spaces/" + spaceName + "/messages/" + msgId);
      msg.put("author", author);
      msg.put("time", time.toString());
      msg.put("message", message);
      return msg.toString();
    } 
}