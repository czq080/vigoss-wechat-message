package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;
import com.vigoss.wechat.core.handle.EnterpriseEventMessageHandle;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.enterprise.event.model.EnterpriseExternalContactChangeMessage;

@EventMessage(EventMessageType.change_external_contact)
public class EpExternalContactChangeMessageHandle extends EnterpriseEventMessageHandle<EnterpriseExternalContactChangeMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseExternalContactChangeMessage message) {
        return null;
    }
}
