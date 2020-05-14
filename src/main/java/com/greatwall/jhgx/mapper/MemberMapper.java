package com.greatwall.jhgx.mapper;

import com.greatwall.jhgx.domain.Member;
import com.greatwall.jhgx.domain.PayOrder;

import java.util.List;

public interface MemberMapper extends SuperMapper<Member> {

    List<PayOrder> selectOrder(String authCode);
}
