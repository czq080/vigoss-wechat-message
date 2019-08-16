package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

import javax.xml.bind.annotation.XmlElement;

public class EnterpriseExternalContactChangeMessage extends EventMessage {

    private static final long serialVersionUID = -691001795539748688L;

    public EnterpriseExternalContactChangeMessage() {
        super(EventMessageType.change_external_contact.name());
    }

    @XmlElement(name = "ChangeType")
    private String changeType;

    @XmlElement(name = "UserID")
    private String userId;

    @XmlElement(name = "ExternalUserID")
    private String externalUserID;

    public String getChangeType() {
        return changeType;
    }

    public String getUserId() {
        return userId;
    }

    public String getExternalUserID() {
        return externalUserID;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (changeType != null ? changeType.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (externalUserID != null ? externalUserID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EnterpriseExternalContactChangeMessage{" +
                "changeType='" + changeType + '\'' +
                ", userId='" + userId + '\'' +
                ", externalUserID='" + externalUserID + '\'' +
                ", " + super.toString() +
                "} ";
    }
}
