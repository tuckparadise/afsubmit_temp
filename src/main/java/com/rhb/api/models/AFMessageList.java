package com.rhb.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

/**
 * Message List
 */
@Schema(description = "Message List")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-15T01:00:23.343319Z[GMT]")


public class AFMessageList   {
    @JsonProperty("progID")
    private String progID = null;

    @JsonProperty("messageCode")
    private String messageCode = null;

    @JsonProperty("messageSeverity")
    private String messageSeverity = null;

    @JsonProperty("messageDesc")
    private String messageDesc = null;

    public AFMessageList progID(String progID) {
        this.progID = progID;
        return this;
    }

    /**
     * Prog ID
     * @return progID
     **/
    @Schema(required = true, description = "Prog ID")
    @NotNull

    public String getProgID() {
        return progID;
    }

    public void setProgID(String progID) {
        this.progID = progID;
    }

    public AFMessageList messageCode(String messageCode) {
        this.messageCode = messageCode;
        return this;
    }

    /**
     * Message Code
     * @return messageCode
     **/
    @Schema(required = true, description = "Message Code")
    @NotNull

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public AFMessageList messageSeverity(String messageSeverity) {
        this.messageSeverity = messageSeverity;
        return this;
    }

    /**
     * Message Severity
     * @return messageSeverity
     **/
    @Schema(required = true, description = "Message Severity")
    @NotNull

    public String getMessageSeverity() {
        return messageSeverity;
    }

    public void setMessageSeverity(String messageSeverity) {
        this.messageSeverity = messageSeverity;
    }

    public AFMessageList messageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
        return this;
    }

    /**
     * Message Description
     * @return messageDesc
     **/
    @Schema(required = true, description = "Message Description")
    @NotNull

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AFMessageList pfMessageList = (AFMessageList) o;
        return Objects.equals(this.progID, pfMessageList.progID) &&
                Objects.equals(this.messageCode, pfMessageList.messageCode) &&
                Objects.equals(this.messageSeverity, pfMessageList.messageSeverity) &&
                Objects.equals(this.messageDesc, pfMessageList.messageDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progID, messageCode, messageSeverity, messageDesc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AFMessageList {\n");

        sb.append("    progID: ").append(toIndentedString(progID)).append("\n");
        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append("\n");
        sb.append("    messageSeverity: ").append(toIndentedString(messageSeverity)).append("\n");
        sb.append("    messageDesc: ").append(toIndentedString(messageDesc)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
