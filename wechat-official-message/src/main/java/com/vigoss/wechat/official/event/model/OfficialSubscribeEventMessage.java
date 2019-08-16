package com.vigoss.wechat.official.event.model;

import com.vigoss.wechat.core.event.model.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialSubscribeEventMessage extends EventMessage {
    private static final long serialVersionUID = -3022556785194085067L;

    public OfficialSubscribeEventMessage() {
        super(EventMessageType.subscribe.name());
    }

    /**
     * 事件类型
     *
     */
    @XmlElement(name = "EventKey")
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OfficialSubscribeEventMessage that = (OfficialSubscribeEventMessage) o;
        return Objects.equals(eventKey, that.eventKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eventKey);
    }

    @Override
    public String toString() {
        return "OfficialSubscribeEventMessage{" + super.toString() + "} ";
    }
}
