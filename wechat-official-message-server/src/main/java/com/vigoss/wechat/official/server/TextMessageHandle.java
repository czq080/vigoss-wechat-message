package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.OfficialMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.official.SpringUtils;
import com.vigoss.wechat.official.config.TimeBean;
import com.vigoss.wechat.official.message.model.OfficialTextMessage;

import java.time.Instant;
import java.util.Date;

/**
 * @author chenzhiqiang
 * @date 2018/7/9
 */
@Message(value = MessageType.text)
public class TextMessageHandle extends OfficialMessageHandle<OfficialTextMessage> {
    @Override
    protected MessageResponse doHandle(OfficialTextMessage message) {
        if ("【收到不支持的消息类型，暂无法显示】".equals(message.getContent())) {
            return new TextResponse(message.getContent());
        }
        if (message.getContent().startsWith("redisson:")) {
            Integer threadNum = Integer.valueOf(message.getContent().split(":")[1]);
            Long date = Long.valueOf(message.getContent().split(":")[2]);
            TimeBean timeBean = SpringUtils.getBean(TimeBean.class);
            Date d = Date.from(Instant.ofEpochSecond(date));
            timeBean.run(d, threadNum, message.getCreateTime());
        }
        return new TextResponse("O(∩_∩)O哈哈~");
    }
}
