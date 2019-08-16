package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;
import com.vigoss.wechat.core.handle.OfficialEventMessageHandle;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.official.event.model.OfficialSubscribeEventMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@EventMessage(EventMessageType.subscribe)
public class SubscribeMessageHandle extends OfficialEventMessageHandle<OfficialSubscribeEventMessage> {
    @Override
    protected MessageResponse doHandle(OfficialSubscribeEventMessage message) {
        return new TextResponse(message.getEventKey());
    }
}
