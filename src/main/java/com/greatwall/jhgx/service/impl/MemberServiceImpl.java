package com.greatwall.jhgx.service.impl;

import com.greatwall.component.ccyl.common.service.impl.SuperServiceImpl;
import com.greatwall.jhgx.domain.Member;
import com.greatwall.jhgx.domain.PayOrder;
import com.greatwall.jhgx.mapper.MemberMapper;
import com.greatwall.jhgx.mapper.PayOrderMapper;
import com.greatwall.jhgx.service.MemberService;
import com.greatwall.jhgx.service.PayOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl extends SuperServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public List<PayOrder> selectOrder(String authCode) {
        return baseMapper.selectOrder(authCode);
    }
}
