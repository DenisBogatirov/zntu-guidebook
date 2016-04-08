package ua.edu.zntu.guidebook.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Example {

    private String success;
    private String message;
    private String messages;
    private String data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The success
     */
    public String getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(String success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The messages
     */
    public String getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     * The messages
     */
    public void setMessages(String messages) {
        this.messages = messages;
    }

    /**
     *
     * @return
     * The data
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
