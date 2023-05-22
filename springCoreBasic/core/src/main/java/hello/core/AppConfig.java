package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {    // application 전체를 설정하고 구성

    /*
        메서드 명을 보면 역할이 드러남
        구현체도 어떤걸 사용하는지 확인할 수 있음
        설계에 대한 그림이 구성정보에 그대로 드러남
        역할과 구현 클래스가 한눈에 들어옴. 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있음
     */

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
