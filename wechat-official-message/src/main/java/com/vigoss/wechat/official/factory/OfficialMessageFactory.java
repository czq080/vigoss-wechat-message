package com.vigoss.wechat.official.factory;

import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.event.type.EventMessageType;
import com.vigoss.wechat.core.factory.AbstractMessageFactory;
import com.vigoss.wechat.core.factory.MessageKey;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.official.event.model.OfficialMenuClickEventMessage;
import com.vigoss.wechat.official.event.model.OfficialMenuViewEventMessage;
import com.vigoss.wechat.official.event.model.OfficialSubscribeEventMessage;
import com.vigoss.wechat.official.message.model.*;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialMessageFactory extends AbstractMessageFactory {
    public OfficialMessageFactory(String basePackage, WechatAccount... wechatAccounts) throws Exception {
        super(basePackage, WechatAccountType.OFFICIAL, wechatAccounts);
    }

    @Override
    protected void initMessage() throws InstantiationException, IllegalAccessException {
        register(new MessageKey(MessageType.link.name(), WechatAccountType.OFFICIAL), OfficialLinkMessage.class);
        register(new MessageKey(MessageType.text.name(), WechatAccountType.OFFICIAL), OfficialTextMessage.class);
        register(new MessageKey(MessageType.image.name(), WechatAccountType.OFFICIAL), OfficialImageMessage.class);
        register(new MessageKey(MessageType.location.name(), WechatAccountType.OFFICIAL), OfficialLocationMessage.class);
        register(new MessageKey(MessageType.shortvideo.name(), WechatAccountType.OFFICIAL), OfficialShortVideoMessage.class);
        register(new MessageKey(MessageType.video.name(), WechatAccountType.OFFICIAL), OfficialVideoMessage.class);
        register(new MessageKey(MessageType.voice.name(), WechatAccountType.OFFICIAL), OfficialVoiceMessage.class);
        //event
        register(new MessageKey(MessageType.event.name(), EventMessageType.click.name(), WechatAccountType.OFFICIAL), OfficialMenuClickEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.subscribe.name(), WechatAccountType.OFFICIAL), OfficialSubscribeEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.view.name(), WechatAccountType.OFFICIAL), OfficialMenuViewEventMessage.class);
    }
}
