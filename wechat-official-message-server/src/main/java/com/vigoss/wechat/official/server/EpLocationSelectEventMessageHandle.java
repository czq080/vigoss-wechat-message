package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;
import com.vigoss.wechat.core.handle.EnterpriseEventMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.enterprise.event.model.EnterpriseLocationSelectEventMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@EventMessage(EventMessageType.location_select)
public class EpLocationSelectEventMessageHandle extends EnterpriseEventMessageHandle<EnterpriseLocationSelectEventMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseLocationSelectEventMessage message) {
        return new TextResponse(String.format("消息类型:%s,事件类型:%s,消息体:%s", MessageType.event, EventMessageType.location_select, message));
    }
}
